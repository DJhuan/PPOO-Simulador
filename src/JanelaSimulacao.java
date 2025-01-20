import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.List;

/**
 * Fornece a visualizacao da simulacao
 * 
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class JanelaSimulacao extends JFrame implements KeyListener {
    private Mapa mapa;
    private VisaoMapa visaoMapa;
    private Simulacao simulacao;

    public JanelaSimulacao(Mapa mapa, Simulacao simulacao) {
        this.mapa = mapa;
        this.simulacao = simulacao;
        visaoMapa = new VisaoMapa(mapa.getLargura(), mapa.getAltura());
        Container contentPane = getContentPane();
        contentPane.add(visaoMapa, BorderLayout.CENTER);
        addKeyListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void executarAcao() {
        visaoMapa.preparePaint();
        visaoMapa.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'p') {
            simulacao.adicionarPessoa();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private class VisaoMapa extends JPanel {
        private final int largura;
        private final int altura;
        private final int escala = 10;

        public VisaoMapa(int largura, int altura) {
            this.largura = largura;
            this.altura = altura;
            setPreferredSize(new Dimension(largura * escala, altura * escala));
            setBackground(Color.white);
        }

        public void preparePaint() {
            // Desenha as filas de raio-x e embarque
            for (RaioX raioX : simulacao.getFilasRaioX()) {
                desenharFila(raioX);
            }
            for (FilaEmbarque filaEmbarque : simulacao.getFilasEmbarque()) {
                desenharFila(filaEmbarque);
            }
            // Desenha as pessoas
            for (Pessoa pessoa : simulacao.getPessoas()) {
                desenharPessoa(pessoa);
            }
        }

        private void desenharFila(FilaAeroporto fila) {
            Localizacao loc = fila.getLocalizcao();
            Image img = fila.getImagem();
            if (img != null) {
                desenharImagem(loc.getX(), loc.getY(), img);
            }
        }

        private void desenharPessoa(Pessoa pessoa) {
            Localizacao loc = pessoa.getLocalizacaoAtual();
            Image img = pessoa.getImagem();
            if (img != null) {
                desenharImagem(loc.getX(), loc.getY(), img);
            }
        }

        public void desenharImagem(int x, int y, Image image) {
            Graphics g = getGraphics();
            if (g != null) {
                g.drawImage(image, x * escala, y * escala, this);
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            preparePaint();
        }
    }
}
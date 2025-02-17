import java.awt.*;
import javax.swing.*;

/**
 * Fornece a visualizacao da simulacao
 * 
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 * @author Ana Clara Carvalho Nascimento
 * @author Isadora Gomes Melo Cunha
 * @author Jhuan Carlos Sabaini Dassie
 * @author Wesley Filipe Rocha da Silva
 */
public class JanelaSimulacao extends JFrame {
    /**
     * O mapa a ser exibido em tela
     */
    private Mapa mapa;
    private VisaoMapa visaoMapa;

    public JanelaSimulacao(Mapa mapa) {
        this.mapa = mapa;
        visaoMapa = new VisaoMapa(mapa.getLargura(), mapa.getAltura());
        getContentPane().add(visaoMapa);
        setTitle("Simulator");
        setSize(700, 700);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Mostra o estado atual do mapa.
     */
    public void executarAcao() {
        visaoMapa.preparePaint();
        for (int i = 0; i < mapa.getAltura(); i++) {
            for (int j = 0; j < mapa.getLargura(); j++) {
                if (mapa.getItem(i, j) != null) {// Se existir algum objeto na posicao (i,j)
                    ItemMapa item = mapa.getItem(i, j);
                    Localizacao localizacao = item.getLocalizacaoAtual();
                    visaoMapa.desenharImagem(localizacao.getX(), localizacao.getY(), item.getImagem());
                }
            }
        }
        visaoMapa.repaint();
    }

    /**
     * Fornece uma visualizacao grafica do mapa. Esta eh
     * uma classe interna que define os componentes da GUI.
     * Ela contém alguns detalhes mais avancados sobre GUI
     * que voce pode ignorar para realizacao do seu trabalho.
     */
    private class VisaoMapa extends JPanel {

        private final int VIEW_SCALING_FACTOR = 6;

        private int larguraMapa, alturaMapa;
        private int xScale, yScale;
        private Dimension tamanho;
        private Graphics g;
        private Image imagemMapa;
        private Image background;

        /**
         * Cria um novo componente VisaoMapa.
         */
        public VisaoMapa(int largura, int altura) {
            larguraMapa = largura;
            alturaMapa = altura;
            setBackground(Color.white);
            tamanho = new Dimension(0, 0);
            background = new ImageIcon(getClass().getResource("Imagens/BKG.png")).getImage();
        }

        /**
         * Informa para o gerenciador GUI o tamanho.
         */
        public Dimension getPreferredSize() {
            return new Dimension(larguraMapa * VIEW_SCALING_FACTOR,
                    alturaMapa * VIEW_SCALING_FACTOR);
        }

        /**
         * Prepara para um novo ciclo de exibicao. Uma vez que o componente
         * pode ser redimensionado, calcula o "fator de escala" novamente.
         */
        public void preparePaint() {
            if (!tamanho.equals(getSize())) { // se o tamanho mudou...
                tamanho = getSize();
                imagemMapa = visaoMapa.createImage(tamanho.width, tamanho.height);
                g = imagemMapa.getGraphics();

                xScale = tamanho.width / larguraMapa;
                if (xScale < 1) {
                    xScale = VIEW_SCALING_FACTOR;
                }
                yScale = tamanho.height / alturaMapa;
                if (yScale < 1) {
                    yScale = VIEW_SCALING_FACTOR;
                }
            }
            g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
        }

        /**
         * Desenha a imagem para um determinado item.
         */
        public void desenharImagem(int x, int y, Image image) {
            g.drawImage(image, x * xScale + 1, y * yScale + 1,
                    xScale +10, yScale + 10, this);
        }

        /**
         * O componente VisaoMapa precisa ser reexibido. Copia a
         * imagem interna para a tela.
         */
        public void paintComponent(Graphics g) {
            if (imagemMapa != null) {
                g.drawImage(imagemMapa, 0, 0, null);
            }
        }
    }

}

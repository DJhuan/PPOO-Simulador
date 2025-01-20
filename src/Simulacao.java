import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Simulacao {
    private List<Pessoa> pessoas;
    private List<RaioX> filasRaioX;
    private List<FilaEmbarque> filasEmbarque;
    private JanelaSimulacao janelaSimulacao;
    private Mapa mapa;
    private Random rand;

    public Simulacao() {
        mapa = new Mapa();
        janelaSimulacao = new JanelaSimulacao(mapa, this);
        rand = new Random(98147);
        pessoas = new ArrayList<>();
        filasRaioX = new ArrayList<>();
        filasEmbarque = new ArrayList<>();

        // Inicializa filas de raio-x e embarque
        for (int i = 0; i < 3; i++) {
            filasEmbarque.add(new FilaEmbarque(10, new Localizacao(rand.nextInt(mapa.getLargura()), rand.nextInt(mapa.getAltura()))));
        }
        for (int i = 0; i < 3; i++) {
            filasRaioX.add(new RaioX(10, new Localizacao(rand.nextInt(mapa.getLargura()), rand.nextInt(mapa.getAltura())), 0, filasEmbarque));
        }
    }

    public void executarSimulacao(int numPassos) {
        janelaSimulacao.executarAcao();
        for (int i = 0; i < numPassos; i++) {
            executarUmPasso();
            esperar(100);
        }
    }

    private void executarUmPasso() {
        for (Pessoa p : pessoas) {
            mapa.removerItem(p);
            p.executarAcao();
            mapa.adicionarItem(p);
        }
        for (RaioX raioX : filasRaioX) {
            raioX.continuarAvaliacao();
        }
        for (FilaEmbarque filaEmbarque : filasEmbarque) {
            filaEmbarque.executarAcao();
        }
        janelaSimulacao.executarAcao();
    }

    public void adicionarPessoa() {
        Pessoa p = new Pessoa(new Localizacao(rand.nextInt(mapa.getLargura()), mapa.getAltura() - 1));
        p.setLocalizacaoDestino(new Localizacao(rand.nextInt(mapa.getLargura()), rand.nextInt(mapa.getAltura())));

        pessoas.add(p);

        // Adiciona a pessoa em uma fila de raio-x aleatória
        RaioX filaRaioX = filasRaioX.get(rand.nextInt(filasRaioX.size()));
        filaRaioX.adicionarPessoa(p);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public List<RaioX> getFilasRaioX() {
        return filasRaioX;
    }

    public List<FilaEmbarque> getFilasEmbarque() {
        return filasEmbarque;
    }

    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
import java.util.Random;
import java.util.Vector;

/**
 * Responsavel pela simulacao.
 * 
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Simulacao {
    private Vector<Pessoa> pessoas;
    private JanelaSimulacao janelaSimulacao;
    private Mapa mapa;
    private Random rand;

    public Simulacao() {
        mapa = new Mapa();
        janelaSimulacao = new JanelaSimulacao(mapa, this);
        rand = new Random(98147);
        pessoas = new Vector<Pessoa>();
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
        janelaSimulacao.executarAcao();
    }

    public void adicionarPessoa() {
        Pessoa p = new Pessoa(new Localizacao(rand.nextInt(mapa.getLargura()), mapa.getAltura() - 1));
        p.setLocalizacaoDestino(new Localizacao(rand.nextInt(mapa.getLargura()), rand.nextInt(mapa.getAltura())));

        pessoas.add(p);
    }

    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}

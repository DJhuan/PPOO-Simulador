import java.util.Random;
import java.util.Vector;
/**
 * Responsavel pela simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Simulacao {
    private Vector<Veiculo> veiculos;
    private JanelaSimulacao janelaSimulacao;
    private Mapa mapa;
    private Random rand;
    
    public Simulacao() {
        mapa = new Mapa();
        janelaSimulacao = new JanelaSimulacao(mapa, this);
        rand = new Random(95462);
        veiculos = new Vector<Veiculo>();
    }
    
    public void executarSimulacao(int numPassos){
        janelaSimulacao.executarAcao();
        for (int i = 0; i < numPassos; i++) {
            executarUmPasso();
            esperar(100);
        }        
    }

    private void executarUmPasso() {
        for (Veiculo v : veiculos){
            mapa.removerItem(v);
            v.executarAcao();
            mapa.adicionarItem(v);
        }
        
        janelaSimulacao.executarAcao();
    }

    public void adicionarVeiculo(){
        Veiculo v = new Veiculo(new Localizacao(rand.nextInt(mapa.getLargura()),rand.nextInt(mapa.getAltura())));
        v.setLocalizacaoDestino(new Localizacao(rand.nextInt(mapa.getLargura()),rand.nextInt(mapa.getAltura())));

        veiculos.add(v);
    }
    
    private void esperar(int milisegundos){
        try{
            Thread.sleep(milisegundos);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    
}

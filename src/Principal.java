/**
 * Classe que instancia e inicia a simulação
 * @author Luiz Merschmann
 */
public class Principal {

    public static void main(String[] args) {
        Simulacao sim = new Simulacao();
        while (true){
            sim.executarSimulacao(1);
        }
    }
}

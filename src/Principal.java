/**
 * Classe que instancia e inicia a simulação
 * @author Luiz Merschmann
 * @author Ana Clara Carvalho Nascimento
 * @author Isadora Gomes Melo Cunha
 * @author Jhuan Carlos Sabaini Dassie
 * @author Wesley Filipe Rocha da Silva
 */
public class Principal {
    /**
     * Ponto inicial da aplicação
     * @param args Argumentos da linha de comando
     */
    public static void main(String[] args) {
        Simulacao sim = new Simulacao();
        while (true){
            sim.executarSimulacao(1);
        }
    }
}

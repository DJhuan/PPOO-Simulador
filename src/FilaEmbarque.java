import java.util.Random;

/**
 * Classe que representa uma fila de embarque no mapa
 * @author Ana Clara Carvalho Nascimento
 * @author Isadora Gomes Melo Cunha
 * @author Jhuan Carlos Sabaini Dassie
 * @author Wesley Filipe Rocha da Silva
 */

public class FilaEmbarque extends FilaAeroporto {
    /**
     * gerador de números aleatórios
     */
    public static Random rand;

    /**
     * Guarda se o embarque está disponível para as pessoas da fila
     */
    private boolean embarqueDisponivel;

    /**
     * Guarda o tempo que o embarque ficará disponível
     */
    private int tempoParaEmbarcar;

    /**
     * Guarda o tempo que a fila aguardará antes do próximo embarque
     */
    private int tempoDeVoo;

    /**
     * Construtor para a classe FilaEmbarque.
     * 
     * @param localizacao Localização da fila no mapa.
     */
    public FilaEmbarque(Localizacao localizacao) {
        super(localizacao, "Imagens/FilaEmbarque.png");
        embarqueDisponivel = false;
        rand = new Random();

        tempoParaEmbarcar = 0;
        tempoDeVoo = 5 + rand.nextInt(10); // Temporizador inicial aleatório entre 5 e 14
    }

    /**
     * Define se o embarque está disponível ou não
     * @param embarqueDisponivel boolean que define disponibilidade do embarque
     */
    public void setEmbarqueDisponivel(boolean embarqueDisponivel) {
        this.embarqueDisponivel = embarqueDisponivel;
    }

    /**
     * Retorna se o embarque está disponível ou não
     * @return boolean de disponibilidade do embarque
     */
    public boolean getEmbarqueDisponivel() {
        return embarqueDisponivel;
    }

    /**
     * Se o embarque estiver disponível, remove uma pessoa da fila.
     * Caso contrário, decrementa o temporizador e verifica se o embarque deve ficar disponível.
     * 
     * @return Pessoa que saiu da fila, ou null se nenhuma pessoa saiu.
     */
    @Override
    public Pessoa executarAcao() {

        if (embarqueDisponivel){
            // Se o embarque estiver disponível, remove uma pessoa da fila
            Pessoa p = super.removerPessoa();

            // Decrementa o tempo de embarque
            tempoParaEmbarcar--;

            // Se o tempo de embarque acabou, o embarque não está mais disponível
            // Define um tempo de voo para que o avião não retorne imediatamente
            if (tempoParaEmbarcar <= 0){
                embarqueDisponivel = false;
                tempoDeVoo = rand.nextInt(30) + 51;
            }

            // Retorna a pessoa que saiu da fila (ou null se nenhuma pessoa saiu)
            return p;

        } else {
            // Se o embarque não estiver disponível, decrementa o tempo de voo
            tempoDeVoo--;

            // Se o tempo de voo acabou, o embarque está disponível
            // Define o tempo que o avião irá esperar para embarcar
            if (tempoDeVoo <= 0){
                embarqueDisponivel = true;
                tempoParaEmbarcar = rand.nextInt(30) + 51;
            }

            return null;
        }
    }
}


import java.util.Random;

public class FilaEmbarque extends FilaAeroporto {
    private boolean embarqueDisponivel;
    private int tempoParaEmbarcar;
    private Random rand;
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
        tempoDeVoo = 5 + rand.nextInt(10); // Temporizador inicial aleatório entre 1 e 10
    }

    public void setEmbarqueDisponivel(boolean embarqueDisponivel) {
        this.embarqueDisponivel = embarqueDisponivel;
    }
    
    public boolean getEmbarqueDisponivel() {
        return embarqueDisponivel;
    }

    @Override
    public void adicionarPessoa(Pessoa novaPessoa) {
        super.adicionarPessoa(novaPessoa);
        embarqueDisponivel = true;
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
            Pessoa p = super.removerPessoa();

            tempoParaEmbarcar--;

            if (tempoParaEmbarcar <= 0){
                embarqueDisponivel = false;
                tempoDeVoo = rand.nextInt(30) + 51;
            }

            return p;

        } else {
            tempoDeVoo--;

            if (tempoDeVoo <= 0){
                embarqueDisponivel = true;
                tempoParaEmbarcar = rand.nextInt(30) + 51;
            }

            return null;
        }
    }
}


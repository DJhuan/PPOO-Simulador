import java.util.Random;

public class FilaEmbarque extends FilaAeroporto {
    private boolean embarqueDisponivel;
    private int timerEmbarque;
    private Random rand;

    /**
     * Construtor para a classe FilaEmbarque.
     * 
     * @param tamanhoFila Tamanho máximo da fila.
     * @param localizacao Localização da fila no mapa.
     */
    public FilaEmbarque(int tamanhoFila, Localizacao localizacao) {
        super(tamanhoFila, localizacao, "Imagens/Embarque/FilaEmbarque.png");
        this.embarqueDisponivel = false;
        this.rand = new Random();
        this.timerEmbarque = rand.nextInt(10) + 1; // Temporizador inicial aleatório entre 1 e 10
    }

    public void setEmbarqueDisponivel(boolean embarqueDisponivel) {
        this.embarqueDisponivel = embarqueDisponivel;
    }

    @Override
    public void adicionarPessoa(Pessoa novaPessoa) {
        super.adicionarPessoa(novaPessoa);
    }

    /**
     * Se o embarque estiver disponível, remove uma pessoa da fila.
     * Caso contrário, decrementa o temporizador e verifica se o embarque deve ficar disponível.
     * 
     * @return Pessoa que saiu da fila, ou null se nenhuma pessoa saiu.
     */
    @Override
    public Pessoa executarAcao() {
        if (embarqueDisponivel) {
            return super.removerPessoa();
        }

        if (super.getFilaDePessoas().isEmpty()) {
            embarqueDisponivel = false;
        }

        // Decrementa o temporizador e verifica se o embarque deve ficar disponível
        if (timerEmbarque > 0) {
            timerEmbarque--;
        } else {
            setEmbarqueDisponivel(true);
            timerEmbarque = rand.nextInt(10) + 1; // Reinicia o temporizador aleatório
        }

        return null;
    }
}


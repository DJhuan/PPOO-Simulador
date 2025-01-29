import java.util.Random;

public class FilaEmbarque extends FilaAeroporto {
    private boolean embarqueDisponivel;
    private Pessoa pessoaAtual;
    private int tempoDeEmbarque;
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
        this.tempoDeEmbarque = rand.nextInt(10) + 1; // Temporizador inicial aleatório entre 1 e 10
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
        if(!embarqueDisponivel){
            return null;
        }

        if(tempoDeEmbarque > 0){
            tempoDeEmbarque--;
            return pessoaAtual;
        }

        Pessoa p = super.removerPessoa();
        if(p == null) {
            embarqueDisponivel = false;
            return null;
        }

        pessoaAtual = p;
        tempoDeEmbarque = rand.nextInt(100) + 1;
        return pessoaAtual;
    }
}


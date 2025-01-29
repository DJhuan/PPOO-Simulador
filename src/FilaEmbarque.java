import java.util.Random;

public class FilaEmbarque extends FilaAeroporto {
    private boolean embarqueDisponivel;
    private Pessoa pessoaAtual;
    private int tempoDeEmbarque;
    private Random rand;

    /**
     * Construtor para a classe FilaEmbarque.
     * 
     * @param localizacao Localização da fila no mapa.
     */
    public FilaEmbarque(Localizacao localizacao) {
        super(localizacao, "Imagens/FilaEmbarque.png");
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
        // Embarque não disponível, ninguém sai da fila
        if(!embarqueDisponivel){
            return null;
        }

        // Embarque disponível, ainda estamos embarcando, removemos a pessoa atual
        if(tempoDeEmbarque > 0){
            tempoDeEmbarque--;
            return pessoaAtual;
        }

        // Embarque disponível, acabou o tempo de embarque
        // Verificamos se ainda restam pessoas a embarcar
        // Caso haja, então dizemos que não se pode mais embarcar
        Pessoa p = super.removerPessoa();
        if(p == null) {
            embarqueDisponivel = false;
            return null;
        }

        // Caso não haja, então a embarcamos e definimos o próximo tempo de embarque
        pessoaAtual = p;
        tempoDeEmbarque = rand.nextInt(100) + 1;
        return pessoaAtual;
    }
}


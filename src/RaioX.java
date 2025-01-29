public class RaioX extends FilaAeroporto {
    private Pessoa avaliadoAtual;
    private int timerAvaliacao;

    /**
     * Construtor para a classe RaioX.
     * 
     * @param tamanhoFila Tamanho máximo da fila.
     * @param localizacao Localização da fila no mapa.
     */
    public RaioX(int tamanhoFila, Localizacao localizacao) {
        super(tamanhoFila, localizacao, "Imagens/RaioX.png");
        this.timerAvaliacao = 0;
    }

    /** 
     * Avalia a pessoa atual, decrementando o temporizador.
     * Se a avaliação terminar, remove a pessoa da fila.
     * 
     * @return Pessoa que saiu da fila, ou null se nenhuma pessoa saiu.
     */
    @Override
    public Pessoa executarAcao(){
        if (timerAvaliacao == 0 && avaliadoAtual != null){
            // Terminamos de avaliar a pessoa
            Pessoa avaliadoConcluido = avaliadoAtual;
            avaliadoAtual = null;
            return avaliadoConcluido;
        }
        else if (avaliadoAtual != null) {
            // Continuamos avaliando a pessoa
            timerAvaliacao--;
        } else if (avaliadoAtual == null) {
            // Começamos a avaliar a próxima pessoa
            avaliadoAtual = super.removerPessoa();
            if (avaliadoAtual != null) {
                timerAvaliacao = avaliadoAtual.getPesoBagagem();
            }
        }

        return null;
    }
}

public class RaioX extends FilaAeroporto {
    private Pessoa avaliadoAtual;
    private int timerAvaliacao;

    public RaioX(int tamanhoFila, Localizacao localizacao) {
        super(tamanhoFila, localizacao);
        this.timerAvaliacao = 0;
    }

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

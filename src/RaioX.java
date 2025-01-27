public class RaioX extends FilaAeroporto {
    private Pessoa avaliadoAtual;
    private int timerAvaliacao;

    public RaioX(int tamanhoFila, Localizacao localizacao) {
        super(tamanhoFila, localizacao);
        this.timerAvaliacao = 0;
    }

    public Pessoa executarAcao(){
        if (timerAvaliacao == 0 && avaliadoAtual != null){
            Pessoa avaliadoConcluido = avaliadoAtual;
            avaliadoAtual = null;
            return avaliadoConcluido;
        }
        else if (avaliadoAtual != null) {
            timerAvaliacao--;
        } else if (avaliadoAtual == null) {
            avaliadoAtual = super.removerPessoa();
            if (avaliadoAtual != null) {
                timerAvaliacao = avaliadoAtual.getPesoBagagem();
            }
        }

        return null;
    }
}

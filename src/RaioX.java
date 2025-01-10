public class RaioX extends FilaAeroporto {
    private Pessoa avaliadoAtual;
    private int timerAvaliacao;

    public RaioX(int tamanhoFila, Localizacao localizacao, int timerAvaliacao) {
        super(tamanhoFila, localizacao);
        this.timerAvaliacao = timerAvaliacao;
    }

    public void setAvaliadoAtual(Pessoa avaliadoAtual) {
        this.avaliadoAtual = avaliadoAtual;
    }

    public void setTimerAvaliacao(int timerAvaliacao) {
        this.timerAvaliacao = timerAvaliacao;
    }

    // public Pessoa concluirAvaliadoAtual() {

    // }

    public void continuarAvaliacao() {
        
    }
}

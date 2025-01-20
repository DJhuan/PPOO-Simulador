import java.util.List;
import java.util.Random;

public class RaioX extends FilaAeroporto {
    private int timerAvaliacao;
    private Pessoa avaliadoAtual;
    private List<FilaEmbarque> filasEmbarque;
    private Random rand;

    public RaioX(int tamanhoFila, Localizacao localizacao, int timerAvaliacao, List<FilaEmbarque> filasEmbarque) {
        super(tamanhoFila, localizacao);
        this.timerAvaliacao = timerAvaliacao;
        this.filasEmbarque = filasEmbarque;
        this.rand = new Random();
    }

    public void setAvaliadoAtual(Pessoa avaliadoAtual) {
        this.avaliadoAtual = avaliadoAtual;
    }

    public void setTimerAvaliacao(int timerAvaliacao) {
        this.timerAvaliacao = timerAvaliacao;
    }

    public Pessoa concluirAvaliadoAtual() {
        Pessoa liberado = avaliadoAtual;
        avaliadoAtual = null;
        return liberado;
    }

    public void continuarAvaliacao() {
        if (avaliadoAtual != null) {
            timerAvaliacao--;
            if (timerAvaliacao <= 0) {
                Pessoa liberado = concluirAvaliadoAtual();
                // Adiciona a pessoa liberada em uma fila de embarque aleatória
                FilaEmbarque filaEmbarque = filasEmbarque.get(rand.nextInt(filasEmbarque.size()));
                filaEmbarque.adicionarPessoa(liberado);
            }
        } else if (!filaDePessoas.isEmpty()) {
            avaliadoAtual = filaDePessoas.remove(0);
            timerAvaliacao = avaliadoAtual.getPesoBagagem();
        }
    }
}
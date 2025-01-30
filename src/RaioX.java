/**
 * Classe que representa a fila de raio-x do aeroporto.
 * Avalia as pessoas da fila, removendo-as após a avaliação.
 * Quanto maior o peso da bagagem da pessoa, mais tempo ela leva para ser avaliada.
 * @author Ana Clara Carvalho Nascimento
 * @author Isadora Gomes Melo Cunha
 * @author Jhuan Carlos Sabaini Dassie
 * @author Wesley Filipe Rocha da Silva
 */
public class RaioX extends FilaAeroporto {
    /**
     * Guarda a pessoa que está sendo avaliada no momento.
     */
    private Pessoa avaliadoAtual;

    /**
     * Guarda o tempo restante para a avaliação da pessoa atual.
     */
    private int timerAvaliacao;

    /**
     * Construtor para a classe RaioX.
     * 
     * @param localizacao Localização da fila no mapa.
     */
    public RaioX(Localizacao localizacao) {
        super(localizacao, "Imagens/RaioX.png");
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
        if (timerAvaliacao <= 0 && avaliadoAtual != null){
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

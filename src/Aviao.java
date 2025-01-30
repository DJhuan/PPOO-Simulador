/**
 * Classe que representa um avião no mapa
 * Essa classe tem como objetivo fornecer uma dica visual do que acontece na fila de embarque
 * @author Ana Clara Carvalho Nascimento
 * @author Isadora Gomes Melo Cunha
 * @author Jhuan Carlos Sabaini Dassie
 * @author Wesley Filipe Rocha da Silva
 */
public class Aviao extends ItemMapa {

    /**
     * Guarda o limite inferior que o avião pode descer
     * normalmente pos Y da fila de embarque que ele representa
     */
    private int limiteInferior;

    /**
     * Construtor da classe aviao
     * @param localizacao Localização inicial do avião
     * @param limiteInferior Limite inferior que o avião pode descer
     */
    public Aviao(Localizacao localizacao, int limiteInferior) {
        super(localizacao, "Imagens/Aviao.png");
        this.limiteInferior = limiteInferior;
    }

    /**
     * Move o avião para baixo em uma unidade no mapa
     */
    private void descerAviao() {
        Localizacao localizacao = super.getLocalizacaoAtual();
        super.setLocalizacaoAtual(new Localizacao(localizacao.getX(), localizacao.getY() + 1));
    }

    /**
     * Move o avião para cima em uma unidade no mapa
     */
    private void subirAviao() {
        Localizacao localizacao = super.getLocalizacaoAtual();
        super.setLocalizacaoAtual(new Localizacao(localizacao.getX(), localizacao.getY() - 1));
    }

    /**
     * Lógica de atualização do avião
     * Se o embarque não estiver disponível, o avião sobe
     * Se o embarque estiver disponível, o avião desce
     * @param embarqueDisponivel Indica se o embarque está disponível
     */
    public void executarAcao(boolean embarqueDisponivel) {
        Localizacao localizacao = super.getLocalizacaoAtual();
        if(!embarqueDisponivel) {
            if(localizacao.getY() == 1){
                return;
            }
            subirAviao();
            return;
        }

        if(localizacao.getY() < limiteInferior) {
            descerAviao();
        } 
    }
}

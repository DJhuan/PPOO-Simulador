import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * Classe que representa um avião no mapa
 * Essa classe tem como objetivo fornecer uma dica visual do que acontece na fila de embarque
 */

public class Aviao implements ItemMapa {
    private Localizacao localizacao;
    private Image imagem;
    private int limiteInferior;

    /*
     * Construtor da classe
     * @param localizacao Localização inicial do avião
     * @param limiteInferior Limite inferior que o avião pode descer (normalmente pos Y da fila de embarque)
     */
    public Aviao(Localizacao localizacao, int limiteInferior) {
        this.localizacao = localizacao;
        this.imagem = new ImageIcon(getClass().getResource("Imagens/Aviao.png")).getImage();
        this.limiteInferior = limiteInferior;
    }

    @Override
    public Localizacao getLocalizacaoAtual() {
        return localizacao;
    }

    @Override
    public Image getImagem() {
        return imagem;
    }

    /*
     * Move o avião para baixo em uma unidade no mapa
     */
    private void descerAviao() {
        localizacao = new Localizacao(localizacao.getX(), localizacao.getY() + 1);
    }

    /*
     * Move o avião para cima em uma unidade no mapa
     */
    private void subirAviao() {
        localizacao = new Localizacao(localizacao.getX(), localizacao.getY() - 1);
    }

    /*
     * Lógica de atualização do avião
     * Se o embarque não estiver disponível, o avião sobe
     * Se o embarque estiver disponível, o avião desce
     */
    public void executarAcao(boolean embarqueDisponivel) {
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

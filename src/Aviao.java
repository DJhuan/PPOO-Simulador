import java.awt.Image;
import javax.swing.ImageIcon;

/*
 * Classe que representa um avião no mapa
 * Essa classe tem como objetivo fornecer uma dica visual do que acontece na fila de embarque
 */
public class Aviao implements ItemMapa {
    /*
     * Guarda a localização do avião
     * O avião desce no mapa relativa a essa posição
     */
    private Localizacao localizacao;

    /*
     * Guarda a imagem do avião
     */
    private Image imagem;

    /*
     * Guarda o limite inferior que o avião pode descer
     * normalmente pos Y da fila de embarque que ele representa
     */
    private int limiteInferior;

    /*
     * Construtor da classe aviao
     */
    public Aviao(Localizacao localizacao, int limiteInferior) {
        this.localizacao = localizacao;
        this.imagem = new ImageIcon(getClass().getResource("Imagens/Aviao.png")).getImage();
        this.limiteInferior = limiteInferior;
    }

    /*
     * Retorna a localização atual do avião
     */
    @Override
    public Localizacao getLocalizacaoAtual() {
        return localizacao;
    }

    /*
     * Retorna a imagem do avião
     */
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

import java.awt.Image;
import javax.swing.ImageIcon;

public class Aviao implements ItemMapa {
    private Localizacao localizacao;
    private Image imagem;
    private int limiteInferior;

    public Aviao(Localizacao localizacao, int limiteInferior) {
        this.localizacao = localizacao;
        this.imagem = new ImageIcon(getClass().getResource("Imagens/RX/RX1.png")).getImage();
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

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public void descerAviao() {
        localizacao = new Localizacao(localizacao.getX(), localizacao.getY() + 1);
    }

    public void subirAviao() {
        localizacao = new Localizacao(localizacao.getX(), localizacao.getY() - 1);
    }

    public void executarAcao(boolean embarqueDisponivel) {
        /* if(!embarqueDisponivel && localizacao.getY() <= limiteInferior) {
            localizacao = new Localizacao(localizacao.getX(), localizacao.getY() + 1);
        } else if(localizacao.getY() > 0) {
            localizacao = new Localizacao(localizacao.getX(), localizacao.getY() - 1);
        } */
        if(!embarqueDisponivel) {
            if(localizacao.getY() == 1){
                return;
            }
            subirAviao();
            System.out.println("Subindo avião");
            return;
        }

        if(localizacao.getY() < limiteInferior) {
            descerAviao();
            System.out.println("Descendo avião");
        } 
    }
}

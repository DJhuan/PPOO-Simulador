import java.awt.Image;
import javax.swing.ImageIcon;

public class Aviao implements ItemMapa {
    private Localizacao localizacao;
    private Image imagem;

    public Aviao(Localizacao localizacao) {
        this.localizacao = localizacao;
        this.imagem = new ImageIcon(getClass().getResource("Imagens/RX/RX1.png")).getImage();
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
}

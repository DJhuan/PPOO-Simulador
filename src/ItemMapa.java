import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * Classe abstrata que representa um item no mapa
 * 
 * @author Ana Clara Carvalho Nascimento
 * @author Isadora Gomes Melo Cunha
 * @author Jhuan Carlos Sabaini Dassie
 * @author Wesley Filipe Rocha da Silva
 */
public abstract class ItemMapa {
    /**
     * Guarda a imagem do item
     */
    private Image imagem;

    /**
     * Guarda a localização atual do item
     */
    private Localizacao localizacaoAtual;

    /**
     * Construtor da classe ItemMapa.
     * @param localizacaoAtual Localização inicial do item
     * @param caminhoImagem Caminho da imagem do item
     */
    public ItemMapa(Localizacao localizacaoAtual, String caminhoImagem){
        this.localizacaoAtual = localizacaoAtual;
        this.imagem = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
    }

    /**
     * Retorna a imagem do item.
     * @return Imagem do item
     */
    public Image getImagem(){
        return imagem;
    }

    /**
     * Retorna a localização atual do item.
     * @return Localização atual do item
     */
    public Localizacao getLocalizacaoAtual(){
        return localizacaoAtual;
    }

    /**
     * Modifica a localização atual do item.
     * @param localizacaoAtual Localização a ser substituída
     */
    public void setLocalizacaoAtual(Localizacao localizacaoAtual){
        this.localizacaoAtual = localizacaoAtual;
    }
}

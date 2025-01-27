import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Representa os veiculos da simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Pessoa {
    private static Random rand = new Random(96587);

    private Localizacao localizacaoAtual;
    private Localizacao localizacaoDestino;
    private Image imagem;
    private int pesoBagagem;

    public Pessoa(Localizacao localizacao) {
        this.localizacaoAtual = localizacao;
        localizacaoDestino = null;

        String caminho = "Imagens/Pessoas/Pessoa" + (rand.nextInt(6) + 1) + ".png";
        imagem = new ImageIcon(getClass().getResource(caminho)).getImage();

        int pesoBagagem = rand.nextInt(10) + 1;
    }

    public Localizacao getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    public Localizacao getLocalizacaoDestino() {
        return localizacaoDestino;
    }
    
    public Image getImagem(){
        return imagem;
    }

    public int getPesoBagagem() {
        return pesoBagagem;
    }

    public void setLocalizacaoAtual(Localizacao localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
    }

    public void setLocalizacaoDestino(Localizacao localizacaoDestino) {
        this.localizacaoDestino = localizacaoDestino;
    }

    public void setPesoBagagem(int pesoBagagem) {
        this.pesoBagagem = pesoBagagem;
    }
    
    public void executarAcao(){
        Localizacao destino = getLocalizacaoDestino();
        if(destino != null){
            Localizacao proximaLocalizacao = getLocalizacaoAtual().proximaLocalizacao(localizacaoDestino);
            setLocalizacaoAtual(proximaLocalizacao);
        }
    } 
}

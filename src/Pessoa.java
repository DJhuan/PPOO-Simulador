import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Representa os veiculos da simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Pessoa implements ItemMapa{
    private static Random rand = new Random(96587);

    private Localizacao localizacaoAtual;
    private Localizacao localizacaoDestino;
    private Image imagem;
    private int pesoBagagem;
    private int filaDestino;

    public Pessoa(Localizacao localizacao, int filaDestino) {
        this.localizacaoAtual = localizacao;
        localizacaoDestino = null;
        this.filaDestino = filaDestino;

        String caminho = "Imagens/Pessoas/Pessoa" + (rand.nextInt(6) + 1) + ".png";
        imagem = new ImageIcon(getClass().getResource(caminho)).getImage();

        pesoBagagem = rand.nextInt(6);
    }

    public int getFilaDestino() {
        return filaDestino;
    }

    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }

    @Override
    public Localizacao getLocalizacaoAtual() {
        return localizacaoAtual;
    }

    public Localizacao getLocalizacaoDestino() {
        return localizacaoDestino;
    }

    @Override
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

    public boolean alcancouDestino(){
        return localizacaoAtual.equals(localizacaoDestino);
    }

    public void executarAcao(){
        Localizacao destino = getLocalizacaoDestino();
        if(destino != null){
            Localizacao proximaLocalizacao = getLocalizacaoAtual().proximaLocalizacao(localizacaoDestino);
            setLocalizacaoAtual(proximaLocalizacao);
        }
    } 
}

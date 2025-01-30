import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

/**
 * Representa os veiculos da simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Pessoa implements ItemMapa{
    private static Random rand = new Random(96587);

    /*Representa a localizacao atual de uma pessoa;
    */
    private Localizacao localizacaoAtual;
    /*
    Representa a localizacao (x,y) de destino de uma pessoa;
    */ 
    private Localizacao localizacaoDestino;
    /*
    Imagem representativa de uma pessoa no mapa;
    */
    private Image imagem;
    /*
    Representa o peso da bagagem de uma pessoa a ser pesado no raio-x;
    */
    private int pesoBagagem;
    /*Número da fila (raiox ou embarque) que a pessoa será destinada ;
    */
    private int filaDestino;


    /**
     * Construtor da classe
     * 
     * @param localizacao Localização inicial da pessoa
     * @param filaDestino Número randomico da fila de embarque de destino
    */
    public Pessoa(Localizacao localizacao, int filaDestino) {
        this.localizacaoAtual = localizacao;
        localizacaoDestino = null;
        this.filaDestino = filaDestino;

        String caminho = "Imagens/Pessoas/Pessoa" + (rand.nextInt(6) + 1) + ".png";
        imagem = new ImageIcon(getClass().getResource(caminho)).getImage();

        pesoBagagem = rand.nextInt(6);
    }
    /*
     * Retorna o número da fila de destino
    */
    public int getFilaDestino() {
        return filaDestino;
    }
    /*
     * Modifica a fila de destino de raiox para fila de embarque 
    */
    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }
    /*
     * Retorna a localização atual da pessoa
    */
    @Override
    public Localizacao getLocalizacaoAtual() {
        return localizacaoAtual;
    }
    /*
     * Retorna a localização de destino da pessoa
    */
    public Localizacao getLocalizacaoDestino() {
        return localizacaoDestino;
    }
    /*
     * Retorna a imagem da pessoa
    */
    @Override
    public Image getImagem(){
        return imagem;
    }
    /*
     * Retorna o peso da bagagem da pessoa
    */
    public int getPesoBagagem() {
        return pesoBagagem;
    }
    /*
     * Modifica a localização atual da pessoa
    */
    public void setLocalizacaoAtual(Localizacao localizacaoAtual) {
        this.localizacaoAtual = localizacaoAtual;
    }
    /*
     * Modifica a localização de destino da pessoa
    */
    public void setLocalizacaoDestino(Localizacao localizacaoDestino) {
        this.localizacaoDestino = localizacaoDestino;
    }
    /*
     * Modifica o peso da bagagem da pessoa
    */
    public void setPesoBagagem(int pesoBagagem) {
        this.pesoBagagem = pesoBagagem;
    }
    
    /**
     * 
     * Verifica se a pessoa chegou ao seu destino.
     * @return True se a localização atual for igual a localização de destino, ou False se forem diferentes
     */
    public boolean alcancouDestino(){
        return localizacaoAtual.equals(localizacaoDestino);
    }

    /**
     * 
     * Solicita a movimentação da pessoa para a próxima localização.
    */
    public void executarAcao(){
        Localizacao destino = getLocalizacaoDestino();
        if(destino != null){
            Localizacao proximaLocalizacao = getLocalizacaoAtual().proximaLocalizacao(localizacaoDestino);
            setLocalizacaoAtual(proximaLocalizacao);
        }
    } 
}

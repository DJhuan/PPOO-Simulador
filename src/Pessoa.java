import java.util.Random;

/**
 * Representa os veiculos da simulacao.
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 * @author Ana Clara Carvalho Nascimento
 * @author Isadora Gomes Melo Cunha
 * @author Jhuan Carlos Sabaini Dassie
 * @author Wesley Filipe Rocha da Silva
 */
public class Pessoa extends ItemMapa{
    /**
     * Gerador de números aleatórios para definir peso da bagagem.
     */
    private static Random rand = new Random(96587);

    /*
    Representa a localizacao (x,y) de destino de uma pessoa;
    */ 
    private Localizacao localizacaoDestino;

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
        super(localizacao, "Imagens/Pessoas/Pessoa" + (rand.nextInt(6) + 1) + ".png");
        localizacaoDestino = null;
        this.filaDestino = filaDestino;
        pesoBagagem = rand.nextInt(6);
    }

    /**
     * Retorna o número da fila de destino
     * @return Número da fila de destino
     */
    public int getFilaDestino() {
        return filaDestino;
    }

    /**
     * Modifica a fila de destino de raiox para fila de embarque 
     * @param filaDestino Número da fila de destino
     */
    public void setFilaDestino(int filaDestino) {
        this.filaDestino = filaDestino;
    }

    /**
     * Retorna a localização de destino da pessoa
     * @return Localização de destino da pessoa
     */
    public Localizacao getLocalizacaoDestino() {
        return localizacaoDestino;
    }

    /**
     * Retorna o peso da bagagem da pessoa
     * @return int peso da bagagem da pessoa
     */
    public int getPesoBagagem() {
        return pesoBagagem;
    }

    /**
     * Modifica a localização de destino da pessoa
     * @param localizacaoDestino nova Localização de destino da pessoa
     */
    public void setLocalizacaoDestino(Localizacao localizacaoDestino) {
        this.localizacaoDestino = localizacaoDestino;
    }

    /**
     * Modifica o peso da bagagem da pessoa
     * @param pesoBagagem Peso da bagagem da pessoa
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
        return super.getLocalizacaoAtual().equals(localizacaoDestino);
    }

    /**
     * 
     * Solicita a movimentação da pessoa para a próxima localização.
    */
    public void executarAcao(){
        Localizacao destino = getLocalizacaoDestino();
        if(destino != null){
            Localizacao proximaLocalizacao = getLocalizacaoAtual().proximaLocalizacao(localizacaoDestino);
            super.setLocalizacaoAtual(proximaLocalizacao);
        }
    } 
}

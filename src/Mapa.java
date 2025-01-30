/**
 * Representa um mapa com todos os itens que podem ser desenhados em tela
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Mapa {
    private ItemMapa[][] itensDoMapa;
    private int largura;
    private int altura;

    private static final int LARGURA_PADRAO = 30;
    private static final int ALTURA_PADRAO = 30;

    /**
     * Cria mapa para alocar pessoas da simulacao.
     * @param largura: largura da área de simulacao.
     * @param altura:  altura da área de simulação.
     */
    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        itensDoMapa = new ItemMapa[altura][largura];
    }

    /**
     * Cria mapa com tamanho padrao.
     */
    public Mapa() {
        this(LARGURA_PADRAO, ALTURA_PADRAO);
    }
    
    /**
     * Adiciona um item ao mapa
     * @param i Item a ser adicionado
     */
    public void adicionarItem(ItemMapa i){
        itensDoMapa[i.getLocalizacaoAtual().getX()][i.getLocalizacaoAtual().getY()] = i;
    }
    
    /**
     * Remove um item do mapa
     * @param i Item a ser removido
     */
    public void removerItem(ItemMapa i){
        itensDoMapa[i.getLocalizacaoAtual().getX()][i.getLocalizacaoAtual().getY()] = null;
    }
    
    /**
     * Atualiza a posicao de um item no mapa
     * @param i Item a ser atualizado
     */
    public void atualizarMapa(ItemMapa i){
        removerItem(i);
        adicionarItem(i);
    }
    
    /**
     * Retorna o item da posicao (x, y) do mapa
     * @param x Coordenada x
     * @param y Coordenada y
     * @return Item na posicao (x, y)
     */
    public ItemMapa getItem(int x, int y){
        return itensDoMapa[x][y];
    }

    /**
     * Retorna a largura do mapa
     * @return int largura do mapa 
     */
    public int getLargura() {
        return largura;
    }

    /**
     * Retorna a altura do mapa
     * @return int largura do mapa 
     */
    public int getAltura() {
        return altura;
    }

}

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
    
    public void adicionarItem(ItemMapa i){
        itensDoMapa[i.getLocalizacaoAtual().getX()][i.getLocalizacaoAtual().getY()] = i;
    }
    
    public void removerItem(ItemMapa i){
        itensDoMapa[i.getLocalizacaoAtual().getX()][i.getLocalizacaoAtual().getY()] = null;
    }
    
    public void atualizarMapa(ItemMapa i){
        removerItem(i);
        adicionarItem(i);
    }
    
    public ItemMapa getItem(int x, int y){
        return itensDoMapa[x][y];
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

}

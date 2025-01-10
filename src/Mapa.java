/**
 * Representa um mapa com todos as pessoas que participam da simulacao
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 */
public class Mapa {
    private Pessoa[][] pessoas;
    private int largura;
    private int altura;
    
    private static final int LARGURA_PADRAO = 35;
    private static final int ALTURA_PADRAO = 35;
    
    /**
     * Cria mapa para alocar pessoas da simulacao.
     * @param largura: largura da área de simulacao.
     * @param altura: altura da área de simulação.
     */
    public Mapa(int largura, int altura) {
        this.largura = largura;
        this.altura = altura;
        pessoas = new Pessoa[altura][largura];
    }
    /**
     * Cria mapa com tamanho padrao.
     */
    public Mapa(){
        this(LARGURA_PADRAO,ALTURA_PADRAO);
    }
    
    public void adicionarItem(Pessoa p){
        pessoas[p.getLocalizacaoAtual().getX()][p.getLocalizacaoAtual().getY()] = p;
    }
    
    public void removerItem(Pessoa p){
        pessoas[p.getLocalizacaoAtual().getX()][p.getLocalizacaoAtual().getY()] = null;
    }
    
    public void atualizarMapa(Pessoa p){
        removerItem(p);
        adicionarItem(p);
    }
    
    public Pessoa getItem(int x, int y){
        return pessoas[x][y];
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }
    
}

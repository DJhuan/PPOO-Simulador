import java.util.List;
import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class FilaAeroporto implements ItemMapa {

    /*
     * Lista de pessoas em uma fila.
     */
    private List<Pessoa> filaDePessoas;
    /*
     * Localização da fila no mapa.
     */
    private Localizacao localizacao;
    /*
     * Imagem representativa da fila no mapa.
     */
    private Image imagem;

    /**
     * Construtor para a classe FilaAeroporto.
     * 
     * @param localizacao   Localização da fila no mapa.
     * @param caminhoImagem Caminho da imagem que representa a fila.
     */
    public FilaAeroporto(Localizacao localizacao, String caminhoImagem) {
        filaDePessoas = new ArrayList<Pessoa>();
        this.localizacao = localizacao;
        imagem = new ImageIcon(getClass().getResource(caminhoImagem)).getImage();
    }

    /*
     * Retorna a localização da fila.
     */
    @Override
    public Localizacao getLocalizacaoAtual() {
        return localizacao;
    }

    /*
     * Retorna a imagem representativa da fila.
     */ 
    @Override
    public Image getImagem() {
        return imagem;
    }

    /**
     * Adiciona uma nova pessoa à fila.
     * 
     * @param novaPessoa Pessoa a ser adicionada à fila.
     */
    public void adicionarPessoa(Pessoa novaPessoa) {
        filaDePessoas.add(novaPessoa);
    }

    /**
     * Remove e retorna a primeira pessoa da fila.
     * 
     * @return Pessoa removida da fila, ou null se a fila estiver vazia.
     */
    public Pessoa removerPessoa() {
        if (filaDePessoas.isEmpty()) {
            return null;
        } else {
            return filaDePessoas.remove(0);
        }
    }

    /**
     * Executa a ação específica da fila.
     * 
     * @return Pessoa que saiu da fila, ou null se nenhuma pessoa saiu.
     */
    abstract public Pessoa executarAcao();
}
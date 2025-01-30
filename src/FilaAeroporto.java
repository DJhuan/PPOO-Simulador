import java.util.List;
import java.util.ArrayList;

/**
 * Classe abstrata que representa uma fila no aeroporto.
 * Possui apenas o básico para coordenar uma fila de pessoas.
 * 
 * @author Ana Clara Carvalho Nascimento
 * @author Isadora Gomes Melo Cunha
 * @author Jhuan Carlos Sabaini Dassie
 * @author Wesley Filipe Rocha da Silva
 * 
 * @see ItemMapa
 * @see FilaEmbarque
 * @see RaioX
 */
public abstract class FilaAeroporto extends ItemMapa {

    /*
     * Lista de pessoas em uma fila.
     */
    private List<Pessoa> filaDePessoas;

    /**
     * Construtor para a classe FilaAeroporto.
     * 
     * @param localizacao   Localização da fila no mapa.
     * @param caminhoImagem Caminho da imagem que representa a fila.
     */
    public FilaAeroporto(Localizacao localizacao, String caminhoImagem) {
        super(localizacao, caminhoImagem);
        filaDePessoas = new ArrayList<Pessoa>();
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
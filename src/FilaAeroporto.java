import java.util.List;
import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class FilaAeroporto implements ItemMapa {
    private int tamanhoFila;
    private List<Pessoa> filaDePessoas;
    private Localizacao localizacao;
    private Image imagem;

    public FilaAeroporto(int tamanhoFila, Localizacao localizacao) {
        this.tamanhoFila = tamanhoFila;
        filaDePessoas = new ArrayList<Pessoa>();
        this.localizacao = localizacao;
        imagem = new ImageIcon(getClass().getResource("Imagens/RX/RX1.png")).getImage();
    }

    public int getTamanhoFila() {
        return tamanhoFila;
    }

    @Override
    public Localizacao getLocalizacaoAtual() {
        return localizacao;
    }

    @Override
    public Image getImagem() {
        return imagem;
    }

    public void adicionarPessoa(Pessoa novaPessoa) {
        filaDePessoas.add(novaPessoa);
    }

    public Pessoa removerPessoa() {
        if (filaDePessoas.isEmpty()) {
            return null;
        } else {
            return filaDePessoas.remove(0);
        }
    }

    abstract public Pessoa executarAcao();
}
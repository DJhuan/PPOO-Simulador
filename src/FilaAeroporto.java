import java.util.List;
import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class FilaAeroporto {
    private int tamanhoFila;
    protected List<Pessoa> filaDePessoas;
    private Localizacao localizacao;
    private Image imagem;

    public FilaAeroporto(int tamanhoFila, Localizacao localizacao) {
        this.tamanhoFila = tamanhoFila;
        filaDePessoas = new ArrayList<>();
        this.localizacao = localizacao;
        imagem = new ImageIcon(getClass().getResource("Imagens/fila.png")).getImage();
    }

    public int getTamanhoFila() {
        return tamanhoFila;
    }

    public int getTamanhoFilaAtual() {
        return filaDePessoas.size();
    }

    public Localizacao getLocalizcao() {
        return localizacao;
    }

    public Image getImagem() {
        return imagem;
    }

    public void adicionarPessoa(Pessoa novaPessoa) {
        filaDePessoas.add(novaPessoa);
    }

    public void removerPessoa() {
        filaDePessoas.remove(0);
    }

    public List<Pessoa> getFilaDePessoas() {
        return filaDePessoas;
    }
}
import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;

public abstract class FilaAeroporto {
    private int tamanhoFila;
    private ArrayList<Pessoa> filaDePessoas;
    private Localizacao localizacao;
    private Image imagem;

    public FilaAeroporto(int tamanhoFila, Localizacao localizacao) {
        this.tamanhoFila = tamanhoFila;
        filaDePessoas = new ArrayList<Pessoa>();
        this.localizacao = localizacao;
        imagem = new ImageIcon(getClass().getResource("Imagens/fila.png")).getImage();
    }

    public int getTamanhoFila() {
        return tamanhoFila;
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

    public Pessoa removerPessoa(Pessoa excluirPessoa) {
        filaDePessoas.remove(excluirPessoa);
        return excluirPessoa;
    }
}
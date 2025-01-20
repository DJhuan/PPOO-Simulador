public class FilaEmbarque extends FilaAeroporto {
    private boolean embarqueDisponivel;
    private boolean aviaoPresente;

    public FilaEmbarque(int tamanhoFila, Localizacao localizacao) {
        super(tamanhoFila, localizacao);
        this.embarqueDisponivel = false;
        this.aviaoPresente = false;
    }

    public void setEmbarqueDisponivel(boolean embarqueDisponivel) {
        this.embarqueDisponivel = embarqueDisponivel;
    }

    public void setAviaoPresente(boolean aviaoPresente) {
        this.aviaoPresente = aviaoPresente;
    }

    public void executarAcao() {
        if (embarqueDisponivel && aviaoPresente && !filaDePessoas.isEmpty()) {
            super.removerPessoa();
        }

        if (super.getTamanhoFila() == 0) {
            embarqueDisponivel = false;
        }
    }

    @Override
    public void adicionarPessoa(Pessoa novaPessoa) {
        super.adicionarPessoa(novaPessoa);
        if (super.getTamanhoFilaAtual() == super.getTamanhoFila()) {
            embarqueDisponivel = true;
        }
    }
}
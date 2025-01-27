
public class FilaEmbarque extends FilaAeroporto {
    private boolean embarqueDisponivel;

    public FilaEmbarque(int tamanhoFila, Localizacao localizacao) {
        super(tamanhoFila, localizacao);
        this.embarqueDisponivel = false;
    }

    public void setEmbarqueDisponivel(boolean embarqueDisponivel) {
        this.embarqueDisponivel = embarqueDisponivel;
    }

    public Pessoa executarAcao(){
        if(embarqueDisponivel){
            return super.removerPessoa();
        }
        
        if(super.getTamanhoFila() == 0) {
            embarqueDisponivel = false;
        }

        return null;
    } 

}


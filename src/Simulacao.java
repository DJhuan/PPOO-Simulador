import java.util.Random;
import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Responsavel pela simulacao do aeroporto.
 * Gerencia o mapa e as filas de raio-x e embarque.
 * 
 * @author David J. Barnes and Michael Kolling and Luiz Merschmann
 * @author Jhuan Carlos Sabaini Dassie
 * 
 */

public class Simulacao {
    private static final int NRO_EMBARQUES = 4;
    private static final int NRO_RAIOSX = 7;

    private static final int POSY_EMBARQUES = 4;
    private static final int POSY_RAIOSX = 15;


    /**
     * Guarda todas as filas de raio-x e embarque.
     * A chave é utilizada para identificar a fila, usada para
     * definir o destino da pessoa aleatoriamente.
     */
    private HashMap<Integer, FilaAeroporto> filas;

    /**
     * Guarda todas as pessoas que estão na simulação.
     */
    private Vector<Pessoa> pessoas;

    private int nroRaiosx;
    private int nroEmbarques;
    private Aviao [] avioes;

    /**
     * Janela de simulação que exibe o estado atual da simulação.
     */
    private JanelaSimulacao janelaSimulacao;

    private Mapa mapa;
    private Random rand;

    /**
     * Construtor para a classe Simulação.
     * 
     * @param raiosx    Número de raios-x na simulação.
     * @param embarque  Número de embarques na simulação.
     */
    public Simulacao() {
        mapa = new Mapa();
        janelaSimulacao = new JanelaSimulacao(mapa, this);
        rand = new Random(98147);
        pessoas = new Vector<Pessoa>();
        nroRaiosx = NRO_EMBARQUES;
        nroEmbarques = NRO_RAIOSX;
        filas = new HashMap<Integer, FilaAeroporto>();
        avioes = new Aviao [nroEmbarques];


        // Posicionamento automático das filas de raio-x
        int espacamento = mapa.getLargura() / nroRaiosx;
        int distanciaBorda = espacamento / 2;
        for (int i = 0; i < nroRaiosx; i++) {
            filas.put(i, new RaioX(i, new Localizacao(distanciaBorda + espacamento * i, POSY_RAIOSX)));
        }

        // Posicionamento automático das filas de embarque
        espacamento = mapa.getLargura() / nroEmbarques;
        distanciaBorda = espacamento / 2;
        for (int i = 0; i < nroEmbarques; i++) {
            filas.put(nroRaiosx + i, new FilaEmbarque(i, new Localizacao(distanciaBorda + espacamento * i, POSY_EMBARQUES)));
            avioes[i] = new Aviao(new Localizacao(distanciaBorda + espacamento * i + 1 , POSY_EMBARQUES-1), POSY_EMBARQUES);
        }

    }

    public void executarSimulacao(int numPassos) {
        janelaSimulacao.executarAcao();
        for (int passo = 0; passo < numPassos; passo++) {
            executarUmPasso();
            esperar(100);
        }
    }

    /**
     * Executa um passo da simulação.
     * 
     * Para cada pessoa, ela continua a andar pelo mapa até chegar em uma fila.
     * Chegando na fila ela é removida do mapa, da fila de pessoas
     * e adicionada na fila que entrou (embarque ou raio-x).
     * 
     * Para cada fila, suas respectivas ações são executadas, e caso uma pessoa
     * saia da fila, ela recebe um novo destino e volta para a lista de pessoas.
     */
    private void executarUmPasso() {
        Iterator<Pessoa> itPessoas = pessoas.iterator();
        Pessoa p = null;
        
        while (itPessoas.hasNext()) {
            p = itPessoas.next();
            mapa.removerItem(p);
            p.executarAcao();

            if (p.alcancouDestino()) {
                // Este IF é temporário, pois ainda não adicionamos o embarque
                if (p.getFilaDestino() == -1) {
                    itPessoas.remove();
                } else {
                    filas.get(p.getFilaDestino()).adicionarPessoa(p);
                    itPessoas.remove();
                }
            } else {
                mapa.adicionarItem(p);
            }
        }

        p = null;

        for (FilaAeroporto f : filas.values()) {
            mapa.removerItem(f);
            p = f.executarAcao();
            if (p != null) {
                if (f instanceof RaioX) {
                    // Definir o novo destino dinamicamente através dos embarques
                    int filaEmbarqueId = nroRaiosx + rand.nextInt(nroEmbarques);
                    Localizacao novoDestino = filas.get(filaEmbarqueId).getLocalizacaoAtual();
                    p.setFilaDestino(filaEmbarqueId);
                    p.setLocalizacaoDestino(novoDestino);
                } else {
                    // Remover pessoa da simulação
                    p.setFilaDestino(-1);
                }

                pessoas.add(p);
            }

            mapa.adicionarItem(f);
        }

        for (int i = 0; i < nroEmbarques; i++) {
            mapa.removerItem(avioes[i]);
            avioes[i].executarAcao(((FilaEmbarque)filas.get(nroRaiosx + i)).getEmbarqueDisponivel());
            mapa.adicionarItem(avioes[i]);
        }

        janelaSimulacao.executarAcao();
    }

    public void adicionarPessoa() {
        Pessoa p = new Pessoa(new Localizacao(rand.nextInt(mapa.getLargura()), mapa.getAltura() - 1),
                rand.nextInt(nroRaiosx));
        Localizacao locFilaDest = filas.get(p.getFilaDestino()).getLocalizacaoAtual();
        p.setLocalizacaoDestino(locFilaDest);
        pessoas.add(p);
    }

    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

}

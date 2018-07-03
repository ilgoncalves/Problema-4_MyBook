package model;

import java.util.Comparator;
import java.util.LinkedList;

/**
 * Classe que instância uma palavra
 *
 * @author Igor Gonçalves
 */
public class Palavra implements Comparable {

    private LinkedList paginas;
    private String palavra;
    private int qntBuscas;

    /**
     * Construtor da classe palavra
     *
     * @param palavra uma String com a palavra
     * @param pagina uma pagina para ser adicionada a lista de paginas das quais
     * aparecem a respectiva palavra
     */
    public Palavra(String palavra, Pagina pagina) {

        paginas = new LinkedList();
        paginas.add(pagina);
        this.palavra = palavra;
    }

    /**
     * Método para incrementar a quantidade de vezes que palavra foi buscada
     */
    public void incrementaQntdBusca() {
        qntBuscas++;
    }

    /**
     * Método getter da Quantidade de buscas
     *
     * @return
     */
    public int getQntBuscas() {
        return qntBuscas;
    }

    /**
     * Metodo para adicionar na lista de paginas
     *
     * @param p
     */
    public void insereArquivo(Pagina p) {
        this.paginas.add(p);
    }

    /**
     * Método setter da Quantidade de buscas
     *
     * @param qntBuscas
     */
    public void setQntBuscas(int qntBuscas) {
        this.qntBuscas = qntBuscas;
    }

    /**
     * Método setter da lista de paginas
     *
     * @param paginas
     */
    public void setPaginas(LinkedList paginas) {
        this.paginas = paginas;
    }

    /**
     * Método setter da palavra
     *
     * @param palavra
     */
    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    /**
     * Método getter da lista de páginas
     *
     * @return
     */
    public LinkedList getPaginas() {
        return paginas;
    }

    /**
     * Método getter da Palavra
     *
     * @return
     */
    public String getPalavra() {
        return palavra;
    }

    @Override
    public int compareTo(Object t) {
        return this.palavra.compareTo(t.toString());
    }

    @Override
    public String toString() {
        return this.getPalavra();
    }

    public static Comparator<Palavra> PalavraBuscasComparator
            = new Comparator<Palavra>() {
        @Override
        public int compare(Palavra p1, Palavra p2) {
            return p1.qntBuscas - p2.qntBuscas;
        }
    };
}

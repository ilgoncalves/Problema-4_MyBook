package model;

import java.util.LinkedList;

public class Palavra implements Comparable {

    private LinkedList<Pagina> paginas = new LinkedList();
    private String palavra;
    private int ocorrencia;
    private int qntBuscas;

    public Palavra(Pagina pagina, String palavra) {
        this.paginas.add(pagina);
        this.palavra = palavra;
    }

    public int getQntBuscas() {
        return qntBuscas;
    }

    public void setQntBuscas(int qntBuscas) {
        this.qntBuscas = qntBuscas;
    }

    public void setPaginas(LinkedList paginas) {
        this.paginas = paginas;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public void setOcorrencia(int ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public LinkedList getPaginas() {
        return paginas;
    }

    public String getPalavra() {
        return palavra;
    }

    public int getOcorrencia() {
        return ocorrencia;
    }

    @Override
    public int compareTo(Object t) {
        return this.palavra.compareTo(t.toString());
    }

    @Override
    public String toString() {
        return this.getPalavra();
    }

}

package model;

import java.util.LinkedList;

public class Palavra implements Comparable {

    private LinkedList paginas;
    private LinkedList ocorrencias;
    private String palavra;

//    private int qntBuscas;
    private boolean repetiuPalavra;

    public boolean isRepetiuPalavra() {
        return repetiuPalavra;
    }

    public void setRepetiuPalavra(boolean repetiuPalavra) {
        this.repetiuPalavra = repetiuPalavra;
    }

    public Palavra(String palavra, Pagina pagina) {

        paginas = new LinkedList();
        paginas.add(pagina);
        this.palavra = palavra;
    }

//    public int getQntBuscas() {
//        return qntBuscas;
//    }
    public void insereArquivo(Pagina p) {
        this.paginas.add(p);
    }

//    public void setQntBuscas(int qntBuscas) {
//        this.qntBuscas = qntBuscas;
//    }
    public void setPaginas(LinkedList paginas) {
        this.paginas = paginas;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

//    public void setOcorrencia(int ocorrencia) {
//        this.ocorrencia = ocorrencia;
//    }
    public LinkedList getPaginas() {
        return paginas;
    }

    public String getPalavra() {
        return palavra;
    }

//    public int getOcorrencia() {
//        return ocorrencia;
//    }
    @Override
    public int compareTo(Object t) {
        return this.palavra.compareTo(t.toString());
    }

    @Override
    public String toString() {
        return this.getPalavra();
    }

}

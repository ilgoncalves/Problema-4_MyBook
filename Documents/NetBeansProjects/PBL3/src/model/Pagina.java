package model;

import java.io.File;
import java.util.Objects;

public class Pagina implements Cloneable, Comparable {

    private String nomeArquivo;
    private int ocorenciaDaPalavras;

    /**
     * Método getter do atributo ocorrencia das palavras
     *
     * @return
     */
    public int getOcorenciaDaPalavras() {
        return ocorenciaDaPalavras;
    }

    /**
     * Método para incrementar a ocorrencia
     *
     */
    public void incrementaOcorrecia() {
        ocorenciaDaPalavras++;
    }

    /**
     * Método setter da ocorrencia das palavras
     *
     * @param ocorenciaDaPalavras
     */
    public void setOcorenciaDaPalavras(int ocorenciaDaPalavras) {
        this.ocorenciaDaPalavras = ocorenciaDaPalavras;
    }

    /**
     * Método getter do atributo nome do arquivo
     *
     * @return
     */
    public String getNomeArquivo() {
        return nomeArquivo;
    }

    /**
     * Método setter do nome do arquivo
     *
     * @param nomeArquivo
     */
    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public String toString() {
        return "em: " + nomeArquivo.substring(0, nomeArquivo.length() - 4);
    }

    @Override
    public boolean equals(Object obj) {
        return this.nomeArquivo.equals(((Pagina) obj).getNomeArquivo());
    }

    @Override
    public Pagina clone() throws CloneNotSupportedException {
        return (Pagina) super.clone();
    }

    /**
     * Método compareTo para ordenar as paginas pela ocorrencia da palavra
     *
     * @param t
     * @return
     */
    @Override
    public int compareTo(Object t) {
        return ((Pagina) t).getOcorenciaDaPalavras() - this.ocorenciaDaPalavras;
    }
}

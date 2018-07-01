package model;

import java.io.File;
import java.util.Objects;

public class Pagina implements Cloneable, Comparable {

    private String nomeArquivo;
    private int ocorenciaDaPalavras;

    public int getOcorenciaDaPalavras() {
        return ocorenciaDaPalavras;
    }

    public void incrementaOcorrecia() {
        ocorenciaDaPalavras++;
    }

    public void setOcorenciaDaPalavras(int ocorenciaDaPalavras) {
        this.ocorenciaDaPalavras = ocorenciaDaPalavras;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

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

    @Override
    public int compareTo(Object t) {
        return ((Pagina) t).getOcorenciaDaPalavras() - this.ocorenciaDaPalavras;
    }
}

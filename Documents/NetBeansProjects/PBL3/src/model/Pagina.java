package model;

import java.io.File;

public class Pagina {

    private int repeticaoDaPalavraBuscada;
    private String nomeArquivo;
    private int ocorenciaDaPalavras;

    public int getOcorenciaDaPalavras() {
        return ocorenciaDaPalavras;
    }

    public void setOcorenciaDaPalavras(int ocorenciaDaPalavras) {
        this.ocorenciaDaPalavras = ocorenciaDaPalavras;
    }

    public int getRepeticaoDaPalavraBuscada() {
        return repeticaoDaPalavraBuscada;
    }

    public void setRepeticaoDaPalavraBuscada(int repeticaoDaPalavraBuscada) {
        this.repeticaoDaPalavraBuscada = repeticaoDaPalavraBuscada;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

}

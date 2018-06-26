package util;

import model.Palavra;

public class No {

    private No esquerda;
    private No direita;
    private No pai;
    private Palavra chave;
    private int balanceamento;

    public No(Palavra k) {
        setEsquerda(setDireita(setPai(null)));
        setBalanceamento(0);
        setChave(k);
    }

    @Override
    public String toString() {
        return getChave().toString();
    }

    public Palavra getChave() {
        return chave;
    }

    public void setChave(Palavra chave) {
        this.chave = chave;
    }

    public int getBalanceamento() {
        return balanceamento;
    }

    public void setBalanceamento(int balanceamento) {
        this.balanceamento = balanceamento;
    }

    public No getPai() {
        return pai;
    }

    public No setPai(No pai) {
        this.pai = pai;
        return pai;
    }

    public No getDireita() {
        return direita;
    }

    public No setDireita(No direita) {
        this.direita = direita;
        return direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
}

package model;

import util.*;

public class Partida {

    private ILista jogadores;
    private Baralho baralho;
    private int quantidadeJogadores;
    private Croupier croupier;

    public Croupier getCroupier() {
        return croupier;
    }

    public Partida(ILista jogadores, Baralho baralho) {
        this.jogadores = jogadores;
        this.baralho = baralho;
        this.croupier = new Croupier("Croupier", "123456789");
    }

    public void setJogadores(ILista jogadores) {
        this.jogadores = jogadores;
    }

    public void setBaralho(Baralho baralho) {
        this.baralho = baralho;
    }

    public void setQuantidadeJogadores(int quantidadeJogadores) {
        this.quantidadeJogadores = quantidadeJogadores;
    }

    public ILista getJogadores() {
        return jogadores;
    }

    public Baralho getBaralho() {
        return baralho;
    }

    public int getQuantidadeJogadores() {
        return quantidadeJogadores;
    }

}

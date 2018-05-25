package model;

import util.*;

public class MaoDeCarta {

    private ILista mao = new ListaEncadeada();

    public void adicionaCarta(Carta c) {
        if (c != null) {
            mao.insereFinal(c);
        }
    }

    public int tamanhoMao() {
        return mao.tamanho();
    }

    public Carta getCarta(int posicao) {
        if (posicao >= 0 && posicao < mao.tamanho()) {
            return (Carta) mao.recupera(posicao);
        } else {
            return null;
        }
    }

    public void printaMao() {
        for (int i = 0; i < mao.tamanho(); i++) {
            System.out.println(mao.recupera(i).toString());
        }
    }

    public int valorMao() {
        int val = 0;
        boolean condicaoAs = false;

        for (int i = 0; i < mao.tamanho(); i++) {
            Carta carta;
            carta = getCarta(i);
            val += carta.getValor();

            if (carta.getValor() == 1) {
                condicaoAs = true;
            }
        }

        if (condicaoAs == true && val + 10 <= 21) {
            val += 10;
        }

        return val;
    }

}

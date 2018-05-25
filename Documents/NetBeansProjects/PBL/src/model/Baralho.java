package model;

import util.*;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Baralho {

    private ILista baralho;

    public IStack getPilhaBaralho() {
        return embaralhar();
    }

    public Baralho() {
        baralho = new ListaEncadeada();
        cartasBaralho();
        embaralhar();

    }

    public void cartasBaralho() {
        this.baralho.insereFinal(new Carta("Paus", "A"));
        this.baralho.insereFinal(new Carta("Paus", "2"));
        this.baralho.insereFinal(new Carta("Paus", "3"));
        this.baralho.insereFinal(new Carta("Paus", "4"));
        this.baralho.insereFinal(new Carta("Paus", "5"));
        this.baralho.insereFinal(new Carta("Paus", "6"));
        this.baralho.insereFinal(new Carta("Paus", "7"));
        this.baralho.insereFinal(new Carta("Paus", "8"));
        this.baralho.insereFinal(new Carta("Paus", "9"));
        this.baralho.insereFinal(new Carta("Paus", "10"));
        this.baralho.insereFinal(new Carta("Paus", "J"));
        this.baralho.insereFinal(new Carta("Paus", "Q"));
        this.baralho.insereFinal(new Carta("Paus", "K"));

        this.baralho.insereFinal(new Carta("Copas", "A"));
        this.baralho.insereFinal(new Carta("Copas", "2"));
        this.baralho.insereFinal(new Carta("Copas", "3"));
        this.baralho.insereFinal(new Carta("Copas", "4"));
        this.baralho.insereFinal(new Carta("Copas", "5"));
        this.baralho.insereFinal(new Carta("Copas", "6"));
        this.baralho.insereFinal(new Carta("Copas", "7"));
        this.baralho.insereFinal(new Carta("Copas", "8"));
        this.baralho.insereFinal(new Carta("Copas", "9"));
        this.baralho.insereFinal(new Carta("Copas", "10"));
        this.baralho.insereFinal(new Carta("Copas", "J"));
        this.baralho.insereFinal(new Carta("Copas", "Q"));
        this.baralho.insereFinal(new Carta("Copas", "K"));

        this.baralho.insereFinal(new Carta("Ouros", "A"));
        this.baralho.insereFinal(new Carta("Ouros", "2"));
        this.baralho.insereFinal(new Carta("Ouros", "3"));
        this.baralho.insereFinal(new Carta("Ouros", "4"));
        this.baralho.insereFinal(new Carta("Ouros", "5"));
        this.baralho.insereFinal(new Carta("Ouros", "6"));
        this.baralho.insereFinal(new Carta("Ouros", "7"));
        this.baralho.insereFinal(new Carta("Ouros", "8"));
        this.baralho.insereFinal(new Carta("Ouros", "9"));
        this.baralho.insereFinal(new Carta("Ouros", "10"));
        this.baralho.insereFinal(new Carta("Ouros", "J"));
        this.baralho.insereFinal(new Carta("Ouros", "Q"));
        this.baralho.insereFinal(new Carta("Ouros", "K"));

        this.baralho.insereFinal(new Carta("Espada", "A"));
        this.baralho.insereFinal(new Carta("Espada", "2"));
        this.baralho.insereFinal(new Carta("Espada", "3"));
        this.baralho.insereFinal(new Carta("Espada", "4"));
        this.baralho.insereFinal(new Carta("Espada", "5"));
        this.baralho.insereFinal(new Carta("Espada", "6"));
        this.baralho.insereFinal(new Carta("Espada", "7"));
        this.baralho.insereFinal(new Carta("Espada", "8"));
        this.baralho.insereFinal(new Carta("Espada", "9"));
        this.baralho.insereFinal(new Carta("Espada", "10"));
        this.baralho.insereFinal(new Carta("Espada", "J"));
        this.baralho.insereFinal(new Carta("Espada", "Q"));
        this.baralho.insereFinal(new Carta("Espada", "K"));
    }

    public IStack embaralhar() {
        int[] array = randomizar();
        Iterador itr = baralho.iterador();
        IStack pilha = new Stack();
        for (int i = 0; i < array.length; i++) {

            Carta c = (Carta) baralho.recupera(array[i] - 1);
            if (!(c == null)) {
                pilha.push(c);
            }
        }
        return pilha;
    }

    public int[] randomizar() {
        int find = 0;
        int c, i = 0;
        int[] num = new int[52];
        Random r = new Random();
        for (i = 0; i < num.length; i++) {
            find = r.nextInt(52) + 1;
            if (i == 0) {
                num[i] = find;
            } else {
                c = 0;
                while (c < i) {
                    if (num[c] == find) {
                        find = r.nextInt(52) + 1;
                        c = 0;
                    } else {
                        c++;
                    }
                }
                num[i] = find;
            }
        }
        return num;
    }
}

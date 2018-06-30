package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import model.*;

public class ArvoreAvl {

    protected No raiz;

    public void inserir(Palavra k, Pagina p) {
        No n = new No(k);
        inserirAVL(this.raiz, n, k, p);
    }

    public Palavra busca(String k) {
        return busca(k, raiz);
    }

    private Palavra busca(String k, No no) {

        if (!(no == null)) {
            if (no.getChave().compareTo(k) > 0) {
                return busca(k, no.getEsquerda());
            } else if (no.getChave().compareTo(k) < 0) {
                return busca(k, no.getDireita());
            } else {
                return no.getChave();
            }
        }
        return null;
    }

    public void inserirAVL(No aComparar, No aInserir, Palavra k, Pagina p) {

        if (aComparar == null) {
            this.raiz = aInserir;
        } else {

            if (aInserir.getChave().compareTo(aComparar.getChave()) < 0) {

                if (aComparar.getEsquerda() == null) {
                    aComparar.setEsquerda(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirAVL(aComparar.getEsquerda(), aInserir, k, p);
                }

            } else if (aInserir.getChave().compareTo(aComparar.getChave()) > 0) {

                if (aComparar.getDireita() == null) {
                    aComparar.setDireita(aInserir);
                    aInserir.setPai(aComparar);
                    verificarBalanceamento(aComparar);

                } else {
                    inserirAVL(aComparar.getDireita(), aInserir, k, p);
                }

            } else {
                // O nó já existe
            }

        }
    }

    public void verificarBalanceamento(No atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getBalanceamento();

        if (balanceamento == -2) {

            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = rotacaoDireita(atual);

            } else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }

        } else if (balanceamento == 2) {

            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);

            } else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }

        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        } else {
            this.raiz = atual;
        }
    }

    public void remover(int k) {
        removerAVL(this.raiz, k);
    }

    public void removerAVL(No atual, Comparable k) {
        if (atual == null) {
            return;
        } else {
            if (atual.getChave().compareTo(k) > 0) {
                removerAVL(atual.getEsquerda(), k);
            } else if (atual.getChave().compareTo(k) > 0) {
                removerAVL(atual.getDireita(), k);

            } else if (atual.getChave().compareTo(k) == 0) {
                removerNoEncontrado(atual);
            }
        }
    }

    public void removerNoEncontrado(No aRemover) {
        No r;

        if (aRemover.getEsquerda() == null || aRemover.getDireita() == null) {

            if (aRemover.getPai() == null) {
                this.raiz = null;
                aRemover = null;
                return;
            }
            r = aRemover;

        } else {
            r = sucessor(aRemover);
            aRemover.setChave(r.getChave());
        }

        No p;
        if (r.getEsquerda() != null) {
            p = r.getEsquerda();
        } else {
            p = r.getDireita();
        }

        if (p != null) {
            p.setPai(r.getPai());
        }

        if (r.getPai() == null) {
            this.raiz = p;
        } else {
            if (r == r.getPai().getEsquerda()) {
                r.getPai().setEsquerda(p);
            } else {
                r.getPai().setDireita(p);
            }
            verificarBalanceamento(r.getPai());
        }
        r = null;
    }

    public No rotacaoEsquerda(No inicial) {

        No direita = inicial.getDireita();
        direita.setPai(inicial.getPai());

        inicial.setDireita(direita.getEsquerda());

        if (inicial.getDireita() != null) {
            inicial.getDireita().setPai(inicial);
        }

        direita.setEsquerda(inicial);
        inicial.setPai(direita);

        if (direita.getPai() != null) {

            if (direita.getPai().getDireita() == inicial) {
                direita.getPai().setDireita(direita);

            } else if (direita.getPai().getEsquerda() == inicial) {
                direita.getPai().setEsquerda(direita);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(direita);

        return direita;
    }

    public No rotacaoDireita(No inicial) {

        No esquerda = inicial.getEsquerda();
        esquerda.setPai(inicial.getPai());

        inicial.setEsquerda(esquerda.getDireita());

        if (inicial.getEsquerda() != null) {
            inicial.getEsquerda().setPai(inicial);
        }

        esquerda.setDireita(inicial);
        inicial.setPai(esquerda);

        if (esquerda.getPai() != null) {

            if (esquerda.getPai().getDireita() == inicial) {
                esquerda.getPai().setDireita(esquerda);

            } else if (esquerda.getPai().getEsquerda() == inicial) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }

        setBalanceamento(inicial);
        setBalanceamento(esquerda);

        return esquerda;
    }

    public No duplaRotacaoEsquerdaDireita(No inicial) {
        inicial.setEsquerda(rotacaoEsquerda(inicial.getEsquerda()));
        return rotacaoDireita(inicial);
    }

    public No duplaRotacaoDireitaEsquerda(No inicial) {
        inicial.setDireita(rotacaoDireita(inicial.getDireita()));
        return rotacaoEsquerda(inicial);
    }

    public No sucessor(No q) {
        if (q.getDireita() != null) {
            No r = q.getDireita();
            while (r.getEsquerda() != null) {
                r = r.getEsquerda();
            }
            return r;
        } else {
            No p = q.getPai();
            while (p != null && q == p.getDireita()) {
                q = p;
                p = q.getPai();
            }
            return p;
        }
    }

    private int altura(No atual) {
        if (atual == null) {
            return -1;
        }

        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;

        } else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());

        } else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());

        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }

    private void setBalanceamento(No no) {
        no.setBalanceamento(altura(no.getDireita()) - altura(no.getEsquerda()));
    }

    final protected ArrayList<No> inorder() {
        ArrayList<No> ret = new ArrayList<No>();
        inorder(raiz, ret);
        return ret;
    }

    final protected void inorder(No no, ArrayList<No> lista) {
        if (no == null) {
            return;
        }
        inorder(no.getEsquerda(), lista);
        lista.add(no);
        inorder(no.getDireita(), lista);
    }
}

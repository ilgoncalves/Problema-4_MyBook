package util;

public class ListaEncadeada implements ILista {

    private Node head;
    private Node tail;
    private int size = 0;

    public class Node {

        private Object content;
        private Node next;

        public Node(Object o) {
            this.content = o;
        }

        public Object getContent() {
            return this.content;
        }

        public void setContent(Object o) {
            this.content = o;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return content.toString();
        }
    } // OK

    public class iterator implements Iterador {//Classe necessaria para pecorrer a lista.

        private Node itrAux;

        public iterator() {
            this.itrAux = head;
        }

        @Override
        public boolean temProximo() {
            return itrAux != null;
        }

        @Override
        public Object proximo() {
            if (temProximo()) {
                Node aux;
                aux = itrAux;
                itrAux = itrAux.getNext();
                return aux.content;
            }
            return null;
        }
    }

    @Override
    public boolean estaVazia() {//Verifica se a lista esta vazia.
        return this.size == 0;
    } // OK

    @Override
    public int tamanho() { // Retorna o tamanho da lista.

        return this.size;
    } //OK

    @Override
    public void insereInicio(Object o) { //Insere um elemento no inicio da lista.
        if (estaVazia()) {
            head = tail = new Node(o);
        } else {
            Node aux = head;
            head = new Node(o);
            head.setNext(aux);
        }
        size++;
    }//OK

    @Override
    public void insereFinal(Object o) { //Insere um elemento no final da lista.
        if (estaVazia()) {
            head = tail = new Node(o);
        } else {
            tail.setNext(new Node(o));
            tail = tail.getNext();
        }
        size++;
    } //OK

    @Override
    public Object removeInicio() { //Remove o primeiro elemento da lista e retorna seu conteudo.
        if (estaVazia()) {
            return null;
        }
        Node aux;
        aux = head;
        head = head.getNext();
        aux.setNext(null);
        size--;
        return aux.getContent();
    } //OK

    @Override
    public Object removeUltimo() { //Remove o ultimo elemento da lista e retorna seu conteudo.
        if (estaVazia()) {
            return null;
        }
        if (tamanho() == 1) {
            return removeInicio();
        }
        Node percorre = head;
        while (percorre.getNext() != tail && percorre.getNext() != null) {
            percorre = percorre.getNext();
        }
        percorre.setNext(null);
        Node aux = tail;
        tail = percorre;
        size--;
        return aux.getContent();
    } // OK

    @Override
    public Object recupera(int index) {
        Node n = getNode(index);
        if (n != null) {
            return n.getContent();
        } else {
            return null;
        }
    }

    @Override
    public Object removePorIndex(int index) {
        Node n = getNode(index);
        Object o = n.getContent();
        Node nAnterior = getNode(index - 1);
        nAnterior.setNext(n.getNext());
        n.setNext(null);
        return o;
    }

    @Override
    public Iterador iterador() { //Retorna o iterador.
        return new iterator();
    }

    public Node getNode(int index) { //retorna determinado nó apartir da posição.
        if (index >= 0 && index < tamanho()) {
            Node n = head;
            for (int i = 0; i < index; i++) {
                n = n.getNext();
            }
            return n;
        }
        return null;
    }
}

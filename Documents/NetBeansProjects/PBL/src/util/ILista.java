package util;

public interface ILista {

    public boolean estaVazia();

    public int tamanho();

    public void insereInicio(Object o);

    public void insereFinal(Object o);

    public Object removeInicio();

    public Object removeUltimo();

    public Object recupera(int index);

    public Iterador iterador();

    public Object removePorIndex(int index);

}

package util;

public interface IStack {

    public void push(Object data);

    public Object pop();

    public Object peek();

    public boolean isEmpty();

    public int getSize();
}

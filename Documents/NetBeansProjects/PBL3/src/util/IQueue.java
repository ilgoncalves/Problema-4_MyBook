package util;

public interface IQueue {

    public void add(Object data);

    public Object remove();

    public Object peek();

    public boolean isEmpty();
}

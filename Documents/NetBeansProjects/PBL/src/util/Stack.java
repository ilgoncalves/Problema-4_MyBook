package util;

public class Stack implements IStack {

    private Node head;
    private int size;

    @Override
    public void push(Object data) {
        Node aux = head;
        head = new Node(data);
        head.setNext(aux);
        size++;
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            return null;
        } else {
            Object o = head.getData();
            head = head.getNext();
            size--;
            return o;

        }
    }

    @Override
    public Object peek() {
        return isEmpty() ? null : head.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

}

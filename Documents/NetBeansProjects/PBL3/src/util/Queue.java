package util;

public class Queue implements IQueue {

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(Object data) {
        if (isEmpty()) {
            head = tail = new Node(data);
        } else {
            Node aux = tail;
            tail = new Node(data);
            aux.setNext(tail);
        }
        size++;
    }

    @Override
    public Object remove() {
        if (!isEmpty()) {
            if (size == 1) {
                head = tail = null;
            } else {
                Object o = head.getData();
                head = head.getNext();
                return o;
            }
            size--;
        }
        return null;
    }

    @Override
    public Object peek() {
        return isEmpty() ? null : head.getData();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(Object obj) {
        for (Node n = head; n != null; n = n.getNext()) {
            if (n.getData().equals(obj)) {
                return true;
            }
        }
        return false;

    }

    public Iterator iterador() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator {

        private Node itrAux;

        public MyIterator() {
            this.itrAux = head;
        }

        @Override
        public boolean hasNext() {
            return head != null;
        }

        @Override
        public Object next() {
            Object o = itrAux.getData();
            itrAux = itrAux.getNext();
            return o;
        }

    }

    private class Node {

        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

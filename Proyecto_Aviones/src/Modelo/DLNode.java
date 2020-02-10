package Modelo;

public class DLNode<T> {

    private T element;
    private DLNode prev;
    private DLNode next;

    public DLNode() {
        this(null, null, null);
    }

    public DLNode(T elemento, DLNode<T> prev, DLNode<T> next) {
        this.element = elemento;
        this.prev = prev;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public DLNode getPrev() {
        return prev;
    }

    public DLNode getNext() {
        return next;
    }

    public void setElement(T elemento) {
        this.element = elemento;
    }

    public void setPrev(DLNode prev) {
        this.prev = prev;
    }

    public void setNext(DLNode next) {
        this.next = next;
    }

}

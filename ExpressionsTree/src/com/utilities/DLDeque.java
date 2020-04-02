package com.utilities;

import com.exceptions.DequeEmptyException;

public class DLDeque<T> implements Deque<T> {

    private DLNode<T> top;
    private DLNode<T> tail;
    private int size;

    public DLDeque() {
        top = new DLNode<>();
        tail = new DLNode<>();
        top.setNext(tail);
        tail.setPrev(top);
        size = 0;

    }

    @Override
    public String toString() {
        DLNode<T> aux = top.getNext();
        String elementos = "";
        while (aux != tail) {
            elementos += aux.getElement();
            aux = aux.getNext();
            if (aux != tail) {
                elementos += " <=> ";

            }
        }

        return elementos;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return top.getNext() == tail;
    }

    @Override
    public void insertFirst(T e) {
        DLNode<T> second = top.getNext();
        DLNode<T> first = new DLNode<>(e, top, second);
        second.setPrev(first);
        top.setNext(first);
        size++;
    }

    @Override
    public void insertLast(T e) {
        DLNode<T> nextToLast = tail.getPrev();
        DLNode<T> last = new DLNode<>(e, nextToLast, tail);
        nextToLast.setNext(last);
        tail.setPrev(last);
        size++;

    }

    public DLNode<T> getTop() {
        return top;
    }

    public DLNode<T> getTail() {
        return tail;
    }

    @Override
    public T removeFirst() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque Vacio");
        }
        DLNode<T> first = top.getNext();
        T temp = first.getElement();
        DLNode<T> second = first.getNext();
        top.setNext(second);
        second.setPrev(top);
        size--;
        return temp;

    }

    @Override
    public T removeLast() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque Vacio");
        }
        DLNode<T> last = tail.getPrev();
        T temp = last.getElement();
        DLNode<T> nextToLast = last.getPrev();
        tail.setPrev(nextToLast);
        nextToLast.setNext(tail);
        size--;
        return temp;
    }

    @Override
    public T first() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque Vacio");
        }
        return (T) top.getNext().getElement();
    }

    @Override
    public T last() throws DequeEmptyException {
        if (isEmpty()) {
            throw new DequeEmptyException("Deque Vacio");
        }
        return (T) tail.getPrev().getElement();
    }

}

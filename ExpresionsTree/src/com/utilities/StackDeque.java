package com.utilities;

import com.exceptions.DequeEmptyException;
import com.exceptions.StackEmptyException;

public class StackDeque<T> implements Stack<T> {

    private DLDeque<T> deque;

    public StackDeque() {
        deque = new DLDeque<>();
    }

    @Override
    public int size() {
        return deque.size();
    }

    @Override
    public T top() throws StackEmptyException {
        try {
            return deque.last();
        } catch (DequeEmptyException ex) {
            throw new StackEmptyException("Pila vacia");
        }
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public void push(T e) {
        deque.insertLast(e);
    }

    @Override
    public T pop() throws StackEmptyException {
        try {
            return deque.removeLast();
        } catch (DequeEmptyException ex) {
            throw new StackEmptyException("Pila Llena");
        }
    }

    protected DLDeque<T> getDeque() {
        return deque;
    }

    protected void setDeque(DLDeque<T> deque) {
        this.deque = deque;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author emman
 */
public class QueueDeque<T> implements Queue<T> {

    private DLDeque<T> deque;

    public QueueDeque() {
        deque = new DLDeque<>();
    }

    @Override
    public int size() {
        return deque.size();
    }

    @Override
    public T font() throws QueueEmptyException {
        try {
            return deque.first();
        } catch (DequeEmptyException ex) {
            throw new QueueEmptyException("Cola Vacia");
        }
    }

    @Override
    public boolean isEmpty() {
        return deque.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        deque.insertLast(e);
    }

    @Override
    public T dequeue() throws QueueEmptyException {
        try {
            return deque.removeFirst();
        } catch (DequeEmptyException ex) {
            throw new QueueEmptyException("Cola Vacia");
        }
    }

    @Override
    public String toString() {
        return deque.toString();
    }

    protected DLDeque<T> getDeque() {
        return deque;
    }

    protected void setDeque(DLDeque<T> deque) {
        this.deque = deque;
    }

}

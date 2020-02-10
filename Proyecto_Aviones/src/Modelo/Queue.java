package Modelo;

public interface Queue<T> {

    public int size();

    public T font() throws QueueEmptyException;

    public boolean isEmpty();

    public void enqueue(T e);

    public T dequeue() throws QueueEmptyException;
}

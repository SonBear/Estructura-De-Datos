package Modelo.Utilities;

import Modelo.Exceptions.StackEmptyException;

public interface Stack<T> {

    public int size();

    public T top() throws StackEmptyException;

    public boolean isEmpty();

    public void push(T e);

    public T pop() throws StackEmptyException;

}

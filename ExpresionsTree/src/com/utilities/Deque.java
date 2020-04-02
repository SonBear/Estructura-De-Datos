package com.utilities;

import com.exceptions.DequeEmptyException;

public interface Deque<T> {

    public int size();

    public boolean isEmpty();

    public void insertFirst(T e);

    public void insertLast(T e);

    public T removeFirst() throws DequeEmptyException;

    public T removeLast() throws DequeEmptyException;

    public T first() throws DequeEmptyException;

    public T last() throws DequeEmptyException;
}

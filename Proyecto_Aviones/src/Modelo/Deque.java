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

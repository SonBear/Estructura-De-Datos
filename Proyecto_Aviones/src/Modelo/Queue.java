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
public interface Queue<T> {

    public int size();

    public T font() throws QueueEmptyException;

    public boolean isEmpty();

    public void enqueue(T e);

    public T dequeue() throws QueueEmptyException;
}

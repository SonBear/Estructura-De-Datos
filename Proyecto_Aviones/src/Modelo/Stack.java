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
public interface Stack<T> {

    public int size();

    public T top() throws StackEmptyException;

    public boolean isEmpty();

    public void push(T e);

    public T pop() throws StackEmptyException;

}

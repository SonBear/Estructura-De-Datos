/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tree;

/**
 *
 * @author emman
 */
public class Nodo<T> {

    private T obj;
    private Nodo<T> right;
    private Nodo<T> left;

    public Nodo() {
        obj = null;
        right = null;
        left = null;
    }

    public Nodo(T obj) {
        this.obj = obj;
        right = null;
        left = null;
    }

    public T getObj() {
        return obj;
    }

    public Nodo<T> getRight() {
        return right;
    }

    public Nodo<T> getLeft() {
        return left;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public void setRight(Nodo<T> right) {
        this.right = right;
    }

    public void setLeft(Nodo<T> left) {
        this.left = left;
    }

    public boolean isSheet() {
        return getLeft() == null && getRight() == null;
    }

    public void inOrden() {
        if (left != null) {
            left.inOrden();
        }
        System.out.print(obj + " ");
        if (right != null) {
            right.inOrden();
        }
    }

}

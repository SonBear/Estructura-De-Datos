/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author emman
 */
public class Nodo<T extends Comparable<T>> {

    private T elemento;
    private Nodo<T> derecha;
    private Nodo<T> izquierda;

    public Nodo(T elemento, Nodo<T> derecha, Nodo<T> izquierda) {
        this.elemento = elemento;
        this.derecha = derecha;
        this.izquierda = izquierda;
    }

    public Nodo() {
    }

    public Nodo(T elemento) {
        this(elemento, null, null);

    }

    public T getElemento() {
        return elemento;
    }

    public Nodo<T> getDerecha() {
        return derecha;
    }

    public Nodo<T> getIzquierda() {
        return izquierda;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setDerecha(Nodo<T> Derecha) {
        this.derecha = Derecha;
    }

    public void setIzquierda(Nodo<T> Izquierda) {
        this.izquierda = Izquierda;
    }

}

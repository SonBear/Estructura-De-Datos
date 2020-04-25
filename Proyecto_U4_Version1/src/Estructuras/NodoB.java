/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class NodoB<T extends Comparable<T>> {

    private Key<T> elemento;
    private NodoB<T> derecha;
    private NodoB<T> izquierda;

    public NodoB(T elemento, NodoB<T> derecha, NodoB<T> izquierda) {
        this.elemento = new Key<>(elemento);
        this.derecha = derecha;
        this.izquierda = izquierda;
    }

    public ArrayList<Integer> getEgresados() {
        return elemento.getIndiceEgresados();
    }

    public NodoB() {
    }

    public NodoB(T elemento) {
        this(elemento, null, null);

    }

    public T getElemento() {
        return elemento.getElemento();
    }

    public NodoB<T> getDerecha() {
        return derecha;
    }

    public NodoB<T> getIzquierda() {
        return izquierda;
    }

    public void setElemento(T elemento) {
        this.elemento.setElemento(elemento);
    }

    public void setDerecha(NodoB<T> Derecha) {
        this.derecha = Derecha;
    }

    public void setIzquierda(NodoB<T> Izquierda) {
        this.izquierda = Izquierda;
    }

}

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
public class NodoA<T extends Comparable<T>> {

    private T elemento;
    private ArrayList<Integer> indiceEgresados;
    private NodoA<T> derecha;
    private NodoA<T> izquierda;

    public NodoA(T elemento, NodoA<T> derecha, NodoA<T> izquierda) {
        this.elemento = elemento;
        this.derecha = derecha;
        this.izquierda = izquierda;
        indiceEgresados = new ArrayList<>();
    }

    public ArrayList<Integer> getEgresados() {
        return indiceEgresados;
    }

    public NodoA() {
    }

    public NodoA(T elemento) {
        this(elemento, null, null);

    }

    public T getElemento() {
        return elemento;
    }

    public NodoA<T> getDerecha() {
        return derecha;
    }

    public NodoA<T> getIzquierda() {
        return izquierda;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setDerecha(NodoA<T> Derecha) {
        this.derecha = Derecha;
    }

    public void setIzquierda(NodoA<T> Izquierda) {
        this.izquierda = Izquierda;
    }

}

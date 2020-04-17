/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jorge.reyes
 */
public class NodoABB<T extends Comparable<T>> {

    protected T dato;
    protected NodoABB<T> izq;
    protected NodoABB<T> der;

    public NodoABB(T dato, NodoABB izq, NodoABB der) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;
    }

    public NodoABB(T dato) {
        this(dato, null, null);
    }

    public NodoABB() {
        this(null);
    }

    /**
     * @return the dato
     */
    public T getDato() {
        return dato;
    }

    public void posOrden() {
        if (izq != null) {
            izq.posOrden();
        }
        if (der != null) {
            der.posOrden();
        }
        System.out.println(dato);//Raiz
    }

    public void preOrden() {
        System.out.println(dato);//Raiz
        if (izq != null) {
            izq.preOrden();
        }
        if (der != null) {
            der.preOrden();
        }

    }

    public void inOrden() { //IRD
        if (izq != null) {
            izq.inOrden();
        }
        System.out.println(dato);//Raiz
        if (der != null) {
            der.inOrden();
        }
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(T dato) {
        this.dato = dato;
    }

    /**
     * @return the izq
     */
    public NodoABB<T> getIzq() {
        return izq;
    }

    /**
     * @param izq the izq to set
     */
    public void setIzq(NodoABB<T> izq) {
        this.izq = izq;
    }

    /**
     * @return the der
     */
    public NodoABB<T> getDer() {
        return der;
    }

    /**
     * @param der the der to set
     */
    public void setDer(NodoABB der) {
        this.der = der;
    }

}

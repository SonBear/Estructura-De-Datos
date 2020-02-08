/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emman
 */
public class NodoDoble {

    private Object dato;
    private NodoDoble next;
    private NodoDoble prev;

    public NodoDoble(Object dato) {
        this.dato = dato;
        prev = null;
        next = null;
    }

    public Object getDato() {
        return dato;
    }

    public NodoDoble getNext() {
        return next;
    }

    public NodoDoble getPrev() {
        return prev;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public void setNext(NodoDoble next) {
        this.next = next;
    }

    public void setPrev(NodoDoble prev) {
        this.prev = prev;
    }

}

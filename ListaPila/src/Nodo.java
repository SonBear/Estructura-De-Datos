/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A18016328
 */
public class Nodo {

    private char dato;
    private Nodo next;

    public Nodo(char dato) {
        this.dato = dato;
        next = null;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A18016328
 */
public class Nodo{
    private int dato;
    private Nodo next;

    public Nodo(int dato) {
        this.dato = dato;
        this.next = null;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    
}

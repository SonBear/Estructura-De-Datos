/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emman
 */
public class Nodo {

    private int date;
    private Nodo next;

    public Nodo(int date) {
        this.date = date;
        this.next = null;
    }

    public int getDate() {
        return date;
    }

    public Nodo getNext() {
        return next;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

}

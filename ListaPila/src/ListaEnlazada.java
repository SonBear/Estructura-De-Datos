/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A18016328
 */
public class ListaEnlazada {

    private Nodo head;

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public void insertarInicio(Nodo n) {
        if (isEmpty()) {
            head = n;
        } else {
            n.setNext(head);
            head = n;
        }
    }

    public void insertarFinal(Nodo n) {
        if (isEmpty()) {
            head = n;
        } else {
            Nodo temp = head;
            while (temp != null) {
                if (temp.getNext() == null) {
                    temp.setNext(n);
                    return;
                }
            }
            temp = temp.getNext();
        }
    }

    public void eliminarInicio() {
        if (isEmpty()) {
            return;
        } else {
            setHead(head.getNext());
        }
    }

    @Override
    public String toString() {
        Nodo temp = head;
        String palabra = "";
        while (temp != null) {
            palabra += temp.getDato() + " -> ";
            temp = temp.getNext();
        }
        return palabra;
    }

    public boolean isEmpty() {
        return head == null;
    }

}

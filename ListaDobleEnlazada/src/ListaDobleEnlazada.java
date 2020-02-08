/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emman
 */
public class ListaDobleEnlazada {

    private NodoDoble head;

    public NodoDoble getHead() {
        return head;
    }

    public void setHead(NodoDoble head) {
        this.head = head;
    }

    public void agregarInicio(NodoDoble n) {
        if (isEmpty()) {
            head = n;
        } else {
            n.setNext(head);
            head.setPrev(n);
            head = n;
        }
    }

    public void agregarFinal(NodoDoble n) {
        NodoDoble temp = head;
        while (temp != null) {
            if (temp.getNext() == null) {
                temp.setNext(n);
                n.setPrev(temp);
                return;
            }
            temp = temp.getNext();
        }
    }

    @Override
    public String toString() {
        String salida = "";
        NodoDoble temp = head;
        salida += "null" + " <=> ";
        while (temp != null) {
            salida += temp.getDato() + " <=> ";
            temp = temp.getNext();
            if (temp == null) {
                salida += temp;
            }

        }

        return salida;
    }

    public boolean isEmpty() {
        return head == null;
    }
}

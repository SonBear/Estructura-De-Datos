/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A18016328
 */
public class PilaEnlazada {

    private ListaEnlazada lista = new ListaEnlazada();
    private int size = 0;

    public void push(char n) {
        lista.insertarInicio(new Nodo(n));
        size++;
    }

    public int pop() throws PilaVaciaException {
        if (lista.isEmpty()) {
            throw new PilaVaciaException("Error pila vacia");
        } else {

            int d = lista.getHead().getDato();
            lista.eliminarInicio();
            return d;
        }
    }

    public int peek() throws PilaVaciaException {
        if (lista.isEmpty()) {
            throw new PilaVaciaException("Error pila vacia");
        } else {

            return lista.getHead().getDato();
        }

    }

    public ListaEnlazada getLista() {
        return lista;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return lista.toString();
    }

}

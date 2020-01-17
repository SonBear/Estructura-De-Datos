/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emman
 */
public class Pila {

    private int tamanio;
    private int cima;
    private Object datos[];

    public Pila(int tamanio) {
        this.tamanio = tamanio;
        this.cima = 0;
        this.datos = new Object[tamanio];
    }

    public void push(Object x) throws PilaLlenaException {
        if (cima < tamanio) {
            datos[cima++] = x;
        } else {
            throw new PilaLlenaException("Error Pila Llena");
        }
    }

    public Object pop() throws PilaVaciaException {
        if (!isEmpty()) {

            Object e = datos[--cima];
            datos[cima] = null;
            return e;
        } else {
            throw new PilaVaciaException("Error pila vacia");
        }
    }

    public Object peek() throws PilaVaciaException {
        if (!isEmpty()) {
            return datos[cima - 1];
        } else {
            return new PilaVaciaException("Error pila vacia");
        }
    }

    public int size() {
        return cima;
    }

    public boolean isEmpty() {
        return cima == 0;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emman
 */
public class Cola<E> {

    private E datos[];
    private int size;

    public Cola() {
        this.datos = (E[]) new Object[10];
        this.size = 0;
    }

    public void insertar(E elem) throws ColaLlenaException {
        if (isFull()) {
            throw new ColaLlenaException("Error cola llena");
        }
        datos[size++] = elem;

    }

    public E quitar() throws ColaVaciaException {
        if (isEmpty()) {
            throw new ColaVaciaException("Error Cola Vacia");
        }
        E elem = datos[0];
        for (int i = 0; i < datos.length - 1; i++) {
            datos[i] = datos[i + 1];
            datos[i + 1] = null;
        }
        size--;
        return elem;
    }

    public E frente() throws ColaVaciaException {
        if (isEmpty()) {
            throw new ColaVaciaException("Error Cola Vacia");
        }
        return datos[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == datos.length;
    }

    public int size() {
        return datos.length;
    }

    @Override
    public String toString() {
        String salida = "";
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] == null) {
                return salida;
            }
            salida += datos[i] + "<-";

        }

        return salida;
    }

}

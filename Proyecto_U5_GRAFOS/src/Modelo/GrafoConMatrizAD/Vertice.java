/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.GrafoConMatrizAD;

import java.util.Objects;

/**
 *
 * @author emman
 */
public class Vertice<T> {

    private T elemento;
    private int numVertice;

    public Vertice(T elemento) {
        this.elemento = elemento;
        this.numVertice = -1;
    }

    public T getElemento() {
        return elemento;
    }

    public int getNumVertice() {
        return numVertice;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vertice<?> other = (Vertice<?>) obj;
        if (!Objects.equals(this.elemento, other.elemento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nombre: " + elemento + " numero de vertices: " + numVertice;
    }

}

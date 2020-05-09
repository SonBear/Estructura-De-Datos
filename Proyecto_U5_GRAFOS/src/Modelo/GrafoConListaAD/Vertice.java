/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.GrafoConListaAD;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author emman
 */
public class Vertice<T> {

    private T elemento;
    private int numVertice;
    private ArrayList<Vertice> listaAdayacencia; //Cambiar esta mierdaaaaaa, por vertices y eliminar arco

    public Vertice(T elemento) {
        this.elemento = elemento;
        numVertice = -1;
        listaAdayacencia = new ArrayList<>();

    }

    public Vertice(int numeroVertice, T elemento) {
        this.elemento = elemento;
        numVertice = numeroVertice;
    }

    public T getElemento() {
        return elemento;
    }

    public int getNumVertice() {
        return numVertice;
    }

    public ArrayList<Vertice> getListaAdayacencia() {
        return listaAdayacencia;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    public void setListaAdayacencia(ArrayList<Vertice> listaAdayacencia) {
        this.listaAdayacencia = listaAdayacencia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
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
        return elemento + " #" + numVertice;
    }

}

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
    private ArrayList<Vertice> listaAdayacencia; //Cambiar esta mierdaaaaaa, por vertices y eliminar arco

    public Vertice(T elemento) {
        this.elemento = elemento;
        listaAdayacencia = new ArrayList<>();

    }

    public Vertice(int numeroVertice, T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public ArrayList<Vertice> getListaAdayacencia() {
        return listaAdayacencia;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setListaAdayacencia(ArrayList<Vertice> listaAdayacencia) {
        this.listaAdayacencia = listaAdayacencia;
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
        return elemento + " ";
    }

}

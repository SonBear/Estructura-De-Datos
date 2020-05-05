/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Lista.DLDeque;
import Lista.Deque;
import java.util.Objects;

/**
 *
 * @author emman
 */
public class Vertice {

    private String nombre;
    private int numVertice;
    private Deque<Arco> listaAdayacencia;

    public Vertice(String nombre) {
        this.nombre = nombre;
        numVertice = -1;
        listaAdayacencia = new DLDeque<Arco>();

    }

    public Vertice() {
        this(null);
        listaAdayacencia = new DLDeque<Arco>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumVertice() {
        return numVertice;
    }

    public Deque<Arco> getListaAdayacencia() {
        return listaAdayacencia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    public void setListaAdayacencia(Deque listaAdayacencia) {
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
        final Vertice other = (Vertice) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " #" + numVertice;
    }

}

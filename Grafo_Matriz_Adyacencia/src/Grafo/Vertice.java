/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.Objects;

/**
 *
 * @author emman
 */
public class Vertice {

    private String nombre;
    private int numVertice;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.numVertice = -1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumVertice() {
        return numVertice;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumVertice(int numVertice) {
        this.numVertice = numVertice;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Vertice other = (Vertice) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + " numero de vertices: " + numVertice;
    }

}

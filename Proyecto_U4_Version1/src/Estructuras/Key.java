/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class Key<T extends Comparable<T>> implements Comparable<Key<T>> {

    private T elemento;
    private ArrayList<Integer> indecesEgresados = new ArrayList<>();

    public Key(T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public ArrayList<Integer> getIndiceEgresados() {
        return indecesEgresados;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public void setIndecesEgresados(ArrayList<Integer> indecesEgresados) {
        this.indecesEgresados = indecesEgresados;
    }

    @Override
    public int compareTo(Key<T> o) {
        return elemento.compareTo(o.getElemento());
    }

    @Override
    public String toString() {
        return "elemento = " + elemento + " --indecesEgresados=" + indecesEgresados;
    }

}

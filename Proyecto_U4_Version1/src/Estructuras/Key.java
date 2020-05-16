package Estructuras;

import java.util.ArrayList;

/**
 * Clase que representa los elementos agregados en los arboles (nodos)
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

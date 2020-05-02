/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Estructuras.Exceptions.ItemNotFoundException;
import Estructuras.Exceptions.NoDatosException;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public interface ArbolIB<T extends Comparable<T>> {

    /**
     * busca los indices que codidan con el elmento de parametro
     *
     * @param elemento elemento a buscar
     * @return ArrayList con los indices que coicidieron
     * @throws ItemNotFoundException
     */
    public ArrayList<Integer> buscar(T elemento) throws ItemNotFoundException;

    /**
     * Inserta los elementos en el arbol
     *
     * @param index indices del egresado
     * @param elemento elemento a comparar del egresado
     */
    public void insertar(int index, T elemento);

    /**
     * Lista los incides de todos los egresados dentro del arbol
     *
     * @return @throws NoDatosException
     */
    public ArrayList<Integer> enlistarIndices() throws NoDatosException;

    /**
     * Lista todos los elementos principales (nodos) del arbol
     *
     * @return @throws NoDatosException por si los datos no estan iniciados
     */
    public ArrayList<T> enlistarElementos() throws NoDatosException;

    /**
     * imprime los datos del arbol ordenados en consola
     */
    public void recorrerArbol();

}

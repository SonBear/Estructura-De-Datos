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

    public ArrayList<Integer> buscar(T elemento) throws ItemNotFoundException;

    public void insertar(int index, T elemento);

    public ArrayList<Integer> enlistarIndices() throws NoDatosException;

    public ArrayList<T> enlistarElementos() throws NoDatosException;

    public void recorrerArbol();

}

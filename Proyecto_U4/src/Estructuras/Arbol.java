/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Estructuras.Exceptions.ItemNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public interface Arbol<T extends Comparable<T>> {

    public ArrayList<Integer> buscar(T elemento) throws ItemNotFoundException;

    public void borrar(T elemento) throws ItemNotFoundException;

    public void insertar(int index);

    public ArrayList<Integer> enlistarIndices();

    public void recorrerArbol();
}

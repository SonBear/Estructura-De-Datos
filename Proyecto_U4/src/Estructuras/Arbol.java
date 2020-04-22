/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

/**
 *
 * @author emman
 */
public interface Arbol<T extends Comparable<T>> {

    public void buscar(T elemento);

    public void borrar(T elemento);

    public void insertar(int index);

    public void recorrerArbol();
}

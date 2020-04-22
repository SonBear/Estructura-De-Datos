/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author emman
 */
public interface Lector<T> {

    public T[] obtenerDatos();

    public void insertarDato(T elemento);

    public void eliminar(T elemento);
}

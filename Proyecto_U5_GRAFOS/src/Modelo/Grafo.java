/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Exceptions.ArcoNoExisteException;
import Modelo.Exceptions.VerticeExisteException;
import Modelo.Exceptions.VerticeNoExisteException;

/**
 *
 * @author emman
 */
public interface Grafo<T> {

    public void borrarArco(T elemento1, T elemento2) throws VerticeNoExisteException, ArcoNoExisteException;

    public boolean adyacente(T elemento1, T elemento2) throws VerticeNoExisteException;

    public void nuevoVertice(T elemento) throws VerticeExisteException;

    public void borrarVertice(T elemento) throws VerticeNoExisteException;

    public void union(T elemento1, T elemento2) throws VerticeNoExisteException;

    public boolean buscarProfundidad(T elemento) throws VerticeNoExisteException;

    public boolean buscarAmplitud(T elemento) throws VerticeNoExisteException;

    public void recorrerAmplitud() throws VerticeNoExisteException;

    public void recorrerProfundidad() throws VerticeNoExisteException;

    public int getNumeroVertices();

    public boolean adyacente(int num1, int num2) throws VerticeNoExisteException;

    public T getElemento(int vertice) throws VerticeNoExisteException;
}

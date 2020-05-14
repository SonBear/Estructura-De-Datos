/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.GrafoConMatrizAD;

import Modelo.Exceptions.ArcoNoExisteException;
import Modelo.Exceptions.VerticeExisteException;
import Modelo.Exceptions.VerticeNoExisteException;
import Modelo.Grafo;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author emman
 */
public class GrafoMatriz<T> implements Grafo<T> {

    private int numeroVertices;
    private static int MAXVERTICES = 20;
    private Vertice<T>[] vertices;
    private int[][] matrizAdyacencia;

    public GrafoMatriz(int maximoVertices) {
        matrizAdyacencia = new int[maximoVertices][maximoVertices];
        vertices = new Vertice[maximoVertices];
        MAXVERTICES = maximoVertices;
        for (int i = 0; i < maximoVertices; i++) {
            for (int j = 0; j < maximoVertices; j++) {
                matrizAdyacencia[i][j] = 0;
            }
        }
        numeroVertices = 0;
    }

    public GrafoMatriz() {
        this(MAXVERTICES);
    }

    //Reparar array sale de rango
    @Override
    public boolean adyacente(int num1, int num2) throws VerticeNoExisteException {
        if (num1 < 0 || num2 < 0) {
            throw new VerticeNoExisteException("Vertice no existe");
        }
        return matrizAdyacencia[num1][num2] == 1;
    }

    private int getNumeroVertice(T elemento) {
        Vertice<T> v = new Vertice(elemento);

        for (int i = 0; i < numeroVertices; i++) {
            if (vertices[i].equals(v)) {

                return i;
            }

        }
        return -1;
    }

    @Override
    public String toString() {
        int dim = matrizAdyacencia.length;
        String matriz = "  ";
        for (int i = 0; i < dim; i++) {
            if (vertices[i] == null) {
                matriz += "#" + " ";
            } else {
                matriz += vertices[i].getElemento() + " ";
            }

        }
        matriz += "\n";
        for (int i = 0; i < dim; i++) {
            if (vertices[i] == null) {
                matriz += "#" + " ";
            } else {

                matriz += vertices[i].getElemento() + " ";
            }
            for (int j = 0; j < dim; j++) {
                matriz += matrizAdyacencia[i][j] + " ";
            }
            matriz += "\n";
        }
        return matriz;
    }

    @Override
    public void borrarArco(T elemento1, T elemento2) throws VerticeNoExisteException, ArcoNoExisteException {
        int va, vb;
        va = getNumeroVertice(elemento1);
        vb = getNumeroVertice(elemento2);
        if (va < 0 || vb < 0) {
            throw new VerticeNoExisteException("Vertice no existe");
        }

        matrizAdyacencia[va][vb] = 0;
    }

    @Override
    public boolean adyacente(T elemento1, T elemento2) throws VerticeNoExisteException {
        int va, vb;
        va = getNumeroVertice(elemento1);
        vb = getNumeroVertice(elemento2);
        if (va < 0 || vb < 0) {
            throw new VerticeNoExisteException("Vertice no existe");
        }
        return matrizAdyacencia[va][vb] == 1;
    }

    @Override
    public void nuevoVertice(T elemento) throws VerticeExisteException {
        boolean esta = getNumeroVertice(elemento) >= 0;
        if (esta | (numeroVertices >= MAXVERTICES)) {
            throw new VerticeExisteException("El vertice existe o tamaño sobrepsado");
        }
        Vertice<T> v = new Vertice(elemento);
        vertices[numeroVertices++] = v;

    }

    @Override
    public void borrarVertice(T elemento) throws VerticeNoExisteException {
        int va = getNumeroVertice(elemento);
        if (va < 0) {
            throw new VerticeNoExisteException("Vertice no exite");
        }

        //Borro los arcos adyacentes
        for (int i = 0; i < numeroVertices; i++) {
            try {
                if (adyacente(va, i)) {
                    borrarArco(elemento, getElemento(i));
                } else if (adyacente(i, va)) {
                    borrarArco(getElemento(i), elemento);
                }
            } catch (Exception ex) {

            }
        }

        for (int i = va; i < numeroVertices - 1; i++) {
            vertices[i] = vertices[i + 1];
        }
        //FFFFFF
        numeroVertices--;
        moverColumnas(va);
        moverfilas(va);

    }

    @Override
    public void union(T elemento1, T elemento2) throws VerticeNoExisteException {
        int va, vb;
        va = getNumeroVertice(elemento1);
        vb = getNumeroVertice(elemento2);
        if (va < 0 || vb < 0) {
            throw new VerticeNoExisteException("Vertice no existe");
        }

        //Manejando grafos no dirigidos
        matrizAdyacencia[va][vb] = 1;
        // matrizAdyacencia[vb][va] = 1;
    }

    @Override
    public boolean buscarProfundidad(T elemento) throws VerticeNoExisteException {
        Boolean procesados[] = new Boolean[numeroVertices];
        Arrays.fill(procesados, false);
        Stack<Integer> pila = new Stack<>();
        //Desde el vertice D del ejemplo de la presentacion
        recorrerProfundidad(0, pila, procesados);
        return procesados[getNumeroVertice(elemento)];
    }

    @Override
    public boolean buscarAmplitud(T elemento) throws VerticeNoExisteException {
        Boolean procesados[] = new Boolean[numeroVertices];
        Arrays.fill(procesados, false);
        recorrerAmplitud(0, procesados);

        return procesados[getNumeroVertice(elemento)];
    }

    public void recorrerAmplitud(int v, Boolean[] procesados) throws VerticeNoExisteException {
        //numero del vertice inicial
        int vi = v;
        //Estructuras para el algortimo
        Queue<Integer> colaNumVertices = new ArrayDeque<>();
        //Paso 1 Marcar como prodesado el vertice inicial
        procesados[vi] = true;
        //Pasa 2 meter el vertice inicial a la cola
        colaNumVertices.add(vi);
        //Paso repetir paso 4 y paso 5 mientras la cola no este vacía
        while (!colaNumVertices.isEmpty()) {
            //paso 4 visitar el vertice del frente de la cola
            int verticeActual = colaNumVertices.remove();

            //Impresion en pantalla de la visita de vertices
            System.out.println(vertices[verticeActual]);

            //paso 5 agregar todos los vertices adyacentes y que no esten procesados a la cola y marcarlos como procesados
            for (int i = 0; i < numeroVertices; i++) {
                if (adyacente(verticeActual, i) && !procesados[i]) {
                    colaNumVertices.add(i);
                    procesados[i] = true;
                }
            }

        }
    }

    @Override
    public void recorrerAmplitud() throws VerticeNoExisteException {
        Boolean procesados[] = new Boolean[numeroVertices];
        Arrays.fill(procesados, false);
        recorrerAmplitud(0, procesados);

    }

    //Aun falla, en grafos no dirigidos, asi que que los problame es que solo menejemos grafos dirigidos
    private void recorrerProfundidad(int v, Stack<Integer> pila, Boolean[] procesados) throws VerticeNoExisteException {
        //Vertice inicial
        int vi = v;

        //Se marca como procesado y se mete a la pila
        procesados[vi] = true;
        pila.push(vi);

        //paso 4 visitar el vertice de la pila
        int verticeActual = pila.pop();

        //Impresion en pantalla de la visita de vertices
        System.out.println(vertices[verticeActual]);

        //Ingresar a la pila los vertices adyacentes a v
        for (int i = 0; i < numeroVertices; i++) {
            if (adyacente(verticeActual, i) && !procesados[i]) {
                pila.push(i);
            }
        }
        System.out.println(pila);
        //recorrer en profundidad todos los vertices adyacentes a v
        for (int i = 0; i < pila.size(); i++) {
            recorrerProfundidad(pila.pop(), pila, procesados);
        }

    }

    //Debo testear esto
    @Override
    public void recorrerProfundidad() throws VerticeNoExisteException {
        Boolean procesados[] = new Boolean[numeroVertices];
        Arrays.fill(procesados, false);
        Stack<Integer> pila = new Stack<>();
        //Desde el vertice D del ejemplo de la presentacion
        recorrerProfundidad(3, pila, procesados);
    }

    @Override
    public int getNumeroVertices() {
        return numeroVertices;
    }

    @Override
    public T getElemento(int vertice) throws VerticeNoExisteException {
        return vertices[vertice].getElemento();
    }

    //Debemo correr las columnas y filas
    private void moverColumnas(int columna) {
        for (int i = 0; i < numeroVertices; i++) {
            for (int j = columna; j < numeroVertices; j++) {
                matrizAdyacencia[i][j] = matrizAdyacencia[i][j + 1];
            }
        }

    }

    private void moverfilas(int fila) {
        for (int i = fila; i < numeroVertices; i++) {
            for (int j = 0; j < numeroVertices; j++) {
                matrizAdyacencia[i][j] = matrizAdyacencia[i + 1][j];
            }
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 *
 * @author emman
 */
public class GrafoMatriz {

    private int numVertices;
    private static final int MAXVERTICES = 20;
    private Vertice[] vertices;
    private int[][] matrizAdyacencia;

    public int getNumVertices() {
        return numVertices;
    }

    public static int getMaxVertices() {
        return MAXVERTICES;
    }

    public Vertice[] getVertices() {
        return vertices;
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public GrafoMatriz(int maximoVertices) {
        matrizAdyacencia = new int[maximoVertices][maximoVertices];
        vertices = new Vertice[maximoVertices];
        for (int i = 0; i < maximoVertices; i++) {
            for (int j = 0; j < maximoVertices; j++) {
                matrizAdyacencia[i][j] = 0;
            }
        }
        numVertices = 0;
    }

    public GrafoMatriz() {
        this(MAXVERTICES);
    }

    public void nuevoVertice(String nombreVertice) {
        boolean esta = numVertice(nombreVertice) >= 0;
        if (!esta) {
            Vertice v = new Vertice(nombreVertice);
            v.setNumVertice(numVertices);
            vertices[numVertices++] = v;
        }
    }

    public void nuevoArco(String a, String b) throws Exception {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) {
            throw new Exception("Vertice no existe");
        }
        matrizAdyacencia[va][vb] = 1;
        matrizAdyacencia[vb][va] = 1; //Para lograr la simetría de matrices, ya que es una grafo no dirigido
    }

    public void nuevoAco(int va, int vb) throws Exception {
        if (va < 0 || vb < 0) {
            throw new Exception("Vertice no encontrado");
        }
        matrizAdyacencia[va][vb] = 1;
        matrizAdyacencia[vb][va] = 1;//Para lograr la simetría de matrices, ya que es una grafo no dirigido
    }

    public boolean adyacente(String a, String b) throws Exception {
        int va, vb;
        va = numVertice(a);
        vb = numVertice(b);
        if (va < 0 || vb < 0) {
            throw new Exception("Vertice no existe");
        }
        return matrizAdyacencia[va][vb] == 1;

    }

    public boolean adyacente(int va, int vb) throws Exception {
        if (va < 0 || vb < 0) {
            throw new Exception("Vertice no existe");
        }
        return matrizAdyacencia[va][vb] == 1;
    }

    public int numVertice(String nombreVertice) {
        Vertice v = new Vertice(nombreVertice);

        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(v)) {

                return i;
            }

        }
        return -1;
    }

    public void recorrerEnAnchura(String nombreVertice) throws Exception {
        //numero del vertice inicial
        int vi = numVertice(nombreVertice);
        //Estructuras para el algortimo
        Boolean procesados[] = new Boolean[numVertices];
        Arrays.fill(procesados, false);
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
            for (int i = 0; i < numVertices; i++) {
                if (adyacente(verticeActual, i) && !procesados[i]) {
                    colaNumVertices.add(i);
                    procesados[i] = true;
                }
            }

        }

    }

    @Override
    public String toString() {
        int dim = matrizAdyacencia.length;
        String matriz = "  ";
        for (int i = 0; i < dim; i++) {
            if (vertices[i] == null) {
                matriz += "#" + " ";
            } else {
                matriz += vertices[i].getNombre() + " ";
            }

        }
        matriz += "\n";
        for (int i = 0; i < dim; i++) {
            if (vertices[i] == null) {
                matriz += "#" + " ";
            } else {

                matriz += vertices[i].getNombre() + " ";
            }
            for (int j = 0; j < dim; j++) {
                matriz += matrizAdyacencia[i][j] + " ";
            }
            matriz += "\n";
        }
        return matriz;
    }

}

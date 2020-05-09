package Modelo.GrafoConListaAD;

import Modelo.Exceptions.ArcoNoExisteException;
import Modelo.Exceptions.VerticeExisteException;
import Modelo.Exceptions.VerticeNoExisteException;
import Modelo.Grafo;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 *
 * @author emman
 */
public class GrafoLista<T> implements Grafo<T> {

    @Override
    public void nuevoVertice(T elemento) throws VerticeExisteException {
        boolean esta = getNumeroVertice(elemento) >= 0;
        if (esta) {
            throw new VerticeExisteException("El Vertice ya existe");
        }

        Vertice<T> nuevoVertice = new Vertice<>(elemento);
        nuevoVertice.setNumVertice(numeroVertices);
        vertices[numeroVertices++] = nuevoVertice;

    }

    @Override
    public void borrarArco(T elemento1, T elemento2) throws VerticeNoExisteException, ArcoNoExisteException {
        int va = getNumeroVertice(elemento1);
        int vb = getNumeroVertice(elemento2);
        if (va < 0 || vb < 0) {
            throw new VerticeNoExisteException("Vertice no exite");
        }
        if (!adyacente(elemento1, elemento2)) {
            throw new ArcoNoExisteException("Arco no existe");
        }

        vertices[va].getListaAdayacencia().remove(vb);
        vertices[vb].getListaAdayacencia().remove(va);
    }

    @Override
    public boolean adyacente(T elemento1, T elemento2) throws VerticeNoExisteException {
        int va = getNumeroVertice(elemento1);
        int vb = getNumeroVertice(elemento2);

        if (va < 0 || vb < 0) {
            throw new VerticeNoExisteException("Vertice no exite");
        }

        return vertices[va].getListaAdayacencia().contains(vb);
    }

    @Override
    public void borrarVertice(T elemento) throws VerticeNoExisteException {
        int va = getNumeroVertice(elemento);
        if (va < 0) {
            throw new VerticeNoExisteException("Vertice no exite");
        }

        //Borro los arcos adyacentes
        for (int i = 0; i < numeroVertices; i++) {
            if (adyacente(va, i)) {
                try {

                    borrarArco(elemento, getElemento(i));
                    System.out.println("Arco de " + elemento + " a " + getElemento(i) + " ->Eliminado");
                } catch (ArcoNoExisteException ex) {

                    System.out.println(ex.getMessage());
                }
            }
        }
        //Corre todos los vertices

        for (int i = va; i < numeroVertices; i++) {
            vertices[i] = vertices[i + 1];
        }
        vertices[numeroVertices] = null;

        numeroVertices--;
    }

    @Override
    public void union(T elemento1, T elemento2) throws VerticeNoExisteException {
        if (!adyacente(elemento1, elemento2)) {
            int va = getNumeroVertice(elemento1);
            int vb = getNumeroVertice(elemento2);
            if (va < 0 || vb < 0) {
                throw new VerticeNoExisteException("Vertice no exite");
            }
            Vertice ver = vertices[vb]; //Cambiar esto por buscar el vertices
            vertices[va].getListaAdayacencia().add(ver);
            Vertice ver2 = vertices[va];
            vertices[vb].getListaAdayacencia().add(ver2);

        }
    }

    @Override
    public boolean buscarProfundidad(T elemento) throws VerticeNoExisteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarAmplitud(T elemento) throws VerticeNoExisteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void recorrerAmplitud() throws VerticeNoExisteException {
        //numero del vertice inicial
        int vi = 0;
        //Estructuras para el algortimo
        Boolean procesados[] = new Boolean[numeroVertices];
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
            for (int i = 0; i < numeroVertices; i++) {
                if (adyacente(verticeActual, i) && !procesados[i]) {
                    colaNumVertices.add(i);
                    procesados[i] = true;
                }
            }

        }
    }

    @Override
    public void recorrerProfundidad() {
        System.out.println("Todavia no papá");
    }

    private int numeroVertices;
    private final int MAXVERTICES = 20;
    private Vertice<T>[] vertices;

    public GrafoLista(int maxVer) {
        vertices = new Vertice[maxVer];
        numeroVertices = 0;

    }

    public GrafoLista() {
        vertices = new Vertice[MAXVERTICES];
        numeroVertices = 0;

    }

    private int getNumeroVertice(T elemento) {
        Vertice v = new Vertice(elemento);
        for (int i = 0; i < numeroVertices; i++) {
            if (vertices[i].equals(v)) {
                return i;

            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String e = "";
        for (int i = 0; i < numeroVertices; i++) {
            System.out.println(vertices[i]);
            System.out.println(vertices[i].getListaAdayacencia());
        }

        return e;
    }

    @Override
    public int getNumeroVertices() {
        return numeroVertices;
    }

    @Override
    public boolean adyacente(int num1, int num2) throws VerticeNoExisteException {
        if (num1 < 0 || num2 < 0) {
            throw new VerticeNoExisteException("Vertice no exite");
        }

        //true si se logra encontrar el arco
        return vertices[num1].getListaAdayacencia().contains(vertices[num2]);
    }

    @Override
    public T getElemento(int vertice) throws VerticeNoExisteException {
        return vertices[vertice].getElemento();
    }

}

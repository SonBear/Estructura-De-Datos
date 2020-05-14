package Modelo.GrafoConListaAD;

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
public class GrafoLista<T> implements Grafo<T> {

    @Override
    public void nuevoVertice(T elemento) throws VerticeExisteException {
        boolean esta = getNumeroVertice(elemento) >= 0;
        if (esta | numeroVertices >= MAXVERTICES) {
            throw new VerticeExisteException("El Vertice ya existe o tamaño sobrepasado");
        }

        Vertice<T> nuevoVertice = new Vertice<>(elemento);
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
        //vertices[vb].getListaAdayacencia().remove(va);
    }

    @Override
    public boolean adyacente(T elemento1, T elemento2) throws VerticeNoExisteException {
        int va = getNumeroVertice(elemento1);
        int vb = getNumeroVertice(elemento2);

        if (va < 0 || vb < 0) {
            throw new VerticeNoExisteException("Vertice no exite");
        }

        return vertices[va].getListaAdayacencia().contains(vertices[vb]);
    }

    @Override
    public void borrarVertice(T elemento) throws VerticeNoExisteException {
        int va = getNumeroVertice(elemento);
        if (va < 0) {
            throw new VerticeNoExisteException("Vertice no exite");
        }
        System.out.println(va + "---");

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

        //Corre todos los vertices
        for (int i = va; i < numeroVertices - 1; i++) {
            vertices[i] = vertices[i + 1];
        }

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
            Vertice ver = vertices[vb];
            vertices[va].getListaAdayacencia().add(ver);
            //Vertice ver2 = vertices[va];
            //vertices[vb].getListaAdayacencia().add(ver2);

        }
    }

    @Override
    public boolean buscarProfundidad(T elemento) throws VerticeNoExisteException {
        Boolean procesados[] = new Boolean[numeroVertices];
        Arrays.fill(procesados, false);
        Stack<Integer> pila = new Stack<>();
        recorrerProfundidad(3, pila, procesados);
        return procesados[getNumeroVertice(elemento)];

    }

    @Override
    public boolean buscarAmplitud(T elemento) throws VerticeNoExisteException {
        Boolean procesados[] = new Boolean[numeroVertices];
        Arrays.fill(procesados, false);
        recorrerAmplitud(0, procesados);

        return procesados[getNumeroVertice(elemento)];
    }

    @Override
    public void recorrerAmplitud() throws VerticeNoExisteException {
        Boolean procesados[] = new Boolean[numeroVertices];
        Arrays.fill(procesados, false);
        recorrerAmplitud(0, procesados);
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
    public void recorrerProfundidad() throws VerticeNoExisteException {
        Boolean procesados[] = new Boolean[numeroVertices];
        Arrays.fill(procesados, false);
        Stack<Integer> pila = new Stack<>();
        recorrerProfundidad(3, pila, procesados);
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
        System.out.println(Arrays.toString(procesados));

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

    private int numeroVertices;
    private static int MAXVERTICES = 20;
    private Vertice<T>[] vertices;

    public GrafoLista(int maxVer) {
        vertices = new Vertice[maxVer];
        MAXVERTICES = maxVer;
        numeroVertices = 0;

    }

    public GrafoLista() {
        this(MAXVERTICES);

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

    @Override
    public String toString() {
        String e = "";
        for (int i = 0; i < numeroVertices; i++) {
            e += vertices[i] + " ";
            e += vertices[i].getListaAdayacencia();

        }

        return e;
    }

}

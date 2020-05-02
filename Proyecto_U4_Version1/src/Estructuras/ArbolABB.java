package Estructuras;

import Close.Egresado;
import Estructuras.Exceptions.ItemNotFoundException;
import Estructuras.Exceptions.NoDatosException;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class ArbolABB<T extends Comparable<T>> implements ArbolIB<T> {

    private NodoB<T> raiz;

    public ArbolABB() {
        raiz = null;
    }

    public ArbolABB(T o) {
        raiz = new NodoB(o);

    }

    public ArbolABB(Egresado[] alumnos) {
        raiz = null;
    }

    /**
     * Inserta de manera ordenado los datos en el arbol
     *
     * @param n nodo inicial
     * @param o elemento a agregar
     * @param index indice del elemento a agregar
     */
    private void insertarOrdenado(NodoB<T> n, T o, int index) {

        if (o.compareTo(n.getElemento()) < 0) {
            if (n.getIzquierda() == null) {
                n.setIzquierda(new NodoB<>(o));
                n.getIzquierda().getEgresados().add(index);

            } else {
                insertarOrdenado(n.getIzquierda(), o, index);
            }
        } else if (o.compareTo(n.getElemento()) > 0) {

            if (n.getDerecha() == null) {
                n.setDerecha(new NodoB<>(o));
                n.getDerecha().getEgresados().add(index);

            } else {
                insertarOrdenado(n.getDerecha(), o, index);
            }
        } else {
            //repetidos
            n.getEgresados().add(index);
        }
    }

    /**
     * busca el nodo que corresponde al objeto "o" y guarda la lista de indices en "indices"
     *
     * @param n nodo de inicio
     * @param o elemento a encontrar (nodo)
     * @param indices estructura a guardar las coicidencias
     */
    private void buscar(NodoB<T> n, T o, ArrayList<Integer> indices) throws ItemNotFoundException {
        if (o.compareTo(n.getElemento()) < 0) {
            if (n.getIzquierda() == null) {
                throw new ItemNotFoundException("No está el dato :(");
            } else {
                buscar(n.getIzquierda(), o, indices);
            }
        } else {
            if (o.compareTo(n.getElemento()) > 0) {
                if (n.getDerecha() == null) {
                    throw new ItemNotFoundException("No está el dato :(");
                } else {
                    buscar(n.getDerecha(), o, indices);
                }
            } else {

                System.out.println("El dato si está en el árbol");
                indices.addAll(n.getEgresados());
            }
        }

    }

    /**
     * @return the raiz
     */
    public NodoB<T> getRaiz() {
        return raiz;
    }

    /**
     * sirve para buscar la lista de indices que coicidan con los parametros
     *
     * @param elemento elemento a encontrar
     * @return lista de indices que coicidan con el "elemento"
     * @throws ItemNotFoundException
     */
    @Override
    public ArrayList<Integer> buscar(T elemento) throws ItemNotFoundException {
        ArrayList<Integer> indices = new ArrayList<>();
        buscar(raiz, elemento, indices);
        return indices;
    }

    /**
     * Imprime en inorden el arbol generado a partir de una raíz El resultado es la manera inicial de la expresion pero sin parentesis
     *
     * @param t es la raiz principal del arbol
     */
    private void inOrder(NodoB<T> t) {
        if (t != null) {
            inOrder(t.getIzquierda());
            System.out.println(t.getElemento() + " ");
            System.out.println("\\");
            for (int i = 0; i < t.getEgresados().size(); i++) {
                System.out.println("  -" + t.getEgresados().get(i));
            }
            inOrder(t.getDerecha());
        }
    }

    /**
     * Funcion que se encarga de guardar los indices de todos los datos de manera ordenada, guardandolos en una estructura ArrayList
     *
     * @param t nodo de inicial
     * @param indices estructura a guardar las coicidencias
     *
     */
    private void inOrder(NodoB<T> t, ArrayList<Integer> indices) {
        if (t != null) {
            inOrder(t.getIzquierda(), indices);

            for (int i = 0; i < t.getEgresados().size(); i++) {
                indices.add(t.getEgresados().get(i));
            }
            inOrder(t.getDerecha(), indices);
        }
    }

    /**
     * Funcion que se encarga de guardar los elementos de los nodos de todos los datos de manera ordenada, guardandolos en una estructura ArrayList
     *
     * @param t nodo de inicial
     * @param elementos estructura a guardar las coicidencias
     *
     */
    private void inOrderElementos(NodoB<T> t, ArrayList<T> elementos) {
        if (t != null) {
            inOrderElementos(t.getIzquierda(), elementos);

            elementos.add(t.getElemento());
            inOrderElementos(t.getDerecha(), elementos);
        }
    }

    @Override
    public void recorrerArbol() {
        inOrder(raiz);
    }

    @Override
    public void insertar(int index, T elemento) {

        if (raiz == null) {
            raiz = new NodoB<>(elemento);
        }
        insertarOrdenado(raiz, elemento, index);
    }

    @Override
    public ArrayList<Integer> enlistarIndices() throws NoDatosException {
        if (raiz == null) {
            throw new NoDatosException("No se encontraron datos");
        }
        ArrayList<Integer> indices = new ArrayList<>();
        inOrder(raiz, indices);

        return indices;
    }

    @Override
    public ArrayList<T> enlistarElementos() throws NoDatosException {
        if (raiz == null) {
            throw new NoDatosException("No se encontraron datos");
        }
        ArrayList<T> elementos = new ArrayList<>();
        inOrderElementos(raiz, elementos);

        return elementos;
    }
}

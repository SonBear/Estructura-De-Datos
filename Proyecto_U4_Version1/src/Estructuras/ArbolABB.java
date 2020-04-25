/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    private NodoB<T> borrar(NodoB<T> n, T o) throws ItemNotFoundException {
        if (n == null) {
            throw new ItemNotFoundException("Elemento no encontrado");
        } else {
            if (o.compareTo(n.getElemento()) > 0) {
                n.setDerecha(borrar(n.getDerecha(), o));
            } else if (o.compareTo(n.getElemento()) < 0) {
                n.setIzquierda(borrar(n.getIzquierda(), o));
            } else {//Ya encontré el elemento a eliminar!!
                if (n.getDerecha() != null && n.getIzquierda() != null)//Aquí aplicamos los criterios cuando hay 2 hijos
                //Aplicamos el criterio del hijo más izquierdo del lado derecho
                {
                    NodoB<T> minimo = buscarMin(n.getDerecha());
                    n.setElemento(minimo.getElemento());
                    n.setDerecha(borrarMin(n.getDerecha()));
                } else //Los criterios cuando se tienen 1 de los 2 hijos o es hoja
                {
                    n = (n.getIzquierda() != null) ? n.getIzquierda() : n.getDerecha();
                }
            }
        }
        return n;
    }

    private NodoB<T> buscarMin(NodoB<T> n) {
        while (n.getIzquierda() != null) {
            n = n.getIzquierda();
        }
        return n;
    }

    private NodoB<T> borrarMin(NodoB<T> n) {
        if (n.getIzquierda() != null) {
            n.setIzquierda(borrarMin(n.getIzquierda()));
            return n;
        } else {
            return n.getDerecha();
        }
    }

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

    private void inOrder(NodoB<T> t, ArrayList<Integer> indices) {
        if (t != null) {
            inOrder(t.getIzquierda(), indices);

            for (int i = 0; i < t.getEgresados().size(); i++) {
                indices.add(t.getEgresados().get(i));
            }
            inOrder(t.getDerecha(), indices);
        }
    }

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
        ArrayList<Integer> indices = new ArrayList<>();
        inOrder(raiz, indices);
        if (indices.size() == 0) {
            throw new NoDatosException("No se encontraron datos");
        }
        return indices;
    }

    @Override
    public ArrayList<T> enlistarElementos() throws NoDatosException {
        ArrayList<T> elementos = new ArrayList<>();
        inOrderElementos(raiz, elementos);
        if (elementos.size() == 0) {
            throw new NoDatosException("No se encontraron datos");
        }
        return elementos;
    }
}

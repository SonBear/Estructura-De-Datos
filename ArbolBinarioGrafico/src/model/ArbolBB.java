/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import exception.ItemNotFoundException;

/**
 *
 * @author jorge.reyes
 * @param <T>
 */
public class ArbolBB<T extends Comparable<T>> {

    protected NodoABB<T> raiz;

    public ArbolBB() {
        this(null);
    }

    public ArbolBB(T o) {
        raiz = new NodoABB(o);
    }

    public void inOrden() {
        if (raiz != null) {
            raiz.inOrden();
        }
    }

    public void posOrden() {
        if (raiz != null) {
            raiz.posOrden();
        }
    }

    public void preOrden() {
        if (raiz != null) {
            raiz.preOrden();
        }
    }

    public void insertar(T o) {
        insertarOrdenado(raiz, o);
    }

    public void borrar(T o) {
        borrar(raiz, o);
    }

    private NodoABB<T> borrar(NodoABB<T> n, T o) throws ItemNotFoundException {
        if (n == null) {
            throw new ItemNotFoundException("Elemento no encontrado");
        } else {
            if (o.compareTo(n.getDato()) > 0) {
                n.setDer(borrar(n.getDer(), o));
            } else if (o.compareTo(n.getDato()) < 0) {
                n.setIzq(borrar(n.getIzq(), o));
            } else {//Ya encontré el elemento a eliminar!!
                if (n.getDer() != null && n.getIzq() != null)//Aquí aplicamos los criterios cuando hay 2 hijos
                //Aplicamos el criterio del hijo más izquierdo del lado derecho
                {
                    NodoABB<T> minimo = buscarMin(n.getDer());
                    n.setDato(minimo.getDato());
                    n.setDer(borrarMin(n.getDer()));
                } else //Los criterios cuando se tienen 1 de los 2 hijos o es hoja
                {
                    n = (n.getIzq() != null) ? n.getIzq() : n.getDer();
                }
            }
        }
        return n;
    }

    private NodoABB buscarMin(NodoABB n) {
        while (n.getIzq() != null) {
            n = n.getIzq();
        }
        return n;
    }

    private NodoABB borrarMin(NodoABB n) {
        if (n.getIzq() != null) {
            n.setIzq(borrarMin(n.getIzq()));
            return n;
        } else {
            return n.getDer();
        }
    }

    private void insertarOrdenado(NodoABB<T> n, T o) {

        if (o.compareTo(n.getDato()) < 0) {
            if (n.getIzq() == null) {
                n.setIzq(new NodoABB<>(o));
            } else {
                insertarOrdenado(n.getIzq(), o);
            }
        } else {
            if (o.compareTo(n.getDato()) > 0) {
                if (n.getDer() == null) {
                    n.setDer(new NodoABB<>(o));
                } else {
                    insertarOrdenado(n.getDer(), o);
                }
            }
        }
    }

    public void buscar(T o) {
        buscar(raiz, o);
    }

    private void buscar(NodoABB<T> n, T o) throws ItemNotFoundException {
        if (o.compareTo(n.getDato()) < 0) {
            if (n.getIzq() == null) {
                throw new ItemNotFoundException("No está el dato :(");
            } else {
                buscar(n.getIzq(), o);
            }
        } else {
            if (o.compareTo(n.getDato()) > 0) {
                if (n.getDer() == null) {
                    throw new ItemNotFoundException("No está el dato :(");
                } else {
                    buscar(n.getDer(), o);
                }
            } else {
                System.out.println("El dato si está en el árbol");
            }
        }
    }

    /**
     * @return the raiz
     */
    public NodoABB<T> getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoABB<T> raiz) {
        this.raiz = raiz;
    }

}

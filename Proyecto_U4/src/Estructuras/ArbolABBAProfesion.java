/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Close.Alumno;
import Estructuras.Exceptions.ItemNotFoundException;

/**
 *
 * @author emman
 */
public class ArbolABBAProfesion implements Arbol<String> {

    private NodoA<String> raiz;
    private Alumno[] alumnos;

    public ArbolABBAProfesion() {
        raiz = null;
        alumnos = null;
    }

    public ArbolABBAProfesion(String o) {
        raiz = new NodoA(o);

    }

    public ArbolABBAProfesion(Alumno[] alumnos) {
        raiz = null;
        this.alumnos = alumnos;
    }

    private NodoA<String> borrar(NodoA<String> n, String o) throws ItemNotFoundException {
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
                    NodoA<String> minimo = buscarMin(n.getDerecha());
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

    private NodoA<String> buscarMin(NodoA<String> n) {
        while (n.getIzquierda() != null) {
            n = n.getIzquierda();
        }
        return n;
    }

    private NodoA<String> borrarMin(NodoA<String> n) {
        if (n.getIzquierda() != null) {
            n.setIzquierda(borrarMin(n.getIzquierda()));
            return n;
        } else {
            return n.getDerecha();
        }
    }

    private void insertarOrdenado(NodoA<String> n, String o, int index) {

        if (o.compareTo(n.getElemento()) < 0) {
            if (n.getIzquierda() == null) {
                n.setIzquierda(new NodoA<>(o));
                n.getIzquierda().getAlumnos().add(index);

            } else {
                insertarOrdenado(n.getIzquierda(), o, index);
            }
        } else if (o.compareTo(n.getElemento()) > 0) {

            if (n.getDerecha() == null) {
                n.setDerecha(new NodoA<>(o));
                n.getDerecha().getAlumnos().add(index);

            } else {
                insertarOrdenado(n.getDerecha(), o, index);
            }
        } else {
            //repetidos
            n.getAlumnos().add(index);
        }
    }

    private void buscar(NodoA<String> n, String o) throws ItemNotFoundException {
        if (o.compareTo(n.getElemento()) < 0) {
            if (n.getIzquierda() == null) {
                throw new ItemNotFoundException("No está el dato :(");
            } else {
                buscar(n.getIzquierda(), o);
            }
        } else {
            if (o.compareTo(n.getElemento()) > 0) {
                if (n.getDerecha() == null) {
                    throw new ItemNotFoundException("No está el dato :(");
                } else {
                    buscar(n.getDerecha(), o);
                }
            } else {
                System.out.println("El dato si está en el árbol");
            }
        }
    }

    /**
     * @return the raiz
     */
    public NodoA<String> getRaiz() {
        return raiz;
    }

    @Override
    public void buscar(String elemento) {
        buscar(raiz, elemento);
    }

    @Override
    public void borrar(String elemento) {
        borrar(raiz, elemento);
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public void insertar(int index) {

        String elemento = alumnos[index].getProfesion();
        if (raiz == null) {
            raiz = new NodoA<>(elemento);
        }
        insertarOrdenado(raiz, elemento, index);
    }

    public void imprimirArbol() {
        inOrder(raiz);
    }

    /**
     * Imprime en inorden el arbol generado a partir de una raíz El resultado es la manera inicial de la expresion pero sin parentesis
     *
     * @param t es la raiz principal del arbol
     */
    private void inOrder(NodoA<String> t) {
        if (t != null) {
            inOrder(t.getIzquierda());
            System.out.println(t.getElemento() + " ");
            System.out.println("\\");
            for (int i = 0; i < t.getAlumnos().size(); i++) {
                System.out.println("  -" + t.getAlumnos().get(i));
            }
            inOrder(t.getDerecha());
        }
    }

    @Override
    public void recorrerArbol() {
        imprimirArbol();
    }

}

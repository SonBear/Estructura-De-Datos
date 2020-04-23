/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import Close.Egresado;
import Estructuras.Exceptions.ItemNotFoundException;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class ArbolABBANombres implements Arbol<String> {

    private NodoA<String> raiz;
    private Egresado[] alumnos;

    public ArbolABBANombres() {
        raiz = null;
        alumnos = null;
    }

    public ArbolABBANombres(String o) {
        raiz = new NodoA(o);

    }

    public ArbolABBANombres(Egresado[] alumnos) {
        raiz = null;
        this.alumnos = alumnos;
    }

    private NodoA<String> borrar(NodoA<String> n, String o) throws ItemNotFoundException {
        if (n == null) {
            throw new ItemNotFoundException("Elemento no encontrado");
        } else {
            if (o.toLowerCase().compareTo(n.getElemento()) > 0) {
                n.setDerecha(borrar(n.getDerecha(), o));
            } else if (o.toLowerCase().compareTo(n.getElemento()) < 0) {
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

        if (o.toLowerCase().compareTo(n.getElemento().toLowerCase()) < 0) {
            if (n.getIzquierda() == null) {
                n.setIzquierda(new NodoA<>(o));
                n.getIzquierda().getEgresados().add(index);

            } else {
                insertarOrdenado(n.getIzquierda(), o, index);
            }
        } else if (o.toLowerCase().compareTo(n.getElemento().toLowerCase()) > 0) {

            if (n.getDerecha() == null) {
                n.setDerecha(new NodoA<>(o));
                n.getDerecha().getEgresados().add(index);

            } else {
                insertarOrdenado(n.getDerecha(), o, index);
            }
        } else {
            //repetidos
            n.getEgresados().add(index);
        }
    }

    private void buscar(NodoA<String> n, String o, ArrayList<Integer> indices) throws ItemNotFoundException {
        if (o.toLowerCase().compareTo(n.getElemento().toLowerCase()) < 0) {
            if (n.getIzquierda() == null) {
                throw new ItemNotFoundException("No está el dato :(");
            } else {
                buscar(n.getIzquierda(), o, indices);
            }
        } else {
            if (o.toLowerCase().compareTo(n.getElemento().toLowerCase()) > 0) {
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
    public NodoA<String> getRaiz() {
        return raiz;
    }

    @Override
    public ArrayList<Integer> buscar(String elemento) throws ItemNotFoundException {
        ArrayList<Integer> indices = new ArrayList<>();
        buscar(raiz, elemento, indices);
        return indices;
    }

    @Override
    public void borrar(String elemento) {
        borrar(raiz, elemento);
    }

    public void setAlumnos(Egresado[] alumnos) {
        this.alumnos = alumnos;
    }

    @Override
    public void insertar(int index) {

        String elemento = alumnos[index].getNombre();
        if (raiz == null) {
            raiz = new NodoA<>(elemento);
        }
        insertarOrdenado(raiz, elemento, index);
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
            for (int i = 0; i < t.getEgresados().size(); i++) {
                System.out.println("  -" + t.getEgresados().get(i));
            }
            inOrder(t.getDerecha());
        }
    }

    private void inOrder(NodoA<String> t, ArrayList<Integer> indices) {
        if (t != null) {
            inOrder(t.getIzquierda(), indices);

            for (int i = 0; i < t.getEgresados().size(); i++) {
                indices.add(t.getEgresados().get(i));
            }
            inOrder(t.getDerecha(), indices);
        }
    }

    @Override
    public void recorrerArbol() {
        inOrder(raiz);
    }

    @Override
    public ArrayList<Integer> enlistarIndices() {
        ArrayList<Integer> indices = new ArrayList<>();
        inOrder(raiz, indices);
        return indices;

    }

}

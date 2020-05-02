package Estructuras;

import Estructuras.Exceptions.ItemNotFoundException;
import Estructuras.Exceptions.NoDatosException;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class ArbolAVL<T extends Comparable<T>> implements ArbolIB<T> {

    private NodoBAVL<T> raiz;

    public ArbolAVL() {
        raiz = null;
    }

    public ArbolAVL(T o) {
        raiz = new NodoBAVL<>(o);

    }

    /**
     * Inserta de manera ordenado los datos en el arbol
     *
     * @param n nodo inicial
     * @param o elemento a agregar
     * @param index indice del elemento a agregar
     */
    private void insertarOrdenado(NodoBAVL<T> n, T o, int index) {
        if (o.compareTo(n.getElemento()) < 0) {
            if (n.getIzquierda() == null) {
                n.setIzquierda(new NodoBAVL<>(o, null, null, n));
                n.getIzquierda().getEgresados().add(index);
                recalcularFE(n);
            } else {
                insertarOrdenado((NodoBAVL) n.getIzquierda(), o, index);
            }
        } else if (o.compareTo(n.getElemento()) > 0) {
            if (n.getDerecha() == null) {
                n.setDerecha(new NodoBAVL<>(o, null, null, n));
                n.getDerecha().getEgresados().add(index);
                recalcularFE(n);
            } else {
                insertarOrdenado((NodoBAVL) n.getDerecha(), o, index);
            }
        } else {
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

    public void recalcularFE(NodoBAVL<T> nodo) {
        if (nodo != null) {
            nodo.setFE(
                    NodoBAVL.altura((NodoBAVL) nodo.getDerecha())
                    - NodoBAVL.altura((NodoBAVL) nodo.getIzquierda())
            );
            if (nodo.getFE() == 2 || nodo.getFE() == -2) {
                balancear(nodo);
            } else {
                recalcularFE(nodo.getPadre());
            }
        }
    }

    public void balancear(NodoBAVL<T> nodo) {
        int feActual = nodo.getFE();
        if (feActual == 2) {
            switch (((NodoBAVL) nodo.getDerecha()).getFE()) {
                case 0:
                case 1:
                    rotacionDD(nodo);
                    System.out.println("Aplicando rotación DD..");
                    break;
                case -1:
                    rotacionDI(nodo);
                    System.out.println("Aplicando rotación DI..");
                    break;
            }
        } else {
            switch (((NodoBAVL) nodo.getIzquierda()).getFE()) {
                case 0:
                case -1:
                    rotacionII(nodo);
                    System.out.println("Aplicando rotación II..");
                    break;
                case 1:
                    rotacionID(nodo);
                    System.out.println("Aplicando rotación ID..");
                    break;
            }
        }
    }

    public void rotacionII(NodoBAVL<T> nodo) {
        //Establecer los apuntadores..
        NodoBAVL<T> Padre = nodo.getPadre();
        NodoBAVL<T> P = nodo;
        NodoBAVL<T> Q = (NodoBAVL) P.getIzquierda();
        NodoBAVL<T> B = (NodoBAVL) Q.getDerecha();

        //Ajustar hijos
        if (Padre != null) {
            if (Padre.getDerecha() == P) {
                Padre.setDerecha(Q);
            } else {
                Padre.setIzquierda(Q);
            }
        } else {
            raiz = Q;
        }
        //Reconstruir el arbol
        P.setIzquierda(B);
        Q.setDerecha(P);

        //Reasignar Padres
        P.setPadre(Q);
        if (B != null) {
            B.setPadre(P);
        }
        Q.setPadre(Padre);

        //Ajustar los valores de los FE
        P.setFE(0);
        Q.setFE(0);
    }

    public void rotacionDD(NodoBAVL<T> nodo) {
        //Establecer los apuntadores..
        NodoBAVL<T> Padre = nodo.getPadre();
        NodoBAVL<T> P = nodo;
        NodoBAVL<T> Q = (NodoBAVL) P.getDerecha();
        NodoBAVL<T> B = (NodoBAVL) Q.getIzquierda();

        //Ajustar hijos
        if (Padre != null) {
            if (Padre.getIzquierda() == P) {
                Padre.setIzquierda(Q);
            } else {
                Padre.setDerecha(Q);
            }
        } else {
            raiz = Q;
        }
        //Reconstruir el arbol
        P.setDerecha(B);
        Q.setIzquierda(P);

        //Reasignar Padres
        P.setPadre(Q);
        if (B != null) {
            B.setPadre(P);
        }
        Q.setPadre(Padre);

        //Ajustar los valores de los FE
        P.setFE(0);
        Q.setFE(0);
    }

    public void rotacionID(NodoBAVL<T> nodo) {
        NodoBAVL<T> Padre = nodo.getPadre();
        NodoBAVL<T> P = nodo;
        NodoBAVL<T> Q = (NodoBAVL) P.getIzquierda();
        NodoBAVL<T> R = (NodoBAVL) Q.getDerecha();
        NodoBAVL<T> B = (NodoBAVL) R.getIzquierda();
        NodoBAVL<T> C = (NodoBAVL) R.getDerecha();

        if (Padre != null) {
            if (Padre.getDerecha() == nodo) {
                Padre.setDerecha(R);
            } else {
                Padre.setIzquierda(R);
            }
        } else {
            raiz = R;
        }
        //Reconstrucción del árbol
        Q.setDerecha(B);
        P.setIzquierda(C);
        R.setIzquierda(Q);
        R.setDerecha(P);
        //Reasignación de padres
        R.setPadre(Padre);
        P.setPadre(R);
        Q.setPadre(R);
        if (B != null) {
            B.setPadre(Q);
        }
        if (C != null) {
            C.setPadre(P);
        }
        //Ajusta los valores de los factores de equilibrio
        switch (R.getFE()) {
            case -1:
                Q.setFE(0);
                P.setFE(1);
                break;
            case 0:
                Q.setFE(0);
                P.setFE(0);
                break;
            case 1:
                Q.setFE(-1);
                P.setFE(0);
                break;
        }
        R.setFE(0);
    }

    public void rotacionDI(NodoBAVL<T> nodo) {
        NodoBAVL<T> Padre = nodo.getPadre();
        NodoBAVL<T> P = nodo;
        NodoBAVL<T> Q = (NodoBAVL) P.getDerecha();
        NodoBAVL<T> R = (NodoBAVL) Q.getIzquierda();
        NodoBAVL<T> B = (NodoBAVL) R.getDerecha();
        NodoBAVL<T> C = (NodoBAVL) R.getIzquierda();

        if (Padre != null) {
            if (Padre.getIzquierda() == nodo) {
                Padre.setIzquierda(R);
            } else {
                Padre.setDerecha(R);
            }
        } else {
            raiz = R;
        }
        //Reconstrucción del árbol
        Q.setIzquierda(B);
        P.setDerecha(C);
        R.setDerecha(Q);
        R.setIzquierda(P);
        //Reasignación de padres
        R.setPadre(Padre);
        P.setPadre(R);
        Q.setPadre(R);
        if (B != null) {
            B.setPadre(Q);
        }
        if (C != null) {
            C.setPadre(P);
        }
        //Ajusta los valores de los factores de equilibrio
        switch (R.getFE()) {
            case -1:
                Q.setFE(0);
                P.setFE(1);
                break;
            case 0:
                Q.setFE(0);
                P.setFE(0);
                break;
            case 1:
                Q.setFE(-1);
                P.setFE(0);
                break;
        }
        R.setFE(0);
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

    private void inOrder(NodoB<String> t, ArrayList<Integer> indices) {
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
    public ArrayList<Integer> buscar(T elemento) throws ItemNotFoundException {
        ArrayList<Integer> indices = new ArrayList<>();
        buscar(raiz, elemento, indices);
        return indices;
    }

    /**
     * Inserta de manera ordenado los datos en el arbol
     *
     *
     * @param elemento elemento a agregar, para comparar
     * @param index indice del elemento a agregar
     */
    @Override
    public void insertar(int index, T elemento) {
        if (raiz == null) {
            raiz = new NodoBAVL<>(elemento);
        }
        insertarOrdenado(raiz, elemento, index);
    }

    /**
     *
     * @return @throws NoDatosException
     */
    @Override
    public ArrayList<Integer> enlistarIndices() throws NoDatosException {
        if (raiz == null) {
            throw new NoDatosException("No se encontraron datos");
        }
        ArrayList<Integer> indices = new ArrayList<>();
        inOrder((NodoBAVL<String>) raiz, indices);

        return indices;
    }

    private void inOrderElementos(NodoB<T> t, ArrayList<T> elementos) {
        if (t != null) {
            inOrderElementos(t.getIzquierda(), elementos);

            elementos.add(t.getElemento());
            inOrderElementos(t.getDerecha(), elementos);
        }
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

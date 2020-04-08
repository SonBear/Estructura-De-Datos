/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package F;

/**
 *
 * @author jorge.reyes
 */
public class ArbolABB {

    protected NodoBin raiz;

    public ArbolABB() {
        this(null);
    }

    public ArbolABB(Object o) {
        raiz = new NodoBin(o);
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

    public void insertar(Object o) {
        insertarOrdenado(raiz, o);
    }

    public void borrar(Object o) {
        borrar(raiz, o);
    }

    private NodoBin borrar(NodoBin n, Object o) throws ItemNotFoundException {
        if (n == null) {
            throw new ItemNotFoundException("Elemento no encontrado");
        } else {
            if ((int) o > (int) n.getDato()) {
                n.setDer(borrar(n.getDer(), o));
            } else if ((int) o < (int) n.getDato()) {
                n.setIzq(borrar(n.getIzq(), o));
            } else {//Ya encontré el elemento a eliminar!!
                if (n.getDer() != null && n.getIzq() != null)//Aquí aplicamos los criterios cuando hay 2 hijos
                //Aplicamos el criterio del hijo más izquierdo del lado derecho
                {
                    NodoBin minimo = buscarMin(n.getDer());
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

    private NodoBin buscarMin(NodoBin n) {
        while (n.getIzq() != null) {
            n = n.getIzq();
        }
        return n;
    }

    private NodoBin borrarMin(NodoBin n) {
        if (n.getIzq() != null) {
            n.setIzq(borrarMin(n.getIzq()));
            return n;
        } else {
            return n.getDer();
        }
    }

    private void insertarOrdenado(NodoBin n, Object o) {
        if ((int) o < (int) n.getDato()) {
            if (n.getIzq() == null) {
                n.setIzq(new NodoBin(o));
            } else {
                insertarOrdenado(n.getIzq(), o);
            }
        } else {
            if ((int) o > (int) n.getDato()) {
                if (n.getDer() == null) {
                    n.setDer(new NodoBin(o));
                } else {
                    insertarOrdenado(n.getDer(), o);
                }
            }
        }
    }

    public void buscar(Object o) {
        buscar(raiz, o);
    }

    private void buscar(NodoBin n, Object o) throws ItemNotFoundException {
        if ((int) o < (int) n.getDato()) {
            if (n.getIzq() == null) {
                throw new ItemNotFoundException("No está el dato :(");
            } else {
                buscar(n.getIzq(), o);
            }
        } else {
            if ((int) o > (int) n.getDato()) {
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
    public NodoBin getRaiz() {
        return raiz;
    }

    /**
     * @param raiz the raiz to set
     */
    public void setRaiz(NodoBin raiz) {
        this.raiz = raiz;
    }

    public static void main(String[] args) {
        ArbolABB arbol = new ArbolABB(25);
        arbol.insertar(73);
        arbol.insertar(48);
        arbol.insertar(1);
        arbol.insertar(67);
        arbol.insertar(5);
        arbol.insertar(99);
        arbol.insertar(7);
        arbol.insertar(44);
        arbol.insertar(91);
        arbol.insertar(70);
        arbol.insertar(6);
        //System.out.println("RECORRIDO EN INORDEN");
        //arbol.inOrden();

        //System.out.println("RECORRIDO EN PREORDEN");
        //arbol.preOrden();
        System.out.println("RECORRIDO EN POSORDEN");
        arbol.posOrden();
        /* System.out.println("Buscando datos...");
         try{
         arbol.buscar(105);
         }
         catch(ItemNotFoundException e){
         System.out.println("Error: " + e.getMessage());
         }*/
        int eliminado = 48;
        System.out.println("Eliminando el elemento: " + eliminado);
        try {
            arbol.borrar(eliminado);
            arbol.inOrden();
        } catch (ItemNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

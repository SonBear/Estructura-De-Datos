package Estructuras;

/**
 * Nodo para la estructura de arbol binario AVL
 *
 * @author emman
 * @param <T> cualquierl elemento que implemente una interfaz Comparable<T>
 */
public class NodoBAVL<T extends Comparable<T>> extends NodoB<T> {

    private int FE;
    private NodoBAVL<T> padre;

    public NodoBAVL() {
    }

    public NodoBAVL(T o) {
        super(o);
    }

    public NodoBAVL(T o, NodoBAVL<T> i, NodoBAVL<T> d) {
        super(o, d, i);
    }

    public NodoBAVL(T o, NodoBAVL<T> i, NodoBAVL<T> d, NodoBAVL<T> p) {
        super(o, d, i);
        padre = p;
    }

    public static int altura(NodoBAVL a) {
        if (a == null) {
            return -1;
        } else {
            return 1
                    + Math.max(altura((NodoBAVL) a.getIzquierda()), altura((NodoBAVL) a.getDerecha()));
        }
    }

    /**
     * @return the FE
     */
    public int getFE() {
        return FE;
    }

    /**
     * @param FE the FE to set
     */
    public void setFE(int FE) {
        this.FE = FE;
    }

    /**
     * @return the padre
     */
    public NodoBAVL<T> getPadre() {
        return padre;
    }

    /**
     * @param padre the padre to set
     */
    public void setPadre(NodoBAVL<T> padre) {
        this.padre = padre;
    }
}

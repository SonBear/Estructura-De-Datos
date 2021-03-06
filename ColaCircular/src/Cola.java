
/**
 *
 * @author emman
 */
public class Cola<T> {

    private int tamanio;
    private int frente;
    private int fin;
    private T datos[];

    public Cola(int tamanio, int posicionInicial) {
        this.tamanio = tamanio;
        datos = (T[]) new Object[tamanio];
        frente = posicionInicial;
        fin = frente;
    }

    public void agregar(T elem) throws ColaLlenaException {
        if (isEmpty()) {
            datos[fin] = elem;

        } else if (isFull()) {
            throw new ColaLlenaException("Error Cola Llena");
        } else {
            fin++;
            reiniciar();
            datos[fin] = elem;
        }

    }

    public T quitar() throws ColaVaciaException {
        if (isEmpty()) {
            throw new ColaVaciaException("Error Cola Vacia");
        }
        T elem = datos[frente];
        datos[frente] = null;
        frente++;
        reiniciar();
        return elem;
    }

    public T frente() throws ColaVaciaException {
        if (isEmpty()) {
            throw new ColaVaciaException("Error Cola Vacia");
        }
        return datos[frente];
    }

    public boolean isFull() {
        if (frente == 0 && fin == datos.length - 1) {
            return true;
        }
        return fin == frente - 1 && datos[frente] != null;
    }

    public boolean isEmpty() {
        return fin == frente && datos[fin] == null;
    }

    public void reiniciar() {
        if (fin > datos.length - 1) {
            fin = 0;
        }
        if (frente > datos.length - 1) {
            frente = 0;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        String salida = "";
        int aux = frente;

        while (aux != fin) {
            salida += datos[aux++] + "<-";

            if (aux >= datos.length) {
                aux = 0;

            }

        }

        return salida + datos[aux];
    }

}

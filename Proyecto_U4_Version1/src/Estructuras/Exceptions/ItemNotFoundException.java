package Estructuras.Exceptions;

/**
 * Excepcion por si los datos no se encuantran en el arbol
 *
 * @author emman
 */
public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String msg) {
        super(msg);
    }

}

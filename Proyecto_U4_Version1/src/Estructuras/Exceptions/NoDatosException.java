package Estructuras.Exceptions;

/**
 * Excepcion por si los arboles no contienen datos
 *
 * @author emman
 */
public class NoDatosException extends Exception {

    public NoDatosException(String message) {
        super(message);
    }

}

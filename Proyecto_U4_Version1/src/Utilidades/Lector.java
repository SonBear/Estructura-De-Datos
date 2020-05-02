package Utilidades;

/**
 *
 * @author emman
 * @param <T> objetos a crearse y enlistarse
 */
public interface Lector<T> {

    /**
     * funcion encargada de listar los datos de un archivo creando objetos de tipo T
     *
     * @return Array de los datos a generar
     */
    public T[] obtenerDatos();

    public void insertarDato(T elemento);

    public void eliminar(T elemento);
}

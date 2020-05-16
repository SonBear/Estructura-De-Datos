package ControlEgresados;

import Close.Egresado;
import Estructuras.ArbolABB;
import Estructuras.ArbolAVL;
import Estructuras.ArbolB;
import Estructuras.ArbolIB;
import Estructuras.Exceptions.ItemNotFoundException;
import Estructuras.Exceptions.NoDatosException;
import Utilidades.Lector;
import Utilidades.LectorCSV;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase para tener un manejo de los datos en los arboles
 *
 * @author emman
 */
public class ControlEgresados {

    private Lector<Egresado> lector;
    private Egresado[] egresados;
    private ArbolIB<Double> arbolPromedios;
    private ArbolIB<String> arbolNombres;
    private ArbolIB<String> arbolProfesion;

    public ArbolIB<Double> getArbolPromedios() {
        return arbolPromedios;
    }

    public ArbolIB<String> getArbolNombres() {
        return arbolNombres;
    }

    public ArbolIB<String> getArbolProfesion() {
        return arbolProfesion;
    }

    public Lector getLector() {
        return lector;
    }

    public Egresado[] getEgresados() {
        return egresados;
    }

    public void setLector(LectorCSV lector) {
        this.lector = lector;
    }

    public void setEgresados(Egresado[] egresados) {
        this.egresados = egresados;
    }

    /**
     *
     * Revisa si los arboles ya están generados
     *
     */
    private boolean estanGeneradoLosArboles() {
        if (arbolNombres == null || arbolProfesion == null || arbolPromedios == null) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param ruta direccion del archivo a leer
     * @param command comando a comparar para crear los arboles para cada tipo
     * @throws IOException Error en el archivo
     * @throws NoDatosException Si los datos no existen ó no pueden ser creados
     * @throws FileNotFoundException Error en el archivo
     */
    public void actualizarDatos(String ruta, String command) throws IOException, NoDatosException, FileNotFoundException {
        lector = new LectorCSV(ruta);
        egresados = lector.obtenerDatos();

        switch (command) {
            case "ArbolAVL":
                arbolProfesion = new ArbolAVL<>();
                arbolPromedios = new ArbolAVL<>();
                arbolNombres = new ArbolAVL<>();
                generarArboles();

                break;
            case "ArbolABB":
                arbolProfesion = new ArbolABB<>();
                arbolPromedios = new ArbolABB<>();
                arbolNombres = new ArbolABB<>();
                generarArboles();
                break;
            case "ArbolB":
                arbolNombres = new ArbolB<>();
                arbolPromedios = new ArbolB<>();
                arbolProfesion = new ArbolB<>();
                generarArboles();
                break;
            default:
                throw new AssertionError();
        }

    }

    /**
     *
     *
     * Inicializa los arboles de nombres, profesion y promedio, almacenando los indices y los datos a ordenar
     *
     * @return retorna true si no ocurre ningun error al generar los tres arboles
     */
    public boolean generarArboles() {

        for (int i = 0; i < egresados.length; i++) {
            arbolNombres.insertar(i, egresados[i].getNombre().toLowerCase());
        }
        for (int i = 0; i < egresados.length; i++) {
            arbolProfesion.insertar(i, egresados[i].getProfesion());
        }
        for (int i = 0; i < egresados.length; i++) {
            arbolPromedios.insertar(i, egresados[i].getPromedio());
        }
        return true;
    }

    /**
     *
     * @param arbol cualquier arbol de tipo ArbolIB
     * @return regresa un ArrayList de tipo Egresado, el cual contendra todos los datos ordenados.
     * @throws NoDatosException
     */
    public ArrayList<Egresado> listar(ArbolIB arbol) throws NoDatosException {

        ArrayList<Egresado> egresados = new ArrayList<>();
        if (arbol == null) {
            throw new NoDatosException("Datos no inciado o no compatibles");
        }
        ArrayList<Integer> indiceNombres = arbol.enlistarIndices();
        for (int i = 0; i < indiceNombres.size(); i++) {
            egresados.add(this.egresados[indiceNombres.get(i)]);
        }
        return egresados;
    }

    /**
     * Para esta funcion lista las profesiones del arbol de profesiones
     *
     * @return ArrayList de tipo String retorna los elementos principales de los arboles (nodos) y los enlista
     * @throws NoDatosException
     */
    public ArrayList<String> listaProfesiones() throws NoDatosException {
        return arbolProfesion.enlistarElementos();
    }

    /**
     * Busca por promedio y profesion
     *
     * @param Promedio
     * @param Profesion
     * @return lista de coicidencias entre los indices de los arboles
     * @throws ItemNotFoundException
     */
    public ArrayList<Egresado> buscarPorPromedioYProfesion(Double Promedio, String Profesion) throws ItemNotFoundException {
        if (!estanGeneradoLosArboles()) {
            throw new ItemNotFoundException("Arboles no generados");
        }
        ArrayList<Integer> d = arbolPromedios.buscar(Promedio);
        ArrayList<Integer> y = arbolProfesion.buscar(Profesion);
        ArrayList<Egresado> egresados = new ArrayList<>();
        boolean encontrado = false;
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < y.size(); j++) {
                if (d.get(i) == y.get(j)) {
                    egresados.add(this.egresados[d.get(i)]);
                    System.out.println(this.egresados[d.get(i)]);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            throw new ItemNotFoundException("Dato no encontrado");
        }
        return egresados;
    }

    /**
     * Busca por Nombre y profesion
     *
     * @param nombre
     * @param Profesion
     * @return
     * @throws ItemNotFoundException
     */
    public ArrayList<Egresado> buscarPorNombreYProfesion(String nombre, String Profesion) throws ItemNotFoundException {
        if (!estanGeneradoLosArboles()) {
            throw new ItemNotFoundException("Arboles no generados");
        }
        ArrayList<Integer> d = arbolNombres.buscar(nombre);
        ArrayList<Integer> y = arbolProfesion.buscar(Profesion);
        ArrayList<Egresado> egresados = new ArrayList<>();
        boolean encontrado = false;
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < y.size(); j++) {
                if (d.get(i) == y.get(j)) {
                    egresados.add(this.egresados[d.get(i)]);
                    System.out.println(this.egresados[d.get(i)]);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            throw new ItemNotFoundException("Dato no encontrado");
        }
        return egresados;
    }

    /**
     * Busca por nombre y profesion
     *
     * @param nombre
     * @param Promedio
     * @return lista de coicidencias entre los indices de los arboles
     * @throws ItemNotFoundException
     */
    public ArrayList<Egresado> buscarPorNombreYPromedio(String nombre, Double Promedio) throws ItemNotFoundException {
        if (!estanGeneradoLosArboles()) {
            throw new ItemNotFoundException("Arboles no generados");
        }
        ArrayList<Integer> d = arbolNombres.buscar(nombre);
        ArrayList<Integer> y = arbolPromedios.buscar(Promedio);
        ArrayList<Egresado> egresados = new ArrayList<>();
        boolean encontrado = false;
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < y.size(); j++) {
                if (d.get(i) == y.get(j)) {
                    egresados.add(this.egresados[d.get(i)]);
                    System.out.println(this.egresados[d.get(i)]);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            throw new ItemNotFoundException("Dato no encontrado");
        }
        return egresados;
    }

    /**
     * Busca por nombre, profesion y promedio
     *
     * @param nombre
     * @param Promedio
     * @return lista de coicidencias entre los indices de los arboles
     * @throws ItemNotFoundException
     */
    public ArrayList<Egresado> buscarPorNombreProfesionPromedio(String nombre, String profesion, Double promedio) throws ItemNotFoundException {
        if (!estanGeneradoLosArboles()) {
            throw new ItemNotFoundException("Arboles no generados");
        }
        ArrayList<Integer> d = arbolNombres.buscar(nombre);
        ArrayList<Integer> f = arbolProfesion.buscar(profesion);
        ArrayList<Integer> y = arbolPromedios.buscar(promedio);
        ArrayList<Egresado> egresados = new ArrayList<>();
        boolean encontrado = false;
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < y.size(); j++) {
                for (int k = 0; k < f.size(); k++) {
                    if (d.get(i) == y.get(j) && d.get(i) == f.get(k)) {
                        egresados.add(this.egresados[d.get(i)]);
                        System.out.println(this.egresados[d.get(i)]);
                        encontrado = true;
                    }

                }
            }
        }
        if (!encontrado) {
            throw new ItemNotFoundException("Dato no encontrado");
        }
        return egresados;
    }

    /**
     * Busca indices que coicidan con el promedio propuesto
     *
     * @param Promedio
     * @return lista de egresado que coiciden con los indices de la busqueda
     * @throws ItemNotFoundException
     */
    public ArrayList<Egresado> buscarPorPromedio(Double Promedio) throws ItemNotFoundException {
        if (!estanGeneradoLosArboles()) {
            throw new ItemNotFoundException("Arboles no generados");
        }
        ArrayList<Egresado> egresados = new ArrayList<>();

        ArrayList<Integer> d = arbolPromedios.buscar(Promedio);
        for (int i = 0; i < d.size(); i++) {
            egresados.add(this.egresados[d.get(i)]);
            System.out.println(this.egresados[d.get(i)]);
        }
        return egresados;
    }

    /**
     * Busca indices que coicidan con la profesion propuesta
     *
     * @param profesion
     * @return lista de egresado que coiciden con los indices de la busqueda
     * @throws ItemNotFoundException
     */
    public ArrayList<Egresado> buscarPorProfesion(String profesion) throws ItemNotFoundException {
        if (!estanGeneradoLosArboles()) {
            throw new ItemNotFoundException("Arboles no generados");
        }
        ArrayList<Integer> d = arbolProfesion.buscar(profesion);
        ArrayList<Egresado> egresados = new ArrayList<>();
        for (int i = 0; i < d.size(); i++) {
            egresados.add(this.egresados[d.get(i)]);
            System.out.println(this.egresados[d.get(i)]);
        }
        return egresados;
    }

    /**
     * Busca indices que coicidan con el nombre propuesto
     *
     * @param nombre
     * @return lista de egresado que coiciden con los indices de la busqueda
     * @throws ItemNotFoundException
     */
    public ArrayList<Egresado> buscarPorNombre(String nombre) throws ItemNotFoundException {
        if (!estanGeneradoLosArboles()) {
            throw new ItemNotFoundException("Arboles no generados");
        }
        ArrayList<Integer> d = arbolNombres.buscar(nombre);
        ArrayList<Egresado> egresados = new ArrayList<>();
        for (int i = 0; i < d.size(); i++) {
            egresados.add(this.egresados[d.get(i)]);
            System.out.println(this.egresados[d.get(i)]);
        }
        return egresados;

    }

}

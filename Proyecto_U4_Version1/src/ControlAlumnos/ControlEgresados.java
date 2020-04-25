/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAlumnos;

import Close.Egresado;
import Estructuras.ArbolABB;
import Estructuras.ArbolAVL;
import Estructuras.ArbolB;
import Estructuras.ArbolIB;
import Estructuras.Exceptions.ItemNotFoundException;
import Estructuras.Exceptions.NoDatosException;
import Utilidades.Lector;
import Utilidades.LectorCVS;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class ControlEgresados {
    //Error desconocido F

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

    public void setLector(LectorCVS lector) {
        this.lector = lector;
    }

    public void setEgresados(Egresado[] egresados) {
        this.egresados = egresados;
    }

    private boolean estanGeneradoLosArboles() {
        if (arbolNombres == null || arbolProfesion == null || arbolPromedios == null) {
            return false;
        }
        return true;
    }

    public void actualizarDatos(String ruta, String command) throws IOException, NoDatosException, FileNotFoundException {
        lector = new LectorCVS(ruta);
        egresados = lector.obtenerDatos();
        if (egresados == null) {
            throw new NoDatosException("F");
        }

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

    public boolean generarArboles() {

        for (int i = 0; i < egresados.length; i++) {
            arbolNombres.insertar(i, egresados[i].getNombre());
        }
        for (int i = 0; i < egresados.length; i++) {
            arbolProfesion.insertar(i, egresados[i].getProfesion());
        }
        for (int i = 0; i < egresados.length; i++) {
            arbolPromedios.insertar(i, egresados[i].getPromedio());
        }
        return true;
    }

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

    public ArrayList<String> listaProfesiones() throws NoDatosException {
        return arbolProfesion.enlistarElementos();
    }

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

    public ArrayList<Egresado> buscarPorNombre(String Nombre) throws ItemNotFoundException {
        if (!estanGeneradoLosArboles()) {
            throw new ItemNotFoundException("Arboles no generados");
        }
        ArrayList<Integer> d = arbolNombres.buscar(Nombre);
        ArrayList<Egresado> egresados = new ArrayList<>();
        for (int i = 0; i < d.size(); i++) {
            egresados.add(this.egresados[d.get(i)]);
            System.out.println(this.egresados[d.get(i)]);
        }
        return egresados;

    }

}

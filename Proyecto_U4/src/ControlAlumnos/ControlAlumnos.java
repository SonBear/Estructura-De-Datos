/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAlumnos;

import Close.Egresado;
import Estructuras.Arbol;
import Estructuras.ArbolABBANombres;
import Estructuras.ArbolABBAProfesion;
import Estructuras.ArbolABBAPromedios;
import Estructuras.Exceptions.ItemNotFoundException;
import Utilidades.LectorCVS;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class ControlAlumnos {
    //Error desconocido F

    private LectorCVS lector = new LectorCVS("archivos\\alumnos.cvs");
    private Egresado[] egresados = lector.obtenerDatos();
    private Arbol<Double> arbolPromedios = new ArbolABBAPromedios(egresados);
    private Arbol<String> arbolNombres = new ArbolABBANombres(egresados);
    private Arbol<String> arbolProfesion = new ArbolABBAProfesion(egresados);

    public void setEgresados() {
        this.egresados = lector.obtenerDatos();
    }

    public void actualizarDatos(String ruta) {
        arbolProfesion = new ArbolABBAProfesion(egresados);
        arbolPromedios = new ArbolABBAPromedios(egresados);
        arbolNombres = new ArbolABBANombres(egresados);
        this.lector = new LectorCVS(ruta);
        egresados = lector.obtenerDatos();
    }

    public void f() {

    }

    public void generarArboles() {
        System.out.println("Arbol de promedios");
        generarArbol(arbolPromedios);
        System.out.println("Arbol de profesiones");
        generarArbol(arbolProfesion);
        System.out.println("Arbol de Nombres");
        generarArbol(arbolNombres);
    }

    public ArrayList<Egresado> listarPorNombre() {
        ArrayList<Egresado> egresados = new ArrayList<>();
        ArrayList<Integer> indiceNombres = arbolNombres.enlistarIndices();
        for (int i = 0; i < indiceNombres.size(); i++) {
            egresados.add(this.egresados[indiceNombres.get(i)]);
        }
        return egresados;
    }

    public void listar() {
        System.out.println("Lista Por Nombres");
        imprimirLista(arbolNombres.enlistarIndices());
        System.out.println("Lista por promedios");
        imprimirLista(arbolPromedios.enlistarIndices());
        System.out.println("Lista por Profesiones");
        imprimirLista(arbolProfesion.enlistarIndices());

    }

    private void imprimirLista(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println(egresados[a.get(i)]);
        }
    }

    public void buscarPorNombre(String Nombre) {
        ArrayList<Integer> d = arbolNombres.buscar(Nombre);
        for (int i = 0; i < d.size(); i++) {
            System.out.println(egresados[d.get(i)]);
        }

    }

    public void buscarPorPromedioYProfesion(Double Promedio, String Profesion) throws ItemNotFoundException {
        ArrayList<Integer> d = arbolPromedios.buscar(Promedio);
        ArrayList<Integer> y = arbolProfesion.buscar(Profesion);
        boolean encontrado = false;
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < y.size(); j++) {
                if (d.get(i) == y.get(j)) {
                    System.out.println(egresados[d.get(i)]);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            throw new ItemNotFoundException("Dato no encontrado");
        }
    }

    public void buscarPorNombreYProfesion(String nombre, String Profesion) throws ItemNotFoundException {
        ArrayList<Integer> d = arbolNombres.buscar(nombre);
        ArrayList<Integer> y = arbolProfesion.buscar(Profesion);
        boolean encontrado = false;
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < y.size(); j++) {
                if (d.get(i) == y.get(j)) {
                    System.out.println(egresados[d.get(i)]);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            throw new ItemNotFoundException("Dato no encontrado");
        }
    }

    public void buscarPorNombreYPromedio(String nombre, Double Promedio) throws ItemNotFoundException {
        ArrayList<Integer> d = arbolNombres.buscar(nombre);
        ArrayList<Integer> y = arbolPromedios.buscar(Promedio);
        boolean encontrado = false;
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < y.size(); j++) {
                if (d.get(i) == y.get(j)) {
                    System.out.println(egresados[d.get(i)]);
                    encontrado = true;
                }
            }
        }
        if (!encontrado) {
            throw new ItemNotFoundException("Dato no encontrado");
        }
    }

    public void buscarPorNombreProfesionPromedio(String nombre, String profesion, Double promedio) throws ItemNotFoundException {
        ArrayList<Integer> d = arbolNombres.buscar(nombre);
        ArrayList<Integer> f = arbolProfesion.buscar(profesion);
        ArrayList<Integer> y = arbolPromedios.buscar(promedio);
        boolean encontrado = false;
        for (int i = 0; i < d.size(); i++) {
            for (int j = 0; j < y.size(); j++) {
                for (int k = 0; k < f.size(); k++) {
                    if (d.get(i) == y.get(j) && d.get(i) == f.get(k)) {
                        System.out.println(egresados[d.get(i)]);
                        encontrado = true;
                    }

                }
            }
        }
        if (!encontrado) {
            throw new ItemNotFoundException("Dato no encontrado");
        }
    }

    public void buscarPorPromedio(Double Promedio) {
        try {

            ArrayList<Integer> d = arbolPromedios.buscar(Promedio);
            for (int i = 0; i < d.size(); i++) {
                System.out.println(egresados[d.get(i)]);
            }
        } catch (Exception ex) {

        }
    }

    public void buscarPorProfesion(String profesion) {
        ArrayList<Integer> d = arbolProfesion.buscar(profesion);
        for (int i = 0; i < d.size(); i++) {
            System.out.println(egresados[d.get(i)]);
        }
    }

    private void generarArbol(Arbol arbol) {
        for (int i = 0; i < egresados.length; i++) {
            arbol.insertar(i);
        }
        arbol.recorrerArbol();
    }

    public static void main(String[] args) {
        ControlAlumnos a = new ControlAlumnos();
        a.generarArboles();
        System.out.println("Busqueda por nombre");
        a.buscarPorNombre("Emmanuel Chable");
        System.out.println("Busqueda por porfesion");
        a.buscarPorProfesion("LIS");
        System.out.println("----Busqueda por promedio---");
        a.buscarPorPromedio(9.0);

        System.out.println("--------------------------------------");
        System.out.println("--Listas----------------");
        a.listar();
        System.out.println("Busqueda con dos parametros");
        a.buscarPorNombreProfesionPromedio("Charly Alvares", "LIC", 8.0);
        a.buscarPorNombreYProfesion("Em Chable", "LIS");
        a.buscarPorNombreYPromedio("d Chable", 8.0);
        a.buscarPorPromedioYProfesion(7.0, "ACT");

    }

}

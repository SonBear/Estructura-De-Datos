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

    private LectorCVS lector;
    private Egresado[] egresados;
    private Arbol<Double> arbolPromedios;
    private Arbol<String> arbolNombres;
    private Arbol<String> arbolProfesion;

    public void setEgresados() {
        this.egresados = lector.obtenerDatos();
    }

    public void actualizarDatos(String ruta) {
        lector = new LectorCVS(ruta);
        egresados = lector.obtenerDatos();
        arbolProfesion = new ArbolABBAProfesion(egresados);
        arbolPromedios = new ArbolABBAPromedios(egresados);
        arbolNombres = new ArbolABBANombres(egresados);
        generarArboles();

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

    public ArrayList<Egresado> listarPorPromedio() {
        ArrayList<Egresado> egresados = new ArrayList<>();
        ArrayList<Integer> indiceNombres = arbolPromedios.enlistarIndices();
        for (int i = 0; i < indiceNombres.size(); i++) {
            egresados.add(this.egresados[indiceNombres.get(i)]);
        }
        return egresados;
    }

    public ArrayList<Egresado> listarPorProfesion() {
        ArrayList<Egresado> egresados = new ArrayList<>();
        ArrayList<Integer> indiceNombres = arbolProfesion.enlistarIndices();
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

    public ArrayList<Egresado> buscarPorPromedioYProfesion(Double Promedio, String Profesion) throws ItemNotFoundException {
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

    public ArrayList<Egresado> buscarPorPromedio(Double Promedio) {
        ArrayList<Egresado> egresados = new ArrayList<>();

        ArrayList<Integer> d = arbolPromedios.buscar(Promedio);
        for (int i = 0; i < d.size(); i++) {
            egresados.add(this.egresados[d.get(i)]);
            System.out.println(this.egresados[d.get(i)]);
        }
        return egresados;
    }

    public ArrayList<Egresado> buscarPorProfesion(String profesion) {
        ArrayList<Integer> d = arbolProfesion.buscar(profesion);
        ArrayList<Egresado> egresados = new ArrayList<>();
        for (int i = 0; i < d.size(); i++) {
            egresados.add(this.egresados[d.get(i)]);
            System.out.println(this.egresados[d.get(i)]);
        }
        return egresados;
    }

    public ArrayList<Egresado> buscarPorNombre(String Nombre) {
        ArrayList<Integer> d = arbolNombres.buscar(Nombre);
        ArrayList<Egresado> egresados = new ArrayList<>();
        for (int i = 0; i < d.size(); i++) {
            egresados.add(this.egresados[d.get(i)]);
            System.out.println(this.egresados[d.get(i)]);
        }
        return egresados;

    }

    private void generarArbol(Arbol arbol) {
        for (int i = 0; i < egresados.length; i++) {
            arbol.insertar(i);
        }
        arbol.recorrerArbol();
    }

}

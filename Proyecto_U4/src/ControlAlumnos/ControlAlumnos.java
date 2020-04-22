/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAlumnos;

import Close.Alumno;
import Estructuras.Arbol;
import Estructuras.ArbolABBANombres;
import Estructuras.ArbolABBAProfesion;
import Estructuras.ArbolABBAPromedios;
import Utilidades.LectorCVS;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class ControlAlumnos {
    //Error desconocido F

    private LectorCVS lector = new LectorCVS("archivos\\alumnos.cvs");
    private Alumno[] alumnos = lector.obtenerDatos();
    private Arbol<Double> arbolPromedios = new ArbolABBAPromedios(alumnos);
    private Arbol<String> arbolNombres = new ArbolABBANombres(alumnos);
    private Arbol<String> arbolProfesion = new ArbolABBAProfesion(alumnos);

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

    private void generarArbolProfesion() {
        for (int i = 0; i < alumnos.length; i++) {
            arbolProfesion.insertar(i);
        }
        arbolProfesion.recorrerArbol();
    }

    private void generarArbolPromedios(Arbol arbol) {

        for (int i = 1; i < alumnos.length; i++) {
            arbol.insertar(i);
        }
        arbol.recorrerArbol();
    }

    private void generarArbol(Arbol arbol) {
        for (int i = 0; i < alumnos.length; i++) {
            arbol.insertar(i);
        }
        arbol.recorrerArbol();
    }

    public Alumno[] getPromedios(Double promedio) {
        ArrayList<Alumno> alumnosConPromedio = new ArrayList<>();
        Alumno[] alumnos = lector.obtenerDatos();
        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i].getPromedio() == promedio) {
                alumnosConPromedio.add(alumnos[i]);
            }
        }
        alumnos = alumnosConPromedio.toArray(alumnos);
        return alumnos;
    }

    public Alumno[] getLicenciatura(String profesion) {
        ArrayList<Alumno> alumnosConProfesion = new ArrayList<>();
        Alumno[] alumnos = lector.obtenerDatos();
        for (int i = 0; i < alumnos.length; i++) {

            if (alumnos[i].getProfesion().equals(profesion)) {
                System.out.println("F");
                alumnosConProfesion.add(alumnos[i]);
            }
        }

        return alumnosConProfesion.toArray(alumnos);
    }

    public static void main(String[] args) {
        ControlAlumnos a = new ControlAlumnos();
        a.generarArboles();
    }

}

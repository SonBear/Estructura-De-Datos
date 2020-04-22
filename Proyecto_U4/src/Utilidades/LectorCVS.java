/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Close.Alumno;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author emman
 */
public class LectorCVS implements Lector<Alumno> {

    private File cvs;
    private Scanner scanner;

    public LectorCVS(String path) {
        try {
            cvs = new File(path);
            if (!cvs.exists()) {
                cvs.createNewFile();
            }
            scanner = new Scanner(cvs);
        } catch (FileNotFoundException ex) {
            System.out.println("Error Archivo No encontrado");
        } catch (IOException ex) {
            System.out.println("Eror");
        }
    }

    @Override
    public Alumno[] obtenerDatos() {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] datos = scanner.nextLine().split(",");

            alumnos.add(new Alumno(datos[0], datos[1], Double.parseDouble(datos[2])));
        }
        return alumnos.toArray(new Alumno[alumnos.size()]);
    }

    @Override
    public void insertarDato(Alumno elemento) {

    }

    @Override
    public void eliminar(Alumno elemento) {
    }

}

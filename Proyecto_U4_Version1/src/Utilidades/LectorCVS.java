/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Close.Egresado;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author emman
 */
public class LectorCVS implements Lector<Egresado> {

    private File cvs;
    private Scanner scanner;

    public LectorCVS(String path) throws FileNotFoundException, IOException {

        cvs = new File(path);
        scanner = new Scanner(cvs);

    }

    @Override
    public Egresado[] obtenerDatos() {
        ArrayList<Egresado> alumnos = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] datos = scanner.nextLine().split(",");

            alumnos.add(new Egresado(datos[0], datos[1], Double.parseDouble(datos[2])));
        }
        return alumnos.toArray(new Egresado[alumnos.size()]);
    }

    @Override
    public void insertarDato(Egresado elemento) {

    }

    @Override
    public void eliminar(Egresado elemento) {
    }

}
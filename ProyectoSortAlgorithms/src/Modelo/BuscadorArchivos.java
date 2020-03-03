/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class BuscadorArchivos {

    public File[] enlistarArchivos(String path) {
        File file = new File(path);

        File[] archivos = file.listFiles();

        return archivos;
    }

    public String[] enlistarNombreArchivos(String path) {
        File[] archivos = enlistarArchivos(path);
        String[] nombreArchivos = new String[archivos.length];
        for (int i = 0; i < nombreArchivos.length; i++) {
            nombreArchivos[i] = archivos[i].getName();
        }

        return nombreArchivos;
    }

    public String[] enlistarNombresDeTodoLosArchivos(String path) {
        File[] listArchivos = obtenerListaTodosArchivos(path);
        String[] nombreArchivos = new String[listArchivos.length];
        for (int i = 0; i < nombreArchivos.length; i++) {
            nombreArchivos[i] = listArchivos[i].getName();
        }
        return nombreArchivos;
    }

    public File[] obtenerListaTodosArchivos(String path) {
        ArrayList<File> listArchivos = new ArrayList<>();
        File[] f = new File[listArchivos.size()];
        enlistarTodosLosArchivos(path, listArchivos);
        //listArchivos.toArray(new File[listArchivos.size()]);
        f = listArchivos.toArray(f);
        return f;
    }

    private void enlistarTodosLosArchivos(String path, ArrayList<File> array) {
        File[] files = new File(path).listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                array.add(files[i]);
                if (files[i].isDirectory()) {
                    enlistarTodosLosArchivos(files[i].getAbsolutePath(), array);
                }
            }
        }

    }

}

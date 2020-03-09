/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Excepciones.DirectoryNoSelectedException;
import Excepciones.FileNoFoundException;
import Excepciones.NoFileNameWriteException;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class BinarySearch {

    private static int binarySearch(ArrayList<File> a, int fromIndex, int toIndex,
            String key, ArrayList<File> founds) {
        int cont = 0;
        int low = fromIndex;
        int high = toIndex;
        while (low <= high) {
            int mid = (low + high) >>> 1; //Divide entre dos :v
            File midVal = a.get(mid);
            String name = name(midVal, key);

            if (name.compareTo(key.toLowerCase()) < 0) {
                low = mid + 1;
            } else if (name.compareTo(key.toLowerCase()) > 0) {
                high = mid - 1;
            } else {
                cont++;
                founds.add(midVal);
                a.remove(midVal);
                if (a.isEmpty()) { //Por si solo existe un archico;
                    return cont;
                }
                low = 0;
                high = a.size();
                //return mid; // key found
            }
        }
        return cont;  // key not found.
    }

    private static String name(File archivo, String key) {
        String nameFile = archivo.getName();
        int end = key.length();
        if (end >= nameFile.length()) {
            return nameFile.toLowerCase();
        }
        String name = nameFile.substring(0, end);

        return name.toLowerCase();

    }

    private static ArrayList<File> t(File[] asd) {
        ArrayList<File> d = new ArrayList<>();
        for (int i = 0; i < asd.length; i++) {
            d.add(asd[i]);
        }

        return d;
    }

    public static File[] search(File[] archivos, String fileName) throws FileNoFoundException, NoFileNameWriteException, DirectoryNoSelectedException {

        ArrayList<File> array = new ArrayList<>();
        //------Al
        if (archivos == null) {
            throw new DirectoryNoSelectedException("Directorio no seleccionado");
        }

        if (fileName.equals("") || fileName == null) {
            throw new NoFileNameWriteException("Nombre en blanco");
        }
        int cont;
        if (archivos.length > 0) {
            cont = binarySearch(t(archivos), 0, archivos.length, fileName, array);
        } else {
            cont = 0;
        }

        if (cont == 0) {
            throw new FileNoFoundException("Archivo no encontrado");
        }

        File[] encontrados = new File[array.size()];

        encontrados = array.toArray(encontrados);
        return encontrados;
    }
}

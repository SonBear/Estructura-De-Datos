/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;

/**
 *
 * @author emman
 */
public class InsertionSort {

    public static void sort(File[] archivos) {
        int n = archivos.length;
        for (int i = 1; i < n; ++i) {
            File key = archivos[i];
            int j = i - 1;
            while (j >= 0 && name(archivos[j]).compareTo(name(key)) > 0) {
                archivos[j + 1] = archivos[j];
                j = j - 1;
            }
            archivos[j + 1] = key;
        }
    }

    private static String name(File archivo) {
        return archivo.getName().toLowerCase();
    }

}

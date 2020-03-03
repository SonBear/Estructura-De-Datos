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
public class BubleSort {

    public static void sort(File[] archivos) {

        boolean swapped;
        int n = archivos.length;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (archivos[j].getName().toLowerCase().compareTo(archivos[j + 1].getName().toLowerCase()) > 0) {
                    swap(i, j, archivos);
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
            }
        }

    }

    private static void swap(int i, int j, File[] a) {
        File temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;

    }
}

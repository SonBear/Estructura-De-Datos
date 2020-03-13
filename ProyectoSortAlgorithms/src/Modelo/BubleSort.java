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
                if (name(archivos[j]).compareTo(name(archivos[j + 1])) > 0) {
                    swap(i, j, archivos);
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
            }
        }

    }

    private static String name(File archivo) {
        return archivo.getName().toLowerCase();
    }

    private static void swap(int i, int j, File[] a) {
        File temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;

    }
}

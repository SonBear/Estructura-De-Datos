package Modelo;

import java.io.File;

/**
 * Clase para el algoritmo de Merge Sort
 *
 * @author emman
 *
 */
class MergeSort {

    public static void mergeSort(File[] a, int n) {

        if (n < 2) {

            return;
        }
        int mid = n / 2;
        File[] l = new File[mid];
        File[] r = new File[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    private static void merge(
            File[] a, File[] l, File[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (name(l[i]).compareTo(name(r[j])) <= 0) {

                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {

            a[k++] = l[i++];
        }

        while (j < right) {

            a[k++] = r[j++];
        }

    }

    public static void sort(File[] archivos) {
        mergeSort(archivos, archivos.length);
    }

    private static String name(File archivo) {
        return archivo.getName().toLowerCase();
    }
}

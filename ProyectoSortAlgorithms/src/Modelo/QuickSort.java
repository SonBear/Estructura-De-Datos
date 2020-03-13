package Modelo;

import java.io.File;

/**
 *
 * @author emman
 */
public class QuickSort {

    private static int partition(File arr[], int low, int high) {

        File pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {

            if (name(arr[j]).compareTo(name(pivot)) <= 0) {

                i++;

                File temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        File temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void quickSort(File arr[], int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static String name(File archivo) {
        return archivo.getName().toLowerCase();
    }

    public static void sort(File[] archivos) {
        quickSort(archivos, 0, archivos.length - 1);
    }
}

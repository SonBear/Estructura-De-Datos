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
public class QuickSort {

    private static int partition(File arr[], int low, int high) {

        File pivot = arr[high];
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (name(arr[j]).compareTo(name(pivot)) <= 0) {

                i++;

                // swap arr[i] and arr[j]
                File temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        File temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* The main function that implements QuickSort()
     arr[] --> Array to be sorted,
     low  --> Starting index,
     high  --> Ending index */
    public static void quickSort(File arr[], int low, int high) {

        if (low < high) {
            /* pi is partitioning index, arr[pi] is
             now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
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

package Modelo;

import java.io.File;

/**
 *
 * @author emman
 */
public class ShellSort {

    public static void shellSort(File arr[]) {
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i += 1) {

                File temp = arr[i];

                int j;
                for (j = i; j >= gap && name(arr[j - gap]).compareTo(name(temp)) > 0; j -= gap) {

                    arr[j] = arr[j - gap];
                }

                arr[j] = temp;
            }
        }

    }

    private static String name(File archivo) {
        return archivo.getName().toLowerCase();
    }

    public static void sort(File[] archivos) {
        shellSort(archivos);
    }
}

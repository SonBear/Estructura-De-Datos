/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author emman
 */
public class Algorithms {

    public static void insertionSort(int[] arr) {
        long comp = 0, swaps = 0;
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            comp++;
            while (j >= 0 && arr[j] > key) {
                comp++;
                arr[j + 1] = arr[j];
                j = j - 1;
                swaps++;
            }
            swaps++;
            arr[j + 1] = key;
        }
        System.out.println("Comparaciones: " + comp + " " + "Intercambios: " + swaps);
    }

    public static void bubbleSort(int arr[]) {
        long comp = 0;
        long swaps = 0;
        boolean swapped;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comp++;
                if (arr[j] > arr[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    swap(i, j, arr);

                    swaps++;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false) {
                break;
            }
        }

        System.out.println("Comparaciones : " + comp + " " + "Intercambios: " + swaps);
    }

    public static void shellSort(int arr[]) {
        int n = arr.length;
        long comp = 0;
        long swaps = 0;
        // Start with a big gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    comp++;

                    arr[j] = arr[j - gap];
                    swaps++;
                }

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
                swaps++;
            }
        }

        System.out.println("Comparaciones: " + comp + " " + "Intercambions: " + swaps);

    }
    public static long compM = 0;
    public static long swapsM = 0;

    public static void mergeSort(int[] a, int n) {

        if (n < 2) {

            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

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
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        compM++;
        while (i < left && j < right) {
            compM++;
            if (l[i] <= r[j]) {

                a[k++] = l[i++];
                swapsM++;
            } else {
                swapsM++;
                a[k++] = r[j++];
            }
        }
        while (i < left) {

            swapsM++;
            a[k++] = l[i++];
        }

        while (j < right) {

            swapsM++;
            a[k++] = r[j++];
        }

    }

    public static long swapsQ = 0;
    public static long compQ = 0;

    private static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = (low - 1); // index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            compQ++;
            if (arr[j] < pivot) {

                i++;

                // swap arr[i] and arr[j]
                swapsQ++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        swapsQ++;
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    /* The main function that implements QuickSort()
     arr[] --> Array to be sorted,
     low  --> Starting index,
     high  --> Ending index */
    public static void quickSort(int arr[], int low, int high) {

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

    private static void swap(int i, int j, int[] a) {
        int temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;

    }

    public static void mezclaDirecta(int[] datos) {
        int n = datos.length;
        int mid = (n + 1) / 2;
        int cont = 0;
        int cont2 = 0;
        int[] a = new int[mid];
        int[] b = new int[n - mid];

        mezclarAUno(datos, a, b);
        reescribirApares(datos, a, b);
        mezclarAPares(datos, a, b);
        //mezclarAUno(datos, a, b);
        reescribirApares(datos, a, b);
        mezclarAPares(datos, a, b);

        //ordenar por cuadruplos
        System.out.println(Arrays.toString(datos));
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }

    private static void reescribirApares(int a[], int b[], int c[]) {
        int i = 0;
        int j = 0;

        while (i < b.length && i < c.length) {
            if (b[i] < c[i]) {
                a[j] = b[i];
                a[j + 1] = c[i];
            } else {
                a[j] = c[i];
                a[j + 1] = b[i];
            }
            j += 2;
            i++;
        }
    }

    private static void mezclarAPares(int a[], int b[], int c[]) {
        int cont = 0;
        int cont2 = 0;
        boolean f = true;
        for (int k = 0; k < a.length; k += 2) {

            if (f) {
                b[cont] = a[k];
                if (cont + 1 < c.length) {

                    b[cont + 1] = a[k + 1];
                }
                f = false;
                cont += 2;
            } else {
                c[cont2] = a[k];
                if (cont2 + 1 < c.length) {

                    c[cont2 + 1] = a[k + 1];
                }
                f = true;
                cont2 += 2;
            }

        }

    }

    private static void mezclarAUno(int a[], int b[], int c[]) {
        int cont = 0;
        int cont2 = 0;
        for (int i = 0; i < a.length; i++) {
            if ((i + 1) % 2 == 0) {
                c[cont++] = a[i];
            } else {
                b[cont2++] = a[i];

            }
        }

    }

    private static void ordenarPorPares(int a[], int b[], int c[]) {

    }

    /*Robado de las diapos de garci
     n = total de numeros en el archivo
     f = archivos.dat
     Full*/
    public static void MEZCLADIRECTA(File f, int n) throws IOException {
        File f1 = new File("archivos\\f1.dat");
        File f2 = new File("archivos\\f2.dat");
        for (int i = 1; i < n; i *= 2) {
            PARTICIONA(f, f1, f2, i);
            FUSIONA(f, f1, f2, i);

        }
    }

    private static void PARTICIONA(File f, File f1, File f2, int n) throws FileNotFoundException, IOException {

        Scanner leerAr = new Scanner(f);
        FileWriter flWriter1 = new FileWriter(f1);
        BufferedWriter bw1 = new BufferedWriter(flWriter1);
        FileWriter flWriter2 = new FileWriter(f2);
        BufferedWriter bw2 = new BufferedWriter(flWriter2);
        int k;
        int dato;
        while (leerAr.hasNext()) {

            for (k = 0; k < n && leerAr.hasNext(); k++) {

                dato = leerAr.nextInt();
                bw1.write(dato + "\n");
            }

            for (int l = 0; l < n && leerAr.hasNext(); l++) {
                dato = leerAr.nextInt();
                bw2.write(dato + "\n");

            }
        }

        bw2.close();
        bw1.close();
        leerAr.close();

    }

    private static void FUSIONA(File f, File f1, File f2, int n) throws IOException {
        FileWriter flWriter1 = new FileWriter(f);
        BufferedWriter pF = new BufferedWriter(flWriter1);
        Scanner lF1 = new Scanner(f1);
        Scanner lF2 = new Scanner(f2);
        int k, j;
        boolean b1 = true, b2 = true;
        int clave1 = 0, clave2 = 0;
        if (lF1.hasNext()) {
            clave1 = lF1.nextInt();
            b1 = false;
        }
        if (lF2.hasNext()) {
            clave2 = lF2.nextInt();
            b2 = false;
        }

        while ((lF1.hasNext() || b1 == false) && (lF2.hasNext() || b2 == false)) {
            k = 0;
            j = 0;
            while (((k < n) && (b1 == false)) && ((j < n) && (b2 == false))) {
                if (clave1 <= clave2) {
                    pF.write(clave1 + "\n");
                    b1 = true;
                    k++;
                    if (lF1.hasNext()) {
                        clave1 = lF1.nextInt();
                        b1 = false;
                    }
                } else {
                    pF.write(clave2 + "\n");
                    b2 = true;
                    j++;
                    if (lF2.hasNext()) {
                        clave2 = lF2.nextInt();
                        b2 = false;
                    }
                }
            }

            if (k < n) {
                while (k < n && b1 == false) {
                    pF.write(clave1 + "\n");
                    b1 = true;
                    k++;
                    if (lF1.hasNext()) {
                        clave1 = lF1.nextInt();
                        b1 = false;
                    }
                }

            }

            if (j < n) {
                while (j < n && b2 == false) {
                    pF.write(clave2 + "\n");
                    b2 = true;
                    j++;
                    if (lF2.hasNext()) {
                        clave2 = lF2.nextInt();
                        b2 = false;
                    }
                }

            }
        }
        if (b1 == false) {
            pF.write(clave1 + "\n");

        }

        if (b2 == false) {
            pF.write(clave2 + "\n");
        }

        while (lF1.hasNext()) {
            clave1 = lF1.nextInt();
            pF.write(clave1 + "\n");

        }

        while (lF2.hasNext()) {
            clave2 = lF2.nextInt();
            pF.write(clave2 + "\n");

        }
        pF.close();
        lF1.close();
        lF2.close();

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

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

}

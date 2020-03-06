/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 *
 * @author emman
 */
public class NewMain1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        int[] b = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] a = {10, 3, 5, 6, 1, 4, 7, 2, 9, 8};
        int[] c = new int[100000];
        for (int i = 0, j = 100000; i < c.length; i++, j--) {

            c[i] = j;
        }
        //c = GeneradorArrays.generar100000();
        c = ManejadorArchivos.recuperarDatos(100000);
        System.out.println(Arrays.toString(c));
        System.out.println(c.length);
        Algorithms.mergeSort(c, c.length);
        System.out.println("Comparaciones: " + Algorithms.compM + "in: " + Algorithms.swapsM);
        MergeSort merge = new MergeSort();
        //merge.sort(c, 0, c.length - 1);
        //System.out.println("Comparaciones: " + merge.comp + "in: " + merge.inter);

    }

}

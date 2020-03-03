/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import javax.swing.ButtonModel;

/**
 *
 * @author emman
 */
public class Algoritmos {

    public static void sort(File[] archivos, ButtonModel check) {
        switch (check.getActionCommand()) {
            case "bubleSort":
                System.out.println("s");
                BubleSort.sort(archivos);
                break;
            case "insertionSort":
                InsertionSort.sort(archivos);
                break;

            case "mezclaDirecta":
                MezclaDirecta.sort(archivos);
                break;
            case "mergeSort":
                MergeSort.sort(archivos);
                break;
            case "shellSort":
                ShellSort.sort(archivos);
                break;
            case "quickSort":
                QuickSort.sort(archivos);
                break;

            default:
                throw new AssertionError();
        }
    }

}

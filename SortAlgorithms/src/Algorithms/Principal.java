/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.io.FileNotFoundException;

/**
 *
 * @author emman
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        Controlador ne = new Controlador();
        //ne.iniciarPrimeraVez();
        ne.serArrays();
        System.out.println("Bubble Sort");
        ne.obtenerResultadosBubleSort();
        //System.out.println("Insertion Sort");
        //ne.obtenerResultadosInsertionSort();
        //System.out.println("Merge Sort");
        //ne.obtenerResultadosMergeSort();
        //System.out.println("Quick Sort");
        //ne.obtenerResultadosQuickSort();
        //System.out.println("Shell Sort");
        //ne.obtenerResultadosShellSort();
    }

}

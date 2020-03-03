/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emman
 */
public class Controlador {

    private int[] a10;
    private int[] a100;
    private int[] a1000;
    private int[] a10000;
    private int[] a100000;

    public void iniciarPrimeraVez() {
        generarArrays();
    }

    public void obtenerResultadosMergeSort() {
        Algorithms.mergeSort(a10, a10.length);
        System.out.println("Comparaciones: " + Algorithms.compM + " " + "Intercambios: " + Algorithms.swapsM);
        Algorithms.mergeSort(a100, a100.length);
        System.out.println("Comparaciones: " + Algorithms.compM + " " + "Intercambios: " + Algorithms.swapsM);
        Algorithms.mergeSort(a1000, a1000.length);
        System.out.println("Comparaciones: " + Algorithms.compM + " " + "Intercambios: " + Algorithms.swapsM);
        Algorithms.mergeSort(a10000, a10000.length);
        System.out.println("Comparaciones: " + Algorithms.compM + " " + "Intercambios: " + Algorithms.swapsM);
        Algorithms.mergeSort(a100000, a10000.length);
        System.out.println("Comparaciones: " + Algorithms.compM + " " + "Intercambios: " + Algorithms.swapsM);

    }

    public void obtenerResultadosBubleSort() {
        Algorithms.bubbleSort(a10);
        Algorithms.bubbleSort(a100);
        Algorithms.bubbleSort(a1000);
        Algorithms.bubbleSort(a10000);
        Algorithms.bubbleSort(a100000);
    }

    public void obtenerResultadosInsertionSort() {
        Algorithms.insertionSort(a10);
        Algorithms.insertionSort(a100);
        Algorithms.insertionSort(a1000);
        Algorithms.insertionSort(a10000);
        Algorithms.insertionSort(a100000);
    }

    public void obtenerResultadosShellSort() {
        Algorithms.shellSort(a10);
        Algorithms.shellSort(a100);
        Algorithms.shellSort(a1000);
        Algorithms.shellSort(a10000);
        Algorithms.shellSort(a100000);

    }

    public void obtenerResultadosQuickSort() {
        Algorithms.quickSort(a10, 0, a10.length - 1);
        System.out.println("Comparaciones: " + Algorithms.compQ + " " + "Intercambios: " + Algorithms.swapsQ);
        Algorithms.compQ = 0;
        Algorithms.swapsQ = 0;
        Algorithms.quickSort(a100, 0, a100.length - 1);
        System.out.println("Comparaciones: " + Algorithms.compQ + " " + "Intercambios: " + Algorithms.swapsQ);
        Algorithms.compQ = 0;
        Algorithms.swapsQ = 0;
        Algorithms.quickSort(a1000, 0, a1000.length - 1);
        System.out.println("Comparaciones: " + Algorithms.compQ + " " + "Intercambios: " + Algorithms.swapsQ);
        Algorithms.compQ = 0;
        Algorithms.swapsQ = 0;
        Algorithms.quickSort(a10000, 0, a10000.length - 1);
        System.out.println("Comparaciones: " + Algorithms.compQ + " " + "Intercambios: " + Algorithms.swapsQ);
        Algorithms.compQ = 0;
        Algorithms.swapsQ = 0;
        Algorithms.quickSort(a100000, 0, a10000.length - 1);
        System.out.println("Comparaciones: " + Algorithms.compQ + " " + "Intercambios: " + Algorithms.swapsQ);
        Algorithms.compQ = 0;
        Algorithms.swapsQ = 0;
    }

    public void serArrays() throws FileNotFoundException {
        this.a10 = ManejadorArchivos.recuperarDatos(10);
        this.a100 = ManejadorArchivos.recuperarDatos(100);
        this.a1000 = ManejadorArchivos.recuperarDatos(1000);
        this.a10000 = ManejadorArchivos.recuperarDatos(10000);
        this.a100000 = ManejadorArchivos.recuperarDatos(100000);
    }

    private void generarArrays() {
        int a10[] = GeneradorArrays.generar10();
        int a100[] = GeneradorArrays.generar100();
        int a1000[] = GeneradorArrays.generar1000();
        int a10000[] = GeneradorArrays.generar10000();
        int a100000[] = GeneradorArrays.generar100000();
        guardarDatos(a10, a100, a1000, a10000, a100000);

    }

    private void guardarDatos(int a10[], int a100[], int a1000[], int a10000[], int[] a100000) {
        try {
            ManejadorArchivos.guardarDatos(a10);
            ManejadorArchivos.guardarDatos(a100);
            ManejadorArchivos.guardarDatos(a1000);
            ManejadorArchivos.guardarDatos(a10000);
            ManejadorArchivos.guardarDatos(a100000);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

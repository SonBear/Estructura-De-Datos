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
public class GeneradorArrays {

    public static int[] generar10() {
        int[] a = generarNumerosAleatorio(10);

        return a;
    }

    public static int[] generar100() {
        int[] a = generarNumerosAleatorio(100);

        return a;
    }

    public static int[] generar1000() {
        int[] a = generarNumerosAleatorio(1000);

        return a;
    }

    public static int[] generar10000() {
        int[] a = generarNumerosAleatorio(10000);

        return a;
    }

    public static int[] generar100000() {
        int[] a = new int[100000];
        for (int i = 0; i < a.length; i++) {
            a[i] = generarNumeroAleatorio(100000);
        }
        return a;
    }

    public static int generarNumeroAleatorio(int tamanio) {
        return (int) Math.floor(Math.random() * (0 - tamanio) + tamanio + 1);
    }

    public static int[] generarNumerosAleatorio(int tamanio) {
        boolean repetido;
        int numeros[] = new int[tamanio];
        for (int i = 0; i < tamanio; i++) {
            repetido = false;
            int valorEntero = (int) Math.floor(Math.random() * (0 - tamanio) + tamanio + 1);
            for (int j = 0; j < numeros.length && repetido == false; j++) {
                if (numeros[j] == valorEntero) {
                    repetido = true;
                }
            }
            if (!repetido) {
                numeros[i] = valorEntero;
            } else {
                i--;
            }

        }
        return numeros;
    }

}

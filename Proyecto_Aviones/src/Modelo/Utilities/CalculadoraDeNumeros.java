/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Utilities;

/**
 *
 * @author emman
 */
public class CalculadoraDeNumeros {

    public static int[] generarNumerosAleatorio(int numeroDeVuelos, int limite) {
        boolean repetido;
        int idAviones[] = new int[numeroDeVuelos];
        for (int i = 0; i < numeroDeVuelos; i++) {
            repetido = false;
            int valorEntero = (int) Math.floor(Math.random() * (0 - limite) + limite + 1);
            for (int j = 0; j < idAviones.length && repetido == false; j++) {
                if (idAviones[j] == valorEntero) {
                    repetido = true;
                }
            }
            if (!repetido) {
                idAviones[i] = valorEntero;
            } else {
                i--;
            }

        }
        return idAviones;
    }
}

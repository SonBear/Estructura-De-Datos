/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author emman
 */
public class EscritorAyuda {

    public static void escribir(JTextArea txt) throws FileNotFoundException {
        File file = new File("Proyecto_Aviones/Extras/instrucciones.txt");

        Scanner leer = new Scanner(file);

        String resultado = "";
        while (leer.hasNext()) {
            resultado += leer.nextLine() + "\n";
        }

        txt.setText(resultado);
        leer.close();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author emman
 */
public class EscritorAyuda {

    public void escribir(JTextArea txt) {

        try {

            File file;
            file = new File("instrucciones.txt");

            Scanner leer = new Scanner(file);

            String resultado = "";
            while (leer.hasNext()) {
                resultado += leer.nextLine() + "\n";
            }

            txt.setText(resultado);

            leer.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

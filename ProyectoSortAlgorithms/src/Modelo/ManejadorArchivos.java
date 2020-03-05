/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author emman
 */
public class ManejadorArchivos {

    public static void guardarDatos(File a[]) throws IOException {
        File file = new File("archivos\\" + "ME" + a.length + ".dat");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter flWriter = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(flWriter);

        for (int i = 0; i < a.length; i++) {
            bw.write(a[i].getAbsolutePath() + "\n");
        }
        bw.close();

    }

    public static File[] recuperarDatos(int tamanio) throws FileNotFoundException {
        File a[] = new File[tamanio];
        File file = new File("archivos\\" + "ME" + tamanio + ".dat");
        Scanner scan = new Scanner(file);
        for (int i = 0; scan.hasNext(); i++) {
            a[i] = new File(scan.nextLine());
        }

        return a;
    }
}

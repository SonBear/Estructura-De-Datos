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

    public static void guardarDatos(File a[], File file) throws IOException {
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

    public static void recuperarDatos(File f, File[] archivos) throws FileNotFoundException {
        Scanner scan = new Scanner(f);
        for (int i = 0; scan.hasNext(); i++) {
            archivos[i] = new File(scan.nextLine());
        }

    }
}

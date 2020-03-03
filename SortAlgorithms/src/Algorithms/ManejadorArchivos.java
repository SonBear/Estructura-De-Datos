/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

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

    public static void guardarDatos(int a[]) throws IOException {
        File file = new File(a.length + ".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter flWriter = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(flWriter);

        for (int i = 0; i < a.length; i++) {
            bw.write(a[i] + "\n");
        }
        bw.close();

    }

    public static int[] recuperarDatos(int tamanio) throws FileNotFoundException {
        int a[] = new int[tamanio];
        File file = new File(tamanio + ".txt");
        Scanner scan = new Scanner(file);
        for (int i = 0; scan.hasNext(); i++) {
            a[i] = scan.nextInt();
        }

        return a;
    }
}

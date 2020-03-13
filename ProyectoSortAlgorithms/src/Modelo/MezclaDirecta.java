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
public class MezclaDirecta {

    public static void MEZCLADIRECTA(File f, int n) throws IOException {
        File f1 = new File("archivos\\f1.dat");
        File f2 = new File("archivos\\f2.dat");
        for (int i = 1; i < n; i *= 2) {
            PARTICIONA(f, f1, f2, i);
            FUSIONA(f, f1, f2, i);
        }
    }

    private static void PARTICIONA(File f, File f1, File f2, int n) throws FileNotFoundException, IOException {

        Scanner leerAr = new Scanner(f);
        FileWriter flWriter1 = new FileWriter(f1);
        BufferedWriter bw1 = new BufferedWriter(flWriter1);
        FileWriter flWriter2 = new FileWriter(f2);
        BufferedWriter bw2 = new BufferedWriter(flWriter2);
        int k;
        String dato;
        while (leerAr.hasNext()) {

            for (k = 0; k < n && leerAr.hasNext(); k++) {

                dato = leerAr.nextLine();
                bw1.write(dato + "\n");
            }

            for (int l = 0; l < n && leerAr.hasNext(); l++) {
                dato = leerAr.nextLine();
                bw2.write(dato + "\n");

            }
        }

        bw2.close();
        bw1.close();
        leerAr.close();

    }

    private static void FUSIONA(File f, File f1, File f2, int n) throws IOException {
        FileWriter flWriter1 = new FileWriter(f);
        BufferedWriter pF = new BufferedWriter(flWriter1);
        Scanner lF1 = new Scanner(f1);
        Scanner lF2 = new Scanner(f2);
        int k, j;
        boolean b1 = true, b2 = true;
        String clave1 = "", clave2 = "";
        if (lF1.hasNext()) {
            clave1 = lF1.nextLine();
            b1 = false;
        }
        if (lF2.hasNext()) {
            clave2 = lF2.nextLine();
            b2 = false;
        }

        while ((lF1.hasNext() || b1 == false) && (lF2.hasNext() || b2 == false)) {
            k = 0;
            j = 0;
            while (((k < n) && (b1 == false)) && ((j < n) && (b2 == false))) {
                if (name(clave1).compareTo(name(clave2)) < 0) {//
                    pF.write(clave1 + "\n");
                    b1 = true;
                    k++;
                    if (lF1.hasNext()) {
                        clave1 = lF1.nextLine();
                        b1 = false;
                    }
                } else {
                    pF.write(clave2 + "\n");
                    b2 = true;
                    j++;
                    if (lF2.hasNext()) {
                        clave2 = lF2.nextLine();
                        b2 = false;
                    }
                }
            }

            if (k < n) {
                while (k < n && b1 == false) {
                    pF.write(clave1 + "\n");
                    b1 = true;
                    k++;
                    if (lF1.hasNext()) {
                        clave1 = lF1.nextLine();
                        b1 = false;
                    }
                }

            }

            if (j < n) {
                while (j < n && b2 == false) {
                    pF.write(clave2 + "\n");
                    b2 = true;
                    j++;
                    if (lF2.hasNext()) {
                        clave2 = lF2.nextLine();
                        b2 = false;
                    }
                }

            }
        }
        if (b1 == false) {
            pF.write(clave1 + "\n");

        }

        if (b2 == false) {
            pF.write(clave2 + "\n");
        }

        while (lF1.hasNext()) {
            clave1 = lF1.nextLine();
            pF.write(clave1 + "\n");

        }

        while (lF2.hasNext()) {
            clave2 = lF2.nextLine();
            pF.write(clave2 + "\n");

        }
        pF.close();
        lF1.close();
        lF2.close();

    }

    public static void sort(File listaArchivos, int logLista) {
        try {
            MEZCLADIRECTA(listaArchivos, logLista);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static String name(String path) {
        String name = new File(path).getName().toLowerCase();
        return name;
    }
}

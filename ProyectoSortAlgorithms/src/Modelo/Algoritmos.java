package Modelo;

import java.io.File;
import java.io.IOException;
import javax.swing.ButtonModel;

/**
 * Clase que nos permite ejecutar cualquiera de los algoritmos planteados para este programa
 *
 * @author emman
 *
 */
public class Algoritmos {

    public static void sort(File[] archivos, ButtonModel check) throws IOException {
        switch (check.getActionCommand()) {
            case "bubbleSort":
                BubleSort.sort(archivos);
                break;
            case "insertionSort":
                InsertionSort.sort(archivos);
                break;

            case "mezclaDirecta":
                File f = new File("archivos\\f.dat");
                if (!f.exists()) {
                    f.createNewFile();
                }
                ManejadorArchivos.guardarDatos(archivos, f);
                MezclaDirecta.sort(f, archivos.length);
                ManejadorArchivos.recuperarDatos(f, archivos);
                break;
            case "mergeSort":
                MergeSort.sort(archivos);
                break;
            case "shellSort":
                ShellSort.sort(archivos);
                break;
            case "quickSort":
                QuickSort.sort(archivos);
                break;

            default:
                System.out.println("F");
                ;
        }
    }

}

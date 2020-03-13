package Modelo;

import Excepciones.DirectoryNoSelectedException;
import Excepciones.FileNoFoundException;
import Excepciones.NoFileNameWriteException;
import java.io.File;
import java.util.ArrayList;

/**
 * Clase que se encarga de ejecutar el algoritmo de busqueda binaria.
 *
 * @author emman
 */
public class BinarySearch {

    private static int binarySearch(ArrayList<File> a, int fromIndex, int toIndex,
            String key, ArrayList<File> founds) {
        int cont = 0;
        int low = fromIndex;
        int high = toIndex;
        while (low <= high) {
            int mid = (low + high) >>> 1; //Divide entre dos :v

            File midVal = a.get(mid);

            String name = name(midVal, key);

            if (name.compareTo(key.toLowerCase()) < 0) {
                low = mid + 1;
            } else if (name.compareTo(key.toLowerCase()) > 0) {
                high = mid - 1;
            } else {
                cont++;
                founds.add(midVal);
                a.remove(midVal);// se elimina el archivo encontrado
                if (a.isEmpty()) { //Por si solo existe un archivo;
                    return cont;
                } else {
                    low = 0; //Se reinician para volver a buscar
                    high = a.size() - 1;
                }

                //return mid; // key found
            }
        }
        return cont;  // key not found.
    }

    private static String name(File archivo, String key) {
        String nameFile = archivo.getName().toLowerCase();
        String name = nameFile;
        int end = name.length();
        if (!archivo.isDirectory()) {

            end = nameFile.lastIndexOf(".");
            if (end <= 0 || key.length() >= name.length()) {
                end = name.length();
            }

        }
        name = name.substring(0, end);
        return name;

    }

    private static ArrayList<File> toArrayList(File[] asd) {
        ArrayList<File> d = new ArrayList<>();
        for (int i = 0; i < asd.length; i++) {
            d.add(asd[i]);
        }
        return d;
    }

    public static File[] search(File[] archivos, String fileName) throws FileNoFoundException, NoFileNameWriteException, DirectoryNoSelectedException {

        ArrayList<File> founds = new ArrayList<>();
        //------Al
        if (archivos == null) {
            throw new DirectoryNoSelectedException("Directorio no seleccionado");
        }

        if (fileName.equals("") || fileName == null) {
            throw new NoFileNameWriteException("Nombre en blanco");
        }

        int cont = binarySearch(toArrayList(archivos), 0, archivos.length - 1, fileName, founds);

        if (cont == 0) {
            throw new FileNoFoundException("Archivo no encontrado");
        }

        File[] encontrados = new File[founds.size()];
        encontrados = founds.toArray(encontrados);

        return encontrados;
    }
}

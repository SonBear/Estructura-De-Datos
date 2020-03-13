package Modelo;

import java.io.File;
import java.util.ArrayList;

/**
 * Clase encargada de en listar los archivos de un directorio
 *
 * @author emman
 */
public class BuscadorArchivos {

    /**
     * En lista los archivos de un directorio
     *
     * @param path ruta del directorio
     * @return array de objetos tipo File
     */
    public File[] enlistarArchivos(String path) {
        File file = new File(path);

        File[] archivos = file.listFiles();

        return archivos;
    }

    /**
     * En lista los archivos de un directorio incluyendo subcarpetas
     *
     * @param path ruta del directorio
     * @return array de objetos tipo File
     */
    public File[] obtenerListaTodosArchivos(String path) {
        ArrayList<File> listArchivos = new ArrayList<>();
        File[] f = new File[listArchivos.size()];
        enlistarTodosLosArchivos(path, listArchivos);
        f = listArchivos.toArray(f);
        return f;
    }

    /**
     * En lista los archivos de un directorio incluyendo subcarpetas usando recursividad.
     *
     * @param path ruta del directorio.
     * @param array ArrayList que guarda todos los archivos de un directorio.
     */
    private void enlistarTodosLosArchivos(String path, ArrayList<File> array) {
        File[] files = new File(path).listFiles();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                array.add(files[i]);
                if (files[i].isDirectory()) {
                    enlistarTodosLosArchivos(files[i].getAbsolutePath(), array);
                }
            }
        }

    }

}

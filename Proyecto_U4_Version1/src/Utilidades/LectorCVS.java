package Utilidades;

import Close.Egresado;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que funciona como un lector de archivos CVS
 *
 * @author emman
 */
public class LectorCVS implements Lector<Egresado> {

    private File cvs;
    private Scanner scanner;

    public LectorCVS(String path) throws FileNotFoundException, IOException {
        if (!path.equals("")) {

            cvs = new File(path);
            scanner = new Scanner(cvs);
        } else {
            throw new FileNotFoundException("Archivo no encontrado");
        }

    }

    @Override
    public Egresado[] obtenerDatos() {
        ArrayList<Egresado> alumnos = new ArrayList<>();
        while (scanner.hasNext()) {
            String[] datos = scanner.nextLine().split(",");

            alumnos.add(new Egresado(datos[0], datos[1], Double.parseDouble(datos[2])));
        }
        return alumnos.toArray(new Egresado[alumnos.size()]);
    }

    @Override
    public void insertarDato(Egresado elemento) {

    }

    @Override
    public void eliminar(Egresado elemento) {
    }

}

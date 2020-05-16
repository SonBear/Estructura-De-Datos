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
public class LectorCSV implements Lector<Egresado> {

    private File csv;
    private Scanner scanner;

    public LectorCSV(String path) throws FileNotFoundException, IOException {
        if (!path.equals("")) {

            csv = new File(path);
            scanner = new Scanner(csv);
        } else {
            throw new FileNotFoundException("Archivo no encontrado");
        }

    }

    @Override
    public Egresado[] obtenerDatos() {
        ArrayList<Egresado> egresados = new ArrayList<>();
        //La primera linea sirve para representar las columnas
        System.out.println(scanner.nextLine());
        while (scanner.hasNext()) {
            String[] datos = scanner.nextLine().split(",");

            egresados.add(new Egresado(datos[0], datos[1].toUpperCase(), Double.parseDouble(datos[2])));
        }
        return egresados.toArray(new Egresado[egresados.size()]);
    }

    @Override
    public void insertarDato(Egresado elemento) {

    }

    @Override
    public void eliminar(Egresado elemento) {
    }

}

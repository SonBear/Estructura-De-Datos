/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Close.Egresado;
import Estructuras.ArbolAVL;
import Estructuras.ArbolIB;
import Utilidades.Lector;
import Utilidades.LectorCVS;
import java.io.IOException;

/**
 *
 * @author emman
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Lector<Egresado> L = new LectorCVS("archivos/alumnos.cvs");
        Egresado[] eg = L.obtenerDatos();
        ArbolIB<String> ar = new ArbolAVL<>();
        for (int i = 0; i < eg.length; i++) {
            ar.insertar(i, eg[i].getProfesion());
        }
        ar.recorrerArbol();

        ArbolIB<Double> a = new ArbolAVL<>();
        for (int i = 0; i < eg.length; i++) {
            a.insertar(i, eg[i].getPromedio());
        }
        a.recorrerArbol();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Close.Egresado;
import Estructuras.ArbolB;
import Estructuras.ArbolIB;
import Utilidades.Lector;
import Utilidades.LectorCVS;
import java.io.IOException;

/**
 *
 * @author emman
 */
public class prueba2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Lector<Egresado> L = new LectorCVS("archivos/alumnos.cvs");
        Egresado[] eg = L.obtenerDatos();
        ArbolIB<String> a = new ArbolB();

        ArbolB<String> d = new ArbolB<>();
        for (int i = 0; i < eg.length; i++) {
            a.insertar(i, eg[i].getProfesion());
        }
        System.out.println(a);
        a.recorrerArbol();

    }

}

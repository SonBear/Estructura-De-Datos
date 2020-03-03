/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emman
 */
public class EscritorTablas {

    public static void escribirTablas(JTable tabla, File[] datos) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Ruta");
        model.addColumn("Fecha");
        for (int i = 0; i < datos.length; i++) {
            model.addRow(new String[]{datos[i].getName(), datos[i].getPath(), datos[i].lastModified() + " "});
        }
        tabla.setModel(model);
    }

}

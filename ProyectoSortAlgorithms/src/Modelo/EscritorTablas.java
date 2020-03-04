/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.text.SimpleDateFormat;
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
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String date = sdf.format(datos[i].lastModified());
            model.addRow(new String[]{datos[i].getName(), datos[i].getPath(), date});
        }

        tabla.setModel(model);

    }

}

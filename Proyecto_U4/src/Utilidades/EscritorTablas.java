/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Close.Egresado;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emman
 */
public class EscritorTablas {

    public static void escribirTablas(JTable tabla, Egresado[] datos) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Profesion");
        model.addColumn("Promedio");
        for (int i = 0; i < datos.length; i++) {
            model.addRow(new String[]{datos[i].getNombre(), datos[i].getProfesion(), datos[i].getPromedio() + ""});
        }

        tabla.setModel(model);

        tabla.setCellEditor(new DefaultCellEditor(new JTextField()) {

            @Override
            public boolean stopCellEditing() {
                return false;
            }

        });
        tabla.setAutoscrolls(true);
    }

}

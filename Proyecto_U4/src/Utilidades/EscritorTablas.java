/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import Close.Egresado;
import java.util.ArrayList;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emman
 */
public class EscritorTablas {

    public static void escribirTablas(JTable tabla, ArrayList<Egresado> datos) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Profesion");
        model.addColumn("Promedio");
        for (int i = 0; i < datos.size(); i++) {
            model.addRow(new String[]{datos.get(i).getNombre(), datos.get(i).getProfesion(), datos.get(i).getPromedio() + ""});
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

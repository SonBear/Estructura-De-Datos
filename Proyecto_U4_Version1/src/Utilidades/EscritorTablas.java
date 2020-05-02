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

    /**
     * Funcion escritora de tablas
     *
     * @param tabla JTable donde los datos serán escritos
     * @param datos ArrayList de los egresados que van a ser escritos en la tabla
     */
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

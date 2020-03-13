package Modelo;

import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Clase encargada de escribir una lista de parametros de los objetos tipo File en tablas.
 *
 * @author emman
 *
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

        tabla.setCellEditor(new DefaultCellEditor(new JTextField()) {

            @Override
            public boolean stopCellEditing() {
                return false;
            }

        });
        tabla.setAutoscrolls(true);
    }

}

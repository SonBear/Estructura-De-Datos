package com.controladores;

import com.modelo.Contacto;
import com.vista.MenuListados;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author emman
 */
public class ControllerListado {

    private MenuListados menu = new MenuListados();

    public ControllerListado() {

        initComponents();
    }

    public void iniciar(List<Contacto> contactos, String identificador, String nombre, String correo) {
        setLabels(identificador, nombre, correo);
        llenarTabla(contactos);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    private void setLabels(String identificador, String nombre, String correo) {
        menu.getLabelContactos().setText("Contactos: " + identificador);
        menu.getLabelCorreo().setText(correo);
        menu.getLabelNombre().setText(nombre);
    }

    private void initComponents() {
        menu.getBtnRegresar().addActionListener(this::regresar);
    }

    private void regresar(ActionEvent e) {
        menu.dispose();
    }

    private void llenarTabla(List<Contacto> contactos) {
        JTable tabla = menu.getTableContactos();
        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("Nombre");
        model.addColumn("Correo");
        try {

            for (int i = 0; i < contactos.size(); i++) {
                Contacto cont = contactos.get(i);
                model.addRow(new String[]{cont.getNombre(), cont.getCorreo()});
            }
            tabla.setModel(model);

        } catch (Exception ex) {
            menu.error(ex.getMessage());

        }
    }

}

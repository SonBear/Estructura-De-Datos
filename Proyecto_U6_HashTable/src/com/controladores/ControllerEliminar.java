package com.controladores;

import com.modelo.Administrador;
import com.modelo.Contacto;
import com.vista.MenuEliminar;
import java.awt.event.ActionEvent;

/**
 *
 * @author emman
 */
public class ControllerEliminar {

    private MenuEliminar menu = new MenuEliminar();
    private Administrador admi;
    private Contacto contactoActual;

    public ControllerEliminar(Administrador admi) {
        this.admi = admi;
        initComponents();
    }

    public void iniciar() {
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    private void initComponents() {
        menu.getBtnAceptar().addActionListener(this::aceptar);
        menu.getBtnCancelar1().addActionListener(this::cancelarBusqueda);
        menu.getBtnCancelar2().addActionListener(this::cancelarEncontrado);
        menu.getBtnEliminar().addActionListener(this::eliminar);
    }

    private void aceptar(ActionEvent e) {
        try {
            String correo = menu.getTxtCorreo().getText();
            contactoActual = admi.buscar(correo);
            menu.getLabelCorreo().setText("Correo: " + contactoActual.getCorreo());
            menu.getLabelEdad().setText("Edad: " + contactoActual.getEdad());
            menu.getLabelNombre().setText("Nombre: " + contactoActual.getNombre());

        } catch (NullPointerException ex) {
            menu.error("Contacto no encontrado");
        } catch (Exception ex) {
            ex.getStackTrace();
            menu.error(ex.getMessage());
        }

    }

    private void cancelarBusqueda(ActionEvent e) {
        menu.getTxtCorreo().setText("");
    }

    private void cancelarEncontrado(ActionEvent e) {
        contactoActual = null;
        menu.getLabelCorreo().setText("Correo: ");
        menu.getLabelEdad().setText("Edad: ");
        menu.getLabelNombre().setText("Nombre: ");
    }

    private void eliminar(ActionEvent e) {
        try {
            admi.eliminarContactoAUsuario(contactoActual);

        } catch (NullPointerException ex) {
            menu.error("Contacto no encontrado");
        } catch (Exception ex) {
            menu.error(ex.getMessage());
        }

    }

}

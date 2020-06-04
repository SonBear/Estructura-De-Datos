/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import com.modelo.Administrador;
import com.modelo.Contacto;
import com.vista.MenuBusqueda;
import java.awt.event.ActionEvent;
import java.util.List;

/**
 *
 * @author emman
 */
public class ControllerBusqueda {

    private MenuBusqueda menu = new MenuBusqueda();
    private Administrador admi;
    private Contacto contactoActual;

    public ControllerBusqueda(Administrador admi) {
        this.admi = admi;
        initComponents();
    }

    public void iniciar() {
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    private void initComponents() {
        menu.getBtnAceptar().addActionListener(this::aceptar);
        menu.getBtnAgregar().addActionListener(this::agregar);
        menu.getBtnAgregarContac().addActionListener(this::agregarContactosDe);
        menu.getBtnCancelar1().addActionListener(this::cancelarBusqueda);
        menu.getBtnCancelar2().addActionListener(this::cancelarEncontrado);
    }

    private void aceptar(ActionEvent e) {

        try {
            String correo = menu.getTxtCorreo().getText();
            contactoActual = admi.buscar(correo);
            menu.getLabelCorreo().setText("Correo: " + contactoActual.getCorreo());
            menu.getLabelEdad().setText("Edad: " + contactoActual.getEdad());
            menu.getLabelNombre().setText("Nombre: " + contactoActual.getNombre());

        } catch (Exception ex) {
            menu.error(ex.getMessage());
        }

    }

    private void agregar(ActionEvent e) {
        try {
            admi.agregarContactoUsuario(contactoActual);
        } catch (Exception ex) {
            menu.error(ex.getMessage());
        }
    }

    private void agregarContactosDe(ActionEvent e) {
        try {
            List<Contacto> contactos = admi.listarContactoDe(contactoActual);
            admi.agregarContactosUsuario(contactos);
        } catch (Exception ex) {
            menu.error(ex.getMessage());
        }

    }

    private void cancelarBusqueda(ActionEvent e) {
        contactoActual = null;
        menu.getTxtCorreo().setText("");

    }

    private void cancelarEncontrado(ActionEvent e) {
        contactoActual = null;
        menu.getLabelCorreo().setText("Correo: ");
        menu.getLabelEdad().setText("Edad: ");
        menu.getLabelNombre().setText("Nombre: ");

    }
}

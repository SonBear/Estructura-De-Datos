/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import com.modelo.Administrador;
import com.modelo.Contacto;
import com.modelo.UsuarioNoLoginException;
import com.vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author emman
 */
public class ControllerMenuPrincipal {

    private MenuPrincipal menu = new MenuPrincipal();
    private ControllerBusqueda contBusqueda;
    private ControllerEliminar contEliminar;
    private ControllerLogin contLogin;
    private ControllerListado contListado = new ControllerListado();
    private Administrador admi;

    public ControllerMenuPrincipal(Administrador admi) {
        this.admi = admi;
        contBusqueda = new ControllerBusqueda(admi);
        contEliminar = new ControllerEliminar(admi);

        initComponents();
    }

    public void iniciar() {
        menu.getLabelCorreo().setText("Correo: " + admi.getUsuario().getCorreo());
        menu.getLabelUsuario().setText("Usuario: " + admi.getUsuario().getNombre());
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    private void initComponents() {
        menu.getItemListarContactos().addActionListener(this::listarMisContactos);
        menu.getItemListarTodos().addActionListener(this::listarTodos);
        menu.getItemBorrarCuenta().addActionListener(this::borrarCuenta);
        menu.getItemBuscar().addActionListener(this::buscar);
        menu.getItemEliminarCon().addActionListener(this::eliminarCont);
        menu.getItemLogOut().addActionListener(this::logOut);
    }

    private void logOut(ActionEvent e) {
        if (JOptionPane.showConfirmDialog(menu, "¿Desea cerrar la sesión actual?") == 0) {
            try {
                admi.logOut();
                menu.dispose();
                contLogin = new ControllerLogin();
                contLogin.iniciar();

            } catch (UsuarioNoLoginException ex) {
                menu.error(ex.getMessage());
            }
        }
    }

    private void eliminarCont(ActionEvent e) {
        contEliminar.iniciar();
    }

    private void buscar(ActionEvent e) {
        contBusqueda.iniciar();
    }

    private void borrarCuenta(ActionEvent e) {
        if (JOptionPane.showConfirmDialog(menu, "¿Desea eliminar su cuenta?") == 0) {
            admi.eliminarCuentaActual();
            menu.dispose();
            contLogin = new ControllerLogin();
            contLogin.iniciar();

        }
    }

    private void listarMisContactos(ActionEvent e) {
        try {
            Contacto usuario = admi.getUsuario();
            List<Contacto> contactos = admi.enlistarContactos();
            contListado.iniciar(contactos, "Mis contactos", usuario.getNombre(), usuario.getCorreo());
        } catch (Exception ex) {
            menu.error(ex.getMessage());
        }
    }

    private void listarTodos(ActionEvent e) {
        try {
            Contacto usuario = admi.getUsuario();
            List<Contacto> contactos = admi.listarTodos();

            contListado.iniciar(contactos, "Todos los usuarios", usuario.getNombre(), usuario.getCorreo());
        } catch (Exception ex) {
            menu.error(ex.getMessage());
        }
    }

}

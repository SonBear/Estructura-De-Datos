/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import com.modelo.Administrador;
import com.vista.Login;
import java.awt.event.ActionEvent;

/**
 *
 * @author emman
 */
public class ControllerLogin {

    private Login menu = new Login();
    private ControllerNuevo contNuevo;
    private ControllerMenuPrincipal contPrincipal;
    private Administrador admi = new Administrador();

    public ControllerLogin() {
        contPrincipal = new ControllerMenuPrincipal(admi);
        initComponents();
    }

    public void iniciar() {
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    private void initComponents() {
        menu.getBtnEntrar().addActionListener(this::entrar);
        menu.getBtnNuevo().addActionListener(this::nuevo);
        contNuevo = new ControllerNuevo(admi);

    }

    public void entrar(ActionEvent e) {
        String correo = menu.getTxtCorreo().getText();
        String contraseña = menu.getTxtContraseña().getText();
        try {
            admi.login(correo, contraseña);
            menu.dispose();
            contPrincipal.iniciar();
        } catch (Exception ex) {
            menu.error(ex.getMessage());

        }

    }

    public void iniciarNuevo() {
        contNuevo.iniciar();
    }

    public void nuevo(ActionEvent e) {
        iniciarNuevo();

    }

}

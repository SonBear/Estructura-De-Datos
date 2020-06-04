/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import com.modelo.Administrador;
import com.vista.MenuNuevo;
import java.awt.event.ActionEvent;

/**
 *
 * @author emman
 */
public class ControllerNuevo {

    private MenuNuevo menu = new MenuNuevo();
    private ControllerRuta contRuta;
    private Administrador admi;

    public ControllerNuevo(Administrador admi) {
        this.admi = admi;
        contRuta = new ControllerRuta(admi);
        initComponents();
    }

    public void iniciar() {
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    public void initComponents() {
        menu.getBtnCrear().addActionListener(this::crear);
    }

    public void crear(ActionEvent e) {
        String nombre = menu.getTxtNombre().getText();
        String correo = menu.getTxtCorreo().getText();
        int edad = Integer.parseInt(menu.getTxtEdad().getText());
        String contraseña = menu.getTxtContr().getText();
        contRuta.setValores(correo, nombre, correo, contraseña, edad);
        contRuta.inciar();
        menu.dispose();

    }

}

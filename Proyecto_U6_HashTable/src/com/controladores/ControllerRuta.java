/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controladores;

import com.modelo.Administrador;
import com.vista.MenuRuta;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author emman
 */
public class ControllerRuta {

    private MenuRuta menu = new MenuRuta();
    private Administrador admi;
    private JFileChooser chooser = new JFileChooser();

    public ControllerRuta(Administrador admi) {
        this.admi = admi;
        initComponents();

    }

    public void inciar() {
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    private void initComponents() {
        menu.getBtnAceptar().addActionListener(this::aceptar);
        menu.getBtnBuscar().addActionListener(this::buscar);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    }

    private String ruta, nombre, correo, contraseña;
    private int edad;

    public String getRuta() {
        return ruta;
    }

    public void setValores(String ruta, String nombre, String correo, String contraseña, int edad) {
        this.contraseña = contraseña;
        this.correo = correo;
        this.edad = edad;
        this.nombre = nombre;
    }

    public void aceptar(ActionEvent e) {
        if (rutaEncontrada) {
            ruta = menu.getTxtRuta().getText();
            try {
                admi.crearUsuario(nombre, edad, correo, contraseña, ruta);
            } catch (Exception ex) {
                menu.error(ex.getMessage());
            }
            menu.dispose();
        } else {
            menu.error("Selecciona la ruta con el boton buscar");
        }

    }

    private boolean rutaEncontrada = false;

    public void buscar(ActionEvent e) {
        try {
            chooser.showOpenDialog(menu);
            File file = chooser.getSelectedFile();
            menu.getTxtRuta().setText(file.getAbsolutePath());
            rutaEncontrada = true;
        } catch (NullPointerException ex) {
            menu.error("Directorio no seleccionado");
        }
    }

}

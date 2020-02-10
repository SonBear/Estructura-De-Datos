/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.EscritorAyuda;
import Vista.MenuAyuda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emman
 */
public class ControladorMenuAyuda implements ActionListener {

    MenuAyuda menu = new MenuAyuda();

    public ControladorMenuAyuda() {
        initComponets();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);

    }

    public void initComponets() {
        menu.getBtnSalir().addActionListener(this);
        try {
            EscritorAyuda.escribir(menu.getTextHelp());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControladorMenuAyuda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        menu.dispose();
    }

}

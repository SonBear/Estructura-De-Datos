/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Utilities.EscritorAyuda;
import Vista.MenuAyuda;
import java.awt.Font;
import static java.awt.Font.HANGING_BASELINE;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author emman
 */
public class ControladorMenuAyuda implements ActionListener {

    MenuAyuda menu;
    EscritorAyuda escritor;

    public ControladorMenuAyuda() {
        this.menu = new MenuAyuda();
        escritor = new EscritorAyuda();
        initComponets();

    }

    public void initComponets() {
        menu.getBtnSalir().addActionListener(this);
        menu.getTextHelp().setFont(new Font("D", HANGING_BASELINE, 12));
        menu.getTextHelp().setEditable(false);
        escritor.escribir(menu.getTextHelp());
    }

    public void iniciar(JFrame frame) {
        menu.setLocationRelativeTo(frame);
        menu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menu.dispose();
    }

}

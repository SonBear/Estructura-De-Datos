/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ControlAlumnos.ControlAlumnos;
import Utilidades.EscritorTablas;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author emman
 */
public class Controlador implements ActionListener {

    private MenuPrincipal menu;
    private ControlAlumnos alumnos;

    public Controlador() {
        menu = new MenuPrincipal();
        alumnos = new ControlAlumnos();
        //Por el momento
        alumnos.generarArboles();
        iniciarComponentes();
    }

    public void iniciar() {
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }

    private void iniciarComponentes() {
        menu.getBtnBuscar().addActionListener(this);
        menu.getTxtRuta().addActionListener(this);
        menu.getTxtRuta().setActionCommand("buscar2");
        menu.getBtnIniciar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "iniciar":

                EscritorTablas.escribirTablas(menu.getTablaPrincipal(), alumnos.listarPorNombre());
                break;
            case "buscar":
                break;
            case "buscar2":
                String ruta = menu.getTxtRuta().getText();
                alumnos.actualizarDatos(ruta);
                alumnos.generarArboles();
                System.out.println("F");
                break;
            default:
                throw new AssertionError();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Close.Egresado;
import ControlAlumnos.ControlAlumnos;
import Estructuras.Exceptions.ItemNotFoundException;
import Utilidades.EscritorTablas;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

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

        iniciarComponentes();
    }

    public void iniciar() {
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }

    private void iniciarComponentes() {
        menu.getListar().addActionListener(this);
        menu.getBtnBuscar().addActionListener(this);
        menu.getTxtRuta().addActionListener(this);
        menu.getTxtRuta().setActionCommand("buscar2");
        menu.getBtnIniciar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            switch (e.getActionCommand()) {
                case "iniciar":
                    String nombre = menu.getTxtNombre().getText();
                    String profesion = menu.getTxtProfesion().getText();
                    String promedioS = menu.getTxtPromedio().getText();
                    if (!promedioS.equals("")) {
                        Double promedio = Double.parseDouble(menu.getTxtPromedio().getText());
                        EscritorTablas.escribirTablas(menu.getTablaPrincipal(), buscar(nombre, profesion, promedio));
                    } else {
                        EscritorTablas.escribirTablas(menu.getTablaPrincipal(), buscar(nombre, profesion, 0.0));
                    }

                    break;
                case "buscar":
                    String ruta = obtenerRuta();
                    alumnos.actualizarDatos(ruta);
                    menu.getTxtRuta().setText(ruta);
                    EscritorTablas.escribirTablas(menu.getTablaPrincipal(), alumnos.listarPorNombre());
                    break;
                case "buscar2":

                    alumnos.actualizarDatos(menu.getTxtRuta().getText());
                    EscritorTablas.escribirTablas(menu.getTablaPrincipal(), alumnos.listarPorNombre());
                    break;
                case "listar":
                    EscritorTablas.escribirTablas(menu.getTablaPrincipal(), alumnos.listarPorNombre());
                    break;
                default:
                    throw new AssertionError();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * encargada de obtener la ruta de un directorio a travez de un objeto File Chooser.
     *
     * @param type indica el tipo de FileChooser DIRECTORIES_ONLY, FILES_ONLY, etc.
     * @return ruta del directorio
     * @throws DirectoryNoSelectedException
     */
    private String obtenerRuta() throws DirectoryNoSelectedException {
        JFileChooser ch = new JFileChooser();
        ch.setFileSelectionMode(0);
        ch.showOpenDialog(menu);
        File dsa = ch.getSelectedFile();
        if (dsa == null) {
            throw new DirectoryNoSelectedException("Directorio no seleccionado");
        }
        ch.setSelectedFile(null);
        return dsa.getAbsolutePath();
    }

    private ArrayList<Egresado> buscar(String nombre, String profesion, Double promedio) throws ItemNotFoundException {
        JCheckBox checkNombre = menu.getCheckNombre();
        JCheckBox checkPromedio = menu.getCheckPromedio();
        JCheckBox checkProfesion = menu.getCheckProfesion();
        if ((checkNombre.isSelected() && checkPromedio.isSelected()) && checkProfesion.isSelected()) {
            return alumnos.buscarPorNombreProfesionPromedio(nombre, profesion, promedio);
        } else if (checkNombre.isSelected() && checkPromedio.isSelected()) {
            return alumnos.buscarPorNombreYPromedio(nombre, promedio);
        } else if (checkNombre.isSelected() && checkProfesion.isSelected()) {
            return alumnos.buscarPorNombreYProfesion(nombre, profesion);
        } else if (checkPromedio.isSelected() && checkProfesion.isSelected()) {
            return alumnos.buscarPorPromedioYProfesion(promedio, profesion);
        } else if (checkNombre.isSelected()) {
            return alumnos.buscarPorNombre(nombre);
        } else if (checkProfesion.isSelected()) {
            return alumnos.buscarPorProfesion(profesion);
        } else if (checkPromedio.isSelected()) {
            return alumnos.buscarPorPromedio(promedio);
        } else {
            throw new ItemNotFoundException("ErroR");
        }

    }

}

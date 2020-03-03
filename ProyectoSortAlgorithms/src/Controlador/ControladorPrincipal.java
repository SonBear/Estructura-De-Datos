/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.DirectoryNoSelectedException;
import Excepciones.NoCheckSelectedException;
import Modelo.Algoritmos;
import Modelo.BuscadorArchivos;
import Modelo.EscritorTablas;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author emman
 */
public class ControladorPrincipal implements ActionListener {

    MenuPrincipal menuPrincipal = new MenuPrincipal();
    BuscadorArchivos buscadorArchivos = new BuscadorArchivos();

    public ControladorPrincipal() {
        initComponents();
    }

    public void iniciar() {

        menuPrincipal.setVisible(true);
    }

    public void initComponents() {

        menuPrincipal.getBtnBuscarArchivo().addActionListener(this);
        menuPrincipal.getBtnBuscarDirectorio().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            File[] archivos;
            switch (e.getActionCommand()) {
                case "buscarArchivo":
                    String nombreArchivo = menuPrincipal.getTxtBuscarArchivo().getText();

                    break;

                case "seleccionarRuta":
                    String path2 = obtenerRuta(JFileChooser.DIRECTORIES_ONLY);
                    menuPrincipal.getTxtBuscarDirectorio().setText(path2);
                    archivos = obtenerArchivos(menuPrincipal.getCheckDirectorios().isSelected(), path2);
                    Algoritmos.sort(archivos, checkSeleccionado());
                    EscritorTablas.escribirTablas(menuPrincipal.getTbArchivosOrdenados(), archivos);

                    break;
                default:
                    throw new AssertionError();
            }

        } catch (DirectoryNoSelectedException ex) {
            errorMessage(ex.getMessage());
        } catch (NoCheckSelectedException ex) {
            errorMessage(ex.getMessage());
        }
    }

    public File[] obtenerArchivos(boolean check, String path) {
        if (check) {
            return buscadorArchivos.obtenerListaTodosArchivos(path);
        } else {
            return buscadorArchivos.enlistarArchivos(path);
        }
    }

    public String obtenerRuta(int type) throws DirectoryNoSelectedException {

        menuPrincipal.getFileChooser().setFileSelectionMode(type);
        menuPrincipal.getFileChooser().showOpenDialog(menuPrincipal);
        File dsa = menuPrincipal.getFileChooser().getSelectedFile();
        if (dsa == null) {
            throw new DirectoryNoSelectedException("Directory no selected");
        }

        return dsa.getAbsolutePath();
    }

    public void errorMessage(String mensaje) {
        JOptionPane.showMessageDialog(menuPrincipal, mensaje);
    }

    public ButtonModel checkSeleccionado() throws NoCheckSelectedException {
        ButtonGroup f = menuPrincipal.getButtonGroup();

        if (f.getSelection() == null) {
            throw new NoCheckSelectedException("No se selecciono nungun algoritmo");
        }

        return f.getSelection();
    }

}

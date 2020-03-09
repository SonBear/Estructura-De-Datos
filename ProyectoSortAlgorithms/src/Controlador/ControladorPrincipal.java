/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Excepciones.DirectoryNoSelectedException;
import Excepciones.FileNoFoundException;
import Excepciones.NoCheckSelectedException;
import Excepciones.NoFileNameWriteException;
import Modelo.Algoritmos;
import Modelo.BinarySearch;
import Modelo.BuscadorArchivos;
import Modelo.EscritorTablas;
import Vista.MenuPrincipal;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author emman
 */
public class ControladorPrincipal implements ActionListener {

    private File[] archivos;

    MenuPrincipal menuPrincipal = new MenuPrincipal();
    BuscadorArchivos buscadorArchivos = new BuscadorArchivos();

    public ControladorPrincipal() {
        initComponents();
    }

    public void iniciar() {
        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setTitle("Archivos");
        menuPrincipal.setVisible(true);

    }

    public void initComponents() {

        menuPrincipal.getTxtBuscarArchivo().addActionListener(this);
        menuPrincipal.getTxtBuscarDirectorio().addActionListener(this);
        menuPrincipal.getTxtBuscarArchivo().setActionCommand("txtBuscarArchivos");
        menuPrincipal.getTxtBuscarDirectorio().setActionCommand("txtBuscarDirectorio");
        menuPrincipal.getBtnBuscarArchivo().addActionListener(this);
        menuPrincipal.getBtnBuscarDirectorio().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cursorWait();
        try {
            switch (e.getActionCommand()) {
                case "txtBuscarArchivos":
                case "buscarArchivo":
                    String nombreArchivo = menuPrincipal.getTxtBuscarArchivo().getText();
                    File[] a = BinarySearch.search(archivos, nombreArchivo);
                    EscritorTablas.escribirTablas(menuPrincipal.getTbArchivosEncontrados(), a);
                    break;

                case "txtBuscarDirectorio":

                    String path = obtenerRuta();
                    archivos = obtenerArchivos(menuPrincipal.getCheckDirectorios().isSelected(), path);
                    Algoritmos.sort(archivos, checkSeleccionado());
                    EscritorTablas.escribirTablas(menuPrincipal.getTbArchivosOrdenados(), archivos);
                    break;
                case "seleccionarRuta":
                    String path2 = obtenerRuta(JFileChooser.DIRECTORIES_ONLY);
                    menuPrincipal.getTxtBuscarDirectorio().setText(path2);
                    archivos = obtenerArchivos(menuPrincipal.getCheckDirectorios().isSelected(), path2);
                    Algoritmos.sort(archivos, checkSeleccionado());
                    EscritorTablas.escribirTablas(menuPrincipal.getTbArchivosOrdenados(), archivos);
                    break;
                default:

            }
            cursorNormal();

        } catch (DirectoryNoSelectedException | NoFileNameWriteException ex) {
            errorMessage(ex.getMessage());
            cursorNormal();

        } catch (NoCheckSelectedException ex) {
            limpiartxtDirectorio();
            errorMessage(ex.getMessage());
            cursorNormal();

        } catch (FileNoFoundException ex) {
            limpiartxtArchivoCampos();
            errorMessage(ex.getMessage());
            cursorNormal();
        } catch (IOException ex) {
            errorMessage("Archivo no encontrado");
            cursorNormal();
        }
    }

    public int buscarArchivo(File archivoBuscar, File[] archivos) {
        return Arrays.binarySearch(archivos, archivoBuscar);
    }

    public void limpiartxtDirectorio() {
        menuPrincipal.getTxtBuscarDirectorio().setText("");
    }

    public void limpiartxtArchivoCampos() {
        menuPrincipal.getTxtBuscarArchivo().setText("");
    }

    public File[] obtenerArchivos(boolean check, String path) {
        if (check) {
            return buscadorArchivos.obtenerListaTodosArchivos(path);
        } else {
            return buscadorArchivos.enlistarArchivos(path);
        }
    }

    public String obtenerRuta() throws DirectoryNoSelectedException {
        String ruta = menuPrincipal.getTxtBuscarDirectorio().getText();
        File file = new File(ruta);
        if (!file.isDirectory()) {
            throw new DirectoryNoSelectedException("Ruta no encontrada");
        }

        return ruta;
    }

    public void errorMessage(String mensaje) {
        JOptionPane.showMessageDialog(menuPrincipal, mensaje, "Error", 0);
    }

    public ButtonModel checkSeleccionado() throws NoCheckSelectedException {
        ButtonGroup f = menuPrincipal.getButtonGroup();

        if (f.getSelection() == null) {
            throw new NoCheckSelectedException("No se selecciono nungun algoritmo");
        }

        return f.getSelection();
    }

    private String obtenerRuta(int type) throws DirectoryNoSelectedException {
        menuPrincipal.getFileChooser().setFileSelectionMode(type);
        menuPrincipal.getFileChooser().showOpenDialog(menuPrincipal);
        File dsa = menuPrincipal.getFileChooser().getSelectedFile();
        if (dsa == null) {
            throw new DirectoryNoSelectedException("Directorio no seleccionado");
        }
        menuPrincipal.getFileChooser().setSelectedFile(null);
        return dsa.getAbsolutePath();
    }

    private void cursorWait() {
        menuPrincipal.getTxtBuscarArchivo().setCursor(new Cursor(Cursor.WAIT_CURSOR));
        menuPrincipal.getTxtBuscarDirectorio().setCursor(new Cursor(Cursor.WAIT_CURSOR));
        menuPrincipal.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }

    private void cursorNormal() {
        menuPrincipal.getTxtBuscarArchivo().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        menuPrincipal.getTxtBuscarDirectorio().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        menuPrincipal.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

}

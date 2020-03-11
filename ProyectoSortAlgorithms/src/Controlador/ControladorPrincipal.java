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
    boolean buscando = false;

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
        if (!buscando) {
            try {
                switch (e.getActionCommand()) {
                    case "txtBuscarArchivos":
                    case "buscarArchivo":
                        String nombreArchivo = menuPrincipal.getTxtBuscarArchivo().getText();
                        new BuscarNombreArchivo(nombreArchivo).start();

                        break;

                    case "txtBuscarDirectorio":

                        String path = obtenerRuta();
                        new BuscarArchivos(path).start();
                        break;
                    case "seleccionarRuta":
                        String path2 = obtenerRuta(JFileChooser.DIRECTORIES_ONLY);
                        menuPrincipal.getTxtBuscarDirectorio().setText(path2);
                        new BuscarArchivos(path2).start();
                        break;
                    default:

                }

            } catch (DirectoryNoSelectedException ex) {
                cursorNormal();
                errorMessage(ex.getMessage());

            }
        } else {
            advertencia("Se sigue buscando archivos por favor espere....");
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

    public void advertencia(String mensaje) {
        JOptionPane.showMessageDialog(menuPrincipal, mensaje, "Espera", 2);
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

    private class BuscarArchivos extends Thread {

        private String path2;

        public BuscarArchivos(String path2) {
            this.setDaemon(true);
            this.path2 = path2;
        }

        @Override
        public void run() {
            try {
                buscando = true;
                cursorWait();
                archivos = obtenerArchivos(menuPrincipal.getCheckDirectorios().isSelected(), path2);
                Algoritmos.sort(archivos, checkSeleccionado());
                EscritorTablas.escribirTablas(menuPrincipal.getTbArchivosOrdenados(), archivos);
                cursorNormal();
                buscando = false;

            } catch (NoCheckSelectedException ex) {
                cursorNormal();
                buscando = false;
                errorMessage(ex.getMessage());

            } catch (IOException ex) {
                cursorWait();
                buscando = false;
                errorMessage("Archivo no encontrado");
            }
        }

    }

    private class BuscarNombreArchivo extends Thread {

        private String nombreArchivo;

        public BuscarNombreArchivo(String nombreArchivo) {
            this.nombreArchivo = nombreArchivo;
            this.setDaemon(true);
        }

        @Override
        public void run() {
            try {
                buscando = true;
                cursorWait();
                File[] a = BinarySearch.search(archivos, nombreArchivo);

                EscritorTablas.escribirTablas(menuPrincipal.getTbArchivosEncontrados(), a);
                cursorNormal();
                buscando = false;

            } catch (FileNoFoundException ex) {
                cursorNormal();
                buscando = false;
                errorMessage("Archivo no encontrado");

            } catch (NoFileNameWriteException | DirectoryNoSelectedException ex) {
                cursorNormal();
                buscando = false;
                errorMessage(ex.getMessage());

            }
        }

    }

}

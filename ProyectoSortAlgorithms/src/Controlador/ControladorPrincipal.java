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
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Controlador principal del programa
 *
 * es la clase controlador en ella se ejecutan operaciones relacionadas con la interacción del usuario con el menu.
 *
 * @author emman
 *
 */
public class ControladorPrincipal implements ActionListener {

    private File[] archivos;
    boolean buscando = false;

    MenuPrincipal menuPrincipal = new MenuPrincipal();
    BuscadorArchivos buscadorArchivos = new BuscadorArchivos();

    public ControladorPrincipal() {
        initComponents();
    }

    /**
     * Permite iniciar la ejecucion del programa, haciendo visible el menu principal.
     *
     */
    public void iniciar() {
        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setTitle("Archivos");
        menuPrincipal.setVisible(true);

    }

    /**
     * Inicializa los action listenner de los objetos del menu principal y otros aspectos como actions commands.
     *
     */
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

    /**
     * Obtiene un array de archivos dependiendo la ruta
     *
     * @param check nos dice de que manera se enlistaran los archivos, incluyendo subcarpetas o no
     * @param path es la ruta del directorio
     * @return array de objetos tipo File
     */
    public File[] obtenerArchivos(boolean check, String path) {
        if (check) {
            return buscadorArchivos.obtenerListaTodosArchivos(path);
        } else {
            return buscadorArchivos.enlistarArchivos(path);
        }
    }

    /**
     * Obtiene la ruta que esta escrita en el text field
     *
     * @return ruta del directorio
     * @throws DirectoryNoSelectedException
     *
     */
    public String obtenerRuta() throws DirectoryNoSelectedException {
        String ruta = menuPrincipal.getTxtBuscarDirectorio().getText();
        File file = new File(ruta);
        if (!file.isDirectory()) {
            throw new DirectoryNoSelectedException("Ruta no encontrada");
        }

        return ruta;
    }

    /**
     * Muestra una advertencia en pantalla
     *
     * @param mensaje es el mensaje que se mostrara en la ventana de advertencia.
     */
    public void advertencia(String mensaje) {
        JOptionPane.showMessageDialog(menuPrincipal, mensaje, "Espera", 2);
    }

    /**
     * Muestra un mensaje de error en pantalla
     *
     * @param mensaje es el mensaje que se mostrara en la ventana de error.
     *
     */
    public void errorMessage(String mensaje) {
        JOptionPane.showMessageDialog(menuPrincipal, mensaje, "Error", 0);
    }

    /**
     * Nos dice que algoritmo fue seleccionado del ButtonGroup
     *
     * @return el check correspondiente al algortimo.
     * @throws NoCheckSelectedException
     */
    public ButtonModel checkSeleccionado() throws NoCheckSelectedException {
        ButtonGroup f = menuPrincipal.getButtonGroup();

        if (f.getSelection() == null) {
            throw new NoCheckSelectedException("No se selecciono nungun algoritmo");
        }

        return f.getSelection();
    }

    /**
     * Clase encargada de obtener la ruta de un directorio a travez de un objeto File Chooser.
     *
     * @param type indica el tipo de FileChooser DIRECTORIES_ONLY, FILES_ONLY, etc.
     * @return ruta del directorio
     * @throws DirectoryNoSelectedException
     */
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

    /**
     * Pone el cursor en estado de espera
     */
    private void cursorWait() {
        menuPrincipal.getTxtBuscarArchivo().setCursor(new Cursor(Cursor.WAIT_CURSOR));
        menuPrincipal.getTxtBuscarDirectorio().setCursor(new Cursor(Cursor.WAIT_CURSOR));
        menuPrincipal.setCursor(new Cursor(Cursor.WAIT_CURSOR));
    }

    /**
     * Pone el cursor en su estado normal
     */
    private void cursorNormal() {
        menuPrincipal.getTxtBuscarArchivo().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        menuPrincipal.getTxtBuscarDirectorio().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        menuPrincipal.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    /**
     * Hilo que nos permite enlistar los archivos ordenados en la tabla.
     *
     * @param BuscarArchivos nos permite en listar los archivos dependeiendo si se incluyen subcarpetas o no, a su vez los ordena y los escribe en la tabla correspondiente.
     *
     *
     */
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

    /**
     * Hilo que nos permite buscar archivos
     *
     * @param BuscarNombreArchivo se encarga de buscar la coicidencias en nombres del text field dentro de los archivos usando la busqueda binaria.
     *
     */
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

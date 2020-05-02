package Controlador;

import Close.Egresado;
import ControlAlumnos.ControlEgresados;
import Controlador.Exception.ArbolNoSeleccionadoException;
import Controlador.Exception.DirectoryNoSelectedException;
import Estructuras.Exceptions.ItemNotFoundException;
import Estructuras.Exceptions.NoDatosException;
import Utilidades.EscritorTablas;
import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author emman
 */
public class Controlador implements ActionListener {

    private MenuPrincipal menu;
    private ControlEgresados alumnos;

    public Controlador() {
        menu = new MenuPrincipal();
        alumnos = new ControlEgresados();

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
        menu.getBuscarParametro().addActionListener(this);
        menu.getBtnGenerar().addActionListener(this);
        menu.getBtnOk().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ruta = menu.getTxtRuta().getText();

        try {

            switch (e.getActionCommand()) {
                case "ok":
                    EscritorTablas.escribirTablas(menu.getTablaPrincipal(), alumnos.listar(alumnos.getArbolNombres()));
                    obtenerProfesiones();
                    break;
                case "generarArbol":
                    ruta = menu.getTxtRuta().getText();
                    alumnos.actualizarDatos(ruta, actionArbol());
                    obtenerProfesiones();

                    break;
                case "buscarParametros":
                    String nombre = menu.getTxtNombre().getText();
                    String profesion = getProfesion();
                    String promedioS = menu.getTxtPromedio().getText();
                    if (!promedioS.equals("")) {
                        Double promedio = Double.parseDouble(menu.getTxtPromedio().getText());
                        EscritorTablas.escribirTablas(menu.getTablaPrincipal(), buscar(nombre, profesion, promedio));
                    } else {
                        EscritorTablas.escribirTablas(menu.getTablaPrincipal(), buscar(nombre, profesion, 0.0));
                    }

                    break;
                case "buscar":
                    ruta = obtenerRuta();
                    menu.getTxtRuta().setText(ruta);

                    break;
                case "buscar2":
                    ruta = menu.getTxtRuta().getText();
                    break;
                case "listar":
                    EscritorTablas.escribirTablas(menu.getTablaPrincipal(), alumnos.listar(alumnos.getArbolNombres()));
                    if (alumnos.getLector() == null) {
                        throw new NoDatosException("Ruta invalida/Sin datos");
                    }
                    break;
                default:
                    throw new AssertionError();
            }

        } catch (NumberFormatException ex) {
            mensajeAlerta("Error el campo promedio solo van numeros");
        } catch (Exception ex) {
            mensajeAlerta(ex.getMessage());
            ex.printStackTrace();

            System.out.println(ex.getMessage());
        }
    }

    /**
     * Encuentra el radio button seleccionado, correspondiente a los arboles
     *
     * @return actionCommand de los respectivos, checks del grupo de arboles
     * @throws ArbolNoSeleccionadoException
     */
    private String actionArbol() throws ArbolNoSeleccionadoException {
        ButtonGroup f = menu.getGrupoArboles();

        if (f.getSelection() == null) {
            throw new ArbolNoSeleccionadoException("No se selecciono nungun algoritmo");
        }

        String actionCommand = f.getSelection().getActionCommand();

        return actionCommand;
    }

    /**
     * Añade las profesiones al menu desplegable de la parte de busqueda
     *
     * @throws NoDatosException
     */
    private void obtenerProfesiones() throws NoDatosException {
        ArrayList<String> profesiones = alumnos.listaProfesiones();
        JComboBox profe = menu.getBoxProfesion();
        profe.removeAllItems();
        for (int i = 0; i < profesiones.size(); i++) {

            profe.addItem(profesiones.get(i));
        }
    }

    /**
     * Encuentra la profesion seleccionada del menu desplegable de la parte de busqueda
     *
     * @return
     */
    private String getProfesion() {
        JComboBox profe = menu.getBoxProfesion();
        System.out.println(profe.getSelectedItem());
        return profe.getSelectedItem() + "";
    }

    /**
     * encargada de obtener la ruta de un directorio a travez de un objeto File Chooser.
     *
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

    /**
     *
     * @param nombre es el nombre a encontrar de los egresados
     * @param profesion es la profesion del egresado a encontrar
     * @param promedio es el promedio a encontrar de los egresados
     * @return regresa el listado de coicidencias, dependiendo de los JCheckBox del menu
     * @throws ItemNotFoundException
     */
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
            throw new ItemNotFoundException("Ningún dato seleccionado");
        }

    }

    /**
     * Funcion que presenta una advertencia en pantalla
     *
     * @param mensaje texto a mostrar en la ventana de advertencia
     */
    private void mensajeAlerta(String mensaje) {
        JOptionPane.showMessageDialog(menu, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
    }

}

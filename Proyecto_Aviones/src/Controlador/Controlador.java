package Controlador;

import Modelo.Avion;
import Modelo.QueueEmptyException;
import Modelo.SistemaDeVuelos;
import Vista.DibujadorEsquema;
import Vista.MenuPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowStateListener;
import javax.swing.JOptionPane;

/**
 *
 * @author emman
 */
public class Controlador implements ActionListener, WindowStateListener, WindowFocusListener {

    private MenuPrincipal menuPrincipal;
    private SistemaDeVuelos sistemaDeVuelos;
    private DibujadorEsquema dibujadorEsquema;

    public Controlador(MenuPrincipal menuPrincipal, SistemaDeVuelos sistamaDeVuelos) {
        this.menuPrincipal = menuPrincipal;
        dibujadorEsquema = new DibujadorEsquema(menuPrincipal.getPanelVuelos());
        this.sistemaDeVuelos = sistamaDeVuelos;
        initMisComponentes();
    }

    public void iniciar() {
        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setVisible(true);

    }

    private void initMisComponentes() {
        menuPrincipal.addWindowStateListener(this);
        menuPrincipal.getGenerarVuelos().addActionListener(this);
        menuPrincipal.getAgregarAviones().addActionListener(this);
        menuPrincipal.getQuitarAviones().addActionListener(this);
        menuPrincipal.getPrioridadAviones().addActionListener(this);
        menuPrincipal.getItemAyuda().addActionListener(this);
        menuPrincipal.getItemSalir().addActionListener(this);
        menuPrincipal.getPanelVuelos().setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            switch (e.getActionCommand()) {
                case "generarVuelos":
                    try {
                        int noVuelos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de vuelos"));
                        sistemaDeVuelos.generarVuelos(noVuelos);
                        menuPrincipal.getGenerarVuelos().setVisible(false);

                    } catch (NumberFormatException ex) {

                    }
                    break;

                case "quitar":

                    sistemaDeVuelos.eliminarAvion();

                    break;

                case "prioridad":
                    try {
                        int numVuelo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de vuelo a eliminar"));
                        sistemaDeVuelos.priorizarAvion(new Avion(numVuelo));
                        JOptionPane.showMessageDialog(menuPrincipal, "El avion con numero " + numVuelo + " esta por salir");

                    } catch (NumberFormatException ex) {

                    }
                    break;

                case "salirE":
                    menuPrincipal.dispose();

                    break;
                case "darAyuda":
                    new ControladorMenuAyuda();
                    break;
                default:
                    break;
            }
            if (sistemaDeVuelos.getColaAviones().size() > 0) {
                dibujadorEsquema.dibujar(sistemaDeVuelos.getCopiaAviones());
            } else {
                menuPrincipal.getPanelVuelos().repaint();

            }

        } catch (QueueEmptyException ex) {

        }
    }

    @Override
    public void windowStateChanged(WindowEvent e
    ) {
        if (e.getNewState() == e.getID()) {
            System.out.println("2");
        }
        System.out.println("ldsahfkjasfh");
    }

    @Override
    public void windowGainedFocus(WindowEvent e
    ) {
        System.out.println("sada");
    }

    @Override
    public void windowLostFocus(WindowEvent e
    ) {
        System.out.println("1111");
    }

}

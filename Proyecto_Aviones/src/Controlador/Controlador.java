package Controlador;

import Modelo.Avion;
import Modelo.QueueEmptyException;
import Modelo.SistemaDeVuelos;
import Vista.DibujadorEsquema;
import Vista.MenuPrincipal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author emman
 */
public class Controlador implements ActionListener {

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
        menuPrincipal.getGenerarVuelos().addActionListener(this);
        menuPrincipal.getAgregarAviones().addActionListener(this);
        menuPrincipal.getQuitarAviones().addActionListener(this);
        menuPrincipal.getPrioridadAviones().addActionListener(this);
        menuPrincipal.getItemAyuda().addActionListener(this);
        menuPrincipal.getItemSalir().addActionListener(this);
        menuPrincipal.getPanelVuelos().setBackground(new Color(220, 254, 220));
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
                        JOptionPane.showMessageDialog(menuPrincipal, "Ingrese numeros", "Error", 0);
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
                        JOptionPane.showMessageDialog(menuPrincipal, "Ingrese numeros", "Error", 0);
                    } catch (QueueEmptyException ex) {
                        JOptionPane.showMessageDialog(menuPrincipal, "El avion con numero ese numero no se encuantra", "Error", 0);
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
}

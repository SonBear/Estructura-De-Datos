package Controlador;

import Modelo.Avion;
import Modelo.Exceptions.AvionNotFoundException;
import Modelo.Exceptions.ValorEntradaVuelosException;
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
public class ControladorPrincipal implements ActionListener, Runnable {

    private MenuPrincipal menuPrincipal;
    private ControladorMenuAyuda menuAyuda;
    private SistemaDeVuelos sistemaDeVuelos;
    private DibujadorEsquema dibujadorEsquema;
    private Thread h;

    public ControladorPrincipal() {
        this.menuPrincipal = new MenuPrincipal();
        this.sistemaDeVuelos = new SistemaDeVuelos();
        dibujadorEsquema = new DibujadorEsquema(menuPrincipal, sistemaDeVuelos.getColaAviones());
        menuAyuda = new ControladorMenuAyuda();
        initMisComponentes();
    }

    public void iniciar() {

        menuPrincipal.setLocationRelativeTo(null);
        menuPrincipal.setVisible(true);
        h = new Thread(this);
        h.start();

    }

    private void initMisComponentes() {
        menuPrincipal.getGenerarVuelos().addActionListener(this);
        menuPrincipal.getAgregarAviones().addActionListener(this);
        menuPrincipal.getQuitarAviones().addActionListener(this);
        menuPrincipal.getPrioridadAviones().addActionListener(this);
        menuPrincipal.getItemAyuda().addActionListener(this);
        menuPrincipal.getItemSalir().addActionListener(this);
        menuPrincipal.getItemReiniciar().addActionListener(this);
        menuPrincipal.getjProgressBar1().setString("Dibujando aviones...");
        menuPrincipal.getjProgressBar1().setStringPainted(true);
        menuPrincipal.getPanelVuelos().setBackground(new Color(250, 250, 235));
        menuPrincipal.getjToolBar1().setFloatable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (h.isAlive()) {
                h.interrupt();
            }
            switch (e.getActionCommand()) {
                case "generarVuelos":
                    /*Poner intervalo de entrada aceptada 1-500*/
                    int noVuelos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de vuelos"));
                    sistemaDeVuelos.generarVuelos(noVuelos);
                    menuPrincipal.getGenerarVuelos().setVisible(false);

                    break;

                case "quitar":

                    sistemaDeVuelos.eliminarAvion();

                    break;

                case "prioridad":
                    int numVuelo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de vuelo a eliminar"));
                    sistemaDeVuelos.priorizarAvion(new Avion(numVuelo));
                    JOptionPane.showMessageDialog(menuPrincipal, "El avion con numero " + numVuelo + " esta por salir");

                    break;

                case "salirE":
                    menuPrincipal.dispose();
                    System.exit(0);
                    break;
                case "darAyuda":
                    menuAyuda.iniciar(menuPrincipal);
                    break;

                case "Reiniciar":
                    menuPrincipal.getPanelVuelos().repaint();
                    menuPrincipal.getGenerarVuelos().setVisible(true);
                    sistemaDeVuelos.elminarTodo();
                    break;
                default:
                    break;
            }

            h = new Thread(this);
            h.start();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(menuPrincipal, "Ingrese numeros", "Error", 0);
        } catch (AvionNotFoundException ex) {
            JOptionPane.showMessageDialog(menuPrincipal, ex.getMessage(), "Error", 0);
        } catch (ValorEntradaVuelosException ex) {
            JOptionPane.showMessageDialog(menuPrincipal, ex.getMessage(), "Error", 0);
        }

    }

    @Override
    public void run() {
        dibujadorEsquema.dibujar();
    }

}

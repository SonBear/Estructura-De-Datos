/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Exceptions.ArcoNoExisteException;
import Modelo.Exceptions.VerticeExisteException;
import Modelo.Exceptions.VerticeNoExisteException;
import Modelo.FactoryGrafo;
import Modelo.Grafo;
import Vista.DibujadorGrafo;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author emman
 */
public class Controlador implements ActionListener, Runnable {

    private DibujadorGrafo dibGrafo;
    private Grafo<String> grafo;
    private FactoryGrafo<String> factory = new FactoryGrafo<>();
    private Menu menu;
    private String tipoDeRecorrido = "";
    private Thread recorrido = new Thread(this);

    public Controlador() {
        menu = new Menu();
        iniciarComponente();
    }

    public void iniciar() {
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    public void dibujar() {

        JPanel panel = menu.getjPanel1();
        panel.removeAll();

        dibGrafo = new DibujadorGrafo(grafo, panel.getWidth(), panel.getHeight());

        panel.add(dibGrafo);
        panel.repaint(100);
    }

    private void generar(int maximoVertices, String command) {
        grafo = factory.generarGrafo(command, maximoVertices);
        mensajeInformacion("Grafo generado con un maximo de " + maximoVertices + " vertices con una " + command);
    }

    private void agregarEnlace(String verticeA, String verticeB) throws VerticeNoExisteException, VerticeExisteException {
        if (verticeA.equals(verticeB)) {
            throw new VerticeExisteException("El vertice es el mismo");
        }
        grafo.union(verticeA, verticeB);
    }

    private void agregarVertice(String nombre) throws VerticeExisteException {
        grafo.nuevoVertice(nombre);
        System.out.println(grafo.getNumeroVertices());
    }

    private String getCommand() {
        String command = "";
        command = menu.getButtonGroup().getSelection().getActionCommand();
        return command;
    }

    private void eliminarUnion() throws VerticeNoExisteException, ArcoNoExisteException {
        String nombre1 = menu.getTxtEliminarU1().getText();
        String nombre2 = menu.getTxtEliminarU2().getText();
        grafo.borrarArco(nombre1, nombre2);

    }

    private void eliminarVertice() throws VerticeNoExisteException {
        String nombre = menu.getTxtEliminarVertice().getText();
        System.out.println(nombre);
        grafo.borrarVertice(nombre);
    }

    private void buscarElementoAnchura() throws VerticeNoExisteException {
        String elemento = menu.getTxtBuscarAnchura().getText();
        boolean encontrado = grafo.buscarAmplitud(elemento);
        if (!encontrado) {
            throw new VerticeNoExisteException("Elemento no existe o es inalcanzable");
        } else {
            JOptionPane.showMessageDialog(menu, "El vertice con elemento: " + elemento + " está en el grafo");
        }

    }

    private void buscarElementoProfundidad() throws VerticeNoExisteException {
        String elemento = menu.getTxtBuscarProfundidad().getText();
        boolean encontrado = grafo.buscarProfundidad(elemento);
        if (!encontrado) {
            throw new VerticeNoExisteException("Elemento no existe o es inalcanzable");
        } else {
            JOptionPane.showMessageDialog(menu, "El vertice con elemento: " + elemento + " está en el grafo");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (recorrido.isAlive()) {
            recorrido.interrupt();
        }
        try {
            switch (e.getActionCommand()) {
                case "Generar":
                    int tamanio = Integer.parseInt(menu.getTxtGenerar().getText());
                    generar(tamanio, getCommand());
                    break;
                case "Agregar Vertice":
                    String nombre = menu.getTxtNombre().getText();

                    agregarVertice(nombre);
                    break;
                case "Agregar Enlace":
                    nombre = menu.getTxtNombre1().getText();
                    String nombre2 = menu.getTxtNombre2().getText();
                    agregarEnlace(nombre, nombre2);
                    break;

                case "Recorrido Anchura":
                    recorrido = new Thread(this);
                    tipoDeRecorrido = "Anchura";
                    recorrido.start();
                    grafo.recorrerAmplitud();

                    break;
                case "Recorrido Profundidad":
                    tipoDeRecorrido = "Profundidad";
                    recorrido = new Thread(this);
                    recorrido.start();
                    grafo.recorrerProfundidad();

                    break;
                case "Eliminar Enlace":
                    eliminarUnion();
                    break;
                case "Eliminar Vertice":
                    eliminarVertice();
                    break;
                case "Buscar Anchura":
                    buscarElementoAnchura();
                    break;
                case "Buscar Profundidad":
                    buscarElementoProfundidad();
                    break;
                default:
                    throw new AssertionError();
            }
            dibujar();
        } catch (NumberFormatException ex1) {
            mensajeError("Tamaño no valido");

        } catch (NullPointerException ex) {
            mensajeError("Grafo no generado");
        } catch (Exception ex) {
            dibujar();

            mensajeError(ex.getMessage());

        }
    }

    private void mensajeError(String txt) {
        JOptionPane.showMessageDialog(menu, txt, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void mensajeInformacion(String txt) {
        JOptionPane.showMessageDialog(menu, txt, "Grafo generado", JOptionPane.INFORMATION_MESSAGE);
    }

    private void iniciarComponente() {
        menu.getBtnAgragarEnlace().addActionListener(this);
        menu.getBtnAgregarVertice().addActionListener(this);
        menu.getBtnGenerar().addActionListener(this);
        menu.getBtnRecorridoAnchura().addActionListener(this);
        menu.getBtnProfundidad().addActionListener(this);
        menu.getBtnEliminarUnion().addActionListener(this);
        menu.getBtnEliminarVertice().addActionListener(this);
        menu.getBtnBuscarAnchura().addActionListener(this);
        menu.getBtnBuscarProfundidad().addActionListener(this);

    }

    @Override
    public void run() {
        try {
            switch (tipoDeRecorrido) {
                case "Anchura":
                    dibGrafo.recorridoAnchura();
                    break;
                case "Profundidad":
                    dibGrafo.recorrerProfundidad();
                    break;
                default:
                    System.out.println("Error");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

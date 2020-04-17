/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.ArbolBB;
import model.NodoABB;
import view.GraficoArbol;
import view.Menu;

/**
 *
 * @author emman
 */
public class GeneradorArbolBinario implements ActionListener {

    private Menu menu = new Menu();
    private ArbolBB<String> arbol = new ArbolBB<>();

    public GeneradorArbolBinario() {
        initComponenets();
    }

    public void iniciar() {
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    private void initComponenets() {
        menu.getBoton().addActionListener(this);
        menu.getText().addActionListener(this);
    }
    int cont = 0;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (!menu.getText().getText().equals(" ")) {
            String text = menu.getText().getText();
            if (cont == 0) {
                arbol.setRaiz(new NodoABB<>(text));
                cont++;
            } else {
                arbol.insertar(text);
            }
            updatePanel();
            arbol.inOrden();

        }
        //menu.setPanel(null);
    }

    private void updatePanel() {
        GraficoArbol panel = new GraficoArbol(arbol);

        menu.setPanel(panel);

    }
}

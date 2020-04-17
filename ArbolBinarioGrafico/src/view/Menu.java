/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author emman
 */
public class Menu extends JFrame {

    private final int WIDTHF = 600;
    private final int HEIGHTF = 600;
    private JPanel panelPrincipal = new JPanel();
    private GraficoArbol panel;
    private JButton boton;
    private JTextField text;

    public Menu() throws HeadlessException {
        super.setSize(new Dimension(WIDTHF, HEIGHTF));
        setButton();
        setText();
        setPanelPrincipal();
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void setPanel(GraficoArbol panel) {
        panelPrincipal.removeAll();
        panelPrincipal.updateUI();
        panelPrincipal.add(panel);
    }

    public GraficoArbol getPanel() {
        return panel;
    }

    private void setText() {
        text = new JTextField("asdasd ");
        text.setBounds(WIDTHF / 2, 70, 100, 20);
        text.setLayout(new BorderLayout(100, 0x14));

        super.add(text, BorderLayout.SOUTH);
    }

    private void setButton() {
        boton = new JButton("Iniciar");
        boton.setSize(10, 10);

        super.add(boton, BorderLayout.NORTH);
    }

    public JButton getBoton() {
        return boton;
    }

    public JTextField getText() {
        return text;
    }

    private void setPanelPrincipal() {
        panelPrincipal.setBackground(Color.WHITE);

        super.add(panelPrincipal, BorderLayout.CENTER);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

}

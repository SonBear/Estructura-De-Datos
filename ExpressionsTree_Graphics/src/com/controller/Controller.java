/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.exceptions.ExpresionNoValidException;
import com.tree.BinaryTreeExpression;
import com.view.PrincipalMenu;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EmptyStackException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author emman
 */
public class Controller implements ActionListener {

    private BinaryTreeExpression tree = new BinaryTreeExpression();
    private PrincipalMenu menu = new PrincipalMenu();
    private Graphics2D g = (Graphics2D) menu.getPanelTree().getGraphics();

    public Controller() {
        initComponents();
        run();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tree.setINICIALX(menu.getPanelTree().getWidth() / 2);
        menu.getPanelTree().paint(g);
        try {
            String expression = getExpression();

            tree.drawTree((Graphics2D) menu.getPanelTree().getGraphics(), expression);
        } catch (EmptyStackException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExpresionNoValidException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initComponents() {
        menu.getGenerateTree().addActionListener(this);
    }

    private String getExpression() {
        return menu.getTxtExpression().getText();
    }

    private void run() {
        menu.setVisible(true);
    }

}

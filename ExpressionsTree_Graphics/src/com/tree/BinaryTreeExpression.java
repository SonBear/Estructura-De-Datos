/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tree;

import com.exceptions.ExpresionNoValidException;
import com.utilities.Parser;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 *
 * @author emman
 */
public class BinaryTreeExpression {

    private Parser parser = new Parser();
    private final int RADIUS = 50;
    private int INICIALX = 190;
    private int INICIALY = 30;
    private final int SEPARACIONX = 10 + RADIUS;
    private final int SEPARACIONY = 20 + RADIUS;
    private final int DESDERECHO = SEPARACIONX * 2;

    /**
     * funcion que construye un arbol de expresiones
     *
     * @param expresion expresion a ser evaluada
     * @return la raíz principal del arbol contruido
     * @throws StackEmptyException pila vacía
     * @throws ExpresionNoValidException Si la expresion no es correcta
     */
    public Nodo constructTree(String expresion) throws EmptyStackException, ExpresionNoValidException {
        if (!parser.infixExpresion(expresion)) {
            throw new ExpresionNoValidException("Expresion incorrecta");
        }
        Stack<Nodo> st = new Stack();
        String postfix = parser.infixToPostfix(expresion);
        StringTokenizer tokens = new StringTokenizer(postfix);
        Nodo t, t1, t2;
        while (tokens.hasMoreTokens()) {
            String currentToken = tokens.nextToken();
            if (!isOperand(currentToken)) {
                t = new Nodo(currentToken);
                st.push(t);
            } else {
                t = new Nodo(currentToken);

                t1 = st.pop();
                t2 = st.pop();

                t.setRight(t1);
                t.setLeft(t2);

                st.push(t);
            }

        }
        t = st.pop();
        return t;
    }

    /**
     * Verifica si un valor es un operando
     *
     * @param dat dato a verificar
     * @return regresa el valor booleano que corresponde true si es un operando false de otro modo
     */
    private boolean isOperand(String dat) {
        return dat.equals("+") || dat.equals("-") || dat.equals("*") || dat.equals("/");

    }

    /**
     * Imprime en inorden el arbol generado a partir de una raíz El resultado es la manera inicial de la expresion pero sin parentesis
     *
     * @param t es la raiz principal del arbol
     */
    public void inOrder(Nodo t) {
        if (t != null) {
            inOrder(t.getLeft());
            System.out.print(t.getObj() + " ");
            inOrder(t.getRight());
        }
    }

    public void preOrder(Nodo t) {
        if (t != null) {
            System.out.print(t.getObj() + " ");
            inOrder(t.getLeft());
            inOrder(t.getRight());
        }
    }

    public void posOrder(Nodo t) {
        if (t != null) {
            posOrder(t.getLeft());
            posOrder(t.getRight());
            System.out.print(t.getObj() + " ");
        }
    }

    public void drawTree(Graphics2D g, String s) throws EmptyStackException, ExpresionNoValidException {

        Nodo<String> root = constructTree(s);
        preOrderDraw(root, g, INICIALX, INICIALY);
        g.dispose();
    }

    private void preOrderDraw(Nodo<String> t, Graphics2D g, int x, int y) {
        if (t != null) {
            System.out.print("(" + x + ", " + y + ")");
            System.out.print(t.getObj() + " ");
            if (!t.isSheet()) {

                g.drawLine(x, y, x - SEPARACIONX, y + SEPARACIONY);
                g.drawLine(x, y, x + SEPARACIONX, y + SEPARACIONY);
            }

            drawNode(g, x, y, t.getObj());

            preOrderDraw(t.getLeft(), g, x -= SEPARACIONX, y += SEPARACIONY);

            x += DESDERECHO + SEPARACIONX;
            y += SEPARACIONY;

            preOrderDraw(t.getRight(), g, x -= SEPARACIONX, y -= SEPARACIONY);
        }
    }

    private void drawNode(Graphics2D g, int x, int y, String name) {

        g.setColor(Color.CYAN);
        g.fillOval(x - RADIUS / 2, y - RADIUS / 2, RADIUS, RADIUS);
        g.setColor(Color.BLACK);

        g.drawString(name, x - 2, y + 2);

    }

    public void setINICIALX(int INICIALX) {
        this.INICIALX = INICIALX;
    }

    public void setINICIALY(int INICIALY) {
        this.INICIALY = INICIALY;
    }

}

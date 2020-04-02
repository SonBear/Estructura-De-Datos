/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tree;

import com.exceptions.ExpresionNoValidException;
import com.exceptions.StackEmptyException;
import com.utilities.Parser;
import com.utilities.Stack;
import com.utilities.StackDeque;
import java.util.StringTokenizer;

/**
 *
 * @author emman
 */
public class BinaryTreeExpression {

    private Parser parser = new Parser();

    /**
     * funcion que construye un arbol de expresiones
     *
     * @param expresion expresion a ser evaluada
     * @return la raíz principal del arbol contruido
     * @throws StackEmptyException pila vacía
     * @throws ExpresionNoValidException Si la expresion no es correcta
     */
    public Nodo constructTree(String expresion) throws StackEmptyException, ExpresionNoValidException {
        if (!parser.infixExpresion(expresion)) {
            throw new ExpresionNoValidException("Expresion incorrecta");
        }
        Stack<Nodo> st = new StackDeque();
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
            preOrder(t.getLeft());

            preOrder(t.getRight());
        }
    }

    public void posOrder(Nodo t) {
        if (t != null) {
            posOrder(t.getLeft());
            posOrder(t.getRight());
            System.out.print(t.getObj() + " ");
        }
    }
}

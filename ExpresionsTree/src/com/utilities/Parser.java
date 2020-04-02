/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utilities;

import com.exceptions.StackEmptyException;

/**
 *
 * @author emman
 */
public class Parser {

    /**
     *
     * @param expresion es la cadena que sera transmormada de forma postfija.
     * @return una expresion que es en postfija y facil de comvertirla en tokens ejem: A3* (B1+ C) = A B C +
     *
     * @throws StackEmptyException
     */
    public String infixToPostfix(String expresion) throws StackEmptyException {
        Stack<Character> stack = new StackDeque<>();
        String postfix = "";
        char[] tokens = expresion.toCharArray();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') {
                continue;
            }
            if (tokens[i] == '(') {
                stack.push(tokens[i]);
                continue;
            }
            if (tokens[i] == ')') {
                while (stack.top() != '(') {
                    postfix += stack.pop() + " ";
                }
                stack.pop();
                continue;
            }
            if (isOperand(tokens[i])) {
                if (stack.isEmpty()) {
                    stack.push(tokens[i]);

                } else {

                    if (precedence(stack.top(), tokens[i])) {
                        postfix += stack.pop() + " ";
                        stack.push(tokens[i]);
                    } else {
                        stack.push(tokens[i]);
                    }
                }
                /*Es un numero o variable*/
            } else {

                while (i < tokens.length && !(isOperand(tokens[i]) || isParenthesis(tokens[i]) || tokens[i] == ' ')) {
                    postfix += tokens[i++];
                }

                postfix += " ";
                i--;
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop() + " ";
        }

        return postfix.substring(0, postfix.length() - 1);
    }

    /**
     * Verifica si un valor es un operando
     *
     * @param dat dato a verificar
     * @return regresa el valor booleano que corresponde true si es un operando false de otro modo
     */
    private boolean isOperand(char dat) {
        return dat == '+' || dat == '-' || dat == '*' || dat == '/';

    }

    /**
     * Verifica si un valor es nu parentesis
     *
     * @param dat dato a verificar
     * @return el valor booleano correspondiente
     */
    private boolean isParenthesis(char dat) {
        return dat == '(' || dat == ')';
    }

    /**
     * Funcion que verifica la precedencia de operadores
     *
     * @param a es el dato anterior
     * @param b es el siguiente dato
     * @return el valor booleano true si la precedencia del dato anterior es mayor que el siguiende o si son iguales, false de otro modo
     */
    private boolean precedence(char a, char b) {
        if ((a == '*' || a == '/') && (b == '+' || b == '-')) {
            return true;
        } else if ((a == '+' || a == '-') && (b == '+' || b == '-')) {
            return true;
        } else if ((a == '*' || a == '/') && (b == '*' || b == '/')) {
            return true;
        }
        return false;

    }

    public boolean infixExpresion(String expresion) {

        if (expresion.endsWith("-") || expresion.endsWith("+") || expresion.endsWith("*") || expresion.endsWith("/")) {
            return false;
        }
        if (expresion.startsWith("+") || expresion.startsWith("-") || expresion.startsWith("*") || expresion.startsWith("/")) {
            return false;
        }
        if (!isOkOperators(expresion)) {
            return false;
        }

        return isOkParenthesis(expresion);
    }

    private boolean isOkOperators(String expresion) {
        String expresion2 = expresion.replaceAll("\\(", "").replaceAll("\\)", "").replaceAll(" ", "");
        Stack<Character> st = new StackDeque();
        char[] tokens = expresion2.toCharArray();
        for (int i = 0; i < tokens.length - 1; i++) {
            if (isOperand(tokens[i]) && isOperand(tokens[i + 1])) {
                return false;
            }
        }
        expresion = expresion.replaceAll("\\(", "").replaceAll("\\)", "");
        char[] tokens2 = expresion.toCharArray();
        for (int i = 0; i < tokens2.length; i++) {

        }

        return true;
    }

    private boolean isOkParenthesis(String expresion) {
        Stack<Character> st = new StackDeque();
        char[] tokens = expresion.toCharArray();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == '(') {
                st.push(tokens[i]);
            } else if (tokens[i] == ')') {
                try {
                    st.pop();
                } catch (StackEmptyException ex) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    // A utility method to apply an operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public int applyOp(char op, int b, int a) throws UnsupportedOperationException {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

}

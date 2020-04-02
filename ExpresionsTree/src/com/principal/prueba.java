/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.exceptions.ExpresionNoValidException;
import com.exceptions.StackEmptyException;
import com.tree.BinaryTreeExpression;
import com.tree.Nodo;

/**
 *
 * @author emman
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws StackEmptyException {
        try {
            BinaryTreeExpression pr = new BinaryTreeExpression();


            /*------Primer ejemplo-----------*/
            String input = "3 + ((5+9)*2)";
            System.out.println("---Ejemplo numero uno: " + input + "---");
            Nodo root1 = pr.constructTree(input);
            System.out.println("----PreOrden----");
            pr.preOrder(root1);
            System.out.println("\n" + "----InOrden----");
            pr.inOrder(root1);
            System.out.println("\n" + "----PosOrden----");
            pr.posOrder(root1);
            System.out.println("");
            /*-----------------------------*/
            System.out.println("");
            System.out.println("");
            /*------segundo ejemplo-----------*/
            /*String input2 = "3 + 4 - *";
             System.out.println("---Ejemplo numero dos: " + input2 + "---");
             Nodo root2 = pr.constructTree(input2);
             System.out.println("----PreOrden----");
             pr.preOrder(root2);
             System.out.println("\n" + "----InOrden----");
             pr.inOrder(root2);
             System.out.println("\n" + "----PosOrden----");
             pr.posOrder(root2);
             System.out.println("");*/
            /*-----------------------------*/
            System.out.println("");
            System.out.println("");
            /*------Tercer ejemplo-----------*/
            /* String input3 = "** -4";
             System.out.println("---Ejemplo numero tres: " + input3 + "---");
             Nodo root3 = pr.constructTree(input3);
             System.out.println("----PreOrden----");
             pr.preOrder(root3);
             System.out.println("\n" + "----InOrden----");
             pr.inOrder(root3);
             System.out.println("\n" + "----PosOrden----");
             pr.posOrder(root3);
             System.out.println("");*/
            /*-----------------------------*/
            System.out.println("");
            System.out.println("");
            /*------Cuarto ejemplo-----------*/
            String input4 = "19 - 0 / 5 *10";
            System.out.println("---Ejemplo numero cuatro: " + input4 + "---");
            Nodo root4 = pr.constructTree(input4);
            System.out.println("----PreOrden----");
            pr.preOrder(root4);
            System.out.println("\n" + "----InOrden----");
            pr.inOrder(root4);
            System.out.println("\n" + "----PosOrden----");
            pr.posOrder(root4);
            System.out.println("");
            /*-----------------------------*/
        } catch (ExpresionNoValidException ex) {
            System.out.println(ex);

        }

    }

}

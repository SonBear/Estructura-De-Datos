/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import Lista.DLDeque;
import Lista.Deque;

/**
 *
 * @author emman
 */
public class GrafoConListaAdyacencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Deque<String> d = new DLDeque<>();
        d.insertFirst("dsd");
        d.insertFirst("s");
        d.remove("s");
        System.out.println(d.find("ddff"));
        System.out.println(d);
    }

}

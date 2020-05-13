/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Modelo.Grafo;
import Modelo.GrafoConListaAD.GrafoLista;
import Modelo.GrafoConMatrizAD.GrafoMatriz;
import Vista.DibujadorGrafo;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author emman
 */
public class p {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Grafo<String> g = new GrafoLista(20);
        g.nuevoVertice("A");
        g.nuevoVertice("B");
        g.nuevoVertice("C");
        g.nuevoVertice("D");
        g.nuevoVertice("H");
        g.nuevoVertice("R");
        g.nuevoVertice("T");

        g.union("D", "B");
        g.union("D", "C");
        g.union("B", "H");
        g.union("C", "R");
        g.union("R", "H");
        g.union("H", "A");
        g.union("H", "T");
        g.union("H", "D");
        System.out.println(g.buscarAmplitud("B"));;

        System.out.println(g);

        Grafo<String> g2 = new GrafoMatriz<>(20);
        g2.nuevoVertice("A");
        g2.nuevoVertice("B");
        g2.nuevoVertice("C");
        g2.nuevoVertice("D");
        g2.nuevoVertice("E");
        g2.nuevoVertice("F");
        g2.nuevoVertice("T");
        g2.nuevoVertice("P");
        g2.nuevoVertice("X");
        g2.nuevoVertice("Y");
        g2.nuevoVertice("Z");
        g2.nuevoVertice("2");

        g2.union("A", "B");
        g2.union("B", "F");
        g2.union("F", "C");
        g2.union("C", "E");
        g2.union("C", "D");
        g2.union("C", "T");
        g2.union("T", "P");

        g.recorrerProfundidad();

        DibujadorGrafo f2 = new DibujadorGrafo(g2);
        f2.repaint();

        JFrame frame = new JFrame("FFF");
        frame.setSize(new Dimension(900, 900));
        frame.setLocationRelativeTo(null);
        frame.add(f2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}

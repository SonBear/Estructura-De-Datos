/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Exceptions.VerticeNoExisteException;
import Modelo.Grafo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author emman
 */
public class DibujadorGrafo extends JPanel {

    private Grafo<?> grafo;
    private final int DISTANCIAINICIAL = 150;
    private int IX, IY;
    private final int RADIO = 30;
    private final int NUMEROVERTICESANILLO = 10;
    private int numeroVertices;
    private Punto[] puntos;

    public DibujadorGrafo(Grafo<?> grafo) {
        this.grafo = grafo;
        numeroVertices = grafo.getNumeroVertices();
        puntos = new Punto[numeroVertices];
        this.setBackground(new Color(0, 0, 0));
        this.setSize(new Dimension(800, 800));
        IX = this.getWidth() / 2;
        IY = this.getHeight() / 2;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        int angulo = 0;
        int x, y;
        int DISTANCIA = DISTANCIAINICIAL;
        int GradoDiferencia = 20;

        //Calculamos la posicion de los vertices en el panel
        for (int i = 0; i < numeroVertices; i++) {
            if (angulo >= 360) {
                angulo = GradoDiferencia;
                GradoDiferencia += GradoDiferencia;
                DISTANCIA += DISTANCIA / 2;
            }
            x = (int) (DISTANCIA * Math.sin(Math.toRadians(angulo)));
            y = (int) (DISTANCIA * Math.cos(Math.toRadians(angulo)));
            puntos[i] = new Punto(x + IX, y + IY);

            System.out.println(angulo);
            angulo += 360 / NUMEROVERTICESANILLO;

        }

        //Dibujamos los arcos para los vertices que son adyacentes
        g.setColor(new Color(255, 255, 255));
        for (int i = 0; i < numeroVertices; i++) {

            for (int j = 0; j < numeroVertices; j++) {
                try {
                    if (grafo.adyacente(i, j)) {
                        g.drawLine(puntos[i].getX(), puntos[i].getY(), puntos[j].getX(), puntos[j].getY());
                    }
                } catch (VerticeNoExisteException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }

        for (int i = 0; i < numeroVertices; i++) {
            try {

                dibujarVertice(g, grafo.getElemento(i) + "", puntos[i].getX(), puntos[i].getY());
            } catch (VerticeNoExisteException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    private void dibujarVertice(Graphics g, String elemento, int x, int y) {
        g.setColor(new Color(255, 0, 0));
        g.fillOval(x - RADIO / 2, y - RADIO / 2, RADIO, RADIO);
        g.setColor(new Color(255, 255, 255));
        g.drawString(elemento, x, y);
    }

    private class Punto {

        int x;
        int y;

        public Punto(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

    }

}

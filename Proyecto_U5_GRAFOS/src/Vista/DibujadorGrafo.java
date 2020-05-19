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
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import static java.lang.Thread.sleep;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JPanel;

/**
 *
 * @author emman
 */
public class DibujadorGrafo extends JPanel {

    private Grafo<?> grafo;
    private int DISTANCIAINICIAL = 150;
    private int IX, IY;
    private int RADIO = 30;
    private final int NUMEROVERTICESANILLO = 10;
    private int numeroVertices;
    private Punto[] puntos;
    private final int ARR_SIZE = 4;
    private int WIDHT_PANEL, HEIGHTPANEL;
    private int GRADOS_DIFERENCIA = 20;

    public DibujadorGrafo(Grafo<?> grafo) {
        this.grafo = grafo;
        numeroVertices = grafo.getNumeroVertices();
        puntos = new Punto[numeroVertices];
        this.setBackground(new Color(0, 0, 0));
        this.setSize(new Dimension(800, 800));
        IX = this.getWidth() / 2;
        IY = this.getHeight() / 2;
    }

    public DibujadorGrafo(Grafo<?> grafo, int widht, int height) {
        this.grafo = grafo;
        numeroVertices = grafo.getNumeroVertices();
        puntos = new Punto[numeroVertices];
        this.setBackground(new Color(0, 0, 0));
        this.setSize(new Dimension(widht, height));
        IX = widht / 2;
        IY = height / 2;
        WIDHT_PANEL = widht;
        HEIGHTPANEL = height;
    }

    @Override
    public void paint(Graphics g) {

        numeroVertices = grafo.getNumeroVertices();
        puntos = new Punto[numeroVertices];
        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        int angulo = 0;
        int x, y;
        int DISTANCIA = DISTANCIAINICIAL;
        int GradoDiferencia = GRADOS_DIFERENCIA;

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

            angulo += 360 / NUMEROVERTICESANILLO;

        }
        redimendionar();
        //Dibujamos los arcos para los vertices que son adyacentes
        g.setColor(new Color(255, 255, 255));
        for (int i = 0; i < numeroVertices; i++) {

            for (int j = 0; j < numeroVertices; j++) {
                try {
                    if (grafo.adyacente(i, j)) {
                        drawArrow(g, puntos[i].getX(), puntos[i].getY(), puntos[j].getX(), puntos[j].getY());
                    }
                } catch (VerticeNoExisteException ex) {
                    System.out.println(ex.getMessage());
                }

            }
        }

        //DIBUJAMOS LOS VERTICES EN EL PANEL
        for (int i = 0; i < numeroVertices; i++) {
            try {
                g.setColor(new Color(255, 0, 0)); //Color de los vertices
                dibujarVertice(g, grafo.getElemento(i) + "", puntos[i].getX(), puntos[i].getY());
            } catch (VerticeNoExisteException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

    private void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {
        Graphics2D g = (Graphics2D) g1.create();
        g.setColor(Color.WHITE);
        double dx = x2 - x1, dy = y2 - y1;
        double angle = Math.atan2(dy, dx);
        int len = (int) (Math.sqrt(dx * dx + dy * dy) - RADIO / 2);
        AffineTransform at = AffineTransform.getTranslateInstance(x1, y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[]{len, len - ARR_SIZE, len - ARR_SIZE, len},
                new int[]{0, -ARR_SIZE, ARR_SIZE, 0}, 4);
    }

    private void dibujarVertice(Graphics g, String elemento, int x, int y) {

        g.fillOval(x - RADIO / 2, y - RADIO / 2, RADIO, RADIO);
        g.setColor(new Color(255, 255, 255));
        g.drawString(elemento, x, y);
    }

    public void recorridoAnchura() throws VerticeNoExisteException, InterruptedException {
        recorridoAnchura(getGraphics());

    }

    private void recorridoAnchura(Graphics g) throws VerticeNoExisteException, InterruptedException {

        //numero del vertice inicial
        int vi = 0;
        while (!tieneAdyacentes(vi) && vi < grafo.getNumeroVertices()) {
            vi++;
            if (vi >= grafo.getNumeroVertices()) {
                return;

            }
        }

        //Estructuras para el algortimo
        Boolean procesados[] = new Boolean[numeroVertices];
        Arrays.fill(procesados, false);
        Queue<Integer> colaNumVertices = new ArrayDeque<>();
        //Paso 1 Marcar como prodesado el vertice inicial
        procesados[vi] = true;
        //Pasa 2 meter el vertice inicial a la cola
        colaNumVertices.add(vi);
        //Paso repetir paso 4 y paso 5 mientras la cola no este vacía
        while (!colaNumVertices.isEmpty()) {
            //paso 4 visitar el vertice del frente de la cola
            int verticeActual = colaNumVertices.remove();
            sleep(1000);
            g.setColor(Color.YELLOW);
            dibujarVertice(g, grafo.getElemento(verticeActual) + " ", puntos[verticeActual].getX(), puntos[verticeActual].getY());

            //Impresion en pantalla de la visita de vertices
            //paso 5 agregar todos los vertices adyacentes y que no esten procesados a la cola y marcarlos como procesados
            for (int i = 0; i < numeroVertices; i++) {
                if (grafo.adyacente(verticeActual, i) && !procesados[i]) {
                    colaNumVertices.add(i);
                    procesados[i] = true;
                }
            }

        }
        sleep(1000);
        repaint();

    }

    private boolean tieneAdyacentes(int vertice) throws VerticeNoExisteException {
        for (int i = 0; i < numeroVertices; i++) {
            if (grafo.adyacente(vertice, i)) {
                return true;
            }
        }
        return false;
    }

    public void recorrerProfundidad() throws VerticeNoExisteException, InterruptedException {
        int vi = 0;
        Boolean procesados[] = new Boolean[numeroVertices];
        Arrays.fill(procesados, false);
        Stack<Integer> pila = new Stack<>();
        //numero del vertice inicial
        while (!tieneAdyacentes(vi) && vi < grafo.getNumeroVertices()) {
            vi++;
            if (vi >= grafo.getNumeroVertices()) {
                return;

            }
        }
        recorrerProfundidad(getGraphics(), vi, pila, procesados);
        sleep(1000);
        repaint();
    }

    //Recorrido en profundidad
    private void recorrerProfundidad(Graphics g, int v, Stack<Integer> pila, Boolean[] procesados) throws VerticeNoExisteException, InterruptedException {
        //Vertice inicial
        int vi = v;

        //Se marca como procesado y se mete a la pila
        procesados[vi] = true;
        pila.push(vi);

        //paso 4 visitar el vertice de la pila
        int verticeActual = pila.pop();

        //Impresion en pantalla de la visita de vertices
        sleep(1000);
        g.setColor(Color.YELLOW);
        dibujarVertice(g, grafo.getElemento(verticeActual) + " ", puntos[verticeActual].getX(), puntos[verticeActual].getY());

        //Ingresar a la pila los vertices adyacentes a v
        for (int i = 0; i < numeroVertices; i++) {
            if (grafo.adyacente(verticeActual, i) && !procesados[i]) {
                pila.push(i);
            }
        }
        System.out.println(pila);
        //recorrer en profundidad todos los vertices adyacentes a v
        for (int i = 0; i < pila.size(); i++) {
            recorrerProfundidad(g, pila.pop(), pila, procesados);
        }

    }

    private boolean estaSobrepasado() {
        for (int i = 0; i < puntos.length; i++) {
            if (puntos[i].getX() > WIDHT_PANEL || puntos[i].getX() < 0) {
                return true;
            }
            if (puntos[i].getY() > HEIGHTPANEL || puntos[i].getY() < 0) {
                return true;

            }
        }
        return false;
    }

    private void redimendionar() {
        if (estaSobrepasado()) {
            DISTANCIAINICIAL -= RADIO;
            RADIO -= 2;
            if (RADIO < 5) {
                RADIO = 5;

            }
            if (DISTANCIAINICIAL < 5) {
                DISTANCIAINICIAL = 5;
            }
            repaint();
        }
    }

    public void setGrafo(Grafo<?> grafo) {
        this.grafo = grafo;
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

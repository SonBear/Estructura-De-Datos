/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Exceptions.VerticeNoExisteException;
import Modelo.Grafo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import static java.lang.Thread.sleep;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author emman
 */
public class DibujadorGrafo extends JPanel {

    private Grafo<?> grafo;
    private int DISTANCIAINICIAL = 170;
    private int IX, IY;
    private int RADIO = 40;
    private final int NUMEROVERTICESANILLO = 5;
    private int numeroVertices;
    private Punto[] puntos;
    private int ARR_SIZE = 7;
    private int WIDHT_PANEL, HEIGHTPANEL;
    private int GRADOS_DIFERENCIA = 30;

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

        super.paint(g); //To change body of generated methods, choose Tools | Templates.

        numeroVertices = grafo.getNumeroVertices();
        puntos = new Punto[numeroVertices];
        int angulo = 0;
        int x, y;
        int DISTANCIA = 0;

        int cont = 0;
        //Calculamos la posicion de los vertices en el panel
        for (int i = 0; i < numeroVertices; i++) {
            if (i % NUMEROVERTICESANILLO == 0) {
                angulo = angulo % 360 + GRADOS_DIFERENCIA;
                DISTANCIA += DISTANCIAINICIAL + (cont * 5);
                cont++;
            }

            x = (int) (DISTANCIA * Math.sin(Math.toRadians(angulo)));
            y = (int) (DISTANCIA * Math.cos(Math.toRadians(angulo)));
            puntos[i] = new Punto(x + IX, y + IY);

            angulo += 360 / NUMEROVERTICESANILLO;

        }

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
        if (puntos.length > 0) {
            try {
                g.setColor(new Color(255, 78, 219)); //Color de los vertices
                dibujarVertice((Graphics2D) g, grafo.getElemento(0) + "", puntos[0].getX(), puntos[0].getY());
                for (int i = 1; i < numeroVertices; i++) {

                    g.setColor(new Color(186, 78, 219)); //Color de los vertices
                    dibujarVertice((Graphics2D) g, grafo.getElemento(i) + "", puntos[i].getX(), puntos[i].getY());

                }
            } catch (VerticeNoExisteException ex) {
                Logger.getLogger(DibujadorGrafo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (redimendionar()) {
            repaint(1000);
        }

    }

    private void drawArrow(Graphics g1, int x1, int y1, int x2, int y2) {

        Graphics2D g = (Graphics2D) g1.create();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.WHITE);

        double dx = x2 - x1, dy = y2 - y1;

        double angle = Math.atan2(dy, dx);

        int y = (int) ((RADIO / 2 + 7) * Math.sin(angle));
        int x = (int) ((RADIO / 2 + 7) * Math.cos(angle));
        dx = x2 - (x + x1);
        dy = y2 - (y + y1);
        int len = (int) (Math.sqrt(dx * dx + dy * dy)) - (RADIO / 2 + 7);

        AffineTransform at = AffineTransform.getTranslateInstance(x + x1, y + y1);
        at.concatenate(AffineTransform.getRotateInstance(angle));
        g.transform(at);

        // Draw horizontal arrow starting in (0, 0)
        g.drawLine(0, 0, len, 0);
        g.fillPolygon(new int[]{len, len - ARR_SIZE, len - ARR_SIZE, len},
                new int[]{0, -ARR_SIZE, ARR_SIZE, 0}, 4);
    }

    private void dibujarVertice(Graphics2D g, String elemento, int x, int y) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        Ellipse2D circuloAp = new Ellipse2D.Double(x - RADIO / 2 - 5, y - RADIO / 2 - 5, RADIO + 10, RADIO + 10);
        Ellipse2D circulo = new Ellipse2D.Double(x - RADIO / 2, y - RADIO / 2, RADIO, RADIO);
        g.fill(circulo);
        g.draw(circuloAp);
        g.setColor(new Color(255, 255, 255));
        g.drawString(elemento, x - 2, y + RADIO / 2 + 18);
    }

    public void recorridoAnchura() throws VerticeNoExisteException, InterruptedException {
        recorridoAnchura((Graphics2D) getGraphics());

    }

    private void recorridoAnchura(Graphics2D g) throws VerticeNoExisteException, InterruptedException {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

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
            dibujarVertice((Graphics2D) g, grafo.getElemento(verticeActual) + " ", puntos[verticeActual].getX(), puntos[verticeActual].getY());

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
        recorrerProfundidad((Graphics2D) getGraphics(), vi, pila, procesados);
        sleep(1000);
        repaint();
    }

    //Recorrido en profundidad
    private void recorrerProfundidad(Graphics2D g, int v, Stack<Integer> pila, Boolean[] procesados) throws VerticeNoExisteException, InterruptedException {
        //Vertice inicial
        int vi = v;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //Se marca como procesado y se mete a la pila
        procesados[vi] = true;
        pila.push(vi);

        //paso 4 visitar el vertice de la pila
        int verticeActual = pila.pop();

        //Impresion en pantalla de la visita de vertices
        sleep(1000);
        g.setColor(Color.YELLOW);
        dibujarVertice((Graphics2D) g, grafo.getElemento(verticeActual) + " ", puntos[verticeActual].getX(), puntos[verticeActual].getY());

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
            if (puntos[i].getX() > WIDHT_PANEL - (RADIO / 2 + 18) || puntos[i].getX() < (RADIO / 2 + 18)) {
                return true;
            }
            if (puntos[i].getY() > HEIGHTPANEL - (RADIO / 2 + 18) || puntos[i].getY() < (RADIO / 2 + 18)) {
                return true;

            }
        }
        return false;
    }

    private boolean redimendionar() {
        if (estaSobrepasado()) {
            DISTANCIAINICIAL -= RADIO / 3;
            RADIO -= 2;
            ARR_SIZE -= 1;
            if (ARR_SIZE < 4) {
                ARR_SIZE = 4;
            }
            if (RADIO < 5) {
                RADIO = 5;

            }
            if (DISTANCIAINICIAL < 5) {
                DISTANCIAINICIAL = 5;
            }
            return true;

        }
        return false;

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

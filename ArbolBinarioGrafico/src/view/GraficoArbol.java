package view;

import exception.MaximoHeightExcedido;
import exception.MaximoWidthExcedido;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import model.ArbolBB;
import model.NodoABB;

/**
 * Codigo sacado de la deepWeb según @Mohamed
 *
 * @author Nicolás
 * @param <E>
 */
public class GraficoArbol extends JPanel {

    private ArbolBB<?> arbol;

    private final int PARENT_TO_CHILD = 20;
    private final int CHILD_TO_CHILD = 30;
    private final int OFFSET_X = 20;
    private final int OFFSET_Y = 20;

    private final Dimension EMPTY = new Dimension();

    private final HashMap<NodoABB<?>, Rectangle> posicionNodos;
    private final HashMap<NodoABB<?>, Dimension> subtreesSizes;
    private FontMetrics fm;

    public void setArbol(ArbolBB<?> arbol) {
        this.arbol = arbol;
    }

    public GraficoArbol(ArbolBB<?> arbol) {
        this.arbol = arbol;
        posicionNodos = new HashMap<>();
        subtreesSizes = new HashMap<>();
        setBackground(Color.WHITE);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        fm = g.getFontMetrics();
        calcularPosiciones();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.translate(getWidth() / 2, PARENT_TO_CHILD);

        try {
            dibujarArbol(g2d,
                    arbol.getRaiz(),
                    Integer.MAX_VALUE,
                    Integer.MAX_VALUE,
                    fm.getLeading() + fm.getAscent());

        } catch (MaximoWidthExcedido e) {
            cambiarWidthPanel();

        } catch (MaximoHeightExcedido e) {
            cambiarHeightPanel();
        }

        g2d.dispose();
    }

    /**
     * Dibuja el árbol teniendo en cuenta las ubicaciones de los nodos y los subárboles calculadas anteriormente.
     *
     * @param g: Objeto de la clase Graphics2D que permite realizar el dibujo de las líneas, rectangulos y del String de la información que contiene el Nodo.
     * @param nodo: Objeto de la clase NodoB <T> que se utiliza como referencia para dibujar el árbol.
     * @param puntox: int con la posición en x desde donde se va a dibujar la línea hasta el siguiente hijo.
     * @param puntoy: int con la posición en y desde donde se va a dibujar la línea hasta el siguiente hijo.
     * @param yoffs: int con la altura del FontMetrics.
     */
    private void dibujarArbol(Graphics2D g, NodoABB<?> nodo, int puntox, int puntoy, int yoffs) {
        if (nodo == null) {
            return;
        }

        Rectangle rect = posicionNodos.get(nodo);

        if (rect.getX() < -getWidth() / 2 + OFFSET_X || rect.getX() + rect.getWidth() > getWidth() / 2 - OFFSET_X) {
            throw new MaximoWidthExcedido();
        }

        if (rect.getY() + rect.getHeight() > getHeight() - OFFSET_Y) {
            throw new MaximoHeightExcedido();
        }

        g.draw(rect);
        g.drawString(nodo.getDato().toString(), rect.x + 3, rect.y + yoffs);

        if (puntox != Integer.MAX_VALUE) {
            g.drawLine(puntox, puntoy, rect.x + rect.width / 2, rect.y);
        }

        dibujarArbol(g, nodo.getIzq(), rect.x + rect.width / 2, rect.y + rect.height, yoffs);
        dibujarArbol(g, nodo.getDer(), rect.x + rect.width / 2, rect.y + rect.height, yoffs);
    }

    /**
     * Calcula las posiciones de los respectivos subárboles y de cada nodo que forma parte de ese subárbol, para conocer en que posición van a ir dibujados los rectángulos representativos del árbol de la expresión.
     */
    private void calcularPosiciones() {
        posicionNodos.clear();
        subtreesSizes.clear();

        NodoABB<?> root = arbol.getRaiz();

        if (root != null) {
            calcularTamanioSubarboles(root);
            calcularPosicion(root, Integer.MAX_VALUE, Integer.MAX_VALUE, 0);
        }

    }

    /**
     * Calcula el tamaño de cada subárbol y lo agrega al objeto subtreeSizes de la clase de tipo HashMap<> que va a contener la coleccion de todos los subárboles que contiene un arbol.
     *
     * @param nodo:Objeto de la clase NodoB <T> que se utiliza como referencia calcular el tamaño de cada subárbol.
     * @return Dimension con el tamaño de cada subárbol.
     *
     */
    private Dimension calcularTamanioSubarboles(NodoABB<?> nodo) {
        if (nodo == null) {
            return EMPTY;
        }

        Dimension ld = calcularTamanioSubarboles(nodo.getIzq());
        Dimension rd = calcularTamanioSubarboles(nodo.getDer());

        //            16
        int h = fm.getHeight() + PARENT_TO_CHILD + Math.max(ld.height, rd.height);
        int w = ld.width + CHILD_TO_CHILD + rd.width;

        Dimension d = new Dimension(w, h);
        subtreesSizes.put(nodo, d);
        return d;
    }

    /**
     * Calcula la ubicación de cada nodo de cada subárbol y agrega cada nodo con un objeto de tipo Rectangle que tiene la ubicación y la información específica de dónde va a ser dibujado.
     *
     * @param n: Objeto de tipo NodoB <T> que se utiliza como referencia para calcular la ubicación de cada nodo.
     * @param left: int con alineación y orientación a la izquierda.
     * @param right: int con alineación y orientación a la derecha.
     * @param top: int del tope.
     *
     */
    private void calcularPosicion(NodoABB<?> n, int left, int right, int top) {
        if (n == null) {
            return;
        }

        Dimension ld = subtreesSizes.get(n.getIzq());

        if (ld == null) {
            ld = EMPTY;
        }

        Dimension rd = subtreesSizes.get(n.getDer());

        if (rd == null) {
            rd = EMPTY;
        }

        int center = 0;

        if (right != Integer.MAX_VALUE) {
            center = right - rd.width - CHILD_TO_CHILD / 2;
        } else if (left != Integer.MAX_VALUE) {
            center = left + ld.width + CHILD_TO_CHILD / 2;
        }

        int width = fm.stringWidth(n.getDato().toString());

        posicionNodos.put(n, new Rectangle(center - width / 2 - 3, top, width + 6, fm.getHeight()));

        calcularPosicion(n.getIzq(), Integer.MAX_VALUE, center - CHILD_TO_CHILD / 2, top + fm.getHeight() + PARENT_TO_CHILD);
        calcularPosicion(n.getDer(), center + CHILD_TO_CHILD / 2, Integer.MAX_VALUE, top + fm.getHeight() + PARENT_TO_CHILD);
    }

    private void cambiarWidthPanel() {
        EventQueue.invokeLater(() -> {
            setPreferredSize(new Dimension(getWidth() + 40, getHeight()));
            revalidate();
        });
    }

    private void cambiarHeightPanel() {
        EventQueue.invokeLater(() -> {
            setPreferredSize(new Dimension(getWidth(), getHeight() + 40));
            revalidate();
        });
    }

    private void centrarPanel() {
        EventQueue.invokeLater(() -> {
            JScrollPane scrollPane = (JScrollPane) getParent().getParent().getParent();

            Rectangle r = scrollPane.getViewport().getBounds();
            JScrollBar bar = scrollPane.getHorizontalScrollBar();
            bar.setValue((bar.getMaximum() - r.width) / 2);
        });
    }

}

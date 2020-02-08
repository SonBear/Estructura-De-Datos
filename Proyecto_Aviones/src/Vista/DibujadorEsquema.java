package Vista;

import Modelo.QueueEmptyException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.GeneralPath;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author emman
 */
public class DibujadorEsquema {

    private int ANCHO_PANEL;
    private int ALTO_PANEL;

    private final int ANCHO_LABEL = 80;
    private final int ALTO_LABEL = 20;

    private final int SEPARACION = 30;
    private final int SEPARACION_LINEA = ALTO_LABEL + 15;

    private final int INICIO_X = 30;
    private final int INICIO_Y = 10;

    private int MAXIMO_LABELS_LINEA;
    private int noFilas;

    private JPanel panel;
    private ImageIcon avionIcon;

    public DibujadorEsquema(JPanel panel) {
        this.panel = panel;
        avionIcon = new ImageIcon(getClass().getResource("avion.gif"));

    }

    public void dibujar(String[] colaAviones) throws QueueEmptyException {
        ANCHO_PANEL = panel.getWidth();
        ALTO_PANEL = panel.getHeight();
        MAXIMO_LABELS_LINEA = (ANCHO_PANEL - INICIO_X * 2) / (ANCHO_LABEL + SEPARACION);
        Graphics2D g = (Graphics2D) panel.getGraphics();
        panel.update(g);
        int y = INICIO_Y;
        noFilas = colaAviones.length / MAXIMO_LABELS_LINEA;
        dibujarpanel(MAXIMO_LABELS_LINEA, noFilas, g, INICIO_X, y);

        for (int i = 0, x = INICIO_X; i < colaAviones.length; i++, x += ANCHO_LABEL + SEPARACION) {
            g.setColor(Color.red);
            g.setStroke(new BasicStroke(2));

            g.fillRect(x, y, ANCHO_LABEL + avionIcon.getIconHeight(), ALTO_LABEL);

            g.drawImage(avionIcon.getImage(), x + 2, y + ALTO_LABEL / 2 - avionIcon.getIconHeight() / 2, null);
            dibujarStringCentradoRect(g, colaAviones[i], x, y, ANCHO_LABEL + avionIcon.getIconHeight(), ALTO_LABEL);
            dibujarTriangulo(g, x + avionIcon.getIconHeight(), y);
            if ((i + 1) % MAXIMO_LABELS_LINEA == 0) {
                x = INICIO_X - (ANCHO_LABEL + SEPARACION);
                y += SEPARACION_LINEA;
            }

        }

        g.dispose();

    }

    private void dibujarStringCentradoRect(Graphics2D g, String text, int x, int y, int ancho, int alto) {
        g.setColor(Color.white);
        Rectangle bounds = g.getFontMetrics().getStringBounds(text, g).getBounds();
        g.drawString(text, x + ancho / 2 - bounds.width / 2 + avionIcon.getIconHeight() / 2, y + alto / 2 + bounds.height / 2 - 3);

    }

    private void dibujarTriangulo(Graphics2D g, int x, int y) {
        g.setColor(Color.blue);
        GeneralPath triangulo = new GeneralPath();

        int[] px = {x + ANCHO_LABEL + 2, x + ANCHO_LABEL + 2, x + ANCHO_LABEL + 10};
        int[] py = {y, y + ALTO_LABEL, y + 10};

        triangulo.moveTo(x + ANCHO_LABEL + 2, y);

        for (int i = 0; i < px.length; i++) {
            triangulo.lineTo(px[i], py[i]);
        }

        triangulo.closePath();
        g.fill(triangulo);

    }

    private void dibujarpanel(int noLabels, int filas, Graphics2D g, int x, int y) {

        int sep = 0;
        int x2, y2;
        for (int i = 0; i < filas + 1; i++) {
            x2 = (x + ANCHO_LABEL) * noLabels + SEPARACION;
            y2 = y * 2 + sep;
            g.drawLine(x, y2, x2, y2);
            if (i != filas) {

                g.drawLine(x2, y2, x2, y2 + SEPARACION_LINEA / 2);
                g.drawLine(x - 15, y * 2 + sep + 17, (x + ANCHO_LABEL) * noLabels + SEPARACION, y * 2 + sep + 17);
                x2 = x - 15;
                y2 = y * 2 + sep + 18;
                g.drawLine(x2, y2, x2, y2 + SEPARACION_LINEA / 2);
                g.drawLine(x2, y2 + SEPARACION_LINEA / 2, x2 + 15, y2 + SEPARACION_LINEA / 2);
                sep += SEPARACION_LINEA;
            }

        }

    }

}

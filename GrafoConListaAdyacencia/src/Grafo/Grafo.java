package Grafo;

import Lista.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 *
 * @author emman
 */
public class Grafo {

    private int numeroVertices;
    private final int MAXVERTICES = 20;
    private Vertice[] vertices;
    ArrayDeque<String> de = new ArrayDeque<>();

    public Grafo(int maxVer) {
        vertices = new Vertice[maxVer];
        numeroVertices = 0;

    }

    public Grafo() {
        vertices = new Vertice[MAXVERTICES];
        numeroVertices = 0;

    }

    public int getNumeroVertices() {
        return numeroVertices;
    }

    public Vertice[] getVertices() {
        return vertices;
    }

    public void setNumeroVertices(int numeroVertices) {
        this.numeroVertices = numeroVertices;
    }

    public void setVertices(Vertice[] vertices) {
        this.vertices = vertices;
    }

    public Deque getListaVertice(int ver) throws Exception {
        if (ver < 0 || ver >= numeroVertices) {
            throw new Exception("Vertice no existe");
        }
        return vertices[ver].getListaAdayacencia();
    }

    public void nuevoVertice(String nombre) {
        boolean esta = getNumeroVertice(nombre) >= 0;
        if (!esta) {
            Vertice nuevoVertice = new Vertice(nombre);
            nuevoVertice.setNumVertice(numeroVertices);
            vertices[numeroVertices++] = nuevoVertice;
        }
    }

    public void nuevoArco(String a, String b) throws Exception {

        if (!esAdyacente(a, b)) {
            int va = getNumeroVertice(a);
            int vb = getNumeroVertice(b);
            if (va < 0 || vb < 0) {
                throw new Exception("Vertice no exite");
            }
            Arco ar = new Arco(vb);
            vertices[va].getListaAdayacencia().insertFirst(ar);

        }

    }

    public void nuevoArco(String a, String b, Double peso) throws Exception {

        if (!esAdyacente(a, b)) {
            int va = getNumeroVertice(a);
            int vb = getNumeroVertice(b);
            if (va < 0 || vb < 0) {
                throw new Exception("Vertice no exite");
            }
            Arco ar = new Arco(vb, peso);
            vertices[va].getListaAdayacencia().insertFirst(ar);

        }

    }

    /**
     * No dirigido
     */
    public void nuevoArco(String a, String b, Double peso, int i) throws Exception {

        if (!esAdyacente(a, b)) {
            int va = getNumeroVertice(a);
            int vb = getNumeroVertice(b);
            if (va < 0 || vb < 0) {
                throw new Exception("Vertice no exite");
            }
            Arco ar = new Arco(vb, peso);
            vertices[va].getListaAdayacencia().insertFirst(ar);

            //Para un grafo no dirigido
            Arco ar2 = new Arco(va, peso);
            vertices[vb].getListaAdayacencia().insertFirst(ar2);

        }

    }

    public void borrarArco(String a, String b) throws Exception {
        int va = getNumeroVertice(a);
        int vb = getNumeroVertice(b);
        if (va < 0 || vb < 0) {
            throw new Exception("Vertice no exite");
        }
        Arco ar = new Arco(vb);
        vertices[va].getListaAdayacencia().remove(ar);

    }

    public int getNumeroVertice(String nombre) {
        Vertice v = new Vertice(nombre);
        for (int i = 0; i < numeroVertices; i++) {
            if (vertices[i].equals(v)) {
                return i;

            }
        }
        return -1;
    }

    private boolean esAdyacente(String a, String b) throws Exception {
        int va = getNumeroVertice(a);
        int vb = getNumeroVertice(b);

        if (va < 0 || vb < 0) {
            throw new Exception("Vertice no exite");
        }

        return vertices[va].getListaAdayacencia().find(new Arco(vb));
    }

    private boolean esAdyacente(int va, int vb) throws Exception {

        if (va < 0 || vb < 0) {
            throw new Exception("Vertice no exite");
        }

        //true si se logra encontrar el arco
        return vertices[va].getListaAdayacencia().find(new Arco(vb));
    }

    public void recorrerEnAnchura(String nombreVertice) throws Exception {
        //numero del vertice inicial
        int vi = getNumeroVertice(nombreVertice);
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

            //Impresion en pantalla de la visita de vertices
            System.out.println(vertices[verticeActual]);

            //paso 5 agregar todos los vertices adyacentes y que no esten procesados a la cola y marcarlos como procesados
            for (int i = 0; i < numeroVertices; i++) {
                if (esAdyacente(verticeActual, i) && !procesados[i]) {
                    colaNumVertices.add(i);
                    procesados[i] = true;
                }
            }

        }

    }

    @Override
    public String toString() {
        String e = "";
        for (int i = 0; i < numeroVertices; i++) {
            try {
                e += vertices[i].getNombre() + " ver# " + vertices[i].getNumVertice() + " -> ";
                for (int j = 0; j < vertices[i].getListaAdayacencia().size(); j++) {
                    Vertice verticeDestino = vertices[vertices[i].getListaAdayacencia().get(j).getDestino()];
                    e += verticeDestino.getNombre() + " ver# " + verticeDestino.getNumVertice() + " Peso: " + vertices[i].getListaAdayacencia().get(j).getPeso() + ", ";
                }
            } catch (Exception ex) {

            }
            e += "\n";
        }

        return e;
    }

}

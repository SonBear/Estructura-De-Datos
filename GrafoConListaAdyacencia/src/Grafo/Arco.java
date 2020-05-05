/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

/**
 *
 * @author emman
 */
public class Arco {

    private int destino; //numero del nodo destino
    private double peso;

    public Arco(int d) {
        destino = d;
    }

    public Arco(int d, double p) {
        this(d);
        peso = p;
    }

    public int getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Arco other = (Arco) obj;
        if (this.destino != other.destino) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Arco: " + destino + "peso: " + peso;
    }

}

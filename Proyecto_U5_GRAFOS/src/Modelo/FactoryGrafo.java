/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.GrafoConListaAD.GrafoLista;
import Modelo.GrafoConMatrizAD.GrafoMatriz;

/**
 *
 * @author emman
 */
public class FactoryGrafo<T> {

    public Grafo<T> generarGrafo(String tipo, int maximoVertices) {
        if (tipo.equals("MatrizAdyacencia")) {
            return new GrafoMatriz<T>(maximoVertices);
        } else if (tipo.equals("ListaAdyacencia")) {
            return new GrafoLista<T>(maximoVertices);
        }
        return null;
    }

}

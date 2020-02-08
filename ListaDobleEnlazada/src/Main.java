/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDobleEnlazada lista = new ListaDobleEnlazada();
        System.out.println(lista);
        lista.agregarInicio(new NodoDoble(1));
        System.out.println(lista);
        lista.agregarFinal(new NodoDoble(2));
        System.out.println(lista);
        lista.agregarFinal(new NodoDoble(3));
        System.out.println(lista);
        lista.agregarInicio(new NodoDoble(0));
        System.out.println(lista);
    }

}

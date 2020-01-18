/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emman
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        System.out.println(lista);
        lista.agregarInicio(new Nodo(1));
        System.out.println(lista);
        lista.agregarFinal(new Nodo(2));
        System.out.println(lista);
        lista.agregarFinal(new Nodo(3));
        System.out.println(lista);
        lista.agregarInicio(new Nodo(0));
        System.out.println(lista);
    }

}

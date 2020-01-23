/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author A18016328
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ListaDobleLigada lista = new ListaDobleLigada();
        lista.agregarInicio(new NodoDoble(1));
        lista.agregarInicio(new NodoDoble(0));
        lista.agregarFinal(new NodoDoble(2));
        lista.agregarFinal(new NodoDoble(3));
        lista.agregarInicio(new NodoDoble(-1));
        System.out.println(lista);
    }
    
}

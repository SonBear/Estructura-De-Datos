/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Controlador.Controlador;
import Modelo.SistemaDeVuelos;
import Vista.MenuPrincipal;

/**
 *
 * @author emman
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controlador cont = new Controlador(new MenuPrincipal(), new SistemaDeVuelos());
        cont.iniciar();

    }
}

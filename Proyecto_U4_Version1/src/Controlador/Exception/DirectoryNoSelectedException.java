/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.Exception;

/**
 * Excepciones correspondientes a la parte grafica y logica del programa
 *
 * @author emman
 */
public class DirectoryNoSelectedException extends Exception {

    public DirectoryNoSelectedException(String message) {
        super(message);
    }

}

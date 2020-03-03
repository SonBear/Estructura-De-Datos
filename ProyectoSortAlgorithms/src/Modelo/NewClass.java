/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.util.Arrays;

/**
 *
 * @author emman
 */
public class NewClass {

    public static void main(String[] args) {
        BuscadorArchivos m = new BuscadorArchivos();
        System.out.println(Arrays.toString(m.enlistarNombreArchivos("C:\\Users\\emman\\Documents")));
        File[] s = m.obtenerListaTodosArchivos("C:\\Users\\emman\\Documents\\Arduino");
        System.out.println(s.length);
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }
    }
}

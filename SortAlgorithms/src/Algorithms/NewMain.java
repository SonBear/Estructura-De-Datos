/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author emman
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int a[] = {3, 5, 9, 8, 1, 4, 2, 7, 0};
        Algorithms.mezclaDirecta(a);

        Algorithms.MEZCLADIRECTA(new File("archivos\\f.dat"), 11);

    }

}

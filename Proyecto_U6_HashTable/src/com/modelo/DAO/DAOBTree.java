/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.DAO;

import com.modelo.ArbolB.BTree;
import com.modelo.Contacto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author emman
 */
public class DAOBTree {

    public static BTree<Contacto> getData(String directorio) {
        try {
            File file = new File(directorio);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                return (BTree<Contacto>) in.readObject();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return new BTree<>(3);
    }

    public static void saveData(BTree<Contacto> arbol, String directorio) {
        try {
            File file = new File(directorio);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream(file));
            ou.writeObject(arbol);
            ou.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage() + "FF");
        }

    }
}

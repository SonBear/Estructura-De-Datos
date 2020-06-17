package com.modelo.DAO;

import com.modelo.ArbolB.BTree;
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

    public static BTree getData(String directorio) {

        try {
            File file = new File(directorio);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                return (BTree) in.readObject();
            }

        } catch (Exception ex) {
            return new BTree(3);

        }

    }

    public static void saveData(BTree arbol, String directorio) {
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

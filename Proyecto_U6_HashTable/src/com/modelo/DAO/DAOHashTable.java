package com.modelo.DAO;

import com.modelo.HasTable.HashTable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author emman
 */
public class DAOHashTable {

    private final static String directorio = "archivos/" + "DirectorioCorreos" + ".dat";

    public static <T> HashTable<String, T> getData() {
        try {
            File file = new File(directorio);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                return (HashTable<String, T>) in.readObject();
            }

        } catch (Exception ex) {
            return new HashTable<>();
        }

    }

    public static <T> void saveData(HashTable<String, T> hashTable) {
        try {
            File file = new File(directorio);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream(file));
            ou.writeObject(hashTable);
            ou.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}

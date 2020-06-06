/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.DAO;

import com.modelo.Contacto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author emman
 */
public class DAOUsuarios {

    private final static String directorio = "archivos/" + "Usuarios" + ".txt";

    public static ArrayList<Contacto> getData() {
        try {
            File file = new File(directorio);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                return (ArrayList<Contacto>) in.readObject();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return new ArrayList<>();

    }

    public static void saveData(ArrayList<Contacto> usuarios) {
        try {
            File file = new File(directorio);
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream ou = new ObjectOutputStream(new FileOutputStream(file));
            ou.writeObject(usuarios);
            ou.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

}

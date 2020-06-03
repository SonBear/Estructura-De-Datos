/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.modelo.ArbolB.BTree;
import com.modelo.ArbolB.Exception.NoDatosException;
import com.modelo.DAO.DAOBTree;
import com.modelo.DAO.DAOHashTable;
import com.modelo.HasTable.HashTable;

/**
 *
 * @author emman
 */
public class Administrador {

    private Contacto usuario;
    private final String RutaContactos = "archivos/" + "Usuarios" + ".txt";
    private String rutaArbol = "";
    private boolean contactoLogeado = false;

    public void login(String correo, String contraseña) throws UsuarioIncorrectoException, ContraseñaIncorrectaException {
        HashTable<String, Contacto> usuarios = DAOHashTable.getData(RutaContactos);
        Contacto usuario = usuarios.get(correo);

        if (usuario == null) {
            contactoLogeado = false;
            throw new UsuarioIncorrectoException("El correo ingresado no está asociado a ninguna cuenta");
        }

        if (!usuario.getContraseña().equals(contraseña)) {
            contactoLogeado = false;
            throw new UsuarioIncorrectoException("Error contraseña incorrecta");
        }

        this.usuario = usuario;
        contactoLogeado = true;
    }

    public void crearUsuario(String nombre, int edad, String correo, String contraseña, String rutaContacto) throws CorreoAsociadoException {

        HashTable<String, Contacto> usuarios = DAOHashTable.getData(RutaContactos);
        if (usuarios.containsKey(correo)) {
            throw new CorreoAsociadoException("El correo ingresado ya ha sido asociado a una cuenta");
        }
        Contacto usuario = new Contacto(nombre, edad, correo, contraseña, rutaContacto);

        usuarios.add(correo, usuario);
        DAOHashTable.saveData(usuarios, RutaContactos);
    }

    public Administrador(Contacto usuario) {

    }

    public void agregarContactoUsuario(Contacto contacto) throws NoDatosException, UsuarioNoLoginException {
        if (contactoLogeado) {
            String directorio = usuario.getRutaContacto() + usuario.getCorreo() + ".txt";

            BTree<Contacto> arbol = DAOBTree.getData(directorio);

            arbol.add(contacto);

            DAOBTree.saveData(arbol, directorio);
        } else {
            throw new UsuarioNoLoginException("No hay usuario logeado");
        }
    }

    public void eliminarContactoUsuario(Contacto contacto) throws UsuarioNoLoginException {
        if (contactoLogeado) {
            String directorio = usuario.getRutaContacto() + usuario.getCorreo() + ".txt";

            BTree<Contacto> arbol = DAOBTree.getData(directorio);
            System.out.println(arbol.remove(usuario));
            DAOBTree.saveData(arbol, directorio);
        } else {
            throw new UsuarioNoLoginException("No hay usuario logeado");
        }

    }

}

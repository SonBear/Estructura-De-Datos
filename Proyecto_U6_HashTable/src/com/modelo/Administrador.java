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
import com.modelo.DAO.DAOUsuarios;
import com.modelo.HasTable.HashTable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author emman
 */
public class Administrador {

    private Contacto usuario;
    private boolean usuarioLogeado = false;

    public Contacto getUsuario() {
        return usuario;
    }

    public void login(String correo, String contraseña) throws UsuarioIncorrectoException, ContraseñaIncorrectaException {
        HashTable<String, String> directorios = DAOHashTable.getData();
        //Contacto usuario = usuarios.get(correo);
        if (!directorios.containsKey(correo)) {
            usuarioLogeado = false;
            throw new UsuarioIncorrectoException("El correo ingresado no está asociado a ninguna cuenta");
        }
        Contacto nuevoUsuario = buscarContactoLista(correo);

        if (!nuevoUsuario.getContraseña().equals(contraseña)) {
            usuarioLogeado = false;
            throw new UsuarioIncorrectoException("Error contraseña incorrecta");
        }

        this.usuario = nuevoUsuario;
        usuarioLogeado = true;
    }

    public void logOut() throws UsuarioNoLoginException {
        if (usuarioLogeado) {
            usuario = null;
            usuarioLogeado = false;
        } else {
            throw new UsuarioNoLoginException("Usuario no logeado");
        }

    }

    public void crearUsuario(String nombre, int edad, String correo, String contraseña, String rutaContacto) throws CorreoAsociadoException {

        HashTable<String, String> directorios = DAOHashTable.getData();

        if (directorios.containsKey(correo)) {
            throw new CorreoAsociadoException("El correo ingresado ya ha sido asociado a una cuenta");
        }
        Contacto nuevoUsuario = new Contacto(nombre, edad, correo, contraseña, rutaContacto);

        //Save and add data to list of usuarios
        ArrayList<Contacto> usuarios = DAOUsuarios.getData();
        usuarios.add(nuevoUsuario);
        DAOUsuarios.saveData(usuarios);

        //Save and add data to hastable of directories
        directorios.put(correo, rutaContacto + "\\" + correo + ".dat");
        DAOHashTable.saveData(directorios);

        //create the file of Btree
        String directorio = directorios.get(correo);
        BTree arbol = DAOBTree.getData(directorios.get(correo));
        DAOBTree.saveData(arbol, directorio);

    }

    public Administrador() {

    }

    public Contacto buscar(String correo) throws NoDatosException {

        HashTable<String, String> directorios = DAOHashTable.getData();

        if (directorios.containsKey(correo)) {
            Contacto contacto = buscarContactoLista(correo);
            return contacto;
        } else {
            throw new NoDatosException("Usuario no encontrado");
        }

    }

    private Contacto buscarContactoLista(String correo) {
        ArrayList<Contacto> usuarios = DAOUsuarios.getData();
        for (int i = 0; i < usuarios.size(); i++) {
            Contacto contac = usuarios.get(i);
            if (contac.getCorreo().equals(correo)) {
                return contac;
            }
        }
        return null;
    }

    public void agregarContactosUsuario(List<Contacto> contactos) throws NoDatosException, UsuarioNoLoginException, Exception {
        for (int i = 0; i < contactos.size(); i++) {
            if (!contactos.get(i).getCorreo().equals(usuario.getCorreo())) {
                agregarContactoUsuario(contactos.get(i));
            }

        }
    }

    public void agregarContactoUsuario(Contacto contacto) throws NoDatosException, UsuarioNoLoginException, Exception {
        if (usuarioLogeado) {
            if (contacto.getCorreo().equals(usuario.getCorreo())) {
                throw new Exception("No se puede agregar a si mismo");
            }
            //Find the directory of the current user
            HashTable<String, String> directorios = DAOHashTable.getData();
            String directorio = directorios.get(usuario.getCorreo());

            //add and save the contact to contacts user
            BTree arbol = DAOBTree.getData(directorio);
            arbol.add(contacto);
            DAOBTree.saveData(arbol, directorio);
        } else {
            throw new UsuarioNoLoginException("No hay usuario logeado");
        }
    }

    public List<Contacto> enlistarContactos() throws UsuarioNoLoginException, NoDatosException {
        if (usuarioLogeado) {
            HashTable<String, String> directorios = DAOHashTable.getData();
            String directorio = directorios.get(usuario.getCorreo());

            BTree arbol = DAOBTree.getData(directorio);
            return arbol.getItems();
        } else {
            throw new UsuarioNoLoginException("Usuario no logeado");
        }

    }

    public List<Contacto> listarContactoDe(Contacto contacto) throws NoDatosException, CorreoAsociadoException {

        HashTable<String, String> directorios = DAOHashTable.getData();
        if (!directorios.containsKey(contacto.getCorreo())) {
            throw new CorreoAsociadoException("Usuario no existe");
        }
        String directorio = directorios.get(contacto.getCorreo());
        BTree arbol = DAOBTree.getData(directorio);
        return arbol.getItems();
    }

    public void eliminarContactoAUsuario(Contacto contacto) throws UsuarioNoLoginException, UsuarioIncorrectoException {
        if (usuarioLogeado) {
            if (contacto.getCorreo().equals(usuario.getCorreo())) {
                throw new UsuarioIncorrectoException("No se puede eliminar a si mismo");
            }
            HashTable<String, String> directorios = DAOHashTable.getData();
            String directorio = directorios.get(usuario.getCorreo());

            BTree arbol = DAOBTree.getData(directorio);
            arbol.remove(contacto);
            DAOBTree.saveData(arbol, directorio);
        } else {
            throw new UsuarioNoLoginException("No hay usuario logeado");
        }

    }

    public void eliminarCuentaActual() {
        if (usuarioLogeado) {
            //remove the current user form all BTree contacts
            eliminarContactoDeTodos(usuario);
            //get the directory of the current user
            HashTable<String, String> directorios = DAOHashTable.getData();

            //delete the contacts file of current user
            String directorio = directorios.get(usuario.getCorreo());
            File file = new File(directorio);
            file.delete();

            //Remove the current user from user list
            ArrayList<Contacto> usuarios = DAOUsuarios.getData();
            usuarios.remove(usuario);
            DAOUsuarios.saveData(usuarios);

            //remove the current user from directory and save it
            directorios.remove(usuario.getCorreo());
            DAOHashTable.saveData(directorios);

            usuario = null;
            usuarioLogeado = false;
        }
    }

    public void eliminarContactoDeTodos(Contacto contactoEliminar) {
        List<Contacto> usuarios = listarTodos();
        HashTable<String, String> directorios = DAOHashTable.getData();
        for (int i = 0; i < usuarios.size(); i++) {
            Contacto contacto = usuarios.get(i);
            if (!contacto.equals(contactoEliminar)) {

                String directorio = directorios.get(contacto.getCorreo());

                BTree arbol = DAOBTree.getData(directorio);

                arbol.remove(contactoEliminar);
                DAOBTree.saveData(arbol, directorio);

            }

        }
    }

    public List<Contacto> listarTodos() {
        ArrayList<Contacto> usuarios = DAOUsuarios.getData();

        return usuarios;
        //usuarios.values()
    }

}

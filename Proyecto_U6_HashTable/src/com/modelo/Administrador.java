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
import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author emman
 */
public class Administrador {

    private Contacto usuario;
    private final String RutaContactos = "archivos/" + "Usuarios" + ".txt";
    private String rutaArbol = "";
    private boolean usuarioLogeado = false;

    public Contacto getUsuario() {
        return usuario;
    }

    public void login(String correo, String contraseña) throws UsuarioIncorrectoException, ContraseñaIncorrectaException {
        HashTable<String, Contacto> usuarios = DAOHashTable.getData(RutaContactos);
        Contacto usuario = usuarios.get(correo);

        if (usuario == null) {
            usuarioLogeado = false;
            throw new UsuarioIncorrectoException("El correo ingresado no está asociado a ninguna cuenta");
        }

        if (!usuario.getContraseña().equals(contraseña)) {
            usuarioLogeado = false;
            throw new UsuarioIncorrectoException("Error contraseña incorrecta");
        }

        this.usuario = usuario;
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

        HashTable<String, Contacto> usuarios = DAOHashTable.getData(RutaContactos);
        if (usuarios.containsKey(correo)) {
            throw new CorreoAsociadoException("El correo ingresado ya ha sido asociado a una cuenta");
        }
        Contacto usuario = new Contacto(nombre, edad, correo, contraseña, rutaContacto);

        usuarios.add(correo, usuario);
        DAOHashTable.saveData(usuarios, RutaContactos);
    }

    public void crearUsuario(String nombre, int edad, String correo, String contraseña) throws CorreoAsociadoException {

        HashTable<String, Contacto> usuarios = DAOHashTable.getData(RutaContactos);
        if (usuarios.containsKey(correo)) {
            throw new CorreoAsociadoException("El correo ingresado ya ha sido asociado a una cuenta");
        }
        Contacto usuario = new Contacto(nombre, edad, correo, contraseña);

        usuarios.add(correo, usuario);
        DAOHashTable.saveData(usuarios, RutaContactos);
    }

    public Administrador() {

    }

    public Contacto buscar(String correo) throws NoDatosException {

        HashTable<String, Contacto> usuarios = DAOHashTable.getData(RutaContactos);
        if (usuarios.containsKey(correo)) {
            return usuarios.get(correo);
        } else {
            throw new NoDatosException("Usuario no encontrado");
        }

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
            String directorio = usuario.getRutaContacto() + "/" + usuario.getCorreo() + ".txt";

            BTree<Contacto> arbol = DAOBTree.getData(directorio);

            arbol.add(contacto);

            DAOBTree.saveData(arbol, directorio);
        } else {
            throw new UsuarioNoLoginException("No hay usuario logeado");
        }
    }

    public List<Contacto> enlistarContactos() throws UsuarioNoLoginException, NoDatosException {
        if (usuarioLogeado) {
            String directorio = usuario.getRutaContacto() + "/" + usuario.getCorreo() + ".txt";

            BTree<Contacto> arbol = DAOBTree.getData(directorio);
            return arbol.enlistarElementos();
        } else {
            throw new UsuarioNoLoginException("Usuario no logeado");
        }

    }

    public List<Contacto> listarContactoDe(Contacto contacto) throws NoDatosException, CorreoAsociadoException {

        HashTable<String, Contacto> usuarios = DAOHashTable.getData(RutaContactos);
        if (!usuarios.containsKey(contacto.getCorreo())) {
            throw new CorreoAsociadoException("Usuario no existe");
        }
        String directorio = contacto.getRutaContacto() + "/" + contacto.getCorreo() + ".txt";

        BTree<Contacto> arbol = DAOBTree.getData(directorio);
        return arbol.enlistarElementos();
    }

    public void eliminarContactoUsuario(Contacto contacto) throws UsuarioNoLoginException, UsuarioIncorrectoException {
        if (usuarioLogeado) {
            if (contacto.getCorreo().equals(usuario.getCorreo())) {
                throw new UsuarioIncorrectoException("No se puede eliminar a si mismo");
            }
            String directorio = usuario.getRutaContacto() + "/" + usuario.getCorreo() + ".txt";

            BTree<Contacto> arbol = DAOBTree.getData(directorio);
            System.out.println(arbol.remove(contacto));
            DAOBTree.saveData(arbol, directorio);
        } else {
            throw new UsuarioNoLoginException("No hay usuario logeado");
        }

    }

    public void eliminarCuentaActual() {
        if (usuarioLogeado) {
            String directorio = usuario.getRutaContacto() + "/" + usuario.getCorreo() + ".txt";
            File file = new File(directorio);
            file.delete();
            HashTable<String, Contacto> usuarios = DAOHashTable.getData(RutaContactos);
            usuarios.remove(usuario.getCorreo());
            DAOHashTable.saveData(usuarios, RutaContactos);
            eliminarContactoDeTodos(usuario);
        }
    }

    public void eliminarContactoDeTodos(Contacto contactoEliminar) {
        List<Contacto> contactos = listarTodos();
        for (int i = 0; i < contactos.size(); i++) {
            Contacto contacto = contactos.get(i);
            String directorio = contacto.getRutaContacto() + "/" + contacto.getCorreo() + ".txt";

            BTree<Contacto> arbol = DAOBTree.getData(directorio);
            System.out.println(arbol.remove(contactoEliminar));
            DAOBTree.saveData(arbol, directorio);
        }
    }

    public List<Contacto> listarTodos() {
        HashTable<String, Contacto> usuarios = DAOHashTable.getData(RutaContactos);

        return Collections.list(usuarios.elements());
        //usuarios.values()
    }

}

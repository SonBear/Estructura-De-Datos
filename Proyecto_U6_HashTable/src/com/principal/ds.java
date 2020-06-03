/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.modelo.Administrador;
import com.modelo.ArbolB.BTree;
import com.modelo.ArbolB.Exception.NoDatosException;
import com.modelo.Contacto;
import com.modelo.ContraseñaIncorrectaException;
import com.modelo.CorreoAsociadoException;
import com.modelo.DAO.DAOBTree;
import com.modelo.UsuarioIncorrectoException;
import com.modelo.UsuarioNoLoginException;

/**
 *
 * @author emman
 */
public class ds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoDatosException, UsuarioIncorrectoException, ContraseñaIncorrectaException, UsuarioNoLoginException, CorreoAsociadoException {
        Contacto usuario = new Contacto("Emmanuel", 18, "Chable@Hotmail.com", "1234");
        Administrador ad = new Administrador(usuario);
        // ad.crearUsuario(usuario.getNombre(), usuario.getEdad(), usuario.getCorreo(), usuario.getContraseña(), "archivos/");
        ad.login("Chable@Hotmail.com", "1234");
        //ad.agregarContactoUsuario(new Contacto("asd", 10, "Edd@asda.com", "1234"));

        // ad.agregarContactoUsuario(new Contacto("dsd", 10, "Ed@asda.com", "1234"));
        // ad.agregarContactoUsuario(usuario);
        //ad.eliminarContactoUsuario(usuario);
        BTree<Contacto> a = DAOBTree.getData("archivos/Chable@Hotmail.com.txt");
        System.out.println(a.enlistarElementos().toString());
    }

}

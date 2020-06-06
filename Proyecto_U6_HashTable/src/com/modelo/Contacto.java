/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.modelo.ArbolB.BTreeComparable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author emman
 */
public class Contacto implements BTreeComparable, Serializable {

    private String nombre;
    private int edad;
    private String correo;
    private String contraseña;

    public Contacto(String nombre, int edad, String correo, String contraseña) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public Contacto(String nombre, int edad, String correo, String contraseña, String rutaContacto) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCorreo() {
        return correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", edad=" + edad + ", correo=" + correo + ", contrase\u00f1a=" + contraseña + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(BTreeComparable other) {
        return getNombre().compareTo(((Contacto) other).getNombre());
    }

}

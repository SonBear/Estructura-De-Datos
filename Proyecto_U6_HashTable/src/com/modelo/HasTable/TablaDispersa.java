/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.HasTable;

import java.io.Serializable;

/**
 *
 * @author emman
 */
public class TablaDispersa<K, T> implements Serializable {

    private static int TAMTABLA = 11;
    private int numElementos;
    private double factorCarga;
    private Entrada<K, T>[] valores;

    public TablaDispersa() {
        valores = new Entrada[TAMTABLA];
        for (int j = 0; j < TAMTABLA; j++) {
            valores[j] = null;
        }
        numElementos = 0;
        factorCarga = 0.0;
    }

    private int direccion(K key) {
        int i = 0, p;
        long d;

        d = key.hashCode();
        // aplica aritmética modular para obtener dirección base
        p = (int) (d % TAMTABLA);
        if (p < 0) {
            p = -p;
        }
        System.out.println(p);
        // bucle de exploración

        while (valores[p] != null && !valores[p].getKey().equals(key)) {
            i++;
            p += (i * i) + 1;
            p %= TAMTABLA; // considera el array como circular
        }
        return p;
    }

    public void put(K key, T element) {
        int posicion;
        posicion = direccion(key);
        valores[posicion] = new Entrada(key, element);
        numElementos++;
        factorCarga = (double) (numElementos) / TAMTABLA;
        if (factorCarga > 0.7) {
            aumentarTamaño();
            System.out.println("\n!! Factor de carga supera el 70%.!!"
                    + " Conviene aumentar el tamaño.");
        }
    }

    public T get(K key) {
        int posicion;

        posicion = direccion(key);
        Entrada<K, T> entrada = valores[posicion];
        if (entrada == null) {
            return null;
        }
        return entrada.getValue();
    }

    public T remove(K key) {
        int posicion;
        T value = null;
        posicion = direccion(key);

        if (valores[posicion] != null) {
            value = valores[posicion].getValue();
            System.out.println("valor Eliminado: " + valores[posicion].getValue());
            valores[posicion] = null;
            numElementos--;
        }
        return value;
    }

    public boolean containsKey(K key) {
        T element = get(key);
        return element != null;
    }

    public void imprimirTabla() {
        for (int i = 0; i < valores.length; i++) {
            System.out.println(i + ".- " + valores[i]);
        }
    }

    private void aumentarTamaño() {
        factorCarga = 0;
        numElementos = 0;
        Entrada<K, T> valoresAnteriores[] = valores.clone();
        TAMTABLA *= 2;
        valores = new Entrada[TAMTABLA];
        //Se vueven a dispersar los valores
        for (int i = 0; i < valoresAnteriores.length; i++) {
            if (valoresAnteriores[i] != null) {
                Entrada<K, T> valor = valoresAnteriores[i];
                put(valor.key, valor.value);
            }
        }

    }

    public int size() {
        return numElementos;
    }

    public boolean isEmpty() {
        return numElementos == 0;
    }

    private class Entrada<K, T> implements Serializable {

        private K key;
        private T value;

        public Entrada(K key, T value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(T value) {
            this.value = value;
        }

    }

}

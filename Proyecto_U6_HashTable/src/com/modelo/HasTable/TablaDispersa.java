package com.modelo.HasTable;

import java.io.Serializable;

/**
 *
 * @author emman
 */
public class TablaDispersa<K, V> implements Serializable {

    private int TAMTABLA = 11;
    private int numElementos;
    private double factorCarga;
    private Entrada<K, V>[] valores;

    public TablaDispersa() {
        valores = new Entrada[TAMTABLA];
        numElementos = 0;
        factorCarga = 0.0;
    }

    public void setTAMTABLA(int TAMTABLA) {
        this.TAMTABLA = TAMTABLA;
    }

    public void setNumElementos(int numElementos) {
        this.numElementos = numElementos;
    }

    public void setFactorCarga(double factorCarga) {
        this.factorCarga = factorCarga;
    }

    public void setValores(Entrada<K, V>[] valores) {
        this.valores = valores;
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

        // bucle de exploración
        while (valores[p] != null && !(valores[p].getKey().equals(key))) {
            i++;
            p += (i * i) + 1;
            p %= TAMTABLA; // considera el array como circular
        }
        System.out.println(p + "F");
        return p;
    }

    public void put(K key, V element) {
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

    public V get(K key) {
        int posicion;

        posicion = direccion(key);
        System.out.println(posicion);
        Entrada<K, V> entrada = valores[posicion];
        if (entrada == null) {
            return null;
        }
        return entrada.getValue();
    }

    public V remove(K key) {
        int posicion;
        V value = null;
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
        V element = get(key);
        return element != null;
    }

    public void imprimirTabla() {
        for (int i = 0; i < valores.length; i++) {
            System.out.println(i + ".- " + valores[i]);
        }
    }

    private void aumentarTamaño() {
        setFactorCarga(0.0);
        setNumElementos(0);

        Entrada<K, V> valoresAnteriores[] = valores.clone();

        setTAMTABLA(TAMTABLA * 2 + 1);
        setValores(new Entrada[TAMTABLA]);

        //Se vueven a dispersar los valores
        for (Entrada<K, V> valor : valoresAnteriores) {
            if (valor != null) {
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

        @Override
        public String toString() {
            return "Entrada{" + "key=" + key + ", value=" + value + '}';
        }

    }

}

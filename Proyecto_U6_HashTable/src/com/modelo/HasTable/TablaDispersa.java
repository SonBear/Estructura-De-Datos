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

        return p < 0 ? -p : p;
    }

    public void put(K key, V element) {
        int posicion;
        posicion = direccion(key);
        Entrada<K, V> prev = valores[posicion];
        if (prev != null && prev.key != key) {
            valores[posicion] = new Entrada(key, element, prev);

            numElementos++;
            //factorCarga = (double) (numElementos) / TAMTABLA;

            return;

        }

        valores[posicion] = new Entrada(key, element);
        numElementos++;
        factorCarga = (double) (numElementos) / TAMTABLA;
        if (factorCarga > 0.7) {
            //  aumentarTamaño();
            System.out.println("\n!! Factor de carga supera el 70%.!!"
                    + " Conviene aumentar el tamaño.");
        }
    }

    public V get(K key) {
        int posicion;
        V value = null;

        posicion = direccion(key);

        Entrada<K, V> aux = valores[posicion];
        while (aux != null && aux.key != key) {
            aux = aux.getNext();
        }
        if (aux == null) {
            return null;
        }
        value = aux.value;

        return value;

    }

    public V remove(K key) {
        int posicion;
        V value = null;
        posicion = direccion(key);

        if (valores[posicion] != null) {

            Entrada<K, V> prev = valores[posicion];

            if (prev.key.equals(key)) {
                value = prev.value;
                valores[posicion] = valores[posicion].getNext();
                System.out.println("valor Eliminado: " + value);
                numElementos--;
                return value;
            }
            Entrada<K, V> aux = valores[posicion].getNext();
            while (aux != null && aux.getKey() != key) {
                prev = aux;
                aux = aux.next;
            }
            if (aux == null) {
                return null;
            }
            value = aux.value;
            prev.setNext(aux.getNext());

            System.out.println("valor Eliminado: " + value);

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

    private class Entrada<K, V> implements Serializable {

        private K key;
        private V value;
        private Entrada<K, V> next = null;

        public Entrada(K key, V value, Entrada<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Entrada(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public void setNext(Entrada<K, V> next) {
            this.next = next;
        }

        public Entrada<K, V> getNext() {
            return next;
        }

        @Override
        public String toString() {
            String out = "";
            Entrada<K, V> aux = next;

            out += " -> Entrada{" + "key=" + key + ", value=" + value + '}';
            while (aux != null) {
                out += " -> Entrada{" + "key=" + next.key + ", value=" + next.value + '}';
                aux = next.next;
            }
            return out;
        }

    }

}

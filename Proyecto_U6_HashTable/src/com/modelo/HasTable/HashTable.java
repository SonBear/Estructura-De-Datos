/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.HasTable;

/**
 *
 * @author emman
 */
public class HashTable<K, V> extends TablaDispersa<K, V> {

    public HashTable() {
        super();
    }

    @Override
    public synchronized V remove(K key) {
        return super.remove(key); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized void put(K key, V value) {

        super.put(key, value); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized V get(K key) {
        return super.get(key); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized boolean containsKey(K key) {
        return super.containsKey(key); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized int size() {
        return super.size(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public synchronized boolean isEmpty() {
        return super.isEmpty(); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo.HasTable;

import java.util.Hashtable;

/**
 *
 * @author emman
 */
public class HashTable<K, V> extends Hashtable<K, V> {

    public HashTable(int initialCapacity) {
        super(initialCapacity);
    }

    public HashTable() {
    }

    public void add(K key, V value) {
        if (this.containsKey(key)) {
            return;
        }
        super.put(key, value);
    }

}

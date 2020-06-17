/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.modelo.HasTable.HashTable;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable<String, Integer> d = new HashTable<>();
        // d.put("1", "1");
        d.put("10", 10);
        d.put("1", 12222);
        d.put("12", 12222);
        d.put("13", 12222);
        d.put("14", 12222);
        d.put("15", 12222);
        d.put("16", 10);
        d.put("17", 10);
        d.put("18", 10);
        d.put("5", 10);
        d.put("2", 10);
        d.put("3", 10);
        d.put("4", 10);
        d.put("5", 10);
        d.put("19", Integer.SIZE);
        d.put("20", Integer.SIZE);
        d.put("21", Integer.SIZE);
        d.put("22", Integer.SIZE);
        d.put("23", Integer.SIZE);
        d.put("24", Integer.SIZE);
        System.out.println(d.remove("22"));
        d.imprimirTabla();
        //System.out.println(d.remove(""));
        //d.imprimirTabla();
    }

}

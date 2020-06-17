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
        d.put("222", 12222);
        d.put("80", 12222);
        d.put("123", 10);
        d.put("12333", 10);
        d.put("4233", 10);

        d.imprimirTabla();
        //System.out.println(d.remove(""));
        //d.imprimirTabla();
    }

}

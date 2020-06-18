/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.modelo.DAO.DAOHashTable;
import com.modelo.HasTable.HashTable;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable<String, String> d = DAOHashTable.getData();

        d.containsKey("1");
        System.out.println(d.size());
        System.out.println(d.remove("12f"));
        d.imprimirTabla();
        //System.out.println(d.remove(""));
        //d.imprimirTabla();
    }

}

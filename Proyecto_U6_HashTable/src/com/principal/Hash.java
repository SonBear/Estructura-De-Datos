/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.principal;

import com.modelo.HasTable.HashTable;

/**
 *
 * @author emman
 */
public class Hash {

    public static void main(String[] args) {
        HashTable<String, String> d = new HashTable();

        d.put("123", "isai");
        d.put("carrot", "popd7");
        d.put("12", "sonBear");
        d.put("13", "kid");
        d.put("23", "hikking");
        d.put("1123", "carrot");
        d.put("122", "77");
        d.put("12313", "ajas");
        d.put("12413", "linux");
        d.put("12133", "pop");
        d.put("2", "popd1");
        d.put("3", "popd2");
        d.put("4", "popd3");
        d.put("5", "popd4");
        d.put("6", "popd5");
        d.put("7", "popd6");

        d.put("d", "popy");
        System.out.println(d.get("123"));
        System.out.println(d.containsKey("d"));
        System.out.println(d.size());

    }
}

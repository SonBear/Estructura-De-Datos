/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafo;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author emman
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        GrafoMatriz grafo = new GrafoMatriz();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {

            try {
                menu();
                System.out.print("Ingrese opcion: ");
                opcion = scanner.nextInt();
                System.out.println("");
                switch (opcion) {
                    case 0:
                        System.out.print("Ingrese numero de vertices: ");
                        int maximoDeVertices = scanner.nextInt();
                        grafo = new GrafoMatriz(maximoDeVertices);
                        break;
                    case 1:
                        System.out.print("Ingrse nombre del vertice a generar: ");
                        String nombre = scanner.next();
                        grafo.nuevoVertice(nombre);
                        break;
                    case 2:
                        System.out.println("Escribe el nombre de los vertices a enlazar");
                        vertices(grafo);
                        System.out.print("Nombre 1: ");
                        String nombre1,
                         nombre2;
                        nombre1 = scanner.next();
                        System.out.print("Nombre 2: ");
                        nombre2 = scanner.next();
                        grafo.nuevoArco(nombre1, nombre2);
                        break;
                    case 3:
                        System.out.println("Matriz Adyacencia");
                        System.out.println(grafo);
                        break;
                    case 4:
                        System.out.println("Elige el nombre del vertice inicial");
                        vertices(grafo);
                        System.out.print("Nombre vertice: ");
                        nombre = scanner.next();
                        System.out.println("--Recorrido---");
                        grafo.recorrerEnAnchura(nombre);
                        break;
                    default:
                        System.out.println("D");
                        break;
                }
            } catch (Exception ex) {

                System.out.println("--->Error " + ex.getMessage());
                scanner = new Scanner(System.in);

            }

        } while (opcion != -1);

    }

    public static void menu() {
        System.out.println("-----------------------------------");
        System.out.println("| Elija la opcion : -1 para SALIR |");
        System.out.println("| 0. Generar Grafo                |");
        System.out.println("| 1. Generar Vertice              |");
        System.out.println("| 2. Enlazar Vertices             |");
        System.out.println("| 3. Imprimir Matriz              |");
        System.out.println("| 4. Recorrido en anchura         |");
        System.out.println("-----------------------------------");
    }

    public static void vertices(GrafoMatriz grafo) {
        for (int i = 0; i < grafo.getVertices().length; i++) {
            if (grafo.getVertices()[i] != null) {
                System.out.println(grafo.getVertices()[i]);
            }

        }
    }

}

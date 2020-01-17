
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author emman
 */
public class NewMain {

    public static void main(String[] args) {

        Scanner leerInt = new Scanner(System.in);
        Scanner leerStr = new Scanner(System.in);
        int op;
        do {
            Pila pila = new Pila(10);
            Verificador ver = new Verificador(pila);
            System.out.print("Ingrese la palabra: ");
            String palabra = leerStr.nextLine();

            try {

                if (ver.verificarParentesis(palabra)) {
                    System.out.print("La palabra: " + "\"" + palabra + "\"");
                    System.out.println(" Contiene parentesis balanceados");
                } else {
                    System.out.print("La palabra: " + "\"" + palabra + "\"");
                    System.out.println(" No contiene parentesis balanceados");
                }

            } catch (ExpresionNoEvaluableException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.print("Ingrese 1 para continuar: ");
            op = leerInt.nextInt();
        } while (op == 1);

    }

}

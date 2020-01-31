

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author emman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cola<Integer> cola = new Cola<>();
        try {
            cola.insertar(1);
            cola.quitar();
            cola.insertar(0);
            cola.insertar(1);
            cola.insertar(2);
            cola.insertar(3);
            cola.insertar(4);
            cola.insertar(5);
            cola.insertar(6);
            cola.insertar(7);
            cola.insertar(8);
            cola.insertar(9);
            System.out.println(cola);
            System.out.println("El frente es: " + cola.frente());
            cola.quitar();
            System.out.println(cola);

        } catch (ColaVaciaException ex) {
            System.out.println(ex.getMessage());
        } catch (ColaLlenaException ex) {
            System.out.println(ex.getMessage());;
        }
    }

}

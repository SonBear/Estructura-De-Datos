
/**
 *
 * @author emman
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Cola<Integer> cola = new Cola<>(10, 0);
            cola.agregar(1);
            System.out.println("Valor eliminado: " + cola.quitar());
            cola.agregar(0);
            cola.agregar(1);
            cola.agregar(2);
            cola.agregar(3);
            cola.agregar(4);
            cola.agregar(5);
            cola.agregar(6);
            cola.agregar(7);
            cola.agregar(8);
            cola.agregar(9);
            System.out.println("Valor del frente: " + cola.frente());
            System.out.println("Valor eliminado: " + cola.quitar());
            cola.agregar(10);
            cola.agregar(11);

            System.out.println(cola);

        } catch (ColaVaciaException ex) {
            System.out.println(ex.getMessage());
        } catch (ColaLlenaException ex) {
            System.out.println(ex.getMessage());
        }
    }

}

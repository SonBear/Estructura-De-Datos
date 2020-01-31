
import java.util.logging.Level;
import java.util.logging.Logger;


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
            Cola<String> cola = new Cola<>(10, 0);
            cola.agregar("1");
            cola.agregar("2");
            cola.agregar("3");
            cola.agregar("4");
            cola.agregar("5");
            cola.agregar("6");
            cola.agregar("7");
            cola.agregar("8");
            cola.agregar("9");
            cola.agregar("10");
            System.out.println("El elemento eliminado fue: " + cola.quitar());
            cola.agregar("f");
            System.out.println(cola);
        } catch (ColaLlenaException ex) {
            System.out.println(ex.getMessage());
        } catch (ColaVaciaException ex) {
            System.out.println(ex.getMessage());
        }
    }

}


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
public class Verificador {

    private PilaEnlazada pila;

    public Verificador(PilaEnlazada pila) {
        this.pila = pila;
    }

    public boolean verificarParentesis(String dato) {
        char caracteres[] = dato.toCharArray();
        try {

            for (int i = 0; i < caracteres.length; i++) {
                if (caracteres[i] == '(') {
                    pila.push('(');
                } else if (caracteres[i] == ')') {
                    pila.pop();
                }

            }

            return pila.getLista().isEmpty();

        } catch (PilaVaciaException ex) {
            return false;
        }
    }
}

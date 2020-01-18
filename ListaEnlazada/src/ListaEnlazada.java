
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author emman
 */
public class ListaEnlazada {

    Nodo head;

    public void agregarInicio(Nodo n) {
        if (isEmpty()) {
            head = n;
        } else {
            n.setNext(head);
            head = n;
        }
    }

    public void agregarFinal(Nodo n) {
        if (isEmpty()) {
            head = n;
        } else {
            Nodo temp = head;

            while (temp != null) {
                if (temp.getNext() == null) {
                    temp.setNext(n);
                    return;
                }
                temp = temp.getNext();

            }

        }

    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        Nodo temp = head;
        ArrayList<String> variables = new ArrayList();
        while (temp != null) {

            variables.add(temp.getDate() + " -> ");
            temp = temp.getNext();
            if (temp == null) {
                variables.add("NULL");
            }
        }
        String salida = "";
        for (int i = 0; i < variables.size(); i++) {
            salida += variables.get(i);
        }
        return salida;
    }

}

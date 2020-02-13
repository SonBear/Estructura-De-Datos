package Modelo;

import Modelo.Exceptions.DequeEmptyException;
import Modelo.Exceptions.ValorEntradaVuelosException;
import Modelo.Exceptions.AvionNotFoundException;
import Modelo.Exceptions.StackEmptyException;
import Modelo.Utilities.Stack;
import Modelo.Utilities.CalculadoraDeNumeros;
import Modelo.Utilities.StackDeque;
import Modelo.Utilities.DLDeque;
import Modelo.Utilities.Deque;

public class SistemaDeVuelos extends Thread {

    private Deque<Avion> colaAviones;
    private Stack<Avion> pilaTemporal;
    private final int LIMITEVUELOS = 500;

    public SistemaDeVuelos() {
        colaAviones = new DLDeque<>();
        pilaTemporal = new StackDeque<>();
    }

    public void generarVuelos(int numeroDeVuelos) throws ValorEntradaVuelosException {
        if (numeroDeVuelos > LIMITEVUELOS || numeroDeVuelos <= 0) {
            throw new ValorEntradaVuelosException("Error en el ingreso de datos");
        }
        int[] idAviones = CalculadoraDeNumeros.generarNumerosAleatorio(numeroDeVuelos, LIMITEVUELOS);
        for (int i = 0; i < idAviones.length; i++) {
            agregarAvion(idAviones[i]);
        }
    }

    public void agregarAvion(int id) {
        colaAviones.insertLast(new Avion(id));
    }

    public void eliminarAvion() {
        try {
            colaAviones.removeFirst();
        } catch (DequeEmptyException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void priorizarAvion(Avion avion) throws AvionNotFoundException {
        try {
            if (colaAviones.first().getId() == avion.getId()) {
                System.out.println("El avion " + colaAviones.removeFirst() + " ha salido");
            } else {
                while (colaAviones.first().getId() != avion.getId()) {
                    pilaTemporal.push(colaAviones.removeFirst());
                    if (colaAviones.first().getId() == avion.getId()) {
                        System.out.println("El avion con id " + colaAviones.removeFirst().getId() + " ha salido");
                        break;
                    }
                }

                addFont();
            }

        } catch (DequeEmptyException ex) {
            addFont();

            throw new AvionNotFoundException("Avion no encontrado");
        }

    }

    private void addFont() {
        try {
            while (!pilaTemporal.isEmpty()) {
                colaAviones.insertFirst(pilaTemporal.pop());
            }

        } catch (StackEmptyException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Deque<Avion> getColaAviones() {
        return colaAviones;
    }

    public Stack<Avion> getPilaTemporal() {
        return pilaTemporal;
    }

    public String[] getCopiaAviones() {

        String aviones[] = colaAviones.toString().split(" <=> ");

        return aviones;
    }

    @Override
    public String toString() {
        return colaAviones.toString();
    }

    public void elminarTodo() {
        while (!colaAviones.isEmpty()) {
            try {
                colaAviones.removeLast();
            } catch (DequeEmptyException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}

package Modelo;

public class SistemaDeVuelos extends Thread {

    private QueueAvion colaAviones;
    private StackDeque<Avion> pilaTemporal;

    public SistemaDeVuelos() {
        colaAviones = new QueueAvion();
        pilaTemporal = new StackDeque<>();
    }

    public void generarVuelos(int numeroDeVuelos) {
        colaAviones = new QueueAvion();
        for (int i = 0; i < numeroDeVuelos; i++) {
            int valorEntero = (int) Math.floor(Math.random() * (100 - 301) + 300);
            colaAviones.enqueue(new Avion(valorEntero));
        }
    }

    public void agregarAvion(Avion avion) {
        colaAviones.enqueue(avion);
    }

    public void eliminarAvion() throws QueueEmptyException {
        try {
            colaAviones.dequeue();
        } catch (QueueEmptyException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void priorizarAvion(Avion avion) throws QueueEmptyException {
        try {
            if (colaAviones.font().getId() == avion.getId()) {
                System.out.println("El avion " + colaAviones.dequeue() + " ha salido");
            } else {
                while (colaAviones.font().getId() != avion.getId()) {
                    pilaTemporal.push(colaAviones.dequeue());
                    if (colaAviones.font().getId() == avion.getId()) {
                        System.out.println("El avion con id " + colaAviones.font().getId() + " ha salido");
                        colaAviones.dequeue();
                        break;
                    }
                }

                addFont();
            }

        } catch (QueueEmptyException ex) {
            addFont();
            throw new QueueEmptyException("ColaLlena");
        }

    }

    private void addFont() {
        try {
            while (!pilaTemporal.isEmpty()) {
                colaAviones.insertFont(pilaTemporal.pop());
            }

        } catch (StackEmptyException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public QueueDeque<Avion> getColaAviones() {
        return colaAviones;
    }

    public StackDeque<Avion> getPilaTemporal() {
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

}

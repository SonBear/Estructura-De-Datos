package Modelo;

public class QueueAvion extends QueueDeque<Avion> {

    public void insertFont(Avion e) {
        super.getDeque().insertFirst(e);
    }

}

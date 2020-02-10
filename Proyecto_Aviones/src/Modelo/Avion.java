package Modelo;

public class Avion {

    private int id;

    public Avion(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Avion #" + id;
    }

}

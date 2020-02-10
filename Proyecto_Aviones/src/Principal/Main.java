package Principal;

import Controlador.Controlador;
import Modelo.SistemaDeVuelos;
import Vista.MenuPrincipal;

public class Main {

    public static void main(String[] args) {
        Controlador cont = new Controlador(new MenuPrincipal(), new SistemaDeVuelos());
        cont.iniciar();

    }
}

package com.controladores;

import com.modelo.Administrador;
import com.vista.MenuNuevo;
import java.awt.event.ActionEvent;

/**
 *
 * @author emman
 */
public class ControllerNuevo {

    private MenuNuevo menu = new MenuNuevo();
    private ControllerRuta contRuta;
    private Administrador admi;

    public ControllerNuevo(Administrador admi) {
        this.admi = admi;
        contRuta = new ControllerRuta(admi);
        initComponents();
    }

    public void iniciar() {
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
    }

    public void initComponents() {
        menu.getBtnCrear().addActionListener(this::crear);
    }

    public void crear(ActionEvent e) {
        try {
            String nombre = menu.getTxtNombre().getText();
            String correo = menu.getTxtCorreo().getText();
            int edad = Integer.parseInt(menu.getTxtEdad().getText());
            String contraseña = menu.getTxtContr().getText();
            contRuta.setValores(correo, nombre, correo, contraseña, edad);
            contRuta.inciar();
            menu.dispose();
        } catch (NumberFormatException ex) {
            menu.error("Datos incorrectos");
        } catch (Exception ex) {
            menu.error(ex.getMessage());
        }
    }

}

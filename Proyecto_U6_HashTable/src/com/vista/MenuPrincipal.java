package com.vista;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author emman
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        labelCorreo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        ItemListarContactos = new javax.swing.JMenuItem();
        ItemListarTodos = new javax.swing.JMenuItem();
        menuEditar = new javax.swing.JMenu();
        ItemBuscar = new javax.swing.JMenuItem();
        ItemEliminarCon = new javax.swing.JMenuItem();
        ItemLogOut = new javax.swing.JMenuItem();
        ItemBorrarCuenta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tus datos"));

        labelUsuario.setText("Usuario: ");

        labelCorreo.setText("Correo: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCorreo)
                    .addComponent(labelUsuario))
                .addContainerGap(447, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelUsuario)
                .addGap(33, 33, 33)
                .addComponent(labelCorreo)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel2.setBackground(new java.awt.Color(102, 153, 255));
        jLabel2.setForeground(new java.awt.Color(102, 153, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/vista/img/Banner - copia (3).png"))); // NOI18N
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        MenuArchivo.setText("Archivo");

        ItemListarContactos.setText("Listar mis contactos");
        MenuArchivo.add(ItemListarContactos);

        ItemListarTodos.setText("Listar todos");
        MenuArchivo.add(ItemListarTodos);

        menuBar.add(MenuArchivo);

        menuEditar.setText("Editar");

        ItemBuscar.setText("Buscar");
        menuEditar.add(ItemBuscar);

        ItemEliminarCon.setText("Eliminar contacto");
        menuEditar.add(ItemEliminarCon);

        ItemLogOut.setText("Cerrar sesión");
        ItemLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemLogOutActionPerformed(evt);
            }
        });
        menuEditar.add(ItemLogOut);

        ItemBorrarCuenta.setText("Borrar mi cuenta");
        menuEditar.add(ItemBorrarCuenta);

        menuBar.add(menuEditar);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemLogOutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemLogOutActionPerformed

    public JMenuItem getItemListarContactos() {
        return ItemListarContactos;
    }

    public JMenuItem getItemListarTodos() {
        return ItemListarTodos;
    }

    public JMenuItem getItemBorrarCuenta() {
        return ItemBorrarCuenta;
    }

    public JMenuItem getItemBuscar() {
        return ItemBuscar;
    }

    public JMenuItem getItemEliminarCon() {
        return ItemEliminarCon;
    }

    public JLabel getLabelCorreo() {
        return labelCorreo;
    }

    public JLabel getLabelUsuario() {
        return labelUsuario;
    }

    public JMenuItem getItemLogOut() {
        return ItemLogOut;
    }

    public void error(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Mensaje", JOptionPane.INFORMATION_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemBorrarCuenta;
    private javax.swing.JMenuItem ItemBuscar;
    private javax.swing.JMenuItem ItemEliminarCon;
    private javax.swing.JMenuItem ItemListarContactos;
    private javax.swing.JMenuItem ItemListarTodos;
    private javax.swing.JMenuItem ItemLogOut;
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelCorreo;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEditar;
    // End of variables declaration//GEN-END:variables
}

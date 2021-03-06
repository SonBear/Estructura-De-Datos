/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

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
        setButtonGroup();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        grupoArboles = new javax.swing.ButtonGroup();
        txtRuta = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        checkNombre = new javax.swing.JCheckBox();
        checkProfesion = new javax.swing.JCheckBox();
        CheckPromedio = new javax.swing.JCheckBox();
        txtNombre = new javax.swing.JTextField();
        txtPromedio = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPrincipal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnBuscarParametro = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        boxProfesion = new javax.swing.JComboBox();
        arbolAvl = new javax.swing.JRadioButton();
        arbolABB = new javax.swing.JRadioButton();
        arbolB = new javax.swing.JRadioButton();
        btnGenerar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Egresados");
        setMinimumSize(new java.awt.Dimension(900, 450));

        btnBuscar.setText("Buscar Archivo");
        btnBuscar.setActionCommand("buscar");

        checkNombre.setText("Nombre");

        checkProfesion.setText("Profesion");

        CheckPromedio.setText("Promedio");

        tablaPrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Profesion", "Promedio"
            }
        ));
        jScrollPane1.setViewportView(tablaPrincipal);

        jLabel1.setText("Ruta de la lista de egresados");

        btnBuscarParametro.setText("buscar");
        btnBuscarParametro.setActionCommand("buscarParametros");

        btnOk.setText("Ok");
        btnOk.setActionCommand("ok");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        boxProfesion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Profesiones" }));

        arbolAvl.setText("ArbolAVL");

        arbolABB.setText("ArbolABB");

        arbolB.setText("ArbolB");

        btnGenerar.setText("Generar Arbol");
        btnGenerar.setActionCommand("generarArbol");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkNombre)
                                .addGap(17, 17, 17)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CheckPromedio)
                                .addGap(11, 11, 11)
                                .addComponent(txtPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(checkProfesion)
                                .addGap(9, 9, 9)
                                .addComponent(boxProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btnBuscarParametro))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(arbolAvl)
                                .addGap(31, 31, 31)
                                .addComponent(arbolABB)
                                .addGap(41, 41, 41)
                                .addComponent(arbolB)
                                .addGap(27, 27, 27)
                                .addComponent(btnGenerar)))
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRuta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addComponent(btnBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(btnOk)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtRuta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arbolAvl)
                            .addComponent(arbolABB)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(arbolB)
                                .addComponent(btnGenerar)))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CheckPromedio)
                            .addComponent(txtPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkProfesion)
                            .addComponent(boxProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(btnBuscarParametro))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnOk)
                        .addComponent(btnBuscar)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOkActionPerformed

    public JComboBox getBoxProfesion() {
        return boxProfesion;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtPromedio() {
        return txtPromedio;
    }

    public JCheckBox getCheckPromedio() {
        return CheckPromedio;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JCheckBox getCheckNombre() {
        return checkNombre;
    }

    public JCheckBox getCheckProfesion() {
        return checkProfesion;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JTable getTablaPrincipal() {
        return tablaPrincipal;
    }

    public JTextField getTxtRuta() {
        return txtRuta;
    }

    public JButton getBuscarParametro() {
        return btnBuscarParametro;
    }

    private void setButtonGroup() {
        arbolABB.setActionCommand("ArbolABB");
        grupoArboles.add(arbolABB);
        arbolAvl.setActionCommand("ArbolAVL");

        grupoArboles.add(arbolAvl);
        arbolB.setActionCommand("ArbolB");
        grupoArboles.add(arbolB);
    }

    public JButton getBtnGenerar() {
        return btnGenerar;
    }

    public JButton getBtnOk() {
        return btnOk;
    }

    public ButtonGroup getGrupoArboles() {
        return grupoArboles;
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckPromedio;
    private javax.swing.JRadioButton arbolABB;
    private javax.swing.JRadioButton arbolAvl;
    private javax.swing.JRadioButton arbolB;
    private javax.swing.JComboBox boxProfesion;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarParametro;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnOk;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox checkNombre;
    private javax.swing.JCheckBox checkProfesion;
    private javax.swing.ButtonGroup grupoArboles;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPrincipal;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPromedio;
    private javax.swing.JTextField txtRuta;
    // End of variables declaration//GEN-END:variables
}

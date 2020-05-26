/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author emman
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setButtonGroup();
        this.setBackground(new Color(115, 51, 134));
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnGenerar = new javax.swing.JButton();
        txtGenerar = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bMatriz = new javax.swing.JRadioButton();
        bLista = new javax.swing.JRadioButton();
        txtNombre = new javax.swing.JTextField();
        btnAgregarVertice = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAgragarEnlace = new javax.swing.JButton();
        txtEliminarVertice = new javax.swing.JTextField();
        btnEliminarVertice = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnEliminarUnion = new javax.swing.JButton();
        txtEliminarU1 = new javax.swing.JTextField();
        txtEliminarU2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnBuscarAnchura = new javax.swing.JButton();
        txtBuscarAnchura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnBuscarProfundidad = new javax.swing.JButton();
        txtBuscarProfundidad = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnRecorridoAnchura = new javax.swing.JButton();
        btnProfundidad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dibujador Grafo");
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1200, 720));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 922, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setBackground(new java.awt.Color(46, 2, 59));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/barraGrafica.png"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(182, 111, 204));

        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnGenerar.png"))); // NOI18N
        btnGenerar.setActionCommand("Generar");
        btnGenerar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGenerar.setBorderPainted(false);
        btnGenerar.setContentAreaFilled(false);
        btnGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerar.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btnGenerar.setFocusPainted(false);
        btnGenerar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnGenerar2.png"))); // NOI18N

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tamaño ");

        bMatriz.setForeground(new java.awt.Color(255, 255, 255));
        bMatriz.setText("Matriz");
        bMatriz.setBorder(null);
        bMatriz.setContentAreaFilled(false);

        bLista.setForeground(new java.awt.Color(255, 255, 255));
        bLista.setText("Lista");
        bLista.setBorder(null);
        bLista.setContentAreaFilled(false);

        btnAgregarVertice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnAgregarVertice.png"))); // NOI18N
        btnAgregarVertice.setActionCommand("Agregar Vertice");
        btnAgregarVertice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgregarVertice.setBorderPainted(false);
        btnAgregarVertice.setContentAreaFilled(false);
        btnAgregarVertice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarVertice.setFocusPainted(false);
        btnAgregarVertice.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnAgregarVertice2.png"))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre vertice");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Vertice destino");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vertice origen");

        btnAgragarEnlace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnAgregarEnlace.png"))); // NOI18N
        btnAgragarEnlace.setActionCommand("Agregar Enlace");
        btnAgragarEnlace.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAgragarEnlace.setBorderPainted(false);
        btnAgragarEnlace.setContentAreaFilled(false);
        btnAgragarEnlace.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgragarEnlace.setFocusPainted(false);
        btnAgragarEnlace.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnAgregarEnlace2.png"))); // NOI18N

        btnEliminarVertice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnEliminarVertice.png"))); // NOI18N
        btnEliminarVertice.setActionCommand("Eliminar Vertice");
        btnEliminarVertice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarVertice.setBorderPainted(false);
        btnEliminarVertice.setContentAreaFilled(false);
        btnEliminarVertice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarVertice.setFocusPainted(false);
        btnEliminarVertice.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnEliminarVertice2.png"))); // NOI18N

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Nombre Vertice");

        btnEliminarUnion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnEliminarEnlace.png"))); // NOI18N
        btnEliminarUnion.setActionCommand("Eliminar Enlace");
        btnEliminarUnion.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminarUnion.setBorderPainted(false);
        btnEliminarUnion.setContentAreaFilled(false);
        btnEliminarUnion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarUnion.setFocusPainted(false);
        btnEliminarUnion.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnEliminarEnlace2.png"))); // NOI18N

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Vertice destino");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Vertice origen");

        btnBuscarAnchura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnBuscarPorArchura.png"))); // NOI18N
        btnBuscarAnchura.setActionCommand("Buscar Anchura");
        btnBuscarAnchura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarAnchura.setBorderPainted(false);
        btnBuscarAnchura.setContentAreaFilled(false);
        btnBuscarAnchura.setFocusPainted(false);
        btnBuscarAnchura.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnBuscarPorArchura2.png"))); // NOI18N

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nombre vertice");

        btnBuscarProfundidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnBuscarPorProfundidad.png"))); // NOI18N
        btnBuscarProfundidad.setActionCommand("Buscar Profundidad");
        btnBuscarProfundidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBuscarProfundidad.setBorderPainted(false);
        btnBuscarProfundidad.setContentAreaFilled(false);
        btnBuscarProfundidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarProfundidad.setFocusPainted(false);
        btnBuscarProfundidad.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnBuscarPorProfundidad2.png"))); // NOI18N

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Nombre Vertice");

        btnRecorridoAnchura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnRecorridoAnchura.png"))); // NOI18N
        btnRecorridoAnchura.setActionCommand("Recorrido Anchura");
        btnRecorridoAnchura.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRecorridoAnchura.setBorderPainted(false);
        btnRecorridoAnchura.setContentAreaFilled(false);
        btnRecorridoAnchura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecorridoAnchura.setFocusPainted(false);
        btnRecorridoAnchura.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnRecorridoAnchura2.png"))); // NOI18N

        btnProfundidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnRecorridoProfundidadpng.png"))); // NOI18N
        btnProfundidad.setActionCommand("Recorrido Profundidad");
        btnProfundidad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnProfundidad.setBorderPainted(false);
        btnProfundidad.setContentAreaFilled(false);
        btnProfundidad.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProfundidad.setFocusPainted(false);
        btnProfundidad.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/btnRecorridoProfundidad2png.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGenerar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(bMatriz))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(bLista))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(btnAgregarVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(btnAgragarEnlace))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEliminarVertice, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(btnEliminarVertice))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEliminarU1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEliminarU2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(btnEliminarUnion))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarAnchura, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(btnBuscarAnchura))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscarProfundidad, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(btnBuscarProfundidad))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnRecorridoAnchura)
                        .addGap(3, 3, 3)
                        .addComponent(btnProfundidad)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel5))
                    .addComponent(btnGenerar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bMatriz)
                            .addComponent(bLista))))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2))
                    .addComponent(btnAgregarVertice))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel4))
                    .addComponent(btnAgragarEnlace))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEliminarVertice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel6))
                    .addComponent(btnEliminarVertice))
                .addGap(66, 66, 66)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEliminarU1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtEliminarU2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel8))
                    .addComponent(btnEliminarUnion))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscarAnchura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel9))
                    .addComponent(btnBuscarAnchura))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBuscarProfundidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel10))
                    .addComponent(btnBuscarProfundidad))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRecorridoAnchura)
                    .addComponent(btnProfundidad))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnBuscarAnchura() {
        return btnBuscarAnchura;
    }

    public JButton getBtnBuscarProfundidad() {
        return btnBuscarProfundidad;
    }

    public JTextField getTxtBuscarAnchura() {
        return txtBuscarAnchura;
    }

    public JTextField getTxtBuscarProfundidad() {
        return txtBuscarProfundidad;
    }

    public JButton getBtnEliminarUnion() {
        return btnEliminarUnion;
    }

    public JButton getBtnEliminarVertice() {
        return btnEliminarVertice;
    }

    public JButton getBtnRecorridoAnchura() {
        return btnRecorridoAnchura;
    }

    public JButton getBtnAgragarEnlace() {
        return btnAgragarEnlace;
    }

    public JButton getBtnAgregarVertice() {
        return btnAgregarVertice;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtNombre1() {
        return txtNombre1;
    }

    public JTextField getTxtNombre2() {
        return txtNombre2;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public ButtonGroup getButtonGroup() {
        return buttonGroup;
    }

    public JButton getBtnGenerar() {
        return btnGenerar;
    }

    public JTextField getTxtGenerar() {
        return txtGenerar;
    }

    public JButton getBtnProfundidad() {
        return btnProfundidad;
    }

    public JTextField getTxtEliminarU2() {
        return txtEliminarU2;
    }

    public JTextField getTxtEliminarU1() {
        return txtEliminarU1;
    }

    public JTextField getTxtEliminarVertice() {
        return txtEliminarVertice;
    }

    public void setButtonGroup() {
        buttonGroup = new ButtonGroup();
        bLista.setActionCommand("ListaAdyacencia");
        bMatriz.setActionCommand("MatrizAdyacencia");
        buttonGroup.add(bLista);
        buttonGroup.add(bMatriz);
    }

    private ButtonGroup buttonGroup;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton bLista;
    private javax.swing.JRadioButton bMatriz;
    private javax.swing.JButton btnAgragarEnlace;
    private javax.swing.JButton btnAgregarVertice;
    private javax.swing.JButton btnBuscarAnchura;
    private javax.swing.JButton btnBuscarProfundidad;
    private javax.swing.JButton btnEliminarUnion;
    private javax.swing.JButton btnEliminarVertice;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnProfundidad;
    private javax.swing.JButton btnRecorridoAnchura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtBuscarAnchura;
    private javax.swing.JTextField txtBuscarProfundidad;
    private javax.swing.JTextField txtEliminarU1;
    private javax.swing.JTextField txtEliminarU2;
    private javax.swing.JTextField txtEliminarVertice;
    private javax.swing.JTextField txtGenerar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtNombre2;
    // End of variables declaration//GEN-END:variables
}

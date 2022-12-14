/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import ModelosD.Boleto;
import java.util.logging.Level;
import java.util.logging.Logger;
import mysqlImplements.DAOException;
import mysqlImplements.MySQLDaoManager;

/**
 *
 * @author braul
 */
public class VentanaInicio extends javax.swing.JPanel {

    /**
     * Creates new form Inicio
     */
    public VentanaInicio() {
        initComponents();
        
        cb_Partidos.removeAllItems();
        cb_Partidos.addItem("87");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelTabla = new javax.swing.JPanel();
        panelDetallesBoleto = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_NomLugar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cb_EquipoUno = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cb_EquipoDos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tf_FechaPartido = new javax.swing.JTextField();
        cb_HoraPartido = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tf_ClvBoleto = new javax.swing.JTextField();
        cb_Partidos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Boletos = new javax.swing.JTable();

        setBackground(new java.awt.Color(243, 243, 243));
        setMaximumSize(new java.awt.Dimension(980, 690));
        setMinimumSize(new java.awt.Dimension(980, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelTabla.setLayout(new java.awt.BorderLayout());

        panelDetallesBoleto.setMaximumSize(new java.awt.Dimension(300, 134));
        panelDetallesBoleto.setMinimumSize(new java.awt.Dimension(300, 134));
        panelDetallesBoleto.setVerifyInputWhenFocusTarget(false);

        jLabel2.setText("Clave del Partido(#):");

        jLabel3.setText("Nobre del estadio:");

        jLabel4.setText("Equipo local:");

        cb_EquipoUno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_EquipoUno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_EquipoUnoActionPerformed(evt);
            }
        });

        jLabel5.setText("Equipo visitante:");

        cb_EquipoDos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setText("Fecha:");

        jLabel7.setText("Hora:");

        jLabel1.setText("Clave de  Boleto:");

        cb_Partidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelDetallesBoletoLayout = new javax.swing.GroupLayout(panelDetallesBoleto);
        panelDetallesBoleto.setLayout(panelDetallesBoletoLayout);
        panelDetallesBoletoLayout.setHorizontalGroup(
            panelDetallesBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesBoletoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelDetallesBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetallesBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_NomLugar)
                    .addComponent(cb_EquipoUno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cb_EquipoDos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_FechaPartido)
                    .addComponent(tf_ClvBoleto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelDetallesBoletoLayout.createSequentialGroup()
                        .addComponent(cb_HoraPartido, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(cb_Partidos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelDetallesBoletoLayout.setVerticalGroup(
            panelDetallesBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesBoletoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(panelDetallesBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_ClvBoleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panelDetallesBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_Partidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelDetallesBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_NomLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(panelDetallesBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_EquipoUno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(panelDetallesBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_EquipoDos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelDetallesBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tf_FechaPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelDetallesBoletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_HoraPartido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(228, Short.MAX_VALUE))
        );

        panelTabla.add(panelDetallesBoleto, java.awt.BorderLayout.LINE_END);

        tb_Boletos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tb_Boletos);

        panelTabla.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(panelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 980, 560));
    }// </editor-fold>//GEN-END:initComponents

    private void cb_EquipoUnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_EquipoUnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_EquipoUnoActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_EquipoDos;
    private javax.swing.JComboBox<String> cb_EquipoUno;
    private javax.swing.JComboBox<String> cb_HoraPartido;
    private javax.swing.JComboBox<String> cb_Partidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelDetallesBoleto;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tb_Boletos;
    private javax.swing.JTextField tf_ClvBoleto;
    private javax.swing.JTextField tf_FechaPartido;
    private javax.swing.JTextField tf_NomLugar;
    // End of variables declaration//GEN-END:variables
}

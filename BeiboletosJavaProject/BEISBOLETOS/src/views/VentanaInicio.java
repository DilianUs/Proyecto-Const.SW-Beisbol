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

        cb_Partidos = new javax.swing.JComboBox<>();
        input_ClvBoleto = new javax.swing.JTextField();
        btn_GenerarBoleto = new javax.swing.JButton();

        setBackground(new java.awt.Color(243, 243, 243));
        setMaximumSize(new java.awt.Dimension(980, 690));
        setMinimumSize(new java.awt.Dimension(980, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_Partidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cb_Partidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 110, 30));

        input_ClvBoleto.setText("Clave del boleto");
        add(input_ClvBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        btn_GenerarBoleto.setText("Generar Boleto");
        btn_GenerarBoleto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GenerarBoletoActionPerformed(evt);
            }
        });
        add(btn_GenerarBoleto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GenerarBoletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GenerarBoletoActionPerformed
        // TODO add your handling code here:
        int clave = Integer.parseInt(input_ClvBoleto.getText());
        int partido=Integer.parseInt(cb_Partidos.getSelectedItem().toString());
        Boleto nuevoBoleto = new Boleto(clave, partido);
        MySQLDaoManager manager = new MySQLDaoManager();
        try {
            manager.getBoletoDAO().agregar(nuevoBoleto);
        } catch (DAOException ex) {
            Logger.getLogger(VentanaInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btn_GenerarBoletoActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_GenerarBoleto;
    private javax.swing.JComboBox<String> cb_Partidos;
    private javax.swing.JTextField input_ClvBoleto;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

/**
 *
 * @author braul
 */
public class Ventas extends javax.swing.JFrame {

    /**
     * Creates new form inicio
     */
    public Ventas() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        beiboletos1 = new com.mycompany.beiboletos.Beiboletos();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnInicio = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPartidos = new javax.swing.JButton();
        btnEquipos = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnInicio.setText("Inicio");
        jPanel2.add(btnInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 150, 40));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Logo");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 90, 50));

        btnPartidos.setText("Partidos");
        jPanel2.add(btnPartidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 150, 40));

        btnEquipos.setText("Equipos");
        btnEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiposActionPerformed(evt);
            }
        });
        jPanel2.add(btnEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 150, 40));

        btnVentas.setText("Ventas");
        jPanel2.add(btnVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 150, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 750));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Reporte");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));
        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 700, 350));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Registro");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, -1, -1));
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 550, 650, 80));
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 640, 650, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEquiposActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.beiboletos.Beiboletos beiboletos1;
    private javax.swing.JButton btnEquipos;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnPartidos;
    private javax.swing.JButton btnVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
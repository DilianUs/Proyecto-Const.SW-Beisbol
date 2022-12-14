package views;

import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *
 * @author braul
 */
public class VistaPrincipal extends javax.swing.JFrame {
   

    /**
     * Creates new form Plantilla
     */
    public VistaPrincipal() {
        initComponents();
                 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        btn_Inicio = new javax.swing.JButton();
        btn_Partidos = new javax.swing.JButton();
        btn_Equipos = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Title = new javax.swing.JPanel();
        btn_Exit = new javax.swing.JButton();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setMaximumSize(new java.awt.Dimension(1280, 720));
        Background.setMinimumSize(new java.awt.Dimension(1280, 720));
        Background.setPreferredSize(new java.awt.Dimension(1280, 720));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Inicio.setBackground(new java.awt.Color(217, 217, 217));
        btn_Inicio.setIcon(new javax.swing.ImageIcon("C:\\Users\\braul\\Desktop\\carpetas escritorio\\proyectobeibol\\Proyecto-Const.SW-Beisbol\\BeiboletosJavaProject\\BEISBOLETOS\\src\\vistas\\images\\home.png")); // NOI18N
        btn_Inicio.setText("inicio");
        btn_Inicio.setBorderPainted(false);
        btn_Inicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Inicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_Inicio.setIconTextGap(10);
        btn_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InicioActionPerformed(evt);
            }
        });
        Menu.add(btn_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 220, 50));

        btn_Partidos.setBackground(new java.awt.Color(217, 217, 217));
        btn_Partidos.setIcon(new javax.swing.ImageIcon("C:\\Users\\braul\\Desktop\\carpetas escritorio\\proyectobeibol\\Proyecto-Const.SW-Beisbol\\BeiboletosJavaProject\\BEISBOLETOS\\src\\vistas\\images\\trophy.png")); // NOI18N
        btn_Partidos.setText("Partidos");
        btn_Partidos.setBorderPainted(false);
        btn_Partidos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Partidos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_Partidos.setIconTextGap(10);
        btn_Partidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_PartidosActionPerformed(evt);
            }
        });
        Menu.add(btn_Partidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 220, 50));

        btn_Equipos.setBackground(new java.awt.Color(217, 217, 217));
        btn_Equipos.setIcon(new javax.swing.ImageIcon("C:\\Users\\braul\\Desktop\\carpetas escritorio\\proyectobeibol\\Proyecto-Const.SW-Beisbol\\BeiboletosJavaProject\\BEISBOLETOS\\src\\vistas\\images\\users.png")); // NOI18N
        btn_Equipos.setText("Equipos");
        btn_Equipos.setBorderPainted(false);
        btn_Equipos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Equipos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btn_Equipos.setIconTextGap(10);
        btn_Equipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EquiposActionPerformed(evt);
            }
        });
        Menu.add(btn_Equipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 220, 50));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/images/3b58d367580c33942dd60f6d20294a71.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        Menu.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 170, 170));

        Background.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        Title.setMaximumSize(new java.awt.Dimension(1270, 32));
        Title.setMinimumSize(new java.awt.Dimension(1270, 32));
        Title.setPreferredSize(new java.awt.Dimension(1270, 32));
        Title.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_Exit.setBorder(null);
        Title.add(btn_Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 0, 50, 30));

        Background.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 30));

        content.setBackground(new java.awt.Color(243, 243, 243));
        content.setMaximumSize(new java.awt.Dimension(980, 690));
        content.setMinimumSize(new java.awt.Dimension(980, 690));
        content.setLayout(new java.awt.GridLayout(1, 0));
        Background.add(content, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 980, 690));

        getContentPane().add(Background, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_PartidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_PartidosActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_btn_PartidosActionPerformed

    private void btn_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InicioActionPerformed
        // TODO add your handling code here:
        
  
    }//GEN-LAST:event_btn_InicioActionPerformed

    private void btn_EquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EquiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_EquiposActionPerformed


   
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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Title;
    private javax.swing.JButton btn_Equipos;
    private javax.swing.JButton btn_Exit;
    private javax.swing.JButton btn_Inicio;
    private javax.swing.JButton btn_Partidos;
    private javax.swing.JPanel content;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

    public JButton getBtn_Equipos() {
        return btn_Equipos;
    }

    public JButton getBtn_Exit() {
        return btn_Exit;
    }

    public JButton getBtn_Inicio() {
        return btn_Inicio;
    }

    public JButton getBtn_Partidos() {
        return btn_Partidos;
    }

    public JPanel getContent() {
        return content;
    }
    
    
}

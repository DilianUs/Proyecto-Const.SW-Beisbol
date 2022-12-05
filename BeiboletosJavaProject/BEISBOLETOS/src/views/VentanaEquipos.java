package views;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;



/**
 *
 * @author braul
 */
public class VentanaEquipos extends javax.swing.JPanel {

    public VentanaEquipos() {
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

        jLabel1 = new javax.swing.JLabel();
        panelTabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_Equipos = new javax.swing.JTable();
        panelDetallesEquipo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tf_ClvEquipo = new javax.swing.JTextField();
        tf_NomEquipo = new javax.swing.JTextField();
        btn_Nuevo = new javax.swing.JButton();
        btn_Editar = new javax.swing.JButton();
        btn_Borrar = new javax.swing.JButton();
        btn_Guardar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(980, 690));
        setMinimumSize(new java.awt.Dimension(980, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Equipos");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        panelTabla.setLayout(new java.awt.BorderLayout());

        tb_Equipos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_Equipos);

        panelTabla.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelDetallesEquipo.setMaximumSize(new java.awt.Dimension(300, 134));
        panelDetallesEquipo.setMinimumSize(new java.awt.Dimension(300, 134));
        panelDetallesEquipo.setPreferredSize(new java.awt.Dimension(300, 134));
        panelDetallesEquipo.setVerifyInputWhenFocusTarget(false);

        jLabel2.setText("Clave del Equipo(#):");

        jLabel3.setText("Nombre del Equipo:");

        tf_ClvEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_ClvEquipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDetallesEquipoLayout = new javax.swing.GroupLayout(panelDetallesEquipo);
        panelDetallesEquipo.setLayout(panelDetallesEquipoLayout);
        panelDetallesEquipoLayout.setHorizontalGroup(
            panelDetallesEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesEquipoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelDetallesEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelDetallesEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_NomEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(tf_ClvEquipo))
                .addContainerGap())
        );
        panelDetallesEquipoLayout.setVerticalGroup(
            panelDetallesEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetallesEquipoLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelDetallesEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tf_ClvEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(panelDetallesEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tf_NomEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(455, Short.MAX_VALUE))
        );

        panelTabla.add(panelDetallesEquipo, java.awt.BorderLayout.LINE_END);

        add(panelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 980, 560));

        btn_Nuevo.setText("Nuevo");
        add(btn_Nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        btn_Editar.setText("Editar");
        add(btn_Editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        btn_Borrar.setText("Borrar");
        add(btn_Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, -1, -1));

        btn_Guardar.setText("Guardar");
        add(btn_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, -1));

        btn_Cancelar.setText("Cancelar");
        add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tf_ClvEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_ClvEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_ClvEquipoActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Borrar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JButton btn_Nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelDetallesEquipo;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tb_Equipos;
    private javax.swing.JTextField tf_ClvEquipo;
    private javax.swing.JTextField tf_NomEquipo;
    // End of variables declaration//GEN-END:variables

   

    public JTable getTb_Equipos() {
        return tb_Equipos;
    }

    public JTextField getTf_ClvEquipo() {
        return tf_ClvEquipo;
    }

    public JTextField getTf_NomEquipo() {
        return tf_NomEquipo;
    }

    public JButton getBtn_Borrar() {
        return btn_Borrar;
    }

    public JButton getBtn_Cancelar() {
        return btn_Cancelar;
    }

    public JButton getBtn_Editar() {
        return btn_Editar;
    }

    public JButton getBtn_Guardar() {
        return btn_Guardar;
    }

    public JButton getBtn_Nuevo() {
        return btn_Nuevo;
    }
    
    
    
    
}
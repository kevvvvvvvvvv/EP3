/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Usuario
 */
public class MenuTelefono extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuTelefono() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        MenuPri = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        EliminarTel = new javax.swing.JButton();
        RegistrarTel = new javax.swing.JButton();
        ModificarTel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(77, 68, 139));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EP2_i1.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(120, 122, 195));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EP2_i2.png"))); // NOI18N

        MenuPri.setBackground(new java.awt.Color(77, 68, 139));
        MenuPri.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        MenuPri.setForeground(new java.awt.Color(255, 255, 255));
        MenuPri.setText("Menú principal");
        MenuPri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPriActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(MenuPri)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(MenuPri)
                        .addGap(19, 19, 19))))
        );

        jLabel4.setFont(new java.awt.Font("Microsoft YaHei", 1, 60)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(168, 242, 254));
        jLabel4.setText("Telefonos");

        EliminarTel.setBackground(new java.awt.Color(120, 122, 195));
        EliminarTel.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        EliminarTel.setForeground(new java.awt.Color(255, 255, 255));
        EliminarTel.setText("Eliminar un teléfono");
        EliminarTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarTelActionPerformed(evt);
            }
        });

        RegistrarTel.setBackground(new java.awt.Color(120, 122, 195));
        RegistrarTel.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        RegistrarTel.setForeground(new java.awt.Color(255, 255, 255));
        RegistrarTel.setText("Registrar un teléfono");
        RegistrarTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarTelActionPerformed(evt);
            }
        });

        ModificarTel.setBackground(new java.awt.Color(120, 122, 195));
        ModificarTel.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        ModificarTel.setForeground(new java.awt.Color(255, 255, 255));
        ModificarTel.setText("Modificar un teléfono");
        ModificarTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarTelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RegistrarTel, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                .addGap(145, 145, 145))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ModificarTel, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EliminarTel, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegistrarTel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(ModificarTel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(EliminarTel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuPriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPriActionPerformed
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MenuPriActionPerformed

    private void EliminarTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarTelActionPerformed
        EliminarTelefono et = new EliminarTelefono();
        et.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EliminarTelActionPerformed

    private void RegistrarTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarTelActionPerformed
        RegistrarTelefono rt = new RegistrarTelefono();
        rt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegistrarTelActionPerformed

    private void ModificarTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarTelActionPerformed
        ModificarTelefono mt = new ModificarTelefono();
        mt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ModificarTelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EliminarTel;
    private javax.swing.JButton MenuPri;
    private javax.swing.JButton ModificarTel;
    private javax.swing.JButton RegistrarTel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}

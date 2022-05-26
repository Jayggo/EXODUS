/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.JOptionPane;

/**
 *
 * @author Jairo
 */
public class PagoTarjeta extends javax.swing.JFrame {

    /**
     * Creates new form PagoTarjeta
     */
    public PagoTarjeta() {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
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

        jLabel1 = new javax.swing.JLabel();
        labelimporte = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtabono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IMPORTE RESTANTE:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        labelimporte.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        labelimporte.setForeground(new java.awt.Color(255, 255, 255));
        labelimporte.setText("importe");
        getContentPane().add(labelimporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/visa.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 78, -1));

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tarjeta-mastercard.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 80, -1));

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/american-express.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 78, -1));

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Cerrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 85, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("MPORTE A ABONAR:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        txtabono.setBackground(new java.awt.Color(153, 153, 153));
        txtabono.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        txtabono.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txtabono, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 158, 29));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/94017.jpg"))); // NOI18N
        jLabel4.setText("MPORTE A ABONAR:");
        jLabel4.setPreferredSize(new java.awt.Dimension(480, 220));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static int banderatarjeta=0;
    public void Validando() { // METODO PARA VALIDAR SI EL TOTAL DE LA COMPRA FUE REALIZADO.
        String importe = labelimporte.getText();
        String importecorto = importe.substring(1, importe.length());

        double importedouble = Double.parseDouble(importecorto);
        String abono = txtabono.getText();
        double abonodouble = Double.parseDouble(abono);

        if (abonodouble > importedouble) {

            JOptionPane.showMessageDialog(null, "El importe a abonar no puede ser mayor al importe restante.");

        } else {
            
            
            banderatarjeta=1;
            double total = importedouble - abonodouble;

            if (total > 0) { // VALIDO SI EL TOTAL DE LA FACTURA YA FUE ALCANZADO. ASI CIERRO O NO. 

                MediodePago.labelrestante.setText("€" + (double) Math.round(total * 100d) / 100);
                txtabono.setText("");
                this.setVisible(false);

            } else if (total <= 0) {
                txtabono.setText("");
                Facturacion.mediodepago.setVisible(false);
                this.setVisible(false);
                MediodePago.imprimiendofactura.setVisible(true);
                MediodePago.imprimiendofactura.Imprimir(MediodePago.labelimporte.getText()); // LLAMO AL METODO PARA QUE CORRA EL PROGRESO DE LA BARRA. 
                                                                                                                                    
            }
        }
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try{
        Validando();
        
        txtabono.setText("");
        }catch(Exception e){
        
        JOptionPane.showMessageDialog(null, "Ingrese el monto");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
        Validando();

        txtabono.setText("");
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Ingrese el monto");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        try{
        Validando();

        txtabono.setText("");
        }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Ingrese el monto");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(false);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(PagoTarjeta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagoTarjeta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagoTarjeta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagoTarjeta.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagoTarjeta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel labelimporte;
    public static javax.swing.JTextField txtabono;
    // End of variables declaration//GEN-END:variables
}

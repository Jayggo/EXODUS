/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Jairo
 */
public class MediodePago extends javax.swing.JFrame {

    /**
     * Creates new form MediodePago
     */
    public MediodePago() {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    
   public static PagoEfectivo pagoefectivo = new PagoEfectivo();
   public static PagoTarjeta pagotarjeta = new PagoTarjeta();
   public static  ImprimiendoFactura imprimiendofactura = new ImprimiendoFactura();
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        labelimporte = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelrestante = new javax.swing.JLabel();
        labelrestante3 = new javax.swing.JLabel();
        labelrestante2 = new javax.swing.JLabel();
        labelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dinero (1).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 100, 70));

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pago.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 102, 70));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("IMPORTE A ABONAR:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        labelimporte.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        labelimporte.setForeground(new java.awt.Color(255, 255, 255));
        labelimporte.setText("IMPORTE");
        getContentPane().add(labelimporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("RESTANTE:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, -1, -1));

        labelrestante.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        labelrestante.setForeground(new java.awt.Color(255, 255, 255));
        labelrestante.setText("RESTANTE");
        getContentPane().add(labelrestante, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, -1, -1));

        labelrestante3.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        labelrestante3.setForeground(new java.awt.Color(255, 255, 255));
        labelrestante3.setText("Efectivo");
        getContentPane().add(labelrestante3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        labelrestante2.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        labelrestante2.setForeground(new java.awt.Color(255, 255, 255));
        labelrestante2.setText("Tarjeta");
        getContentPane().add(labelrestante2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, -1, -1));

        labelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/94017.jpg"))); // NOI18N
        labelfondo.setText("restante");
        labelfondo.setPreferredSize(new java.awt.Dimension(441, 208));
        getContentPane().add(labelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      PagoTarjeta.labelimporte.setText(labelrestante.getText());
       pagotarjeta.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        PagoEfectivo.labelimporte.setText(labelrestante.getText());
        pagoefectivo.setVisible(true);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MediodePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MediodePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MediodePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MediodePago.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MediodePago().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel labelfondo;
    public static javax.swing.JLabel labelimporte;
    public static javax.swing.JLabel labelrestante;
    public static javax.swing.JLabel labelrestante2;
    public static javax.swing.JLabel labelrestante3;
    // End of variables declaration//GEN-END:variables
}

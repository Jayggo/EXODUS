/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Base_datos.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Jairo
 */
public class Bienvenida extends javax.swing.JFrame {

    /**
     * Creates new form Bienvenida
     */
    public Bienvenida() {
        initComponents();
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

        jButton1 = new javax.swing.JButton();
        textfielduser = new javax.swing.JTextField();
        textfieldpass = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(448, 586));
        setSize(new java.awt.Dimension(448, 586));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/entrar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 100, 80));

        textfielduser.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        textfielduser.setText("Usuario");
        textfielduser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textfielduserKeyTyped(evt);
            }
        });
        getContentPane().add(textfielduser, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 360, 170, 40));

        textfieldpass.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        textfieldpass.setText("password");
        textfieldpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textfieldpassFocusGained(evt);
            }
        });
        getContentPane().add(textfieldpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 170, 40));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario.png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, 70));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/contrasena.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/multiple-users-silhouette (1).png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 260, 220));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/94017.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static Principal principal = new Principal();
    

    public static String user;
    public static String pass;
    public static int variable = 0; // USO ESTA VARIABLE COMO BANDERA PARA SABER QUE PRIVILEGIO TIENE MI USUARIO. 

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        user = textfielduser.getText();
        pass = textfieldpass.getText();
        Principal.bd.AccesoUsuario();

        switch (variable) {
            case 1:
                this.setVisible(false);
                 principal.labelusuario.setText("Administrador");
                principal.setVisible(true);
                variable = 0;    
                break;
            // VALIDO LAS CREDENCIALES DEL USUARIO QUE ESTA ENTRANDO 
            case 2:
                this.setVisible(false);
                principal.labelusuario.setText("Encargado");
                principal.setVisible(true);
                variable = 0;
                break;

            case 3:
                this.setVisible(false);
                 principal.labelusuario.setText("Cajero");
                principal.setVisible(true);
                principal.b_egresos.setEnabled(false);
                variable = 0;
               
                break;

            default:
                JOptionPane.showMessageDialog(null, "CREDENCIALES INCORRECTAS");
        }

        this.textfieldpass.setText("");
        this.textfielduser.setText("");


    }//GEN-LAST:event_jButton1ActionPerformed

    private void textfieldpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textfieldpassFocusGained
        textfieldpass.setText("");
    }//GEN-LAST:event_textfieldpassFocusGained

    private void textfielduserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfielduserKeyTyped
       if (textfielduser.getText().equals("Usuario")){
       textfielduser.setText("");
       
       }
       
    }//GEN-LAST:event_textfielduserKeyTyped

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
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bienvenida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bienvenida().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPasswordField textfieldpass;
    public javax.swing.JTextField textfielduser;
    // End of variables declaration//GEN-END:variables
}

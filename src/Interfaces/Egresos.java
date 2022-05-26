/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Logica.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jairo
 */
public class Egresos extends javax.swing.JFrame {

    public static DefaultTableModel modeloegresos = new DefaultTableModel() { // HAGO QUE LAS CELDAS NO SEAN EDITABLES 
        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 4) {
                return true;

            } else {
                return false;

            }

        }

    };

    public Egresos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        tablaegresos.setModel(modeloegresos);

        modeloegresos.addColumn("Codigo");
        modeloegresos.addColumn("Descripcion");
        modeloegresos.addColumn("Precio");
        modeloegresos.addColumn("Cantidad");

        Date fecha = new Date();
        String fechadehoy = new SimpleDateFormat("dd-MM-yyyy").format(fecha);

        labelfecha.setText(fechadehoy);
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
        combodestino = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtconcepto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaegresos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        numeroremito = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelfecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labeltotal = new javax.swing.JLabel();
        labelarticulos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Concepto:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 489, -1, -1));

        combodestino.setBackground(new java.awt.Color(153, 153, 153));
        combodestino.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        combodestino.setForeground(new java.awt.Color(0, 0, 0));
        combodestino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEPOSITO CENTRAL", "UNIFORME", "RETIRO EMPRESA", "TIENDA LOCAL" }));
        getContentPane().add(combodestino, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 215, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Total:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 410, 50, -1));

        txtconcepto.setBackground(new java.awt.Color(153, 153, 153));
        txtconcepto.setColumns(20);
        txtconcepto.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        txtconcepto.setForeground(new java.awt.Color(0, 0, 0));
        txtconcepto.setRows(5);
        jScrollPane1.setViewportView(txtconcepto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 490, 310, 117));

        jScrollPane2.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N

        tablaegresos.setBackground(new java.awt.Color(204, 204, 204));
        tablaegresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaegresos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 593, 327));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 416, 129, -1));

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 681, 91, -1));

        jButton4.setBackground(new java.awt.Color(153, 153, 153));
        jButton4.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Enviar remito");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 649, 160, 39));

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Agregar articulo");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 416, 158, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Remito #");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 15, -1, -1));

        numeroremito.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 18)); // NOI18N
        numeroremito.setForeground(new java.awt.Color(255, 255, 255));
        numeroremito.setText("numero");
        getContentPane().add(numeroremito, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 15, -1, -1));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha: ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 10, -1, -1));

        labelfecha.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 18)); // NOI18N
        labelfecha.setForeground(new java.awt.Color(255, 255, 255));
        labelfecha.setText("labelfecha");
        getContentPane().add(labelfecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Destino:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        labeltotal.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        labeltotal.setForeground(new java.awt.Color(255, 255, 255));
        labeltotal.setText("€");
        getContentPane().add(labeltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 410, 77, -1));

        labelarticulos.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        labelarticulos.setForeground(new java.awt.Color(255, 255, 255));
        labelarticulos.setText("0");
        getContentPane().add(labelarticulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 446, -1, -1));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Items:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 446, 50, -1));

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/94017.jpg"))); // NOI18N
        jLabel7.setText("Items:");
        jLabel7.setPreferredSize(new java.awt.Dimension(729, 726));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static boolean banderaegresos = false;

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        banderaegresos = true;

        Principal.lista.Limpiar();
        if (Principal.interfazdestock.isVisible()) {

            Principal.interfazdestock.toFront();
        } else {
            Stock.botonaceptar.setEnabled(true);
            Principal.bd.Stock();
            Principal.lista.ArregloStock();
            Principal.interfazdestock.setVisible(true);
        }


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {

            int seleccion = tablaegresos.getSelectedRow();

            String precioseleccionado = String.valueOf(tablaegresos.getValueAt(seleccion, 2));

            String precioacortado = precioseleccionado.substring(1, precioseleccionado.length()); // OBTENGO DATO A BORRAR
            double preciofinal = Double.parseDouble(precioacortado);

            String itemseleccionado = String.valueOf(tablaegresos.getValueAt(seleccion, 3));
            int itemfinal = Integer.parseInt(itemseleccionado);

            String itemactual = labelarticulos.getText();
            int enteroitemactual = Integer.parseInt(itemactual);

            int itemtotal = enteroitemactual - itemfinal;

            modeloegresos.removeRow(seleccion);

            String montoactual = labeltotal.getText();
            String montoacortado = montoactual.substring(1, montoactual.length()); // OBTENGO MI TOTAL ACTUAL PARA RESTARLO CON EL DATO A BORRAR
            double montofinal = Double.parseDouble(montoacortado);

            double total = montofinal - preciofinal;
//PINTO EL MONTO E ITEMS FINALES.
            labeltotal.setText("€ " + (double) Math.round(total * 100d) / 100);
            labelarticulos.setText(Integer.toString(itemtotal));
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Seleccione un articulo a borrar.");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        modeloegresos.setRowCount(0);
        txtconcepto.setText("");
        combodestino.setSelectedIndex(0);
        labeltotal.setText("");
        labelarticulos.setText("0");
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    public static String[] codigosegreso; // VECTOR PARA GUARDAR LOS CODIGOS EGRESADOS Y PASARLOS A LA DB COMO UNA SOLA CADENA DE TEXTO.

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (modeloegresos.getRowCount() == 0 || txtconcepto.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Ingrese todos los datos para generar el remito correctamente.");
        }else{
        
        codigosegreso = new String[modeloegresos.getRowCount()];
        String temporalcodigo;
        String temporalstock;
        String temporalprecio;
        String temporaldescripcion;
        Principal.bd.Stock();

        for (int i = 0; i < modeloegresos.getRowCount(); i++) {
            codigosegreso[i] = String.valueOf(modeloegresos.getValueAt(i, 0));
            temporalcodigo = String.valueOf(modeloegresos.getValueAt(i, 0));
            temporaldescripcion = String.valueOf(modeloegresos.getValueAt(i, 1));
            temporalprecio = String.valueOf(modeloegresos.getValueAt(i, 2));
            temporalstock = String.valueOf(modeloegresos.getValueAt(i, 3));
            Principal.lista.ActualizoStock(temporalcodigo, Integer.parseInt(temporalstock), temporaldescripcion, temporalprecio); // ACTUALIZO EL STOCK EN LA DB DE LO QUE SE ACABA DE VENDER O LO QUE ACABA DE INGRESAR.
            Principal.bd.ActualizandoStock(Lista.idtemporal, Lista.StockTemporal);
            Principal.bd.Stock(); //ACTUALIZO MI LISTA ENLAZADA PARA QUE NO HAYA CONFLICTO SI CONSIGUE DOS ARTICULOS IGUALES. 
        }

        Principal.lista.ArticuloAgotado();
        Principal.lista.Limpiar();
        Principal.bd.ListaTemporal(); //ALGORITMOS QUE INVENTE CON LA LISTA ENLAZADA PARA PODER ACTUALIZAR EL ID EN LA DB. 
        Principal.lista.BorrandoStock();

       
        Principal.bd.RegistrandoRemito(numeroremito.getText(), labelarticulos.getText(), labeltotal.getText(), String.valueOf(combodestino.getSelectedItem()), txtconcepto.getText().trim());
        JOptionPane.showMessageDialog(null, "Remito generado con exito.");
        this.setVisible(false);
        modeloegresos.setRowCount(0);
        txtconcepto.setText("");
        labeltotal.setText("");
        labelarticulos.setText("0");
        combodestino.setSelectedIndex(0);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        modeloegresos.setRowCount(0);
        txtconcepto.setText("");
        combodestino.setSelectedIndex(0);
        labeltotal.setText("");
        labelarticulos.setText("0");
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
            java.util.logging.Logger.getLogger(Egresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Egresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Egresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Egresos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Egresos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combodestino;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel labelarticulos;
    public static javax.swing.JLabel labelfecha;
    public static javax.swing.JLabel labeltotal;
    public static javax.swing.JLabel numeroremito;
    public static javax.swing.JTable tablaegresos;
    private javax.swing.JTextArea txtconcepto;
    // End of variables declaration//GEN-END:variables
}

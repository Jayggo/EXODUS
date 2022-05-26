/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Logica.Lista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Jairo
 */
public class ImprimiendoFactura extends javax.swing.JFrame {

    /**
     * Creates new form ImprimiendoFactura
     */
    private Timer t;
    private final ActionListener ac;
    int x = 0;

    public static Principal principal = new Principal();
    public static CerrarFactura cerrarfactura = new CerrarFactura(); // CREO OBJETO PARA CERAR FACTURA Y LIMPIAR TODA LA VENTANA.

    public ImprimiendoFactura() {
        initComponents();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   //METODO DE LA PROGRESSBAR
                x = x + 1;
                progressbar.setValue(x);
                if (progressbar.getValue() == 100) {
                    dispose();
                    t.stop();
                    x = 0; // REINICIO LA VARIABLE PARA QUE SE REINICIE EL PROGRESO DE LA BARRA. 

                    Facturacion.mediodepago.setVisible(false);
                    MediodePago.labelimporte.setText("");
                    MediodePago.labelrestante.setText("");
                    // CIERRO TODA MI OPERACION ACTUAL PORQUE YA FINALIZO. ABRO DE VUELTA LA INTERFAZ PRINCIPAL. 
                    Principal.facturacion.dispose();
                    cerrarfactura.CerrarFactura();
                    JOptionPane.showMessageDialog(null, "Transaccion facturada exitosamente.");
                }
            }
        };

    }

    public static String[] codigos;

    public void Imprimir(String monto) {
        codigos = new String[Facturacion.modelofacturacion.getRowCount()];
        String montototal = monto;
        String mediodepago = "";

        if (PagoEfectivo.banderaefectivo == 1 && PagoTarjeta.banderatarjeta == 1) {
            mediodepago = "Efectivo y Tarjeta";
        } else if (PagoEfectivo.banderaefectivo == 1 && PagoTarjeta.banderatarjeta == 0) {

            mediodepago = "Efectivo";
        } else if (PagoEfectivo.banderaefectivo == 0 && PagoTarjeta.banderatarjeta == 1) {

            mediodepago = "Tarjeta";
        } else if (InterfazCambio.banderacamb == 1) {
            mediodepago = "Cambio";
        }else if (Facturacion.banderadevolucion==1){
         mediodepago = "Devolucion";
        
        }

        t = new Timer(50, ac); // EMPIEZA EL PROGRESO DE LA BARRA.
        t.start();

        String temporalcodigo;
        String temporalstock;
        String temporalprecio; // GUARDO TEMPORALMENTE ESTOS VALORES PARA MANDARLOS A LOS METODOS DE LISTA Y BASE DE DATOS.
        String temporaldescripcion;
        Principal.bd.Stock();
    
        for (int i = 0; i < Facturacion.modelofacturacion.getRowCount(); i++) {
            codigos[i] = String.valueOf(Facturacion.modelofacturacion.getValueAt(i, 0));
            temporalcodigo = String.valueOf(Facturacion.modelofacturacion.getValueAt(i, 0));
            temporaldescripcion = String.valueOf(Facturacion.modelofacturacion.getValueAt(i, 1));
            temporalprecio = String.valueOf(Facturacion.modelofacturacion.getValueAt(i, 2));
            temporalstock = String.valueOf(Facturacion.modelofacturacion.getValueAt(i, 3));
            Principal.lista.ActualizoStock(temporalcodigo, Integer.parseInt(temporalstock), temporaldescripcion, temporalprecio); // ACTUALIZO EL STOCK EN LA DB DE LO QUE SE ACABA DE VENDER O LO QUE ACABA DE INGRESAR.
            Principal.bd.ActualizandoStock(Lista.idtemporal, Lista.StockTemporal);
            Principal.bd.Stock(); //ACTUALIZO MI LISTA ENLAZADA PARA QUE NO HAYA CONFLICTO SI CONSIGUE DOS ARTICULOS IGUALES. 
        }

        Principal.lista.ArticuloAgotado();
        Principal.lista.Limpiar();
        Principal.bd.ListaTemporal(); //ALGORITMOS QUE INVENTE CON LA LISTA ENLAZADA PARA PODER ACTUALIZAR EL ID EN LA DB. 
        Principal.lista.BorrandoStock();

        String vendedor = Facturacion.botonvendedor.getText().substring(10, Facturacion.botonvendedor.getText().length());
        String cajero = Facturacion.botoncajero.getText().substring(8, Facturacion.botoncajero.getText().length());

        Principal.bd.TransaccionesDB(montototal, Facturacion.modelofacturacion.getRowCount(), Integer.parseInt(Facturacion.labelitems.getText()), vendedor, cajero, mediodepago);
        Principal.bd.Comisiones(vendedor,montototal,Integer.parseInt(Facturacion.labelitems.getText()));

        PagoEfectivo.banderaefectivo = 0;
        PagoTarjeta.banderatarjeta = 0;  // REINICIO LAS BANDERAS. 
        InterfazCambio.banderacamb = 0;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        progressbar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("IMPRIMIENDO FACTURA...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(118, 118, 118))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(progressbar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ImprimiendoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImprimiendoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImprimiendoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImprimiendoFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImprimiendoFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar progressbar;
    // End of variables declaration//GEN-END:variables
}

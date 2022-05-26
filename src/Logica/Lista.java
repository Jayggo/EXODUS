package Logica;

import Base_datos.BaseDatos;
import Interfaces.*;
import javax.swing.JOptionPane;

public class Lista {

    Nodo cabeza = null;
    Nodo cola = null;

    public String[] arreglostock = new String[4];
    public String[] arreglofacturacion = new String[4];
    public String[] arreglotransacciones = new String[7];
    public String[] arregloegresos= new String[4];
    public static int bandera = 0;
    public static int StockTemporal;
    public static String idtemporal;
    public static String idborrar;

    public void Agregar(String id, String codigo, String descripcion, String precio, String stock) {

        Nodo nuevo = new Nodo(id, codigo, descripcion, precio, stock);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;

        } else {
            cola.siguiente = nuevo;
            cola = nuevo;

        }

    }

    public void Limpiar() {

        while (cabeza != null) {

            cabeza.siguiente = null;

            cabeza = cabeza.siguiente;

        }

    }

    //ARREGLOS PARA PONER ITEMS EN LAS TABLAS STOCK Y FACTURACION.
    public void ArregloStock() {

        Nodo auxiliar = cabeza;

        while (auxiliar != null) {

            arreglostock[0] = auxiliar.informacion[1];
            arreglostock[1] = auxiliar.informacion[2];
            arreglostock[2] = auxiliar.informacion[3];
            arreglostock[3] = auxiliar.informacion[4];

            Stock.modelo.addRow(arreglostock);
            auxiliar = auxiliar.siguiente;
        }

    }

    public void ArregloFacturacion() {
        arreglofacturacion[0] = Facturacion.txtcodigo.getText();
        arreglofacturacion[1] = Facturacion.txtdescripcion.getText();
        arreglofacturacion[2] = Facturacion.txtprecio.getText();
        arreglofacturacion[3] = Facturacion.txtcantidad.getText();

        Facturacion.modelofacturacion.addRow(arreglofacturacion);

    }

    // ALGORITMO PARA COMPARAR LO QUE SELECCIONO DE MI TABLA CON LO QUE ESTA EN MI LISTA Y OBTENER LOS DATOS. 
    public void MostrarLista() {

        Nodo auxiliar = cabeza;
        while (auxiliar != null) {
            if ((Integer.parseInt(auxiliar.informacion[0]) - 1) == Stock.tabla.getSelectedRow()) { // PARSEO EL ID PORQUE ES TIPO STRING.

                Facturacion.txtcodigo.setText(auxiliar.informacion[1]);
                if (Facturacion.banderacambio == 0) {
                    Facturacion.txtcantidad.setText("1");
                    Facturacion.txtprecio.setText(auxiliar.informacion[3]);
                } else if (Facturacion.banderacambio == 1) {

                    Facturacion.txtcantidad.setText("-1");

                    String temporal = auxiliar.informacion[3];
                    String temporalcorto = temporal.substring(1, temporal.length());
                    double temporaldouble = Double.parseDouble(temporalcorto); // ALGORITMO PARA EL VALOR NEGATIVO. 
                    double negativo = temporaldouble * 2;
                    double negativofinal = temporaldouble - negativo;
                    Facturacion.txtprecio.setText("€" + Double.toString(negativofinal));
                }

                Facturacion.txtdescripcion.setText(auxiliar.informacion[2]);

            }

            auxiliar = auxiliar.siguiente;
        }

    }

    public void Buscar() {

        Nodo auxiliar = cabeza;
        while (auxiliar != null) {
            if (Facturacion.txtcodigo.getText().trim().equals(auxiliar.informacion[1])) {

                Facturacion.txtprecio.setText(auxiliar.informacion[3]);
                Facturacion.txtdescripcion.setText(auxiliar.informacion[2]);
                bandera = 1;
            }

            auxiliar = auxiliar.siguiente;
        }

        if (bandera == 0 && Facturacion.banderacambio == 0) {

            JOptionPane.showMessageDialog(null, "El articulo " + Facturacion.txtcodigo.getText().trim() + " no se encuentra en stock actualmente.");

        }
        Facturacion.aiuda = 0;
    }

    public void ActualizoStock(String codigo, int stock, String descripcion, String precio) {

        Nodo auxiliar = cabeza;
        int aux = 0; // VARIABLE PARA VALIDAR SI EL PRODUCTO ESTA EN STOCK.
        while (auxiliar != null) {

            if (codigo.equals(auxiliar.informacion[1])) {

                if (stock >= 1) { // CHEQUEO SI ES UN CAMBIO O UNA VENTA. ASI DESCUENTO O SUMO AL STOCK.
                    idtemporal = auxiliar.informacion[0];
                    StockTemporal = Integer.parseInt(auxiliar.informacion[4]) - stock;
                } else if (stock == -1) {
                    idtemporal = auxiliar.informacion[0];
                    StockTemporal = Integer.parseInt(auxiliar.informacion[4]) + 1;

                }
                aux = 1;
            }

            auxiliar = auxiliar.siguiente;

        }
        if (aux == 0) { // EN CASO DE QUE NO CONSIGA EL CODIGO (ENTRA UN PRODUCTO QUE NO ESTABA EN STOCK ANTES)

            Principal.bd.IngresoArticulo(codigo, Integer.toString(stock), precio, descripcion);

        }

    }

    public void ArticuloAgotado() {
        Nodo auxiliar = cabeza;

        while (auxiliar != null) {

            if (auxiliar.informacion[4].equals("0")) {

                idborrar = auxiliar.informacion[0];
                Principal.bd.BorrarUnArticulo(idborrar);
                BaseDatos.contadorid--;
            }
            auxiliar = auxiliar.siguiente;
        }

    }

    public void BorrandoStock() { // BUSCANDO LOS ID DE MI LISTA TEMPORAL Y MANDANDOSELOS A EL METODO PARA ACTUALIZARLOS EN LA DB.

        Nodo auxiliar = cabeza;
        int x = 1;

        while (auxiliar != null) {

            Principal.bd.Actualizo(auxiliar.informacion[0], x);

            x++;
            auxiliar = auxiliar.siguiente;
        }

    }

    public boolean ChequeoStock(String codigo, String cantidad) { // METODO PARA VALIDAR SI EL STOCK REQUERIDO ES MAYOR AL STOCK EN SISTEMA.

        Nodo auxiliar = cabeza;

        while (auxiliar != null) {

            if (codigo.equals(auxiliar.informacion[1])) {

                if (Integer.parseInt(cantidad) > Integer.parseInt(auxiliar.informacion[4])) {
                    JOptionPane.showMessageDialog(null, "El stock requerido del articulo " + codigo + " supera el stock existente.\nStock requerido: " + cantidad + ", Stock actual: " + auxiliar.informacion[4]);

                    return true;

                } else {
                    return false;
                }

            }

            auxiliar = auxiliar.siguiente;
        }
        return false;

    }
    
    
    public void ListaEgresos(String codigo, String descripcion, String precio){
    
    
        arregloegresos[0] = codigo;
        arregloegresos[1] = descripcion;
        arregloegresos[2] = precio;
        arregloegresos[3] = "1";
    
        Egresos.modeloegresos.addRow(arregloegresos);
    
    
    }


}

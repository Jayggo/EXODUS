package Logica;

public class NodoTransacciones {

    String[] informacion = new String[7];
    NodoTransacciones siguiente=null;

    public NodoTransacciones(String fecha, String factura, String monto, String articulos, String unidades, String cajero, String vendedor) {
   
        informacion[0] = fecha;
        informacion[1] = factura;
        informacion[2] = monto;
        informacion[3] = articulos;
        informacion[4] = unidades;
        informacion[5] = cajero;
        informacion[6] = vendedor;
    }

}



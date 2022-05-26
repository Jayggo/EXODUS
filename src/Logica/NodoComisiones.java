package Logica;

public class NodoComisiones {

    String[] informacion = new String[5];

    NodoComisiones siguiente = null;

    public NodoComisiones(String id, String fecha, String vendedor, String unidades, String monto) {

        informacion[0] = id;
        informacion[1] = fecha;
        informacion[2] = vendedor;
        informacion[3] = unidades;
        informacion[4] = monto;

    }

}

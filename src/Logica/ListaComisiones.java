package Logica;

import Interfaces.*;
import javax.swing.JOptionPane;

public class ListaComisiones {//////////////////////////////// BASICAMENTE LO MISMO QUE EN TRANSACCIONES PERO CON COMISIONES xd/////////////////////////////////////////////////////////////////////////

    NodoComisiones cabeza = null;
    NodoComisiones cola = null;

    String[] arreglocomisiones = new String[4];
    public static boolean bandera = false;

    public void Enlistar(String id, String fecha, String vendedor, String unidades, String monto) {

        NodoComisiones nuevo = new NodoComisiones(id, fecha, vendedor, unidades, monto);

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

    public void ArregloComisiones() {

        NodoComisiones auxiliar = cabeza;

        while (auxiliar != null) {
            if (Principal.fechadehoy.equals(auxiliar.informacion[1])) {
                arreglocomisiones[0] = auxiliar.informacion[1];
                arreglocomisiones[1] = auxiliar.informacion[2];
                arreglocomisiones[2] = auxiliar.informacion[3];
                arreglocomisiones[3] = auxiliar.informacion[4];

                Comisiones.modelocomisiones.addRow(arreglocomisiones);
            }
            auxiliar = auxiliar.siguiente;
        }

    }

    String fecha_ini, fecha_fin;

    String dia_ini, mes_ini, year_ini;
    String dia_fin, mes_fin, year_fin;

    int idia, imes, iyear;
    int fdia, fmes, fyear;

    public void AsignoValores(String fecha_uno, String fecha_dos, String vendedor) {
        Comisiones.modelocomisiones.setRowCount(0);
        String recibo_vendedor = vendedor;
        fecha_ini = fecha_uno;
        fecha_fin = fecha_dos;

        dia_ini = fecha_ini.substring(0, 2);
        mes_ini = fecha_ini.substring(3, 5);
        year_ini = fecha_ini.substring(6, 10);

        dia_fin = fecha_fin.substring(0, 2);
        mes_fin = fecha_fin.substring(3, 5);
        year_fin = fecha_fin.substring(6, 10);

        idia = ParsearCadena(dia_ini);
        imes = ParsearCadena(mes_ini);
        iyear = ParsearCadena(year_ini);

        fdia = ParsearCadena(dia_fin);
        fmes = ParsearCadena(mes_fin);
        fyear = ParsearCadena(year_fin);

        if (iyear < fyear) {
            do {
                CicloMes(idia, imes, iyear, recibo_vendedor);
                iyear++;
                imes = 1;
            } while (iyear != fyear);
            idia = 01;
        }

        if (imes < fmes) {
            do {
                CicloDias(idia, imes, iyear, recibo_vendedor);
                imes++;
                idia = 1;

            } while (imes != fmes);
        }

        if (idia < fdia) {
            do {
                Validacion(idia, imes, iyear, recibo_vendedor);

                idia++;

            } while (idia != fdia);

        }
        Validacion(idia, imes, iyear, recibo_vendedor); // MANDO EL ULTIMO VALOR DE TODOS.

        if (bandera == false) {

            JOptionPane.showMessageDialog(null, "No se han registrado comisiones en las fechas solicitadas.");

        }
    }

    public int ParsearCadena(String fecha) {

        int fechaentera = Integer.parseInt(fecha);

        return fechaentera;
    }

    public void CicloDias(int dia, int mes, int year, String vendedor) {

        while (dia <= 31) {

            Validacion(dia, mes, year, vendedor);

            dia++;

        }

    }

    public void CicloMes(int dia, int mes, int year, String vendedor) {

        while (mes <= 12) {

            CicloDias(dia, mes, year, vendedor);
            mes++;
            dia = 1;

        }

    }

    public void Validacion(int dia, int mes, int year, String vendedor) { // ALGORITMO PARA AGREGAR 0'S AL DIA Y AL MES SI SON MENORES A 10, SI NO AL MOMENTO DE COMPARARLOS NO ME LO TOMA.

        if (dia >= 10 && mes >= 10) {

            BuscoFechas(Integer.toString(dia) + "-" + Integer.toString(mes) + "-" + Integer.toString(year), vendedor);

        } else if (dia < 10 && mes < 10) {

            BuscoFechas("0" + Integer.toString(dia) + "-" + "0" + Integer.toString(mes) + "-" + Integer.toString(year), vendedor);

        } else if (dia >= 10 && mes < 10) {

            BuscoFechas(Integer.toString(dia) + "-" + "0" + Integer.toString(mes) + "-" + Integer.toString(year), vendedor);

        } else if (dia < 10 && mes >= 10) {

            BuscoFechas("0" + Integer.toString(dia) + "-" + Integer.toString(mes) + "-" + Integer.toString(year), vendedor);

        }

    }

    public void BuscoFechas(String fecha, String vendedor) {

        NodoComisiones auxiliar = cabeza;

        while (auxiliar != null) {

            if (fecha.equals(auxiliar.informacion[1]) && vendedor.equals(auxiliar.informacion[2])) {

                arreglocomisiones[0] = auxiliar.informacion[1];
                arreglocomisiones[1] = auxiliar.informacion[2];
                arreglocomisiones[2] = auxiliar.informacion[3];
                arreglocomisiones[3] = auxiliar.informacion[4];

                Comisiones.modelocomisiones.addRow(arreglocomisiones);
                bandera = true;
            } else if (fecha.equals(auxiliar.informacion[1]) && vendedor.equals("Seleccione...")) {

                arreglocomisiones[0] = auxiliar.informacion[1];
                arreglocomisiones[1] = auxiliar.informacion[2];
                arreglocomisiones[2] = auxiliar.informacion[3];
                arreglocomisiones[3] = auxiliar.informacion[4];

                Comisiones.modelocomisiones.addRow(arreglocomisiones);
                bandera = true;

            }

            auxiliar = auxiliar.siguiente;
        }

    }

    public void TotalesLocal() {

        double preciototal = 0.0;
        int itemstotal = 0;
        for (int i = 0; i < Comisiones.modelocomisiones.getRowCount(); i++) {
            String cadenaprecio = String.valueOf(Comisiones.tablacomisiones.getValueAt(i, 3));
            String cadenacorta = cadenaprecio.substring(1, cadenaprecio.length());   // ALGORITMO PARA SUMAR LOS MONTOS DE LA TABLA.
            double preciofinal = Double.parseDouble(cadenacorta);
            preciototal += preciofinal;
            
            String cadenaitem = String.valueOf(Comisiones.tablacomisiones.getValueAt(i, 2)); //ALGORITMO PARA SUMAR LOS ITEMS. 
            int itementero = Integer.parseInt(cadenaitem);
            itemstotal += itementero;
        }

        Comisiones.totallocal.setText("€ " + (double) Math.round(preciototal * 100d) / 100);
        Comisiones.ulocal.setText(Integer.toString(itemstotal));
        Comisiones.tlocal.setText(Integer.toString(Comisiones.modelocomisiones.getRowCount()));
    }
}

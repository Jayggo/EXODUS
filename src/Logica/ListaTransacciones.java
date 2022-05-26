package Logica;

import Interfaces.Principal;
import Interfaces.Transacciones;
import javax.swing.JOptionPane;

public class ListaTransacciones { // ESTA CLASE TIENE UNA LISTA ENLAZADA QUE ALMACENA LAS TRANSACCIONES Y ALGORITMOS LOCOS PARA FILTRARLAS Y PLASMARLAS BIEN EN UNA JTABLE.

    NodoTransacciones cabeza = null;
    NodoTransacciones cola = null;

    String[] arreglotransacciones = new String[7];
   public static boolean bandera = false;

    public void Enlistar(String fecha, String factura, String monto, String articulos, String unidades, String cajero, String vendedor) {

        NodoTransacciones nuevo = new NodoTransacciones(fecha, factura, monto, articulos, unidades, cajero, vendedor);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;

        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }

    }
    
    
    public void Limpiar(){
        
        while (cabeza != null) {

            cabeza.siguiente = null;

            cabeza = cabeza.siguiente;

        }


    }

    public void ArregloTransacciones() {

        NodoTransacciones auxiliar = cabeza;

        while (auxiliar != null) {

            arreglotransacciones[0] = auxiliar.informacion[0];
            arreglotransacciones[1] = auxiliar.informacion[1];
            arreglotransacciones[2] = auxiliar.informacion[2];
            arreglotransacciones[3] = auxiliar.informacion[3];
            arreglotransacciones[4] = auxiliar.informacion[4];
            arreglotransacciones[5] = auxiliar.informacion[5];
            arreglotransacciones[6] = auxiliar.informacion[6];

            Principal.transacciones.modelotransacciones.addRow(arreglotransacciones);
            auxiliar = auxiliar.siguiente;
        }

    }

    String fecha_ini, fecha_fin;

    String dia_ini, mes_ini, year_ini;
    String dia_fin, mes_fin, year_fin;

    int idia, imes, iyear;
    int fdia, fmes, fyear;
//////////////////////////////////////////////////////// ME INVENTÉ MUCHOS ALGORITMOS ENFERMOS PARA PODER FILTRAR POR FECHAS///////////////////////////////////////////////////////////////////////////
    public void AsignoValores(String fecha_uno, String fecha_dos) { 
        Transacciones.modelotransacciones.setRowCount(0);
        
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
                CicloMes(idia, imes, iyear);
                iyear++;
                imes = 1;
            } while (iyear != fyear);
            idia = 01;
        }

        if (imes < fmes) {
            do {
                CicloDias(idia, imes, iyear);
                imes++;
                idia = 1;

            } while (imes != fmes);
        }

        if (idia < fdia) {
            do {
                Validacion(idia, imes, iyear);

                idia++;

            } while (idia != fdia);

        }
        Validacion(idia, imes, iyear); // MANDO EL ULTIMO VALOR DE TODOS.
        
        if (bandera == false) {

            JOptionPane.showMessageDialog(null, "No se han registrado transacciones en las fechas solicitadas.");

        }
    }

    public int ParsearCadena(String fecha) {

        int fechaentera = Integer.parseInt(fecha);

        return fechaentera;
    }

    public void CicloDias(int dia, int mes, int year) {

        while (dia <= 31) {

            Validacion(dia, mes, year);

            dia++;

        }

    }

    public void CicloMes(int dia, int mes, int year) {

        while (mes <= 12) {

            CicloDias(dia, mes, year);
            mes++;
            dia = 1;

        }

    }

    public void Validacion(int dia, int mes, int year) { // ALGORITMO PARA AGREGAR 0'S AL DIA Y AL MES SI SON MENORES A 10, SI NO AL MOMENTO DE COMPARARLOS NO ME LO TOMA.

        if (dia >= 10 && mes >= 10) {

            BuscoFechas(Integer.toString(dia) + "-" + Integer.toString(mes) + "-" + Integer.toString(year));

        } else if (dia < 10 && mes < 10) {

            BuscoFechas("0" + Integer.toString(dia) + "-" + "0" + Integer.toString(mes) + "-" + Integer.toString(year));

        } else if (dia >= 10 && mes < 10) {

            BuscoFechas(Integer.toString(dia) + "-" + "0" + Integer.toString(mes) + "-" + Integer.toString(year));

        } else if (dia < 10 && mes >= 10) {

            BuscoFechas("0" + Integer.toString(dia) + "-" + Integer.toString(mes) + "-" + Integer.toString(year));

        }

    }

    public void BuscoFechas(String fecha) {

        NodoTransacciones auxiliar = cabeza;

        while (auxiliar != null) {

            if (fecha.equals(auxiliar.informacion[0])) {

                arreglotransacciones[0] = auxiliar.informacion[0];
                arreglotransacciones[1] = auxiliar.informacion[1];
                arreglotransacciones[2] = auxiliar.informacion[2];
                arreglotransacciones[3] = auxiliar.informacion[3];
                arreglotransacciones[4] = auxiliar.informacion[4];
                arreglotransacciones[5] = auxiliar.informacion[5];
                arreglotransacciones[6] = auxiliar.informacion[6];

                Transacciones.modelotransacciones.addRow(arreglotransacciones);
                bandera = true;
            }

            auxiliar = auxiliar.siguiente;
        }

    }

}

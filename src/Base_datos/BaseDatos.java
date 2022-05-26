package Base_datos;

import Interfaces.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class BaseDatos {

    public static int contador = 1;
    public static int contadorclientes = 1;
    public static int banderaempresa = 0;
    public static int idfactura = 1;
    public static int contadorid = 0; // CONTADOR PARA ACTUALIZAR EL ID LUEGO EN IMPRIMIENDO FACTURA.
    public static int idremito = 1;
    public static int cantidad_comisiones = 0;

    public void AccesoUsuario() {
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        for (int x = 1; x <= 3; x++) {
            try {                                                                                                                                                                                     // BUSCO EL USER Y LA CONTRA. 
                conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_accesos", "root", "");
                pst = conector.prepareStatement("select * from accesos_usuarios where ID = ?");

                pst.setString(1, Integer.toString(x));

                rs = pst.executeQuery();

                if (rs.next()) {

                    if (Bienvenida.user.equals(rs.getString("User")) && Bienvenida.pass.equals(rs.getString("Password"))) {
                        Bienvenida.variable = x;
                    }
                }
                conector.close();
                pst.close();
                rs.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        }

    }

    public void AccesoCajero(String codigo) {
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        for (int x = 1; x <= 2; x++) {
            try {                                                                                                                                                                                     // BUSCO EL CODIGO DE CAJERO EN LA DB. 
                conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_accesos", "root", "");
                pst = conector.prepareStatement("select * from accesos_cajeros where ID = ?");

                pst.setString(1, Integer.toString(x));

                rs = pst.executeQuery();

                if (rs.next()) {

                    if (codigo.equals(rs.getString("Numcajero"))) {

                        Principal.accesoc = 1;
                    }

                }
                conector.close();
                pst.close();
                rs.close();

            } catch (SQLException e) {
               

            }
        }

    }

    public void AccesoVendedor(String codigo) {
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        for (int x = 1; x <= 2; x++) {
            try {                                                                                                                                                                                     // BUSCO EL CODIGO DE VENDEDOR EN LA DB 
                conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_accesos", "root", "");
                pst = conector.prepareStatement("select * from accesos_vendedores where ID = ?");

                pst.setString(1, Integer.toString(x));

                rs = pst.executeQuery();

                if (rs.next()) {
                    if (codigo.equals(rs.getString("Numvendedor"))) {
                        Principal.accesov = 1;
                    }

                }
                conector.close();
                pst.close();
                rs.close();

            } catch (SQLException e) {
               

            }
        }

    }

    public void Stock() {

        int x = 0;
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        do {

            try {                                                                                                                                                                                     // BUSCO EL STOCK 

                conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_stock", "root", "");
                pst = conector.prepareStatement("select * from stock where ID = ?");

                pst.setString(1, Integer.toString(contador));

                rs = pst.executeQuery();

                if (rs.next()) {

                    Principal.lista.Agregar(rs.getString("ID"), rs.getString("Codigo"), rs.getString("Descripcion"), rs.getString("Precio"), rs.getString("Stock"));

                    contador++;
                    contadorid++;
                } else {

                    x = 1;
                }
                conector.close();
                pst.close();
                rs.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        } while (x != 1);

        contador = 1;
    }

    public void Clientes() {

        int x = 0;
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {                                                                                                                                                                                     // BUSCO AL CLIENTE.

            conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_clientes", "root", "");
            pst = conector.prepareStatement("select * from clientes where Documento = ?");

            pst.setString(1, Principal.mostrarcliente.txtdocumento.getText().trim());

            rs = pst.executeQuery();

            if (rs.next()) {

                Principal.mostrarcliente.labelnombre.setText(rs.getString("Nombre"));
                Principal.mostrarcliente.labeldomicilio.setText(rs.getString("Domicilio"));
                Principal.mostrarcliente.labeltelefono.setText(rs.getString("Telefono"));

            } else {

                if (Principal.mostrarcliente.txtdocumento.getText().trim().equals("cons")) { // VALIDO QUE SI SE PONE "CONS" SE SETEE CONSUMIDOR FINAL.
                    Principal.mostrarcliente.labelnombre.setText("Consumidor Final");
                    Principal.mostrarcliente.labeldomicilio.setText("Consumidor Final");
                    Principal.mostrarcliente.labeltelefono.setText("Consumidor Final");
                } else {

                    JOptionPane.showMessageDialog(null, "Cliente no registrado.");
                    x = 1;
                    Principal.mostrarcliente.labelnombre.setText("");
                    Principal.mostrarcliente.labeldomicilio.setText("");
                    Principal.mostrarcliente.labeltelefono.setText("");
                }
            }

            conector.close();
            pst.close();
            rs.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public void StockEmpresa() {

        int auxiliar = 1;
        int y = 0;
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        do {

            try {                                                                                                                                                                                     // BUSCO EL STOCK DE LA EMPRESA.

                conector = DriverManager.getConnection("jdbc:mysql://localhost/empresa_stock", "root", "");
                pst = conector.prepareStatement("select * from stock where ID = ?");

                pst.setString(1, Integer.toString(auxiliar));

                rs = pst.executeQuery();

                if (rs.next()) {

                    if (Facturacion.txtcodigo.getText().equals(rs.getString("Codigo"))) {
                        Facturacion.txtcantidad.setText("-1");

                        String temporal = rs.getString("Precio");
                        String temporalcorto = temporal.substring(1, temporal.length());
                        double temporaldouble = Double.parseDouble(temporalcorto);
                        double negativo = temporaldouble * 2;
                        double negativofinal = temporaldouble - negativo;
                        Facturacion.txtprecio.setText("€" + Double.toString(negativofinal));

                        Facturacion.txtdescripcion.setText(rs.getString("Descripcion"));
                        banderaempresa = 1;
                    }

                    auxiliar++;
                } else {
                    y = 1;
                }
                conector.close();
                rs.close();
                pst.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        } while (y != 1);

    }

    public void Factura() {

        int y = 0;
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        do {

            try {                                                                                                               //VALIDO EL NUMERO DE FACTURA CON LAS YA REGISTRADAS EN LA DB ASI SETEO EN LA INTERFAZ DE FACTURACION.

                conector = DriverManager.getConnection("jdbc:mysql://localhost/empresa_transacciones", "root", "");
                pst = conector.prepareStatement("select * from transacciones where ID = ?");

                pst.setString(1, Integer.toString(idfactura));

                rs = pst.executeQuery();

                if (rs.next()) {

                    idfactura++;
                } else {
                    y = 1;
                }
                conector.close();
                pst.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        } while (y != 1);

    }

    public void ActualizandoStock(String id, int stock) { // ACTUALIZO EL STOCK DE LO QUE SE VENDIO.
        Connection conector = null;
        PreparedStatement pre = null;

        try {

            conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_stock", "root", "");
            pre = conector.prepareStatement("UPDATE stock SET Stock = ? WHERE ID= " + id);

            pre.setString(1, Integer.toString(stock));
            pre.executeUpdate();

            conector.close();
            pre.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public void BorrarUnArticulo(String id) {
        Connection conector = null;
        PreparedStatement pst = null;
        try {

            conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_stock", "root", "");
            pst = conector.prepareStatement("DELETE FROM stock WHERE ID = ?");

            pst.setString(1, id);

            pst.executeUpdate();

            conector.close();
            pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public void ListaTemporal() { // LISTA QUE USO PARA ALMACENAR TEMPORALMENTE EL STOCK CUANDO BORRO UN ARTICULO Y NECESITO ACTUALIZAR LOS ID EN LA DB.

        int temporal = 1;
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        for (int i = 0; i < contadorid; i++) {

            try {

                conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_stock", "root", "");
                pst = conector.prepareStatement("select * from stock where ID = ?");

                pst.setString(1, Integer.toString(temporal));

                rs = pst.executeQuery();

                if (rs.next()) {

                    Principal.lista.Agregar(rs.getString("ID"), rs.getString("Codigo"), rs.getString("Descripcion"), rs.getString("Precio"), rs.getString("Stock"));

                    temporal++;
                } else {

                    temporal++;
                }

                conector.close();
                pst.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        }
    }

    public void Actualizo(String busqueda, int setear) { // ACTUALIZO LOS ID DE LA DB GRACIAS A LA LISTA TEMPORAL.
        Connection conector = null;
        PreparedStatement pre = null;

        try {

            conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_stock", "root", "");
            pre = conector.prepareStatement("UPDATE stock SET ID = ? WHERE ID = ? ");
            pre.setString(1, Integer.toString(setear));
            pre.setString(2, busqueda);
            pre.executeUpdate();

            conector.close();
            pre.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public void IngresoArticulo(String codigo, String stock, String precio, String descripcion) { // SI EL ARTICULO NO ESTA EN STOCK Y ENTRA UN CAMBIO. 
        Connection conector = null;
        PreparedStatement pst = null;

        Double preciopositivo = 0.0;
        int stockpositivo = 0;
        String preciocorto = precio.substring(1, precio.length());
        Double preciodouble = Double.parseDouble(preciocorto);

        int stockconvertido = Integer.parseInt(stock);

        if (stockconvertido < 0) {
            stockpositivo = stockconvertido * -1;
        }

        if (preciodouble < 0) {
            preciopositivo = preciodouble * -1;
        }

        try {
            conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_stock", "root", "");
            pst = conector.prepareStatement("INSERT INTO stock VALUES (?,?,?,?,?) ");

            pst.setString(1, Integer.toString(contadorid));
            pst.setString(2, codigo);
            pst.setString(3, descripcion);
            pst.setString(4, "€" + Double.toString(preciopositivo));
            pst.setString(5, Integer.toString(stockpositivo));

            pst.executeUpdate();

            conector.close();
            pst.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public void TransaccionesDB(String monto, int items, int unidades, String vendedor, String cajero, String mediodepago) { // REGISTRA EN LA DB LA TRANSACCION REALIZADA. 
        Connection conector = null;
        PreparedStatement pst = null;

        String codigos = "";

        for (int i = 0; i < items; i++) {
            if (i == items - 1) {
                codigos += ImprimiendoFactura.codigos[i];  // GUARDO ACA LOS CODIGOS DE LA TRANSACCION PARA ALMACENARLOS EN LA BASE DE DATOS COMO UNA SOLA CADENA DE TEXTO.
            } else {
                codigos += ImprimiendoFactura.codigos[i] + ",";
            }
        }

        String cliente = Facturacion.botoncliente.getText().substring(9, Facturacion.botoncliente.getText().length());

        try {
            conector = DriverManager.getConnection("jdbc:mysql://localhost/empresa_transacciones", "root", "");
            pst = conector.prepareStatement("INSERT INTO transacciones VALUES (?,?,?,?,?,?,?,?,?,?) ");

            pst.setString(1, Integer.toString(Facturacion.numfactura));
            pst.setString(2, Facturacion.labelfactura.getText());
            pst.setString(3, Facturacion.fechalabel.getText());
            pst.setString(4, monto);
            pst.setString(5, codigos);
            pst.setString(6, Integer.toString(unidades));
            pst.setString(7, vendedor);
            pst.setString(8, cajero);
            pst.setString(9, mediodepago);
            pst.setString(10, cliente);

            pst.executeUpdate();

            conector.close();
            pst.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public void Comisiones(String vendedor, String monto, int unidades) { // REGISTRA LAS COMISIONES EN LA DB
        Connection conector = null;
        PreparedStatement pst = null;

        try {
            conector = DriverManager.getConnection("jdbc:mysql://localhost/empresa_comisiones", "root", "");
            pst = conector.prepareStatement("INSERT INTO comisiones VALUES (?,?,?,?,?,?) ");

            pst.setString(1, "0");
            pst.setString(2, vendedor);
            pst.setString(3, Facturacion.fechalabel.getText());
            pst.setString(4, monto);
            pst.setString(5, Integer.toString(unidades));
            pst.setString(6, Facturacion.labelfactura.getText());

            pst.executeUpdate();

            conector.close();
            pst.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public static int cantidad_transacciones;
    public static String[] transacciones;

    public boolean Chequeo(String fecha) {   //CHEQUEO MI VECTOR PARA UNIFICAR LAS FECHAS DE LAS TRANSACCIONES. 
        for (int i = 0; i < cantidad_transacciones; i++) {
            if (fecha.equals(transacciones[i])) {
                return true;

            }
        }
        return false;
    }

    public static int temp;// USO TEMP COMO INDICE TEMPORAL PARA LLEVAR UN ORDEN CONCISO Y SABER CUANTAS FECHAS TENGO EN TOTAL.

    public void ValidoTransacciones() { // GUARDO EN MI VECTOR LAS FECHAS DE LAS TRANSACCIONES DE LA DB. 
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        int aux = 1;
        boolean condicion;
        GuardoTransacciones(); // LLAMO A TRANSACCIONES PARA SABER CUANTAS HAY Y TENER UN LIMITE PARA MI CICLO

        for (int i = 0; i < cantidad_transacciones; i++) {
            try {

                conector = DriverManager.getConnection("jdbc:mysql://localhost/empresa_transacciones", "root", "");
                pst = conector.prepareStatement("select * from transacciones where ID = ?");

                pst.setString(1, Integer.toString(aux));

                rs = pst.executeQuery();

                if (rs.next()) {
                    condicion = Chequeo(rs.getString("Fecha"));
                    if (condicion == false) {

                        transacciones[temp] = rs.getString("Fecha"); // USO TEMP COMO INDICE TEMPORAL PARA LLEVAR UN ORDEN CONCISO Y SABER CUANTAS FECHAS TENGO EN TOTAL.
                        temp++;
                    }
                    aux++;
                }

                conector.close();
                pst.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        }

    }

    public String VerificoCierres() { // CREO QUE ESTO ES PARA VER SI PUEDO FACTURAR O NO XD
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        int x = 0;

        for (int i = 0; i < temp; i++) {
            try {

                conector = DriverManager.getConnection("jdbc:mysql://localhost/empresa_cierres", "root", "");
                pst = conector.prepareStatement("select * from cierres where Fecha = ?");
                if (transacciones[i] != null) {
                    pst.setString(1, transacciones[i]);
                }
                rs = pst.executeQuery();

                if (rs.next()) {
                    x++;
                } else {
                    return transacciones[i];
                }

                conector.close();
                pst.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        }
        if (x == temp) {

            return "no";
        }
        return null;
    }

    public void GuardoTransacciones() { // GUARDO LAS TRANSACCIONES QUE OBTENGO DE LA DB EN UNA LISTA ENLAZADA.

        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        int x = 0, aux = 1;
        do {
            try {

                conector = DriverManager.getConnection("jdbc:mysql://localhost/empresa_transacciones", "root", "");
                pst = conector.prepareStatement("select * from transacciones where ID = ?");

                pst.setString(1, Integer.toString(aux));

                rs = pst.executeQuery();

                if (rs.next()) {
                    Principal.listatransacciones.Enlistar(rs.getString("Fecha"), rs.getString("Factura"), rs.getString("Monto"), rs.getString("Articulos"), rs.getString("Unidades"), rs.getString("Cajero"), rs.getString("Vendedor"));
                    cantidad_transacciones++;

                    aux++;
                } else {

                    x = 1;
                }

                conector.close();
                pst.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        } while (x != 1);
        transacciones = new String[cantidad_transacciones]; // INSTANCIO EL VECTOR CORRECTAMENTE. (SI LO HAGO AFUERA DE UN METODO NO FUNKA)
    }

    public double ConvertirMonto(String monto) {

        String montoacortado = monto.substring(1, monto.length());
        double montoconvertido = Double.parseDouble(montoacortado); // ALGORITMO PARA CONVERTIR DE STRING A DOUBLE CUALQUIER PRECIO.

        return montoconvertido;

    }

    public void TotalCierre(String fecha) { // USANDO LA FECHA, BUSCO CADA ITEM NECESARIO PARA MOSTRAR EN LA INTERFAZ ANTES DE REALIZAR EL CIERRE.
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        int x = 0;
        int y = 1;
        double acumulador_montos = 0.0;
        double acumulador_montodevs = 0.0;
        int acumulador_unidades = 0;
        int acumulador_tickets = 0;
        int acumulador_devs = 0;

        do {
            try {

                conector = DriverManager.getConnection("jdbc:mysql://localhost/empresa_transacciones", "root", "");
                pst = conector.prepareStatement("select * from transacciones where ID = ?");

                pst.setString(1, Integer.toString(y));

                rs = pst.executeQuery();

                if (rs.next()) {
                    if (fecha.equals(rs.getString("Fecha"))) {
                        if (rs.getString("Medio_pago").equals("Devolucion")) { // VALIDO SI ES UNA DEVOLUCION
                            acumulador_devs++;
                            acumulador_montodevs += ConvertirMonto(rs.getString("Monto"));
                        }

                        acumulador_montos += ConvertirMonto(rs.getString("Monto"));
                        acumulador_unidades += Integer.parseInt(rs.getString("Unidades"));
                        acumulador_tickets++;
                    }

                } else {
                    x = 1;

                }

                conector.close();
                pst.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }
            y++;
        } while (x != 1);
        Principal.cierres.labeltotal.setText("€" + Double.toString(acumulador_montos)); // SETEO TODOS LOS VALORES EN LA INTERFAZ DE CIERRE. 
        Principal.cierres.labelunidades.setText(Integer.toString(acumulador_unidades));
        Principal.cierres.labeltickets.setText(Integer.toString(acumulador_tickets));
        Principal.cierres.labeldevoluciones.setText(Integer.toString(acumulador_devs));
        Principal.cierres.importedevs.setText("€" + Double.toString(acumulador_montodevs));
    }

    public void CierreDataBase(String fecha, String monto, String unidades, String tickets, String devoluciones, String monto_devoluciones) { // EFECTUO EL CIERRE Y ENVIO LOS DATOS A LA DATA BASE DE CIERRES.

        Connection conector = null;
        PreparedStatement pst = null;

        try {
            conector = DriverManager.getConnection("jdbc:mysql://localhost/empresa_cierres", "root", "");
            pst = conector.prepareStatement("INSERT INTO cierres VALUES (?,?,?,?,?,?) ");

            pst.setString(1, fecha);
            pst.setString(2, monto);
            pst.setString(3, unidades);
            pst.setString(4, tickets);
            pst.setString(5, devoluciones);
            pst.setString(6, monto_devoluciones);

            pst.executeUpdate();

            conector.close();
            pst.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public boolean CierreDeHoy(String fecha) { // VALIDO SI YA SE CERRO LA CAJA DEL DIA.
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            conector = DriverManager.getConnection("jdbc:mysql://localhost/empresa_cierres", "root", "");
            pst = conector.prepareStatement("select * from cierres where Fecha = ?");

            pst.setString(1, fecha);

            rs = pst.executeQuery();

            if (rs.next()) {

                return true;

            }

            conector.close();
            pst.close();
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        return false;
    }

    public void Remito() {
        Connection conector = null;
        PreparedStatement pst = null;                                       //VALIDO EL NUMERO DE REMITO CON LOS QUE YA ESTAN EN LA DB.
        ResultSet rs = null;

        int y = 0;

        do {

            try {                                                                                                                                                                                     

                conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_egresos", "root", "");
                pst = conector.prepareStatement("select * from egresos where ID = ?");

                pst.setString(1, Integer.toString(idremito));

                rs = pst.executeQuery();

                if (rs.next()) {

                    idremito++;
                } else {
                    y = 1;
                }

                conector.close();
                pst.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        } while (y != 1);

    }

    public void RegistrandoRemito(String remito, String cantidad, String monto, String destino, String concepto) { // INGRESO UN REMITO NUEVO A LA DB
        Connection conector = null;
        PreparedStatement pst = null;

        String articulos = "";

        for (int i = 0; i < Egresos.modeloegresos.getRowCount(); i++) {

            if (i == (Egresos.modeloegresos.getRowCount()) - 1) {
                articulos += Egresos.codigosegreso[i];
            } else {
                articulos += Egresos.codigosegreso[i] + ",";
            }

        }

        try {
            conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_egresos", "root", "");
            pst = conector.prepareStatement("INSERT INTO egresos VALUES (?,?,?,?,?,?,?) ");
            pst.setString(1, "0");
            pst.setString(2, remito);
            pst.setString(3, articulos);
            pst.setString(4, cantidad);
            pst.setString(5, monto);
            pst.setString(6, destino);
            pst.setString(7, concepto);

            pst.executeUpdate();

            conector.close();
            pst.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public void NuevoCliente(String documento, String nombre, String domicilio, String telefono) { // REGISTRO UN NUEVO CLIENTE
        Connection conector = null;
        PreparedStatement pst = null;

        try {
            conector = DriverManager.getConnection("jdbc:mysql://localhost/exodus_clientes", "root", "");
            pst = conector.prepareStatement("INSERT INTO clientes VALUES (?,?,?,?) ");
            pst.setString(1, documento);
            pst.setString(2, nombre);
            pst.setString(3, domicilio);
            pst.setString(4, telefono);

            pst.executeUpdate();

            conector.close();
            pst.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Debe rellenar todos los datos correctamente.");

        }

    }

    public void GuardarComisiones() { // ALMACENO LAS COMISIONES EN LA LISTA PARA PINTARLAS EN LA JTABLE
        Connection conector = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        int x = 0, aux = 1;

        do {
            try {

                conector = DriverManager.getConnection("jdbc:mysql://localhost/empresa_comisiones", "root", "");
                pst = conector.prepareStatement("select * from comisiones where ID = ?");

                pst.setString(1, Integer.toString(aux));

                rs = pst.executeQuery();

                if (rs.next()) {
                    Principal.listacomisiones.Enlistar(Integer.toString(aux), rs.getString("Fecha"), rs.getString("Vendedor"), rs.getString("Unidades"), rs.getString("Monto"));
                    cantidad_comisiones++;
                    aux++;
                } else {

                    x = 1;
                }
                
                conector.close();
                pst.close();
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());

            }
        } while (x != 1);

    }

}

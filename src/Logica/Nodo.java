package Logica;

public class Nodo {
    
    public String[] informacion = new String[5];
    
    public Nodo siguiente = null;
    
    public Nodo(String id, String codigo, String descripcion, String precio, String stock){
    
    informacion[0] = id;
    informacion[1] = codigo;
    informacion[2] = descripcion;
    informacion[3] = precio;
    informacion[4] = stock;
    }
    
}

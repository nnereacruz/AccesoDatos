/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasolinera;

/**
 *
 * @author nerea
 */
import java.time.LocalDate;
public class Pagos implements Comparable<Pagos> { //clase de la cual se creraran todos los pagos
    private static int contador=0;
    private int id;
    private int id_cliente;
    private LocalDate fecha;
    private double importe;
    private double litros;
    private String combustible;

    public Pagos( int id_cliente, LocalDate fecha, double importe, double litros, String combustible) {
        this.id = contador;
        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.importe = Math.round(importe*100.0)/100.0;
        this.litros = Math.round(litros*100.0)/100.0;
        this.combustible = combustible;
        contador++;
    }
    public static void actualizarContador(int siguienteId){
        contador=siguienteId;
    }

    public int getId() {
        return id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public double getImporte() {
        return importe;
    }

    public double getLitros() {
        return litros;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    @Override
    public String toString() {
        return "Pagos{" + "id=" + id + ", id_cliente=" + id_cliente + ", fecha=" + fecha + ", importe=" + importe + ", litros=" + litros + ", combustible=" + combustible + '}';
    }

    @Override
    public int compareTo(Pagos o) {//metodo para ordenar los pagos por fecha descendente y si no por id
         int resultado = o.getFecha().compareTo(this.getFecha());

    if (resultado == 0) {
        resultado = Integer.compare(o.getId(), this.getId());
    }

    return resultado;
    }
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasolinera;

import java.util.Objects;

/**
 *
 * @author nerea
 */
public class Clientes {//clase de la cual se crearan todos lso cleintes
    private int id;
    private String nombre;
    private String matricula;
    private int telefono;
    private static int contador=1;

    public Clientes(String nombre, String matricula, int telefono) {
        this.id = contador;
        this.nombre = nombre;
        this.matricula = matricula;
        this.telefono = telefono;
        contador++;
    }

  public static void actualizarContador(int siguienteId){
      contador=siguienteId;
  }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getTelefono() {
        return telefono;
    }
    

   

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clientes other = (Clientes) obj;
        return this.matricula.equalsIgnoreCase(other.matricula);
    }

    @Override
    public String toString() {
        return "Clientes{" + "id=" + id + ", nombre=" + nombre + ", matricula=" + matricula + ", telefono=" + telefono + '}';
    }
    
    

   
    
    
    
    
}

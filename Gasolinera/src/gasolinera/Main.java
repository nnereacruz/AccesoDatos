/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasolinera;

/**
 *
 * @author nerea
 */
import java.util.*;

public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
      Gasolinera gasolinera=new Gasolinera();
        int opcion=-1;
        
        while(opcion!=0){//menu que se repetira hasta que el usuario ingrese 0
       
        System.out.println("==GESTION GASOLINERA==");
        System.out.println("1.Dar de alta un cliente");
        System.out.println("2.Listar clientes");
        System.out.println("3.Buscar clientes");
        System.out.println("4.Procesar pago");
        System.out.println("5.Consultar pagos");
        System.out.println("0.Salir");
        System.out.println("Opcion:");
         opcion = sc.nextInt();
         sc.nextLine();
        
        switch(opcion){
            
            case 1:
                gasolinera.altaCliente(sc);
                break;
                
            case 2:
                gasolinera.listarClientes();
                break;
                
            case 3:
                gasolinera.buscarClientes(sc);
                break;
                
            case 4:
                gasolinera.ProcesarPago(sc);
                break;
                
            case 5:
                gasolinera.buscarPagos(sc);
                break;
                
            case 0:
                System.out.println("SALIENDO...");
        }
        }
        sc.close();
        
    }
 
}

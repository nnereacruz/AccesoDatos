/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gasolinera;

/**
 *
 * @author nerea
 */
import java.io.IOException;
import java.util.*;
import java.time.LocalDate;
public class Gasolinera { //clase que manejara todos los metodos necesarios

List<Cliente> listaclientes = new ArrayList<>();
List <Pagos> listapagos = new ArrayList<>();
Persistencia persistencia;

    public Gasolinera(Persistencia persistencia) {
    this.persistencia=persistencia;
        persistencia.crearFichero();
        persistencia.cargarClientes(listaclientes);
        persistencia.cargarPagos(listapagos);
    
            
        
    }

    public void altaCliente(Scanner sc ){//metodo para dar de alta a un cliente
  
    
     System.out.println("Introduce nombre(campo obligatorio):");
      String nombre = sc.nextLine();
    while(nombre.isEmpty()){
    System.out.println("Este campo no puede estar vacio:");
     nombre = sc.nextLine();
    }
      System.out.println("Introduce matricula(campo obligatorio): ");
       String matricula= sc.nextLine();
    while(matricula.isEmpty()){
    System.out.println("Este campo no puede estar vacio: ");
    matricula= sc.nextLine();
   
    }
     for(Cliente cl:listaclientes){
        if(cl.getMatricula().equalsIgnoreCase(matricula)){
            System.out.println("Esta matricula ya esta registrada");
        return;}
    }
     System.out.println("Introduce telefono(campo obligatorio):");
       int telefono = sc.nextInt();
    while(telefono<100000000){
    System.out.println("Este campo debe tener nueve cifras:");
     telefono = sc.nextInt();
    
    }
     Cliente cliente=new Cliente(nombre,matricula,telefono);
     listaclientes.add(cliente);
    persistencia.guardarCliente(cliente);

     System.out.println("Cliente guardado:"+cliente.getId()+" "+nombre+" "+matricula+" "+telefono);
     
     
    
}

public void listarClientes(){//metodo para listar a todos los clientes añadidos
    System.out.println("==LISTA CLIENTES==");
    for(Cliente cl : listaclientes){
        System.out.println(cl);
    }
    
}
 public void buscarClientes(Scanner sc){
    
     System.out.println("Introduce texto a buscar:");
     String texto = sc.nextLine();
     
     while(texto.isEmpty()){
         System.out.println("Debes introducir algo en el texto para buscar:");
         texto=sc.nextLine();
     }
     
     
     boolean encontrado = false;
     for(Cliente cl:listaclientes){
         if(cl.getNombre().toLowerCase().contains(texto)|| cl.getMatricula().toLowerCase().contains(texto)|| String.valueOf(cl.getTelefono()).contains(texto)){
             System.out.println(cl);
             encontrado=true;
         }
         
         if(!encontrado){
             System.out.println("No hay relaciones con el texto introducido");
         }
         
         
     }
     
     
    
     

    
}
  public void ProcesarPago(Scanner sc){ //metodo para procesar pagos 
         if(listaclientes.isEmpty()){
             System.out.println("Debes ingresar un cliente primero");
             return;
         }
         System.out.println("==CLIENTES DISPONIBLES==");
         for(Cliente cl :listaclientes){
             System.out.println(cl);
         }
         System.out.println("Introduce id cliente para procesar pago:");
         int id = sc.nextInt();
         sc.nextLine();
         
         while(id<0){
             System.out.println("El id debe ser un numero positivo, introduce uno:");
         }
         Cliente cliente =null;
         for(Cliente cl:listaclientes){
             if(cl.getId()==id){
                 cliente=cl;
                 
             }
         }
         if(cliente==null){
             System.out.println("No hay clientes registrados con ese id");
             return;
         }
         
         System.out.println("Introduce fecha:");  
        String fechatexto = sc.nextLine();
         
         LocalDate fecha;
         if(fechatexto.isEmpty()){
             fecha= LocalDate.now();
         }else{
             fecha=LocalDate.parse(fechatexto);
         }
         
         System.out.println("Introduce importe:");
         double importe = sc.nextDouble();
         
         while(String.valueOf(importe).isEmpty()){
             System.out.println("Este campo no puede estar vacio.Introduzca importe:");
             importe = sc.nextDouble();
         }
         
          System.out.println("Introduce litros:");
         double litros = sc.nextDouble();
         
         while(String.valueOf(litros).isEmpty()){
             System.out.println("Este campo no puede estar vacio.Introduzca importe:");
             litros = sc.nextDouble();
         }
         sc.nextLine();
         
          System.out.println("Introduce combustible(diesel/gasolina):");
        String combustible = sc.nextLine();
        
         
         while(combustible.isEmpty()||!combustible.equalsIgnoreCase("gasolina")&&!combustible.equalsIgnoreCase("diesel")){
             System.out.println("Combustible no valido,introduce diesel o gasolina:");
             combustible = sc.nextLine();
             
             
         }
         Pagos pago = new Pagos(id,fecha,importe,litros,combustible);
         listapagos.add(pago);
         persistencia.guardarPago(pago);
         System.out.println("==CONFIRMACION==");
         System.out.println(pago.getId()+" "+cliente.getNombre()+" "+importe+"€");
         
     }
  
  public void buscarPagos(Scanner sc){//metodo para mostrar pagos
      
      if(listapagos.isEmpty()){
          System.out.println("No hay pagos disponibles");
          return;
      }
      Collections.sort(listapagos);
      for (Pagos pago :listapagos){
          System.out.println(pago);
      }
  }

}

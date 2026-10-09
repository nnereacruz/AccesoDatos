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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.nio.file.StandardOpenOption;
import java.nio.charset.StandardCharsets;
public class FicherosCSV implements Persistencia{//clase para almacenar todos los datos del programa y poder reutizarlos

    private final Path carpeta = Path.of("datos");
    private final Path ficheroCliente = carpeta.resolve("clientes.csv");//Path crea las  rutas
    private final Path ficheroPagos = carpeta.resolve("pagos.csv");//resolve es para meter ese archivo/carpeta dentro de la carpeta principal

    public void crearFichero(){
        try{
            Files.createDirectories(carpeta);//crea directorios y archivos
            if(!Files.exists(ficheroCliente)){//Busca si existe ese archivo
                Files.writeString(ficheroCliente,"id;nombre;matricula;tlfno\n");//escribe dentro del archivo
            }

            if(!Files.exists(ficheroPagos)){
                Files.writeString(ficheroPagos,"id;id_cliente;fecha;importe;litros;combustible\n");
            }
        }catch(IOException e){
            System.out.println("Error al crear carpetas: "+e.getMessage());
        }
    }



    public void guardarCliente(Cliente cliente){
    try{
        String linea = cliente.getId()+";"+cliente.getNombre()+";"+cliente.getMatricula()+";"+ cliente.getTelefono()+"\n";
System.out.println("GUARDANDO EN: " + ficheroCliente.toAbsolutePath());
        System.out.println("LINEA: " + linea);
        Files.writeString(ficheroCliente,linea,StandardOpenOption.APPEND);//APPEND se utiliza para añadir una linea nueva sin borrar lo demas
    }catch (IOException e ){
        System.out.println("Error al guardar clientes: "+e.getMessage());
    }
    }

    public void guardarPago(Pagos pago){
    try{
        String linea=pago.getId()+";"+pago.getId_cliente()+";"+pago.getFecha()+";"+pago.getImporte()+";"+ pago.getLitros()+";"+pago.getCombustible()+"\n";//tambien en vez de \n se puede poner System.lineSeparator()
        Files.writeString(ficheroPagos,linea,StandardOpenOption.APPEND);
    }catch (IOException e){
        System.out.println("Error al guardar pago:"+e.getMessage());
    }
    }
    public void cargarClientes(List <Cliente> listaClientes) {
        try {
            List<String> lineas = Files.readAllLines(ficheroCliente, StandardCharsets.UTF_8);
            int maxId = 0;
            for (int i = 1; i < lineas.size(); i++) {
                String linea = lineas.get(i).trim();
                String[] datos = linea.split(";");

                int id = Integer.parseInt(datos[0]);
                String nombre = datos[1];
                String matricula = datos[2];
                int telefono = Integer.parseInt(datos[3]);

                Cliente cliente = new Cliente(nombre, matricula, telefono);
                cliente.setId(id);
                listaClientes.add(cliente);

                if (id > maxId) {
                    maxId = id;
                }
            

            }
                Cliente.actualizarContador(maxId + 1);
        }catch(IOException e){
                System.out.printf("Error al cargar clientes: "+e.getMessage());
            }


    }

    public void cargarPagos(List <Pagos> listaPagos){
        try{
            List <String> lineas = Files.readAllLines(ficheroPagos,StandardCharsets.UTF_8);

            int maxId=0;

            for (int i = 1; i < lineas.size(); i++) {

                String linea = lineas.get(i).trim();

                String[] datos = linea.split(";");

                int id = Integer.parseInt(datos[0]);
                int id_cliente = Integer.parseInt(datos[1]);
                LocalDate fecha = LocalDate.parse(datos[2]);
                double importe = Double.parseDouble(datos[3]);
                double litros = Double.parseDouble(datos[4]);
                String combustible = datos[5];

                Pagos pago= new Pagos(id_cliente,fecha,importe,litros,combustible);

                pago.setId(id);

                listaPagos.add(pago);

                if (id > maxId) {
                    maxId = id;
                }
            }

            Pagos.actualizarContador(maxId + 1);

        } catch (IOException e) {

            System.out.println("Error al cargar los clientes: " + e.getMessage());

        }



    }
}

package gasolinera;

import java.util.List;
import java.nio.file.Files;
import com.google.gson.Gson;
import java.nio.file.Path;
import java.io.*;
public class FicherosJSON implements Persistencia{
private final Path carpeta = Path.of("datos");
private final Path ficheroCliente = carpeta.resolve("clientes.json");
private final Path ficheroPagos = carpeta.resolve("pagos.json");
    @Override
    public void crearFichero() {
        try {
            Files.createDirectories(carpeta);

            if (!Files.exists(ficheroCliente)) {
                Files.writeString(ficheroCliente, "[]");
            }

            if (!Files.exists(ficheroPagos)) {
                Files.writeString(ficheroPagos, "[]");
            }

        } catch (IOException e) {
            System.out.println("Error al crear los ficheros: " + e.getMessage());
        }
    }

    @Override
    public void guardarCliente(Cliente cliente) {
        try {
            String linea = Files.readString(ficheroCliente);

            List<Cliente> listaclientes = new Gson().fromJson(
                    linea,
                    new com.google.gson.reflect.TypeToken<List<Cliente>>(){}.getType()
            );


            listaclientes.add(cliente);

            String json = new Gson().toJson(listaclientes);
            Files.writeString(ficheroCliente, json.replace("},{", "},\n{"));//para saltos de linea en cada cliente

        } catch (IOException e) {
            System.out.println("Error al guardar el cliente: " + e.getMessage());
        }
    }

    @Override
    public void cargarClientes(List<Cliente> listaClientes) {
        try {
            String lineas = Files.readString(ficheroCliente);

            List<Cliente> clientes = new Gson().fromJson(
                    lineas,
                    new com.google.gson.reflect.TypeToken<List<Cliente>>(){}.getType()
            );

            if (clientes != null) {
                listaClientes.addAll(clientes);
            }

        } catch (IOException e) {
            System.out.println("Error al cargar clientes: " + e.getMessage());
        }
    }

    @Override
    public void guardarPago(Pagos pago) {
        try {
            String linea = Files.readString(ficheroPagos);
            List<Pagos> listapagos = new Gson().fromJson(linea,
                    new com.google.gson.reflect.TypeToken<List<Cliente>>() {
                    }.getType());

            listapagos.add(pago);

            String json = new Gson().toJson(listapagos);
            Files.writeString(ficheroPagos,json.replace("},{","},\n{"));

        }catch(IOException e){
            System.out.println("Errror al guardar pago:"+e.getMessage());
        }
    }

    @Override
    public void cargarPagos(List<Pagos> listaPagos) {
        try{
            String lineas = Files.readString(ficheroPagos);
            List <Pagos> pagos = new Gson().fromJson(
                    lineas,
                    new com.google.gson.reflect.TypeToken<List<Pagos>>(){}.getType()
            );
            if(pagos!=null){
                listaPagos.addAll(pagos);
            }

        }catch (IOException e){
            System.out.println("Error al cargar pagos:"+e.getMessage());
        }
    }

}




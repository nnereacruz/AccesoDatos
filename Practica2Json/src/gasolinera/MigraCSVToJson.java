/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gasolinera;

/**
 *
 * @author Admin
 */
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.io.*;
public class MigraCSVToJson {  //Esta clase la cree antes de usar la interfaz persistencia, literalmente es una clase traductora pero que no voy a utilizar ya que voy a usar otra logica para el programa
    private final Path ficheroCSVcl = Path.of("datos", "clientes.csv");
    private final Path ficheroJSONcl = Path.of("datos", "clientes.json");
    private final Path fichreroCSVpg = Path.of("datos", "pagos.csv");
    private final Path ficheroJSONpg = Path.of("datos", "pagos.json");

    public void migrarClientes() {
        try {
            List<String> lineas = Files.readAllLines(ficheroCSVcl);

            String json = "{\n";
            json+="\t[\n";

            for (int i = 1; i < lineas.size(); i++) {

                String[] datos = lineas.get(i).split(";");

                json += "  {";


                json += "    \"id\": " + datos[0] ;
                json += "    \"nombre\": \"" + datos[1] ;
                json += "    \"matricula\": \"" + datos[2] ;
                json += "    \"tlfno\": " + datos[3] ;

                json += "  }";

                if (i < lineas.size() - 1) {
                    json += ",";
                }

                json += "\n";
            }

            json += "\t]";
            json+="\n}";

            Files.writeString(ficheroJSONcl, json);

            System.out.println("Clientes migrados correctamente.");


        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public void migrarPagos() {
        try {
            List<String> lineas = Files.readAllLines(fichreroCSVpg);
            String json = "[\n";
            json+="\t{\n";

            for (int i = 1; i < lineas.size(); i++) {
                String datos[] = lineas.get(i).split(";");

                json += "{";

                json += " \"id\": " + datos[0];
                json += " \"id_cliente\" " + datos[1];
                json += " \"fecha\" " + datos[2];
                json += " \"importe\"" + datos[3];
                json += "\"litros\"" + datos[4];
                json += "\"combustible\"" + datos[5];

                json += "}";

                if(i<lineas.size()-1){
                    System.out.println(",");
                }

        json+="\n";
            }
            json+="\t]";
            json +="\n}";
            Files.writeString(ficheroJSONpg,json);
            System.out.println("Convertido correctamente");


        }catch(IOException e){
            System.out.println("Error+"+e.getMessage());
        }
    }
}

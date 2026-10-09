package gasolinera;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;

public interface Persistencia {

    public void crearFichero();

    public void guardarCliente(Cliente cliente);


    public void guardarPago(Pagos pago);

    public void cargarClientes(List<Cliente> listaClientes);

    public void cargarPagos(List<Pagos> listaPagos);
}
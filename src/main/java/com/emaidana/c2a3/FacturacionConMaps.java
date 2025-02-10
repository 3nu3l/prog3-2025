import java.util.*;

public class FacturacionConMaps {
    public static void main(String[] args) {
        // Lista de facturas
        List<Factura> facturas = List.of(
            new Factura(1, 101, 500.0),
            new Factura(2, 102, 300.0),
            new Factura(3, 101, 200.0),
            new Factura(4, 103, 100.0)
        );

        // Lista de clientes
        List<Cliente> clientes = List.of(
            new Cliente(101, "Cliente A"),
            new Cliente(102, "Cliente B"),
            new Cliente(103, "Cliente C")
        );

        // Usar un Map para almacenar la suma de importes por cliente
        Map<Integer, Double> sumaPorCliente = new HashMap<>();
        for (Factura factura : facturas) {
            sumaPorCliente.put(factura.idCliente,
                sumaPorCliente.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        // Generar resultados combinando los clientes con sus sumas
        List<Resultado> resultados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            resultados.add(new Resultado(cliente.idCliente, cliente.nombre,
                sumaPorCliente.getOrDefault(cliente.idCliente, 0.0)));
        }

        // Imprimir resultados
        for (Resultado resultado : resultados) {
            System.out.println("Cliente ID: " + resultado.idCliente + ", Nombre: " + resultado.nombreCliente +
                               ", Suma de importes: " + resultado.sumaImportes);
        }
    }
}
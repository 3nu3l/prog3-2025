import java.util.ArrayList;
import java.util.List;

class Factura {
    int idFactura;
    int idCliente;
    double importe;

    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
}

class Cliente {
    int idCliente;
    String nombre;

    public Cliente(int idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }
}

class Resultado {
    int idCliente;
    String nombreCliente;
    double sumaImportes;

    public Resultado(int idCliente, String nombreCliente, double sumaImportes) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.sumaImportes = sumaImportes;
    }
}

public class FacturacionSinMaps {
    public static void main(String[] args) {
        List<Factura> facturas = List.of(
            new Factura(1, 101, 500.0),
            new Factura(2, 102, 300.0),
            new Factura(3, 101, 200.0),
            new Factura(4, 103, 100.0)
        );

        List<Cliente> clientes = List.of(
            new Cliente(101, "Cliente A"),
            new Cliente(102, "Cliente B"),
            new Cliente(103, "Cliente C")
        );

        List<Resultado> resultados = new ArrayList<>();

        for (Cliente cliente : clientes) {
            double suma = 0;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    suma += factura.importe;
                }
            }
            resultados.add(new Resultado(cliente.idCliente, cliente.nombre, suma));
        }

        for (Resultado resultado : resultados) {
            System.out.println("Cliente ID: " + resultado.idCliente + ", Nombre: " + resultado.nombreCliente +
                               ", Suma de importes: " + resultado.sumaImportes);
        }
    }
}
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    String nombre;
    double sumaImportes;

    public Resultado(int idCliente, String nombre, double sumaImportes) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.sumaImportes = sumaImportes;
    }

    @Override
    public String toString() {
        return "Resultado{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", sumaImportes=" + sumaImportes +
                '}';
    }
}

public class Facturacion {

    public static List<Resultado> generarListaSinMap(List<Factura> facturas, List<Cliente> clientes) {
        List<Resultado> resultados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            double sumaImportes = 0;
            for (Factura factura : facturas) {
                if (factura.idCliente == cliente.idCliente) {
                    sumaImportes += factura.importe;
                }
            }
            resultados.add(new Resultado(cliente.idCliente, cliente.nombre, sumaImportes));
        }
        return resultados;
    }

    public static List<Resultado> generarListaConMap(List<Factura> facturas, List<Cliente> clientes) {
        Map<Integer, Double> sumaImportesPorCliente = new HashMap<>();
        for (Factura factura : facturas) {
            sumaImportesPorCliente.put(factura.idCliente, sumaImportesPorCliente.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        List<Resultado> resultados = new ArrayList<>();
        for (Cliente cliente : clientes) {
            double sumaImportes = sumaImportesPorCliente.getOrDefault(cliente.idCliente, 0.0);
            resultados.add(new Resultado(cliente.idCliente, cliente.nombre, sumaImportes));
        }
        return resultados;
    }

    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 1, 100.0));
        facturas.add(new Factura(2, 1, 200.0));
        facturas.add(new Factura(3, 2, 300.0));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Cliente A"));
        clientes.add(new Cliente(2, "Cliente B"));

        List<Resultado> resultadosSinMap = generarListaSinMap(facturas, clientes);
        List<Resultado> resultadosConMap = generarListaConMap(facturas, clientes);

        System.out.println("Resultados sin Map:");
        for (Resultado resultado : resultadosSinMap) {
            System.out.println(resultado);
        }

        System.out.println("Resultados con Map:");
        for (Resultado resultado : resultadosConMap) {
            System.out.println(resultado);
        }
    }
}
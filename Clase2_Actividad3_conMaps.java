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

class ClienteImporte {
    int idCliente;
    String nombre;
    double sumaImportes;

    public ClienteImporte(int idCliente, String nombre, double sumaImportes) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.sumaImportes = sumaImportes;
    }
}

public class Clase2_Actividad3_conMaps {

    public static void main(String[] args) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 101, 500.00));
        facturas.add(new Factura(2, 102, 300.00));
        facturas.add(new Factura(3, 101, 200.00));
        
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(101, "Juan"));
        clientes.add(new Cliente(102, "Maria"));

        List<ClienteImporte> clienteImporteList = generarLista(clientes, facturas);

        for (ClienteImporte ci : clienteImporteList) {
            System.out.println("ID Cliente: " + ci.idCliente + ", Nombre: " + ci.nombre + ", Suma Importes: " + ci.sumaImportes);
        }
    }

    public static List<ClienteImporte> generarLista(List<Cliente> clientes, List<Factura> facturas) {
        Map<Integer, Double> importePorCliente = new HashMap<>();

        for (Factura factura : facturas) {
            importePorCliente.put(factura.idCliente, 
                importePorCliente.getOrDefault(factura.idCliente, 0.0) + factura.importe);
        }

        List<ClienteImporte> clienteImporteList = new ArrayList<>();

        for (Cliente cliente : clientes) {
            double sumaImportes = importePorCliente.getOrDefault(cliente.idCliente, 0.0);
            clienteImporteList.add(new ClienteImporte(cliente.idCliente, cliente.nombre, sumaImportes));
        }

        return clienteImporteList;
    }
}

/*
Diferencia en cuanto a la complejidad asintótica

Sin Maps:

Iterar sobre la lista de clientes: 𝑂(𝑛)
Por cada cliente, iterar sobre la lista de facturas: 𝑂(𝑚)
Complejidad total: 𝑂(𝑛⋅𝑚)


Con Maps:

Iterar sobre la lista de facturas para construir el Map: 𝑂(𝑚)
Iterar sobre la lista de clientes: 𝑂(𝑛)
Complejidad total: 𝑂(𝑚+𝑛) 

*/
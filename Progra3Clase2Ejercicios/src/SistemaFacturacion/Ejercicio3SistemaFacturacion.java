//Código sin map

package SistemaFacturacion;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio3SistemaFacturacion {

	public static void main(String[] args) {
		List<Factura> facturas = new ArrayList<>();
		facturas.add(new Factura(1, 101, 500));
        facturas.add(new Factura(2, 102, 300));
        facturas.add(new Factura(3, 101, 200));
        facturas.add(new Factura(4, 103, 150));
        
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(101, "Juan"));
        clientes.add(new Cliente(102, "María"));
        clientes.add(new Cliente(103, "Carlos"));
        
        List<Resultado> resultados = new ArrayList<>();
        
        for (Cliente cliente : clientes) {
            double total = 0;
            for (Factura factura : facturas) {
                if (factura.idCLiente == cliente.idCliente) {
                    total += factura.importe;
                }
            }
            resultados.add(new Resultado(cliente.idCliente, cliente.nombre, total));
        }

        for (Resultado resultado : resultados) {
            System.out.println(resultado);
        }
	}

}

package SistemaFacturacion;
import java.util.*;
public class SistemaFacturacionConMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 List<Factura> facturas = Arrays.asList(
		            new Factura(1, 101, 500),
		            new Factura(2, 102, 300),
		            new Factura(3, 101, 200),
		            new Factura(4, 103, 150)
		 );
		 
		 List<Cliente> clientes = Arrays.asList(
		            new Cliente(101, "Juan"),
		            new Cliente(102, "María"),
		            new Cliente(103, "Carlos")
		        );
		 Map<Integer, String> clienteMap = new HashMap<>();
		 for (Cliente cliente : clientes) {
	            clienteMap.put(cliente.idCliente, cliente.nombre);
	        }
		 Map<Integer, Double> totalFacturacion = new HashMap<>();
	        for (Factura factura : facturas) {
	            totalFacturacion.put(factura.idCLiente, totalFacturacion.getOrDefault(factura.idCLiente, 0.0) + factura.importe);
	        }

	        List<Resultado> resultados = new ArrayList<>();
	        for (Map.Entry<Integer, Double> entry : totalFacturacion.entrySet()) {
	            int idCliente = entry.getKey();
	            double total = entry.getValue();
	            String nombreCliente = clienteMap.get(idCliente);
	            resultados.add(new Resultado(idCliente, nombreCliente, total));
	        }

	        for (Resultado resultado : resultados) {
	            System.out.println(resultado);
	        }
	}

}

//La versión con Map es más eficiente porque evita recorrer la lista de clientes en cada iteración de facturas, reduciendo la complejidad de
//O(n*m) a O(n+m)

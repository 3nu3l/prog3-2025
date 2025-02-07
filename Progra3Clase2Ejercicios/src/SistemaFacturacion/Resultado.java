// Se utiliza para representar el resultado final del procesamiento de las facturas, agrupando los datos de cada cliente con la suma total de sus facturas.
package SistemaFacturacion;

public class Resultado {
	
	int idCliente;
	String nombreCliente;
	double totalFacturado;
	
	public Resultado(int idCliente, String nombreCliente, double totalFacturado) {
		this.idCliente= idCliente;
		this.nombreCliente=nombreCliente;
		this.totalFacturado= totalFacturado;
	}
	
	public String toString() {
		return "Cliente ID: "+ idCliente + ", Nombre: "+ nombreCliente + ", Total Facturado " + totalFacturado;
		
	}
}

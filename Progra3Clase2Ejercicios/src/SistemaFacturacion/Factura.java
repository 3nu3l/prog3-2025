package SistemaFacturacion;

public class Factura {
	
	int idFactura;
	int idCLiente;
	double importe;
	
	public Factura(int idFactura, int idCliente, double importe) {
		this.idFactura = idFactura;
		this.idCLiente = idCliente;
		this.importe = importe;
	}
}

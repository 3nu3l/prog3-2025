package Actividad3;


	public class Main {
	    public static void main(String[] args) {
	        RedElectrica red = new RedElectrica(5);
	        red.agregarConexion(0, 1, 2);
	        red.agregarConexion(0, 3, 6);
	        red.agregarConexion(1, 2, 3);
	        red.agregarConexion(1, 3, 8);
	        red.agregarConexion(1, 4, 5);
	        red.agregarConexion(2, 4, 7);
	        red.agregarConexion(3, 4, 9);
	        
	        red.prim();
	    }
	}

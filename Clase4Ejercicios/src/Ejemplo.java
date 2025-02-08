
public class Ejemplo {
	public static void main(String[] args) {
		int n = 50000; // Probar con 100000 elementos
		int[] numeros = new int[n];
		for (int i = 0; i < n; i++) {
			numeros[i] = 1;
		}
		System.out.println(suma(numeros));
	}
	private static int suma(int[] numeros) {
		return suma(numeros,0);
	}
	private static int suma(int[] numeros, int i) {
		if(i==numeros.length-1) return numeros[numeros.length-1];
		return numeros[i] + suma(numeros,i+1);
	}
}

//Shift + alt + S
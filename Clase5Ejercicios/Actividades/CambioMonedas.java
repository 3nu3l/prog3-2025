import java.util.*;


public class CambioMonedas { 
	// Función para encontrar la cantidad mínima de monedas
	public static List<Integer> encontrarMinimoMonedas(int[] monedas, int monto) {
		Arrays.sort(monedas);
		List<Integer> resultado = new ArrayList<>(); 
		for (int i = monedas.length - 1; i >= 0; i--) {
			while (monto >= monedas[i]) {
				monto -= monedas[i];
				resultado.add(monedas[i]);
			}
		} 
		return resultado;
	} 
	public static void main(String[] args) {
		int[] monedas = {1, 5, 10, 25};
		int monto = 36; 
		List<Integer> resultado = encontrarMinimoMonedas(monedas, monto); 
		System.out.println("Monedas usadas para hacer " + monto + ": " + resultado);
	}
}
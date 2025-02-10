package Actividad1;

	import java.util.Arrays;

	public class Actividad1 {
	    static final int INF = 99999;

	    public static void main(String[] args) {
	        int[][] grafo = {
	            {0, 2, INF, 5},  // Nodo 1
	            {INF, 0, INF, 4}, // Nodo 2
	            {INF, INF, 0, INF}, // Nodo 3
	            {INF, INF, 2, 0}  // Nodo 4
	        };

	        floydWarshall(grafo);
	    }

	    public static void floydWarshall(int[][] dist) {
	        int n = dist.length;

	        // Matriz de distancias inicial
	        System.out.println("Matriz inicial:");
	        imprimirMatriz(dist);

	        // Aplicar el algoritmo de Floyd-Warshall
	        for (int k = 0; k < n; k++) { // Nodo intermedio
	            for (int i = 0; i < n; i++) { // Nodo de origen
	                for (int j = 0; j < n; j++) { // Nodo de destino
	                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
	                        dist[i][j] = dist[i][k] + dist[k][j];
	                    }
	                }
	            }

	            // Imprimir la matriz en cada iteración
	            System.out.println("\nMatriz después de considerar el nodo " + (k + 1) + " como intermedio:");
	            imprimirMatriz(dist);
	        }

	        // Imprimir la matriz final de distancias mínimas
	        System.out.println("\nMatriz final de distancias más cortas:");
	        imprimirMatriz(dist);
	    }

	    public static void imprimirMatriz(int[][] matriz) {
	        for (int[] fila : matriz) {
	            for (int valor : fila) {
	                if (valor == INF) {
	                    System.out.print("INF\t");
	                } else {
	                    System.out.print(valor + "\t");
	                }
	            }
	            System.out.println();
	        }
	    }
	}

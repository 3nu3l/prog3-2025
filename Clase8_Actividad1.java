/*
 * Actividad 1

Tenemos 4 nodos y las siguientes aristas con sus respectivos pesos:
1 → 2, peso 2
2 → 4, peso 4
1 → 4, peso 5
4 → 3, peso 2
Realizar una prueba de escritorio para el algoritmo de Floyd-Warshall, el cual es
un algoritmo clásico de programación dinámica que permite calcular las distancias
más cortas entre todos los pares de nodos en un grafo ponderado.
 * 
 * 
 * 
 */


import java.util.Arrays;

@SuppressWarnings("unused")
public class Clase8_Actividad1 {
    final static int INF = 99999;

    public static void main(String[] args) {
        int[][] grafo = {
            {0, 2, INF, 5},
            {INF, 0, INF, 4},
            {INF, INF, 0, INF},
            {INF, INF, 2, 0}
        };

        floydWarshall(grafo);
    }

    public static void floydWarshall(int[][] grafo) {
        int n = grafo.length;
        int[][] dist = new int[n][n];

        // Inicializar la matriz de distancias
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = grafo[i][j];
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        imprimirMatriz(dist);
    }

    public static void imprimirMatriz(int[][] dist) {
        int n = dist.length;
        System.out.println("Matriz de distancias más cortas entre todos los pares de nodos:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
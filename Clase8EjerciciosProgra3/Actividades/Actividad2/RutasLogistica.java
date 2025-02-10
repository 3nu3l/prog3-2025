package Actividad2;

import java.util.Arrays;

public class RutasLogistica {
    static final int INF = 99999;

    public static void main(String[] args) {
        // Matriz de tiempos de viaje entre centros de distribución
        int[][] tiempos = {
            {0, 4, INF, 8, INF},  // Centro 1
            {INF, 0, -2, INF, 5}, // Centro 2
            {INF, INF, 0, 3, INF}, // Centro 3
            {INF, INF, INF, 0, 2}, // Centro 4
            {INF, -1, INF, INF, 0}  // Centro 5
        };

        floydWarshall(tiempos);
    }

    public static void floydWarshall(int[][] dist) {
        int n = dist.length;

        // Matriz de tiempos inicial
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
            System.out.println("\nMatriz después de considerar el centro " + (k + 1) + " como intermedio:");
            imprimirMatriz(dist);
        }

        // Verificar ciclos negativos
        if (tieneCicloNegativo(dist)) {
            System.out.println("\nEl sistema de rutas contiene un ciclo de costos negativos. Puede haber oportunidades de ahorro infinito.");
        } else {
            System.out.println("\nMatriz final de tiempos mínimos:");
            imprimirMatriz(dist);
        }
    }

    public static boolean tieneCicloNegativo(int[][] dist) {
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                return true;
            }
        }
        return false;
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

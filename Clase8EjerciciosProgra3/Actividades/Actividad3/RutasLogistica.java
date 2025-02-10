package Actividad3;

import java.util.Arrays;
import java.util.Scanner;

public class RutasLogistica {
    static final int INF = 99999;

    public static void main(String[] args) {
        int[][] tiempos = {
            {0, 4, INF, 8, INF},  // Centro 1
            {INF, 0, -2, INF, 5}, // Centro 2
            {INF, INF, 0, 3, INF}, // Centro 3
            {INF, INF, INF, 0, 2}, // Centro 4
            {INF, -1, INF, INF, 0}  // Centro 5
        };

        int[][] next = new int[tiempos.length][tiempos.length];

        // Inicializar la matriz de caminos
        inicializarNext(tiempos, next);
        
        // Aplicar Floyd-Warshall
        floydWarshall(tiempos, next);

        // Pedir origen y destino al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el centro de distribución de origen (1-5): ");
        int origen = scanner.nextInt() - 1;
        System.out.print("Ingrese el centro de distribución de destino (1-5): ");
        int destino = scanner.nextInt() - 1;
        
        // Mostrar el camino más corto
        if (tiempos[origen][destino] == INF) {
            System.out.println("No hay ruta disponible entre los centros " + (origen + 1) + " y " + (destino + 1));
        } else {
            System.out.println("\nTiempo mínimo: " + tiempos[origen][destino] + " minutos");
            System.out.print("Ruta: ");
            imprimirCamino(origen, destino, next);
        }
        
        scanner.close();
    }

    public static void floydWarshall(int[][] dist, int[][] next) {
        int n = dist.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];  // Actualizar el nodo siguiente
                    }
                }
            }
        }
    }

    public static void inicializarNext(int[][] dist, int[][] next) {
        int n = dist.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] != INF && i != j) {
                    next[i][j] = j;
                } else {
                    next[i][j] = -1;
                }
            }
        }
    }

    public static void imprimirCamino(int origen, int destino, int[][] next) {
        if (next[origen][destino] == -1) {
            System.out.println("No hay ruta disponible.");
            return;
        }
        System.out.print((origen + 1));
        while (origen != destino) {
            origen = next[origen][destino];
            System.out.print(" -> " + (origen + 1));
        }
        System.out.println();
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class FloydWarshallPath {
    static final int INF = 99999;

    public static void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];
        int[][] next = new int[n][n];

        // Inicializar la matriz de distancias y la de caminos
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = graph[i][j];
                if (graph[i][j] != INF && i != j) {
                    next[i][j] = j; // Siguiente nodo en el camino
                } else {
                    next[i][j] = -1;
                }
            }
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k]; // Actualizar la ruta
                    }
                }
            }
        }

        // Detectar ciclos negativos
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                System.out.println("¡Ciclo negativo detectado!");
                return;
            }
        }

        // Imprimir resultado de la matriz de distancias
        printSolution(dist);

        // Solicitar origen y destino
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese nodo de origen: ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese nodo de destino: ");
        int destino = scanner.nextInt();

        // Mostrar el camino más corto
        printPath(origen, destino, next);
        scanner.close();
    }

    // Función para imprimir la matriz de distancias mínimas
    public static void printSolution(int[][] dist) {
        int n = dist.length;
        System.out.println("Matriz de distancias mínimas:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    // Función para reconstruir el camino más corto
    public static void printPath(int origen, int destino, int[][] next) {
        if (next[origen][destino] == -1) {
            System.out.println("No existe un camino entre " + origen + " y " + destino);
            return;
        }
        
        System.out.print("Camino más corto: " + origen);
        while (origen != destino) {
            origen = next[origen][destino];
            System.out.print(" -> " + origen);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 3, INF, INF, INF, INF},
            {2, 0, INF, INF, INF, INF},
            {INF, 7, 0, 1, INF, INF},
            {6, INF, INF, 0, INF, INF},
            {INF, INF, INF, 5, 0, 2},
            {INF, INF, INF, INF, INF, 0}
        };

        floydWarshall(graph);
    }
}
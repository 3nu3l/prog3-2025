import java.util.Arrays;

public class FloydWarshall {
    static final int INF = 99999;

    public static void floydWarshall(int[][] graph) {
        int n = graph.length;
        int[][] dist = new int[n][n];

        // Copiar la matriz original de adyacencia
        for (int i = 0; i < n; i++)
            dist[i] = Arrays.copyOf(graph[i], n);

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < n; k++) { // Nodo intermedio
            for (int i = 0; i < n; i++) { // Nodo origen
                for (int j = 0; j < n; j++) { // Nodo destino
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
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

        // Imprimir resultado
        printSolution(dist);
    }

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
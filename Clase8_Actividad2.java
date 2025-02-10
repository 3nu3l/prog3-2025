/*
 * 
 * Actividad 2

Una empresa de logística tiene varios centros de distribución en diferentes ciudades de
una región y necesita optimizar las rutas de entrega de sus camiones. Cada centro de
distribución está conectado a otros centros mediante carreteras, y cada carretera tiene
un tiempo de viaje asociado en minutos. Además, algunos centros pueden tener costos
adicionales asociados que pueden resultar en tiempos negativos en algunas rutas
debido a descuentos especiales o condiciones excepcionales. La empresa desea no
solo minimizar el tiempo total de entrega desde su centro de distribución principal hasta
todas las otras ciudades, sino también identificar si existen ciclos negativos que podrían
llevar a oportunidades de ahorro infinito en el sistema de rutas.
Objetivo:
Aplicar el algoritmo de Floyd-Warshall para: Encontrar el tiempo mínimo de entrega
desde el centro de distribución principal hasta todos los demás centros de distribución,
considerando las diferentes rutas disponibles.
 * 
 * 
 * 
 */



import java.util.Arrays;

@SuppressWarnings("unused")
public class Clase8_Actividad2 {
    final static int INF = 99999;

    public static void main(String[] args) {
        int[][] grafo = {
            {0, 3, INF, 5},
            {2, 0, INF, 4},
            {INF, 1, 0, INF},
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

        // Verificar ciclos negativos
        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                System.out.println("El grafo contiene un ciclo negativo.");
               ;
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
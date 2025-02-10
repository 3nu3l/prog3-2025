/*
 * 
 * Actividad 3

Dada la consigna de la actividad 2, modificar o rehacer el programa, para que se
pida origen y destino y se imprima el camino más corto entre dos vértices.
 * 
 * 
 */

 import java.util.Arrays;
 import java.util.Scanner;
 
 @SuppressWarnings("unused")
public class Clase8_Actividad3 {
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
         int[][] next = new int[n][n];
 
         // Inicializar la matriz de distancias y la matriz de caminos
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 dist[i][j] = grafo[i][j];
                 if (grafo[i][j] != INF && i != j) {
                     next[i][j] = j;
                 } else {
                     next[i][j] = -1;
                 }
             }
         }
 
         // Aplicar el algoritmo de Floyd-Warshall
         for (int k = 0; k < n; k++) {
             for (int i = 0; i < n; i++) {
                 for (int j = 0; j < n; j++) {
                     if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                         dist[i][j] = dist[i][k] + dist[k][j];
                         next[i][j] = next[i][k];
                     }
                 }
             }
         }
 
         // Verificar ciclos negativos
         for (int i = 0; i < n; i++) {
             if (dist[i][i] < 0) {
                 System.out.println("El grafo contiene un ciclo negativo.");
                 return;
             }
         }
 
         // Imprimir la matriz de distancias
         imprimirMatriz(dist);
 
         // Pedir origen y destino
         @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
         System.out.print("Ingrese el nodo de origen: ");
         int origen = scanner.nextInt();
         System.out.print("Ingrese el nodo de destino: ");
         int destino = scanner.nextInt();
 
         // Imprimir el camino más corto
         imprimirCamino(origen, destino, next);
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
 
     public static void imprimirCamino(int origen, int destino, int[][] next) {
         if (next[origen][destino] == -1) {
             System.out.println("No hay camino disponible.");
             return;
         }
         System.out.print("El camino más corto desde " + origen + " hasta " + destino + " es: ");
         int actual = origen;
         while (actual != destino) {
             System.out.print(actual + " -> ");
             actual = next[actual][destino];
         }
         System.out.println(destino);
     }
 }
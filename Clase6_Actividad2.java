/*
 * 
 * Actividad 2

Implementación de un Grafo en una Matriz de Adyacencia
Objetivo: Implementar un grafo utilizando una matriz de adyacencia en Java y
realizar varias operaciones para manipular y consultar el grafo.
Descripción del Problema:
Dado un grafo dirigido, tu tarea es implementar las siguientes operaciones
utilizando una matriz de adyacencia:
Operaciones: Inicialización del Grafo, Agregar Arista, Eliminar Arista, Verificar
Arista, Listar Adyacentes, Contar Grado de Entrada y Salida: Implementa métodos
para contar el grado de salida (número de aristas que salen) y el grado de entrada
(número de aristas que entran) de un vértice dado.
 * 
 * 
 */

 import java.util.*;

 class Grafo {
     private int numVertices;
     private int[][] matrizAdyacencia;
 
     public Grafo(int numVertices) {
         this.numVertices = numVertices;
         matrizAdyacencia = new int[numVertices][numVertices];
     }
 
     public void agregarArista(int origen, int destino) {
         if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
             matrizAdyacencia[origen][destino] = 1;
         }
     }
 
     public void eliminarArista(int origen, int destino) {
         if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
             matrizAdyacencia[origen][destino] = 0;
         }
     }
 
     public boolean verificarArista(int origen, int destino) {
         if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
             return matrizAdyacencia[origen][destino] == 1;
         }
         return false;
     }
 
     public List<Integer> listarAdyacentes(int vertice) {
         List<Integer> adyacentes = new ArrayList<>();
         if (vertice >= 0 && vertice < numVertices) {
             for (int i = 0; i < numVertices; i++) {
                 if (matrizAdyacencia[vertice][i] == 1) {
                     adyacentes.add(i);
                 }
             }
         }
         return adyacentes;
     }
 
     public int contarGradoSalida(int vertice) {
         int gradoSalida = 0;
         if (vertice >= 0 && vertice < numVertices) {
             for (int i = 0; i < numVertices; i++) {
                 if (matrizAdyacencia[vertice][i] == 1) {
                     gradoSalida++;
                 }
             }
         }
         return gradoSalida;
     }
 
     public int contarGradoEntrada(int vertice) {
         int gradoEntrada = 0;
         if (vertice >= 0 && vertice < numVertices) {
             for (int i = 0; i < numVertices; i++) {
                 if (matrizAdyacencia[i][vertice] == 1) {
                     gradoEntrada++;
                 }
             }
         }
         return gradoEntrada;
     }
 
     public void imprimirMatriz() {
         for (int i = 0; i < numVertices; i++) {
             for (int j = 0; j < numVertices; j++) {
                 System.out.print(matrizAdyacencia[i][j] + " ");
             }
             System.out.println();
         }
     }
 }
 
 public class Clase6_Actividad2 {
     public static void main(String[] args) {
         Grafo grafo = new Grafo(5);
 
         grafo.agregarArista(0, 1);
         grafo.agregarArista(0, 2);
         grafo.agregarArista(1, 2);
         grafo.agregarArista(2, 0);
         grafo.agregarArista(2, 3);
 
         System.out.println("Matriz de Adyacencia:");
         grafo.imprimirMatriz();
 
         System.out.println("Adyacentes de 2: " + grafo.listarAdyacentes(2));
         System.out.println("Grado de Salida de 2: " + grafo.contarGradoSalida(2));
         System.out.println("Grado de Entrada de 2: " + grafo.contarGradoEntrada(2));
 
         grafo.eliminarArista(2, 0);
         System.out.println("Matriz de Adyacencia después de eliminar arista 2->0:");
         grafo.imprimirMatriz();
     }
 }
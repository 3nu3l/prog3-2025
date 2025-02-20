package Actividad3;


import java.util.*;
//Clase que representa el grafo de almacenes
class Grafo {
 private Map<Almacen, List<Almacen>> adjList;

 public Grafo() {
     this.adjList = new HashMap<>();
 }

 public void agregarAlmacen(Almacen almacen) {
     adjList.putIfAbsent(almacen, new ArrayList<>());
 }

 public void conectarAlmacenes(Almacen a1, Almacen a2) {
     adjList.get(a1).add(a2);
     adjList.get(a2).add(a1);
 }

 public void dfs(Almacen inicio) {
     Set<Almacen> visitados = new HashSet<>();
     System.out.println("Recorrido DFS desde " + inicio + ":");
     dfsRecursivo(inicio, visitados);
     System.out.println();
 }

 private void dfsRecursivo(Almacen actual, Set<Almacen> visitados) {
     if (visitados.contains(actual)) return;
     System.out.print(actual + " -> ");
     visitados.add(actual);
     for (Almacen vecino : adjList.get(actual)) {
         dfsRecursivo(vecino, visitados);
     }
 }

 public void bfs(Almacen inicio) {
     Set<Almacen> visitados = new HashSet<>();
     Queue<Almacen> cola = new LinkedList<>();
     cola.add(inicio);
     visitados.add(inicio);

     System.out.println("Recorrido BFS desde " + inicio + ":");
     while (!cola.isEmpty()) {
         Almacen actual = cola.poll();
         System.out.print(actual + " -> ");
         for (Almacen vecino : adjList.get(actual)) {
             if (!visitados.contains(vecino)) {
                 visitados.add(vecino);
                 cola.add(vecino);
             }
         }
     }
     System.out.println();
 }
}
/*
 * 
 * Actividad 4

Una empresa de logística tiene varios centros de distribución en diferentes
ciudades de una región y necesita optimizar las rutas de entrega de sus
camiones. Cada centro de distribución está conectado a otros centros mediante
carreteras, y cada carretera tiene un tiempo de viaje asociado en minutos. La
empresa desea minimizar el tiempo total de entrega desde su centro de
distribución principal hasta todas las otras ciudades.
Objetivo:
Aplicar el algoritmo de Dijkstra para encontrar el tiempo mínimo de entrega desde
el centro de distribución principal hasta los demás centros, considerando las
diferentes rutas disponibles.
 * 
 * 
 * 
 */
import java.util.*;

class Nodo implements Comparable<Nodo> {
    int id, distancia;

    public Nodo(int id, int distancia) {
        this.id = id;
        this.distancia = distancia;
    }

    @Override
    public int compareTo(Nodo otro) {
        return Integer.compare(this.distancia, otro.distancia);
    }
}

class Grafo3 {
    private int numVertices;
    private List<List<Nodo>> listaAdyacencia;

    public Grafo3(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int tiempo) {
        listaAdyacencia.get(origen).add(new Nodo(destino, tiempo));
        listaAdyacencia.get(destino).add(new Nodo(origen, tiempo)); // Grafo no dirigido
    }

    public void dijkstra(int inicio) {
        int[] distancias = new int[numVertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[inicio] = 0;

        PriorityQueue<Nodo> pq = new PriorityQueue<>();
        pq.add(new Nodo(inicio, 0));

        while (!pq.isEmpty()) {
            Nodo actual = pq.poll();
            int u = actual.id;

            for (Nodo vecino : listaAdyacencia.get(u)) {
                int v = vecino.id;
                int peso = vecino.distancia;

                if (distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    pq.add(new Nodo(v, distancias[v]));
                }
            }
        }

        System.out.println("Tiempo mínimo de entrega desde el centro de distribución principal:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Centro " + inicio + " a Centro " + i + " : " + distancias[i] + " minutos");
        }
    }
}

public class Clase6_Actividad4 {
    public static void main(String[] args) {
        Grafo3 grafo = new Grafo3(6);

        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 2, 15);
        grafo.agregarArista(1, 3, 12);
        grafo.agregarArista(2, 4, 10);
        grafo.agregarArista(3, 4, 2);
        grafo.agregarArista(3, 5, 1);
        grafo.agregarArista(4, 5, 5);

        grafo.dijkstra(0);
    }
}
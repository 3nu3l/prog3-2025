import java.util.*;

class Edge {
    int destino;
    int peso;

    public Edge(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}

class Grafo {
    private int numVertices;
    private List<List<Edge>> listaAdyacencia;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        listaAdyacencia.get(origen).add(new Edge(destino, peso));
        listaAdyacencia.get(destino).add(new Edge(origen, peso)); // Grafo no dirigido
    }

    public void dijkstra(int inicio) {
        int[] distancias = new int[numVertices];
        Arrays.fill(distancias, Integer.MAX_VALUE);
        distancias[inicio] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.peso));
        pq.add(new Edge(inicio, 0));

        while (!pq.isEmpty()) {
            Edge actual = pq.poll();
            int u = actual.destino;

            for (Edge vecino : listaAdyacencia.get(u)) {
                int v = vecino.destino;
                int peso = vecino.peso;

                if (distancias[u] + peso < distancias[v]) {
                    distancias[v] = distancias[u] + peso;
                    pq.add(new Edge(v, distancias[v]));
                }
            }
        }

        // Imprimir las distancias mínimas desde el nodo de inicio
        System.out.println("Distancias mínimas desde el nodo " + inicio + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Hasta nodo " + i + ": " + distancias[i] + " minutos");
        }
    }
}

public class DijkstraLogistica {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);

        // Agregar las carreteras con tiempos de viaje (minutos)
        grafo.agregarArista(0, 1, 4);
        grafo.agregarArista(0, 2, 2);
        grafo.agregarArista(1, 2, 5);
        grafo.agregarArista(1, 3, 10);
        grafo.agregarArista(2, 4, 3);
        grafo.agregarArista(4, 3, 4);
        grafo.agregarArista(3, 5, 11);

        // Encontrar las rutas mínimas desde el centro de distribución principal (nodo 0)
        grafo.dijkstra(0);
    }
}
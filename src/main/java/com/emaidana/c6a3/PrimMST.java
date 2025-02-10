import java.util.*;

class Edge implements Comparable<Edge> {
    int destino;
    int peso;

    public Edge(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Edge otra) {
        return this.peso - otra.peso;
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

    public void prim() {
        boolean[] enMST = new boolean[numVertices];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] parent = new int[numVertices];
        int[] key = new int[numVertices];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        // Empezamos desde el nodo 0
        key[0] = 0;
        pq.add(new Edge(0, 0));

        int costoTotal = 0;

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.destino;

            if (enMST[u]) continue;
            enMST[u] = true;
            costoTotal += edge.peso;

            for (Edge vecino : listaAdyacencia.get(u)) {
                int v = vecino.destino;
                int peso = vecino.peso;

                if (!enMST[v] && peso < key[v]) {
                    key[v] = peso;
                    pq.add(new Edge(v, peso));
                    parent[v] = u;
                }
            }
        }

        // Mostrar las conexiones del Árbol de Recubrimiento Mínimo
        System.out.println("Aristas del Árbol de Recubrimiento Mínimo:");
        for (int i = 1; i < numVertices; i++) {
            System.out.println(parent[i] + " - " + i + " (Costo: " + key[i] + ")");
        }
        System.out.println("Costo total del Árbol de Recubrimiento Mínimo: " + costoTotal);
    }
}

public class PrimMST {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);

        // Agregamos aristas (Ejemplo de conexiones con costos)
        grafo.agregarArista(0, 1, 4);
        grafo.agregarArista(0, 2, 3);
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 3, 2);
        grafo.agregarArista(2, 3, 4);
        grafo.agregarArista(3, 4, 2);
        grafo.agregarArista(4, 5, 6);

        // Ejecutar Prim para encontrar el Árbol de Recubrimiento Mínimo
        grafo.prim();
    }
}
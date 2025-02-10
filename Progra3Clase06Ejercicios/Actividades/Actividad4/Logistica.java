package Actividad4;

import java.util.*;

class Logistica {
    private int centros;
    private List<List<Conexion>> grafo;

    public Logistica(int centros) {
        this.centros = centros;
        grafo = new ArrayList<>();
        for (int i = 0; i < centros; i++) {
            grafo.add(new ArrayList<>());
        }
    }

    public void agregarRuta(int origen, int destino, int tiempo) {
        grafo.get(origen).add(new Conexion(destino, tiempo));
        grafo.get(destino).add(new Conexion(origen, tiempo)); // Grafo no dirigido
    }

    public void dijkstra(int inicio) {
        PriorityQueue<Conexion> pq = new PriorityQueue<>();
        int[] tiempoMinimo = new int[centros];
        Arrays.fill(tiempoMinimo, Integer.MAX_VALUE);
        tiempoMinimo[inicio] = 0;
        pq.add(new Conexion(inicio, 0));

        while (!pq.isEmpty()) {
            Conexion actual = pq.poll();
            int nodo = actual.destino;

            for (Conexion vecino : grafo.get(nodo)) {
                int nuevoTiempo = tiempoMinimo[nodo] + vecino.costo;
                if (nuevoTiempo < tiempoMinimo[vecino.destino]) {
                    tiempoMinimo[vecino.destino] = nuevoTiempo;
                    pq.add(new Conexion(vecino.destino, nuevoTiempo));
                }
            }
        }

        System.out.println("Tiempo mínimo de entrega desde el centro principal:");
        for (int i = 0; i < centros; i++) {
            System.out.println("Centro " + i + ": " + tiempoMinimo[i] + " minutos");
        }
    }
}
package Actividad3;

import java.util.*;

class RedElectrica {
    private int estaciones;
    private List<List<Conexion>> grafo;

    public RedElectrica(int estaciones) {
        this.estaciones = estaciones;
        grafo = new ArrayList<>();
        for (int i = 0; i < estaciones; i++) {
            grafo.add(new ArrayList<>());
        }
    }

    public void agregarConexion(int origen, int destino, int costo) {
        grafo.get(origen).add(new Conexion(destino, costo));
        grafo.get(destino).add(new Conexion(origen, costo)); // Grafo no dirigido
    }

    public void prim() {
        PriorityQueue<Conexion> pq = new PriorityQueue<>();
        boolean[] visitado = new boolean[estaciones];
        List<String> resultado = new ArrayList<>();
        int costoTotal = 0;
        
        pq.add(new Conexion(0, 0)); // Comenzamos desde el nodo 0

        while (!pq.isEmpty()) {
            Conexion actual = pq.poll();
            int nodo = actual.destino;

            if (visitado[nodo]) continue;
            visitado[nodo] = true;
            costoTotal += actual.costo;

            if (actual.costo > 0) {
                resultado.add("Conexión establecida con costo " + actual.costo);
            }
            
            for (Conexion vecino : grafo.get(nodo)) {
                if (!visitado[vecino.destino]) {
                    pq.add(vecino);
                }
            }
        }
        
        System.out.println("Conexiones establecidas:");
        for (String conexion : resultado) {
            System.out.println(conexion);
        }
        System.out.println("Costo total de la red: " + costoTotal);
    }
}
/*
 * 
 * Actividad 3

Diseño de una red de distribución eléctrica
Una empresa de energía necesita conectar varias estaciones eléctricas en una
región para asegurar que toda la zona esté alimentada de manera eficiente. Las
estaciones están ubicadas en diferentes ciudades y los costos de instalación de
las líneas eléctricas entre ellas varían según la distancia y el terreno.
Tareas:
Representar el grafo utilizando una lista de adyacencia.
Aplicar el algoritmo de Prim para determinar el Árbol de Recubrimiento Mínimo.
Mostrar el conjunto de conexiones resultante y calcular el costo total.
 * 
 * 
 */
import java.util.*;

class Arista implements Comparable<Arista> {
    int origen, destino, costo;

    public Arista(int origen, int destino, int costo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
    }

    @Override
    public int compareTo(Arista otra) {
        return this.costo - otra.costo;
    }
}

class Grafo2 {
    private int numVertices;
    private List<List<Arista>> listaAdyacencia;

    public Grafo2(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int costo) {
        listaAdyacencia.get(origen).add(new Arista(origen, destino, costo));
        listaAdyacencia.get(destino).add(new Arista(destino, origen, costo)); // Grafo no dirigido
    }

    public void primMST() {
        boolean[] enMST = new boolean[numVertices];
        PriorityQueue<Arista> pq = new PriorityQueue<>();
        List<Arista> resultado = new ArrayList<>();
        int costoTotal = 0;

        // Comenzar desde el vértice 0
        enMST[0] = true;
        pq.addAll(listaAdyacencia.get(0));

        while (!pq.isEmpty()) {
            Arista arista = pq.poll();

            if (enMST[arista.destino]) {
                continue;
            }

            enMST[arista.destino] = true;
            resultado.add(arista);
            costoTotal += arista.costo;

            for (Arista adyacente : listaAdyacencia.get(arista.destino)) {
                if (!enMST[adyacente.destino]) {
                    pq.add(adyacente);
                }
            }
        }

        System.out.println("Conjunto de conexiones resultante:");
        for (Arista arista : resultado) {
            System.out.println(arista.origen + " - " + arista.destino + " : " + arista.costo);
        }
        System.out.println("Costo total: " + costoTotal);
    }
}

public class Clase6_Actividad3 {
    public static void main(String[] args) {
        Grafo2 grafo = new Grafo2(6);

        grafo.agregarArista(0, 1, 4);
        grafo.agregarArista(0, 2, 4);
        grafo.agregarArista(1, 2, 2);
        grafo.agregarArista(1, 3, 5);
        grafo.agregarArista(2, 3, 5);
        grafo.agregarArista(2, 4, 6);
        grafo.agregarArista(3, 4, 3);
        grafo.agregarArista(3, 5, 2);
        grafo.agregarArista(4, 5, 3);

        grafo.primMST();
    }
}
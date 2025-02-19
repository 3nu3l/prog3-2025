/*
 * Actividad 2

Una empresa de viajes quiere implementar un sistema de selección de rutas que
permita a los usuarios encontrar el viaje más barato para llegar a un destino,
incluso realizando escalas.
Cada ciudad se representa como un nodo en un grafo dirigido, y cada ruta aérea
entre dos ciudades tiene un costo asociado. El sistema debe encontrar el camino
más barato desde una ciudad de origen hasta una ciudad destino, permitiendo
escalas si es necesario.
Permitir al usuario ingresar una ciudad de origen y una de destino.
Buscar la ruta más barata utilizando el algoritmo Uniform Cost Search (UCS).
Mostrar el costo mínimo y el itinerario de escalas.
 * 
 */

import java.util.*;

class Nodo {
    String ciudad;
    int costo;
    List<Nodo> ruta;

    Nodo(String ciudad, int costo, List<Nodo> ruta) {
        this.ciudad = ciudad;
        this.costo = costo;
        this.ruta = new ArrayList<>(ruta);
        this.ruta.add(this);
    }
}

public class Clasee13_Actividad2 {
    public static void main(String[] args) {
        Map<String, List<Nodo>> grafo = new HashMap<>();
        // Agregar rutas al grafo
        agregarRuta(grafo, "Buenos Aires", "Sao Paulo", 200);
        agregarRuta(grafo, "Buenos Aires", "Lima", 300);
        agregarRuta(grafo, "Sao Paulo", "Lima", 150);
        agregarRuta(grafo, "Sao Paulo", "Bogotá", 400);
        agregarRuta(grafo, "Lima", "Bogotá", 200);
        agregarRuta(grafo, "Bogotá", "México", 300);

        String origen = "Buenos Aires";
        String destino = "México";

        Nodo resultado = buscarRutaMasBarata(grafo, origen, destino);
        if (resultado != null) {
            System.out.println("Costo mínimo: " + resultado.costo);
            System.out.print("Itinerario: ");
            for (Nodo nodo : resultado.ruta) {
                System.out.print(nodo.ciudad + " ");
            }
        } else {
            System.out.println("No se encontró una ruta desde " + origen + " hasta " + destino);
        }
    }

    public static void agregarRuta(Map<String, List<Nodo>> grafo, String origen, String destino, int costo) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.get(origen).add(new Nodo(destino, costo, new ArrayList<>()));
    }

    public static Nodo buscarRutaMasBarata(Map<String, List<Nodo>> grafo, String origen, String destino) {
        PriorityQueue<Nodo> cola = new PriorityQueue<>(Comparator.comparingInt(n -> n.costo));
        cola.add(new Nodo(origen, 0, new ArrayList<>()));

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            if (actual.ciudad.equals(destino)) {
                return actual;
            }
            if (grafo.containsKey(actual.ciudad)) {
                for (Nodo vecino : grafo.get(actual.ciudad)) {
                    cola.add(new Nodo(vecino.ciudad, actual.costo + vecino.costo, actual.ruta));
                }
            }
        }
        return null;
    }
}
package Actividad2;

import java.util.*;

class City {
    String name;
    List<Route> routes;

    City(String name) {
        this.name = name;
        this.routes = new ArrayList<>();
    }

    void addRoute(City destination, int cost) {
        routes.add(new Route(destination, cost));
    }
}

class Route {
    City destination;
    int cost;

    Route(City destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }
}

class Node implements Comparable<Node> {
    City city;
    int cost;
    List<String> path;

    Node(City city, int cost, List<String> path) {
        this.city = city;
        this.cost = cost;
        this.path = new ArrayList<>(path);
        this.path.add(city.name);
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }
}

public class TravelSystem {

    public static void main(String[] args) {
        // Crear ciudades y rutas
        City a = new City("A");
        City b = new City("B");
        City c = new City("C");
        City d = new City("D");

        a.addRoute(b, 1);
        a.addRoute(c, 4);
        b.addRoute(c, 2);
        b.addRoute(d, 5);
        c.addRoute(d, 1);

        // Buscar la ruta más barata
        findCheapestRoute(a, d);
    }

    public static void findCheapestRoute(City start, City goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<>();
        frontier.add(new Node(start, 0, new ArrayList<>()));

        while (!frontier.isEmpty()) {
            Node current = frontier.poll();

            if (current.city.equals(goal)) {
                System.out.println("Costo mínimo: " + current.cost);
                System.out.println("Itinerario: " + String.join(" -> ", current.path));
                return;
            }

            for (Route route : current.city.routes) {
                frontier.add(new Node(route.destination, current.cost + route.cost, current.path));
            }
        }

        System.out.println("No se encontró una ruta.");
    }
}
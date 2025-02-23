package clase13;

import java.util.*;

class Node {
    String name;
    int cost;
    List<String> path;

    public Node(String name, int cost, List<String> path) {
        this.name = name;
        this.cost = cost;
        this.path = new ArrayList<>(path);
        this.path.add(name);
    }
}

public class actividad2 {
    private final Map<String, List<Node>> graph = new HashMap<>();

    // Agregar conexiones al grafo
    public void addEdge(String from, String to, int cost) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.get(from).add(new Node(to, cost, new ArrayList<>()));
    }

    // Método para realizar la búsqueda UCS con itinerario
    public void uniformCostSearch(String start, String goal) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        priorityQueue.add(new Node(start, 0, new ArrayList<>()))
;
        Set<String> visited = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            Node current = priorityQueue.poll();

            // Si alcanzamos el nodo objetivo, imprimimos la ruta y el costo
            if (current.name.equals(goal)) {
                System.out.println("El costo mínimo desde " + start + " hasta " + goal + " es: " + current.cost);
                System.out.println("Itinerario: " + String.join(" -> ", current.path));
                return;
            }

            // Si ya hemos visitado este nodo, lo ignoramos
            if (visited.contains(current.name)) continue;
            visited.add(current.name);

            // Explorar vecinos
            for (Node neighbor : graph.getOrDefault(current.name, new ArrayList<>())) {
                if (!visited.contains(neighbor.name)) {
                    priorityQueue.add(new Node(neighbor.name, current.cost + neighbor.cost, current.path));
                }
            }
        }

        System.out.println("No se encontró un camino desde " + start + " hasta " + goal);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UCS ucs = new UCS();

        // Agregar conexiones
        ucs.addEdge("A", "B", 2);
        ucs.addEdge("A", "C", 4);
        ucs.addEdge("B", "C", 1);
        ucs.addEdge("B", "D", 7);
        ucs.addEdge("C", "E", 3);
        ucs.addEdge("D", "E", 1);

        // Solicitar entrada al usuario
        System.out.print("Ingrese la ciudad de origen: ");
        String startCity = scanner.nextLine();
        System.out.print("Ingrese la ciudad de destino: ");
        String goalCity = scanner.nextLine();

        // Ejecutar UCS
        ucs.uniformCostSearch(startCity, goalCity);
    }
}

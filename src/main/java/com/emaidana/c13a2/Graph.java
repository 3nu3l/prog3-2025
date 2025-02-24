import java.util.*;

class Graph {
    private Map<String, List<Edge>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }

    public void addEdge(String from, String to, int cost) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.putIfAbsent(to, new ArrayList<>());
        graph.get(from).add(new Edge(to, cost));
    }

    public void uniformCostSearch(String start, String goal) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Map<String, Integer> visited = new HashMap<>();
        Map<String, String> path = new HashMap<>();

        queue.add(new Node(start, 0));
        visited.put(start, 0);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.city.equals(goal)) {
                printPath(path, start, goal, current.cost);
                return;
            }

            for (Edge edge : graph.getOrDefault(current.city, Collections.emptyList())) {
                int newCost = current.cost + edge.cost;

                if (!visited.containsKey(edge.to) || newCost < visited.get(edge.to)) {
                    visited.put(edge.to, newCost);
                    queue.add(new Node(edge.to, newCost));
                    path.put(edge.to, current.city);
                }
            }
        }
        System.out.println("No hay ruta disponible.");
    }

    private void printPath(Map<String, String> path, String start, String goal, int cost) {
        List<String> itinerary = new ArrayList<>();
        String step = goal;
        while (step != null) {
            itinerary.add(step);
            step = path.get(step);
        }
        Collections.reverse(itinerary);
        System.out.println("Ruta más barata: " + String.join(" -> ", itinerary));
        System.out.println("Costo mínimo: " + cost);
    }

    private static class Edge {
        String to;
        int cost;

        Edge(String to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class Node {
        String city;
        int cost;

        Node(String city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 100);
        graph.addEdge("A", "C", 300);
        graph.addEdge("B", "C", 50);
        graph.addEdge("B", "D", 200);
        graph.addEdge("C", "D", 100);
        graph.addEdge("C", "E", 400);
        graph.addEdge("D", "E", 100);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Desde A a E, ingrese ciudad de origen: ");
        String origen = scanner.nextLine();
        System.out.print("Desde A a E, ingrese ciudad de destino: ");
        String destino = scanner.nextLine();
        scanner.close();

        graph.uniformCostSearch(origen, destino);
    }
}
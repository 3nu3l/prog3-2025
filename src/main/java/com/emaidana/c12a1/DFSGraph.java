import java.util.*;

public class DFSGraph {
    private Map<Integer, List<Integer>> grafo;

    public DFSGraph() {
        this.grafo = new HashMap<>();
    }

    public void agregarArista(int origen, int destino) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.putIfAbsent(destino, new ArrayList<>());
        grafo.get(origen).add(destino);
    }

    public void DFS(int nodoInicial, Set<Integer> visitado) {
        if (visitado.contains(nodoInicial)) return;
        
        visitado.add(nodoInicial);
        System.out.println("Visitando nodo: " + nodoInicial);
        
        for (int vecino : grafo.getOrDefault(nodoInicial, Collections.emptyList())) {
            DFS(vecino, visitado);
        }
    }

    public static void main(String[] args) {
        DFSGraph grafo = new DFSGraph();
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(3, 6);
        grafo.agregarArista(4, 7);
        grafo.agregarArista(4, 8);
        
        System.out.println("Recorrido DFS desde el nodo 0:");
        grafo.DFS(0, new HashSet<>());
    }
}

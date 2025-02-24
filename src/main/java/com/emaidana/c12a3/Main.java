import java.util.*;

class Almacen {
    int id;
    String nombre;

    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class Grafo {
    private Map<Almacen, List<Almacen>> grafo;

    public Grafo() {
        this.grafo = new HashMap<>();
    }

    public void agregarAlmacen(Almacen almacen) {
        grafo.putIfAbsent(almacen, new ArrayList<>());
    }

    public void conectarAlmacenes(Almacen origen, Almacen destino) {
        grafo.get(origen).add(destino);
        grafo.get(destino).add(origen);
    }

    public void DFS(Almacen inicio) {
        Set<Almacen> visitado = new HashSet<>();
        System.out.println("Recorrido DFS:");
        DFSUtil(inicio, visitado);
        System.out.println();
    }

    private void DFSUtil(Almacen almacen, Set<Almacen> visitado) {
        visitado.add(almacen);
        System.out.print(almacen + " -> ");

        for (Almacen vecino : grafo.getOrDefault(almacen, Collections.emptyList())) {
            if (!visitado.contains(vecino)) {
                DFSUtil(vecino, visitado);
            }
        }
    }

    public void BFS(Almacen inicio) {
        Queue<Almacen> cola = new LinkedList<>();
        Set<Almacen> visitado = new HashSet<>();
        cola.add(inicio);
        visitado.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Almacen actual = cola.poll();
            System.out.print(actual + " -> ");

            for (Almacen vecino : grafo.getOrDefault(actual, Collections.emptyList())) {
                if (!visitado.contains(vecino)) {
                    visitado.add(vecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Grafo redAlmacenes = new Grafo();

        Almacen a1 = new Almacen(1, "Almacen A");
        Almacen a2 = new Almacen(2, "Almacen B");
        Almacen a3 = new Almacen(3, "Almacen C");
        Almacen a4 = new Almacen(4, "Almacen D");

        redAlmacenes.agregarAlmacen(a1);
        redAlmacenes.agregarAlmacen(a2);
        redAlmacenes.agregarAlmacen(a3);
        redAlmacenes.agregarAlmacen(a4);

        redAlmacenes.conectarAlmacenes(a1, a2);
        redAlmacenes.conectarAlmacenes(a1, a3);
        redAlmacenes.conectarAlmacenes(a2, a4);
        redAlmacenes.conectarAlmacenes(a3, a4);

        redAlmacenes.DFS(a1);
        redAlmacenes.BFS(a1);
    }
}
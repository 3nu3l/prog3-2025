package clase12;
import java.util.*;

// Clase que representa un almacén
class Almacen {
    private String id;
    private String nombre;

    public Almacen(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

// Clase que representa la red de almacenes
class Grafo {
    private Map<String, Almacen> almacenes;
    private Map<String, List<String>> adyacencias;

    public Grafo() {
        this.almacenes = new HashMap<>();
        this.adyacencias = new HashMap<>();
    }

    // Agregar un almacén al grafo
    public void agregarAlmacen(String id, String nombre) {
        if (!almacenes.containsKey(id)) {
            Almacen nuevo = new Almacen(id, nombre);
            almacenes.put(id, nuevo);
            adyacencias.put(id, new ArrayList<>());
        }
    }

    // Conectar dos almacenes mediante una ruta directa
    public void conectarAlmacenes(String id1, String id2) {
        if (almacenes.containsKey(id1) && almacenes.containsKey(id2)) {
            adyacencias.get(id1).add(id2);
            adyacencias.get(id2).add(id1); // Grafo no dirigido
        }
    }

    // Recorrido en profundidad (DFS)
    public void dfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRecursivo(inicio, visitados);
    }

    private void dfsRecursivo(String nodo, Set<String> visitados) {
        if (!visitados.contains(nodo)) {
            visitados.add(nodo);
            System.out.println(almacenes.get(nodo).getNombre());
            for (String vecino : adyacencias.get(nodo)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

    // Recorrido en anchura (BFS)
    public void bfs(String inicio) {
        Set<String> visitados = new HashSet<>();
        Queue<String> cola = new LinkedList<>();
        
        System.out.println("Recorrido BFS:");
        cola.add(inicio);
        visitados.add(inicio);
        
        while (!cola.isEmpty()) {
            String nodo = cola.poll();
            System.out.println(almacenes.get(nodo).getNombre());
            
            for (String vecino : adyacencias.get(nodo)) {
                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.add(vecino);
                }
            }
        }
    }
}

// Clase principal para probar la implementación
public class Actividad3 {
    public static void main(String[] args) {
        Grafo red = new Grafo();

        // Agregamos almacenes
        red.agregarAlmacen("A", "Almacén Central");
        red.agregarAlmacen("B", "Almacén Norte");
        red.agregarAlmacen("C", "Almacén Sur");
        red.agregarAlmacen("D", "Almacén Este");
        red.agregarAlmacen("E", "Almacén Oeste");

        // Conectamos almacenes
        red.conectarAlmacenes("A", "B");
        red.conectarAlmacenes("A", "C");
        red.conectarAlmacenes("B", "D");
        red.conectarAlmacenes("C", "E");

        // Realizamos recorridos
        red.dfs("A");
        red.bfs("A");
    }
}

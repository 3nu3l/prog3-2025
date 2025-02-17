/*
 * Actividad 3

Desarrolla una aplicación que permita modelar una red de almacenes
interconectados. El sistema debe permitir agregar almacenes, conectar
almacenes entre sí mediante rutas directas, y realizar recorridos en profundidad
(DFS) y en anchura (BFS) para explorar la red de distribución. Implementa una
clase Almacen que represente un almacén. Cada almacén debe tener un
identificador único y un nombre. Implementa una clase Grafo que gestione la red
de almacenes. Esta clase debe: Permitir agregar almacenes al grafo. Permitir
conectar almacenes entre sí (crear rutas directas entre almacenes). Implementar
un método DFS para realizar un recorrido en profundidad desde un almacén de
inicio. Implementar un método BFS para realizar un recorrido en anchura desde
un almacén de inicio.El grafo debe estar representado utilizando una lista de
adyacencia.
 * 
 */
import java.util.*;

class Almacen {
    private int id;
    private String nombre;

    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

class Grafo4 {
    private Map<Integer, Almacen> almacenes;
    private Map<Integer, List<Integer>> rutas;

    public Grafo4() {
        almacenes = new HashMap<>();
        rutas = new HashMap<>();
    }

    public void agregarAlmacen(Almacen almacen) {
        almacenes.put(almacen.getId(), almacen);
        rutas.put(almacen.getId(), new ArrayList<>());
    }

    public void conectarAlmacenes(int id1, int id2) {
        if (almacenes.containsKey(id1) && almacenes.containsKey(id2)) {
            rutas.get(id1).add(id2);
            rutas.get(id2).add(id1);
        }
    }

    public void dfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        dfsRecursivo(inicio, visitados);
    }

    private void dfsRecursivo(int actual, Set<Integer> visitados) {
        visitados.add(actual);
        System.out.println(almacenes.get(actual).getNombre());
        for (int vecino : rutas.get(actual)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

    public void bfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        cola.add(inicio);
        visitados.add(inicio);
        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.println(almacenes.get(actual).getNombre());
            for (int vecino : rutas.get(actual)) {
                if (!visitados.contains(vecino)) {
                    cola.add(vecino);
                    visitados.add(vecino);
                }
            }
        }
    }
}

public class Clasee12_Actividad3 {
    public static void main(String[] args) {
        Almacen almacen1 = new Almacen(1, "Almacen A");
        Almacen almacen2 = new Almacen(2, "Almacen B");
        Almacen almacen3 = new Almacen(3, "Almacen C");

        Grafo4 grafo = new Grafo4();
        grafo.agregarAlmacen(almacen1);
        grafo.agregarAlmacen(almacen2);
        grafo.agregarAlmacen(almacen3);

        grafo.conectarAlmacenes(1, 2);
        grafo.conectarAlmacenes(2, 3);

        System.out.println("DFS desde Almacen A:");
        grafo.dfs(1);

        System.out.println("\nBFS desde Almacen A:");
        grafo.bfs(1);
    }
}
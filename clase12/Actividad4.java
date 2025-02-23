package clase12;
import java.util.*;

// Clase que representa un usuario en la red social
class Usuario {
    private String id;
    private String nombre;

    public Usuario(String id, String nombre) {
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

// Clase que representa la red social
class RedSocial {
    private Map<String, Usuario> usuarios;
    private Map<String, List<String>> amistades;

    public RedSocial() {
        this.usuarios = new HashMap<>();
        this.amistades = new HashMap<>();
    }

    // Agregar un usuario a la red
    public void agregarUsuario(String id, String nombre) {
        if (!usuarios.containsKey(id)) {
            Usuario nuevo = new Usuario(id, nombre);
            usuarios.put(id, nuevo);
            amistades.put(id, new ArrayList<>());
        }
    }

    // Conectar dos usuarios como amigos
    public void conectarUsuarios(String id1, String id2) {
        if (usuarios.containsKey(id1) && usuarios.containsKey(id2)) {
            amistades.get(id1).add(id2);
            amistades.get(id2).add(id1); // Relación bidireccional
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
            System.out.println(usuarios.get(nodo).getNombre());
            for (String amigo : amistades.get(nodo)) {
                dfsRecursivo(amigo, visitados);
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
            System.out.println(usuarios.get(nodo).getNombre());
            
            for (String amigo : amistades.get(nodo)) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    cola.add(amigo);
                }
            }
        }
    }
}

// Clase principal para probar la implementación
public class Actividad4 {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        // Agregamos usuarios
        red.agregarUsuario("U1", "Alice");
        red.agregarUsuario("U2", "Bob");
        red.agregarUsuario("U3", "Charlie");
        red.agregarUsuario("U4", "David");
        red.agregarUsuario("U5", "Eve");

        // Conectamos usuarios como amigos
        red.conectarUsuarios("U1", "U2");
        red.conectarUsuarios("U1", "U3");
        red.conectarUsuarios("U2", "U4");
        red.conectarUsuarios("U3", "U5");

        // Realizamos recorridos
        red.dfs("U1");
        red.bfs("U1");
    }
}

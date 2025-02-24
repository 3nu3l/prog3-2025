import java.util.*;

class Usuario {
    int id;
    String nombre;

    public Usuario(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}

class RedSocial {
    private Map<Usuario, List<Usuario>> grafo;

    public RedSocial() {
        this.grafo = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        grafo.putIfAbsent(usuario, new ArrayList<>());
    }

    public void conectarUsuarios(Usuario u1, Usuario u2) {
        grafo.get(u1).add(u2);
        grafo.get(u2).add(u1);
    }

    public void DFS(Usuario inicio) {
        Set<Usuario> visitado = new HashSet<>();
        System.out.println("Recorrido DFS desde " + inicio + ":");
        DFSUtil(inicio, visitado);
        System.out.println();
    }

    private void DFSUtil(Usuario usuario, Set<Usuario> visitado) {
        visitado.add(usuario);
        System.out.print(usuario + " -> ");

        for (Usuario amigo : grafo.getOrDefault(usuario, Collections.emptyList())) {
            if (!visitado.contains(amigo)) {
                DFSUtil(amigo, visitado);
            }
        }
    }

    public void BFS(Usuario inicio) {
        Queue<Usuario> cola = new LinkedList<>();
        Set<Usuario> visitado = new HashSet<>();
        cola.add(inicio);
        visitado.add(inicio);

        System.out.println("Recorrido BFS desde " + inicio + ":");
        while (!cola.isEmpty()) {
            Usuario actual = cola.poll();
            System.out.print(actual + " -> ");

            for (Usuario amigo : grafo.getOrDefault(actual, Collections.emptyList())) {
                if (!visitado.contains(amigo)) {
                    visitado.add(amigo);
                    cola.add(amigo);
                }
            }
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        Usuario u1 = new Usuario(1, "Alice");
        Usuario u2 = new Usuario(2, "Bob");
        Usuario u3 = new Usuario(3, "Charlie");
        Usuario u4 = new Usuario(4, "David");
        Usuario u5 = new Usuario(5, "Emma");

        red.agregarUsuario(u1);
        red.agregarUsuario(u2);
        red.agregarUsuario(u3);
        red.agregarUsuario(u4);
        red.agregarUsuario(u5);

        red.conectarUsuarios(u1, u2);
        red.conectarUsuarios(u1, u3);
        red.conectarUsuarios(u2, u4);
        red.conectarUsuarios(u3, u5);
        red.conectarUsuarios(u4, u5);

        red.DFS(u1);
        red.BFS(u1);
    }
}
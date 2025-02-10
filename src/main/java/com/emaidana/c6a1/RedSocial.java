import java.util.*;

public class RedSocial {

    // Clase interna para modelar el grafo
    private static class Grafo {
        private Map<String, List<String>> listaAdyacencia;

        public Grafo() {
            this.listaAdyacencia = new HashMap<>();
        }

        // Método para agregar un usuario
        public void agregarUsuario(String usuario) {
            listaAdyacencia.putIfAbsent(usuario, new ArrayList<>());
        }

        // Método para agregar una relación de seguimiento
        public void seguir(String usuario, String seguidor) {
            agregarUsuario(usuario);
            agregarUsuario(seguidor);
            listaAdyacencia.get(usuario).add(seguidor);
        }

        // Método para obtener la lista de seguidores de un usuario
        public List<String> obtenerSeguidores(String usuario) {
            return listaAdyacencia.getOrDefault(usuario, Collections.emptyList());
        }

        // Método para imprimir todas las relaciones
        public void imprimirRelaciones() {
            for (Map.Entry<String, List<String>> entrada : listaAdyacencia.entrySet()) {
                System.out.println(entrada.getKey() + " sigue a: " + entrada.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Grafo redSocial = new Grafo();

        // Agregar usuarios y relaciones
        redSocial.seguir("Alice", "Bob");
        redSocial.seguir("Alice", "Charlie");
        redSocial.seguir("Bob", "Alice");
        redSocial.seguir("Charlie", "Bob");
        redSocial.seguir("Charlie", "Alice");

        // Imprimir relaciones
        redSocial.imprimirRelaciones();

        // Consultar seguidores de un usuario
        System.out.println("Seguidores de Alice: " + redSocial.obtenerSeguidores("Alice"));
        System.out.println("Seguidores de Bob: " + redSocial.obtenerSeguidores("Bob"));
    }
}
import java.util.*;

public class RedSocial {

    // Clase Usuario con identificador único
    static class Usuario {
        private String id;

        public Usuario(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Usuario usuario = (Usuario) o;
            return Objects.equals(id, usuario.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return id;
        }
    }

    // Clase Grafo para modelar la red social
    static class Grafo {
        private Map<Usuario, Set<Usuario>> listaAdyacencia;

        public Grafo() {
            this.listaAdyacencia = new HashMap<>();
        }

        // Agregar un nuevo usuario al sistema
        public void agregarUsuario(Usuario usuario) {
            listaAdyacencia.putIfAbsent(usuario, new HashSet<>());
        }

        // Permitir que un usuario siga a otro
        public void seguir(Usuario usuario, Usuario destinatario) {
            agregarUsuario(usuario);
            agregarUsuario(destinatario);
            listaAdyacencia.get(usuario).add(destinatario);
        }

        // Permitir que un usuario deje de seguir a otro
        public void dejarDeSeguir(Usuario usuario, Usuario destinatario) {
            if (listaAdyacencia.containsKey(usuario)) {
                listaAdyacencia.get(usuario).remove(destinatario);
            }
        }

        // Consultar la lista de usuarios que un usuario dado sigue
        public Set<Usuario> listaDeSeguidoresDe(Usuario usuario) {
            return listaAdyacencia.getOrDefault(usuario, Collections.emptySet());
        }

        // Consultar la lista de usuarios que siguen a un usuario dado
        public Set<Usuario> listaDeSeguidores(Usuario usuario) {
            Set<Usuario> seguidores = new HashSet<>();
            for (Map.Entry<Usuario, Set<Usuario>> entry : listaAdyacencia.entrySet()) {
                if (entry.getValue().contains(usuario)) {
                    seguidores.add(entry.getKey());
                }
            }
            return seguidores;
        }

        // Imprimir todas las relaciones de la red social
        public void imprimirRelaciones() {
            for (Map.Entry<Usuario, Set<Usuario>> entry : listaAdyacencia.entrySet()) {
                System.out.println(entry.getKey() + " sigue a: " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        Grafo redSocial = new Grafo();

        // Crear usuarios
        Usuario alice = new Usuario("Alice");
        Usuario bob = new Usuario("Bob");
        Usuario charlie = new Usuario("Charlie");

        // Agregar usuarios y relaciones
        redSocial.seguir(alice, bob);
        redSocial.seguir(alice, charlie);
        redSocial.seguir(bob, alice);
        redSocial.seguir(charlie, alice);

        // Imprimir relaciones
        redSocial.imprimirRelaciones();

        // Consultar la lista de seguidores
        System.out.println("Usuarios que Alice sigue: " + redSocial.listaDeSeguidoresDe(alice));
        System.out.println("Usuarios que siguen a Alice: " + redSocial.listaDeSeguidores(alice));

        // Dejar de seguir
        redSocial.dejarDeSeguir(alice, bob);
        System.out.println("\nDespués de que Alice deja de seguir a Bob:");
        redSocial.imprimirRelaciones();
    }
}
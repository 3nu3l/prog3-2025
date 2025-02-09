package clase6;
import java.util.*;

class Usuario {
    private int idUsuario;
    private String nombre;

    public Usuario(int idUsuario, String nombre) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + idUsuario + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario usuario = (Usuario) obj;
        return idUsuario == usuario.idUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario);
    }
}

class RedSocial {
    private Map<Integer, Usuario> usuarios = new HashMap<>();
    private Map<Usuario, Set<Usuario>> grafo = new HashMap<>();

    public void agregarUsuario(int idUsuario, String nombre) {
        if (!usuarios.containsKey(idUsuario)) {
            Usuario usuario = new Usuario(idUsuario, nombre);
            usuarios.put(idUsuario, usuario);
            grafo.put(usuario, new HashSet<>());
        } else {
            System.out.println("El usuario ya existe.");
        }
    }

    public void seguir(int idSeguidor, int idSeguido) {
        if (usuarios.containsKey(idSeguidor) && usuarios.containsKey(idSeguido)) {
            Usuario seguidor = usuarios.get(idSeguidor);
            Usuario seguido = usuarios.get(idSeguido);
            grafo.get(seguidor).add(seguido);
        } else {
            System.out.println("Uno o ambos usuarios no existen.");
        }
    }

    public void dejarDeSeguir(int idSeguidor, int idSeguido) {
        if (usuarios.containsKey(idSeguidor) && usuarios.containsKey(idSeguido)) {
            Usuario seguidor = usuarios.get(idSeguidor);
            Usuario seguido = usuarios.get(idSeguido);
            grafo.get(seguidor).remove(seguido);
        } else {
            System.out.println("Uno o ambos usuarios no existen.");
        }
    }

    public List<Usuario> listaDeSeguidos(int idUsuario) {
        if (usuarios.containsKey(idUsuario)) {
            Usuario usuario = usuarios.get(idUsuario);
            return new ArrayList<>(grafo.get(usuario));
        } else {
            System.out.println("El usuario no existe.");
            return Collections.emptyList();
        }
    }

    public List<Usuario> listaDeSeguidoresDe(int idUsuario) {
        if (usuarios.containsKey(idUsuario)) {
            Usuario seguido = usuarios.get(idUsuario);
            List<Usuario> seguidores = new ArrayList<>();
            for (Usuario u : grafo.keySet()) {
                if (grafo.get(u).contains(seguido)) {
                    seguidores.add(u);
                }
            }
            return seguidores;
        } else {
            System.out.println("El usuario no existe.");
            return Collections.emptyList();
        }
    }

    public static void main(String[] args) {
        RedSocial red = new RedSocial();
        red.agregarUsuario(1, "Alice");
        red.agregarUsuario(2, "Bob");
        red.agregarUsuario(3, "Charlie");

        red.seguir(1, 2);
        red.seguir(1, 3);
        red.seguir(2, 3);

        System.out.println("Alice sigue a: " + red.listaDeSeguidos(1));
        System.out.println("Charlie es seguido por: " + red.listaDeSeguidoresDe(3));

        red.dejarDeSeguir(1, 3);
        System.out.println("Alice sigue a (después de dejar de seguir a Charlie): " + red.listaDeSeguidos(1));
    }
}

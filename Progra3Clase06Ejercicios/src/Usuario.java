import java.util.*;


import java.util.ArrayList;

class Usuario {
    private int id;
    private ArrayList<Usuario> siguiendo; // Lista de usuarios a los que sigue

    public Usuario(int id) {
        this.id = id;
        this.siguiendo = new ArrayList<>();
    }

    // Método para seguir a otro usuario
    public void seguir(Usuario usuario) {
        if (!siguiendo.contains(usuario)) { // Evita duplicados
            siguiendo.add(usuario);
        }
    }

    // Mostrar los usuarios que sigue
    public void mostrarSiguiendo() {
        System.out.print("Usuario " + id + " sigue a: ");
        if (siguiendo.isEmpty()) {
            System.out.println("Nadie");
        } else {
            for (Usuario u : siguiendo) {
                System.out.print("Usuario " + u.id + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Crear usuarios
        Usuario u1 = new Usuario(1);
        Usuario u2 = new Usuario(2);
        Usuario u3 = new Usuario(3);
        Usuario u4 = new Usuario(4);

        // Establecer relaciones
        u1.seguir(u2);
        u1.seguir(u3);
        u2.seguir(u3);
        u3.seguir(u4);
        u4.seguir(u1);

        // Mostrar la red social
        u1.mostrarSiguiendo();
        u2.mostrarSiguiendo();
        u3.mostrarSiguiendo();
        u4.mostrarSiguiendo();
    }
}

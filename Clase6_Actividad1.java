/*
 * 
 * Actividad 1

Desarrolla un programa que modele un sistema de seguidores en una red social
utilizando un grafo representado con una lista de adyacencia. En este sistema,
cada usuario puede seguir a otros usuarios, y queremos almacenar y consultar
estas relaciones de manera eficiente.
Especificaciones:
Representación del Grafo:
Utiliza una lista de adyacencia para representar el grafo. En esta representación,
cada nodo (usuario) tiene una lista de nodos a los que sigue (usuarios que lo
siguen).
Estructuras de Datos:
Usa una clase o estructura Usuario que tenga un identificador único (por ejemplo, un
nombre o un número de ID).
Utiliza un diccionario o un mapa para mantener la lista de adyacencia, donde cada clave
es un Usuario y el valor asociado es una lista de usuarios que ese usuario sigue.
Operaciones Requeridas:
Agregar Usuario: Permite agregar un nuevo usuario al sistema.
Seguir: Permite que un usuario siga a otro. Si el usuario ya sigue al destinatario, la
operación no debe tener efecto.
Dejar de Seguir: Permite que un usuario deje de seguir a otro. Si el usuario no sigue al
destinatario, la operación no debe tener efecto.
Lista de Seguidores: Permite consultar la lista de usuarios que sigue un usuario dado.
Lista de Seguidores de: Permite consultar la lista de usuarios que siguen a un usuario
dado.


 * 
 * 
 * 
 */

 import java.util.*;

class Usuario {
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

class RedSocial {
    private Map<Usuario, List<Usuario>> seguidores;

    public RedSocial() {
        seguidores = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        seguidores.putIfAbsent(usuario, new ArrayList<>());
    }

    public void seguir(Usuario seguidor, Usuario seguido) {
        if (seguidores.containsKey(seguidor) && seguidores.containsKey(seguido)) {
            List<Usuario> siguiendo = seguidores.get(seguidor);
            if (!siguiendo.contains(seguido)) {
                siguiendo.add(seguido);
            }
        }
    }

    public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
        if (seguidores.containsKey(seguidor) && seguidores.containsKey(seguido)) {
            seguidores.get(seguidor).remove(seguido);
        }
    }

    public List<Usuario> listaDeSeguidos(Usuario usuario) {
        return seguidores.getOrDefault(usuario, new ArrayList<>());
    }

    public List<Usuario> listaDeSeguidoresDe(Usuario usuario) {
        List<Usuario> seguidoresDe = new ArrayList<>();
        for (Map.Entry<Usuario, List<Usuario>> entry : seguidores.entrySet()) {
            if (entry.getValue().contains(usuario)) {
                seguidoresDe.add(entry.getKey());
            }
        }
        return seguidoresDe;
    }
}

public class Clase6_Actividad1 {
    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();

        Usuario usuario1 = new Usuario("user1");
        Usuario usuario2 = new Usuario("user2");
        Usuario usuario3 = new Usuario("user3");

        redSocial.agregarUsuario(usuario1);
        redSocial.agregarUsuario(usuario2);
        redSocial.agregarUsuario(usuario3);

        redSocial.seguir(usuario1, usuario2);
        redSocial.seguir(usuario2, usuario3);

        System.out.println("Usuarios seguidos por user1: " + redSocial.listaDeSeguidos(usuario1));
        System.out.println("Usuarios que siguen a user2: " + redSocial.listaDeSeguidoresDe(usuario2));
    }
}
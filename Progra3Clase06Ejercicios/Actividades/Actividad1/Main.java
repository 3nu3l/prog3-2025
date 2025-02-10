package Actividad1;

public class Main {
    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        Usuario nico = new Usuario(1, "Nico");
        Usuario usuario2 = new Usuario(2, "Nico 2");
        Usuario usuario3 = new Usuario(3, "Nico 3");
        Usuario usuario4 = new Usuario(4, "Nico 4");

        red.agregarUsuario(nico);
        red.agregarUsuario(usuario2);
        red.agregarUsuario(usuario3);
        red.agregarUsuario(usuario4);

        red.seguir(nico, usuario2);
        red.seguir(nico, usuario3);
        red.seguir(usuario2, usuario3);
        red.seguir(usuario3, usuario4);

        System.out.println("\nRed Social:");
        red.mostrarRed();

        System.out.println("\nLista de usuarios que sigue " + nico.getNombre() + ": " + red.listaDeSeguidos(nico));
        System.out.println("Lista de seguidores de " + usuario3.getNombre() + ": " + red.listaDeSeguidores(usuario3));

        red.dejarDeSeguir(nico, usuario2);
        System.out.println("\nDespués de dejar de seguir:");
        red.mostrarRed();
    }
}

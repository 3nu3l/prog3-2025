package clase6;

import java.util.ArrayList;
import java.util.List;

public class ejercicio1 {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        int idUsuarioCounter = 0;
        usuarios.add(new Usuario(idUsuarioCounter,"Ana", "Gomez", 25));
        usuarios.add(new Usuario(idUsuarioCounter,"Juan", "Perez", 30));
        idUsuarioCounter++;
        usuarios.add(new Usuario(idUsuarioCounter,"Ana", "Gomez", 25));
        idUsuarioCounter++;
        usuarios.add(new Usuario(idUsuarioCounter,"Luis", "Martinez", 40));
        idUsuarioCounter++;
        idUsuarioCounter = 0;
        for (Usuario usuario : usuarios) {
            System.out.println("id: "+ usuario.idUsuario + " Nombre: " + usuario.getNombre() + ", Apellido: " + usuario.getApellido() + ", Edad: " + usuario.getEdad());
        }
    }

    static class Usuario {
        private int idUsuario;
        private String nombre;
        private String apellido;
        private int edad;

        public Usuario(int idUsuario, String nombre, String apellido, int edad) {
            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.apellido = apellido;
            this.edad = edad;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public int getEdad() {
            return edad;
        }
    }
}
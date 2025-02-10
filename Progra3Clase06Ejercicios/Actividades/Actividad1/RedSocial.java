package Actividad1;

import java.util.ArrayList;
import java.util.TreeMap;

import java.util.*;

public class RedSocial {
    private Map<Usuario, Set<Usuario>> relaciones;

    public RedSocial() {
        this.relaciones = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        relaciones.putIfAbsent(usuario, new HashSet<>());
    }

    public void seguir(Usuario seguidor, Usuario seguido) {
        if (!relaciones.containsKey(seguidor) || !relaciones.containsKey(seguido)) {
            System.out.println("Uno o ambos usuarios no existen.");
            return;
        }
        if (relaciones.get(seguidor).contains(seguido)) {
            System.out.println(seguidor.getNombre() + " ya sigue a " + seguido.getNombre());
        } else {
            relaciones.get(seguidor).add(seguido);
            System.out.println(seguidor.getNombre() + " ahora sigue a " + seguido.getNombre());
        }
    }

    public void dejarDeSeguir(Usuario seguidor, Usuario seguido) {
        if (relaciones.containsKey(seguidor) && relaciones.get(seguidor).remove(seguido)) {
            System.out.println(seguidor.getNombre() + " dejó de seguir a " + seguido.getNombre());
        } else {
            System.out.println(seguidor.getNombre() + " no seguía a " + seguido.getNombre());
        }
    }

    public Set<Usuario> listaDeSeguidos(Usuario usuario) {
        return relaciones.getOrDefault(usuario, new HashSet<>());
    }

    public Set<Usuario> listaDeSeguidores(Usuario usuario) {
        Set<Usuario> seguidores = new HashSet<>();
        for (Map.Entry<Usuario, Set<Usuario>> entry : relaciones.entrySet()) {
            if (entry.getValue().contains(usuario)) {
                seguidores.add(entry.getKey());
            }
        }
        return seguidores;
    }

    public void mostrarRed() {
        for (Usuario usuario : relaciones.keySet()) {
            System.out.print(usuario.getNombre() + " sigue a: ");
            Set<Usuario> seguidos = relaciones.get(usuario);
            if (seguidos.isEmpty()) {
                System.out.println("Nadie");
            } else {
                for (Usuario seguido : seguidos) {
                    System.out.print(seguido.getNombre() + " ");
                }
                System.out.println();
            }
        }
    }
}

/*
 * Actividad 4

Diseña e implementa un sistema que modele una red social utilizando grafos.
Cada usuario será un nodo, y las amistades entre usuarios serán las aristas. El
sistema debe permitir:
Agregar usuarios a la red, cada uno con un identificador único y nombre.
Conectar usuarios indicando que son amigos (relación bidireccional).
Implementar un método para realizar un recorrido DFS (Depth First Search)
desde un usuario dado, mostrando los usuarios alcanzables a través de sus
amistades.
Implementar un recorrido BFS (Breadth First Search) para explorar la red desde
un usuario dado, siguiendo las conexiones de amistad.
 * 
 * 
 */

 import java.util.*;

 class UsuarioRedSocial {
     private int id;
     private String nombre;
 
     public UsuarioRedSocial(int id, String nombre) {
         this.id = id;
         this.nombre = nombre;
     }
 
     public int getId() {
         return id;
     }
 
     public String getNombre() {
         return nombre;
     }
 }
 
 class GrafoRedSocial {
     private Map<Integer, UsuarioRedSocial> usuarios;
     private Map<Integer, List<Integer>> amistades;
 
     public GrafoRedSocial() {
         usuarios = new HashMap<>();
         amistades = new HashMap<>();
     }
 
     public void agregarUsuario(UsuarioRedSocial usuario) {
         usuarios.put(usuario.getId(), usuario);
         amistades.put(usuario.getId(), new ArrayList<>());
     }
 
     public void conectarUsuarios(int id1, int id2) {
         if (usuarios.containsKey(id1) && usuarios.containsKey(id2)) {
             amistades.get(id1).add(id2);
             amistades.get(id2).add(id1);
         }
     }
 
     public void dfs(int inicio) {
         Set<Integer> visitados = new HashSet<>();
         dfsRecursivo(inicio, visitados);
     }
 
     private void dfsRecursivo(int actual, Set<Integer> visitados) {
         visitados.add(actual);
         System.out.println(usuarios.get(actual).getNombre());
         for (int amigo : amistades.get(actual)) {
             if (!visitados.contains(amigo)) {
                 dfsRecursivo(amigo, visitados);
             }
         }
     }
 
     public void bfs(int inicio) {
         Set<Integer> visitados = new HashSet<>();
         Queue<Integer> cola = new LinkedList<>();
         cola.add(inicio);
         visitados.add(inicio);
         while (!cola.isEmpty()) {
             int actual = cola.poll();
             System.out.println(usuarios.get(actual).getNombre());
             for (int amigo : amistades.get(actual)) {
                 if (!visitados.contains(amigo)) {
                     cola.add(amigo);
                     visitados.add(amigo);
                 }
             }
         }
     }
 }
 
 public class Clasee12_Actividad4 {
     public static void main(String[] args) {
         UsuarioRedSocial usuario1 = new UsuarioRedSocial(1, "Usuario A");
         UsuarioRedSocial usuario2 = new UsuarioRedSocial(2, "Usuario B");
         UsuarioRedSocial usuario3 = new UsuarioRedSocial(3, "Usuario C");
 
         GrafoRedSocial red = new GrafoRedSocial();
         red.agregarUsuario(usuario1);
         red.agregarUsuario(usuario2);
         red.agregarUsuario(usuario3);
 
         red.conectarUsuarios(1, 2);
         red.conectarUsuarios(2, 3);
 
         System.out.println("DFS desde Usuario A:");
         red.dfs(1);
 
         System.out.println("\nBFS desde Usuario A:");
         red.bfs(1);
     }
 }
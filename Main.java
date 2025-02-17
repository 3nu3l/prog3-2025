/*
 * UADE Programación 3
Curso intensivo verano 2025

Consignas del trabajo práctico ( forma parte del segundo parcial, otorgando 2 puntos )
En base al ejemplo que está en el repo, crear dos nodos con un tema a elección del equipo.
Luego realizar:
1. Crear una base de datos en neo4j y un api backend con un put y un get (0.8 puntos)
2. Realizar un recorrido usando backtracking (0,4 puntos)
3. Realizar recorridos sobre grafos DFS y BFS (0,4 puntos)
4. Utilizar ramificación y poda (0,4 puntos)
 * 
 * 
 */


import java.util.*;

// Clase que representa una película
class Pelicula {
    private int id;
    private String titulo;

    public Pelicula(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}

// Clase que representa un actor
class Actor {
    private int id;
    private String nombre;

    public Actor(int id, String nombre) {
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

// Clase que representa el grafo de películas y actores
class GrafoPeliculas {
    private Map<Integer, Pelicula> peliculas;
    private Map<Integer, Actor> actores;
    private Map<Integer, List<Integer>> relaciones;

    public GrafoPeliculas() {
        peliculas = new HashMap<>();
        actores = new HashMap<>();
        relaciones = new HashMap<>();
    }

    // Método para agregar una película al grafo
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.put(pelicula.getId(), pelicula);
        relaciones.put(pelicula.getId(), new ArrayList<>());
    }

    // Método para agregar un actor al grafo
    public void agregarActor(Actor actor) {
        actores.put(actor.getId(), actor);
        relaciones.put(actor.getId(), new ArrayList<>());
    }

    // Método para conectar una película con un actor
    public void conectarPeliculaActor(int peliculaId, int actorId) {
        if (peliculas.containsKey(peliculaId) && actores.containsKey(actorId)) {
            relaciones.get(peliculaId).add(actorId);
            relaciones.get(actorId).add(peliculaId);
        }
    }

    // Método para realizar un recorrido en profundidad (DFS)
    public void dfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        dfsRecursivo(inicio, visitados);
    }

    private void dfsRecursivo(int actual, Set<Integer> visitados) {
        visitados.add(actual);
        if (peliculas.containsKey(actual)) {
            System.out.println("Pelicula: " + peliculas.get(actual).getTitulo());
        } else if (actores.containsKey(actual)) {
            System.out.println("Actor: " + actores.get(actual).getNombre());
        }
        for (int vecino : relaciones.get(actual)) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

    // Método para realizar un recorrido en anchura (BFS)
    public void bfs(int inicio) {
        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        cola.add(inicio);
        visitados.add(inicio);
        while (!cola.isEmpty()) {
            int actual = cola.poll();
            if (peliculas.containsKey(actual)) {
                System.out.println("Pelicula: " + peliculas.get(actual).getTitulo());
            } else if (actores.containsKey(actual)) {
                System.out.println("Actor: " + actores.get(actual).getNombre());
            }
            for (int vecino : relaciones.get(actual)) {
                if (!visitados.contains(vecino)) {
                    cola.add(vecino);
                    visitados.add(vecino);
                }
            }
        }
    }

    // Método para buscar películas que contengan dos actores específicos pero no uno excluido
    public List<Pelicula> buscarPeliculasPorActores(int actor1Id, int actor2Id, int actorExcluidoId) {
        List<Pelicula> resultado = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();
        for (Pelicula pelicula : peliculas.values()) {
            // Iniciar el backtracking desde cada película
            if (backtrackingConPoda(pelicula.getId(), actor1Id, actor2Id, actorExcluidoId, visitados)) {
                resultado.add(pelicula);
            }
        }
        return resultado;
    }

    // Método de backtracking con ramificación y poda
    private boolean backtrackingConPoda(int peliculaId, int actor1Id, int actor2Id, int actorExcluidoId, Set<Integer> visitados) {
        // Agregar la película actual a los visitados
        visitados.add(peliculaId);

        // Obtener los actores de la película actual
        List<Integer> actoresPelicula = relaciones.get(peliculaId);

        // Verificar si la película contiene los actores especificados y no contiene el actor excluido
        boolean contieneActor1 = actoresPelicula.contains(actor1Id);
        boolean contieneActor2 = actoresPelicula.contains(actor2Id);
        boolean contieneActorExcluido = actoresPelicula.contains(actorExcluidoId);

        // Ramificación y poda: si la película contiene el actor excluido, podar esta rama
        if (contieneActorExcluido) {
            visitados.remove(peliculaId);
            return false;
        }

        // Si la película contiene ambos actores especificados, se encontró una solución
        if (contieneActor1 && contieneActor2) {
            visitados.remove(peliculaId);
            return true;
        }

        // Continuar el backtracking con los actores de la película actual
        for (int actorId : actoresPelicula) {
            if (!visitados.contains(actorId)) {
                for (int peliculaVecinaId : relaciones.get(actorId)) {
                    if (!visitados.contains(peliculaVecinaId)) {
                        if (backtrackingConPoda(peliculaVecinaId, actor1Id, actor2Id, actorExcluidoId, visitados)) {
                            visitados.remove(peliculaId);
                            return true;
                        }
                    }
                }
            }
        }

        // Eliminar la película actual de los visitados antes de retroceder
        visitados.remove(peliculaId);
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        // Crear instancias de películas
        Pelicula pelicula1 = new Pelicula(1, "Inception");
        Pelicula pelicula2 = new Pelicula(2, "The Dark Knight");
        Pelicula pelicula3 = new Pelicula(3, "Interstellar");
        Pelicula pelicula4 = new Pelicula(4, "Titanic");
        Pelicula pelicula5 = new Pelicula(5, "The Wolf of Wall Street");

        // Crear instancias de actores
        Actor actor1 = new Actor(6, "Leonardo DiCaprio");
        Actor actor2 = new Actor(7, "Joseph Gordon-Levitt");
        Actor actor3 = new Actor(8, "Matthew McConaughey");
        Actor actor4 = new Actor(9, "Christian Bale");
        Actor actor5 = new Actor(10, "Kate Winslet");
        Actor actor6 = new Actor(11, "Margot Robbie");

        // Crear el grafo de películas y actores
        GrafoPeliculas red = new GrafoPeliculas();
        red.agregarPelicula(pelicula1);
        red.agregarPelicula(pelicula2);
        red.agregarPelicula(pelicula3);
        red.agregarPelicula(pelicula4);
        red.agregarPelicula(pelicula5);

        red.agregarActor(actor1);
        red.agregarActor(actor2);
        red.agregarActor(actor3);
        red.agregarActor(actor4);
        red.agregarActor(actor5);
        red.agregarActor(actor6);

        // Conectar películas con actores
        red.conectarPeliculaActor(1, 6); // Inception - Leonardo DiCaprio
        red.conectarPeliculaActor(1, 7); // Inception - Joseph Gordon-Levitt
        red.conectarPeliculaActor(2, 9); // The Dark Knight - Christian Bale
        red.conectarPeliculaActor(3, 8); // Interstellar - Matthew McConaughey
        red.conectarPeliculaActor(3, 6); // Interstellar - Leonardo DiCaprio
        red.conectarPeliculaActor(4, 6); // Titanic - Leonardo DiCaprio
        red.conectarPeliculaActor(4, 10); // Titanic - Kate Winslet
        red.conectarPeliculaActor(5, 6); // The Wolf of Wall Street - Leonardo DiCaprio
        red.conectarPeliculaActor(5, 11); // The Wolf of Wall Street - Margot Robbie

        // Realizar recorridos DFS y BFS
        System.out.println("DFS desde Inception:");
        red.dfs(1);

        System.out.println("\nBFS desde Inception:");
        red.bfs(1);

        // Buscar películas con Leonardo DiCaprio y Joseph Gordon-Levitt, pero sin Matthew McConaughey
        System.out.println("\nBuscar películas con Leonardo DiCaprio y Joseph Gordon-Levitt, pero sin Matthew McConaughey:");
        List<Pelicula> peliculasEncontradas = red.buscarPeliculasPorActores(6, 7, 8);
        for (Pelicula pelicula : peliculasEncontradas) {
            System.out.println("Pelicula encontrada: " + pelicula.getTitulo());
        }
    }
}
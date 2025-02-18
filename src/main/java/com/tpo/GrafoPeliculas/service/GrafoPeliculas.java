package com.tpo.GrafoPeliculas.service;

import java.util.*;
import com.tpo.GrafoPeliculas.model.Pelicula;
import com.tpo.GrafoPeliculas.model.Actor;
import com.tpo.GrafoPeliculas.repository.PeliculaRepository;
import com.tpo.GrafoPeliculas.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GrafoPeliculas {
    @Autowired
    private PeliculaRepository peliculaRepository;
    
    @Autowired
    private ActorRepository actorRepository;
    
    private Map<Integer, Pelicula> peliculas;
    private Map<Integer, Actor> actores;
    private Map<Integer, List<Integer>> relaciones;

    public GrafoPeliculas() {
        peliculas = new HashMap<>();
        actores = new HashMap<>();
        relaciones = new HashMap<>();
    }

    @PostConstruct
    @Transactional
    public void inicializarGrafoEjemplo() {
        // Removido el código de inicialización hardcodeada
    }

    public void agregarPelicula(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
        if (!relaciones.containsKey(pelicula.getId())) {
            relaciones.put(pelicula.getId(), new ArrayList<Integer>());
        }
        peliculas.put(pelicula.getId(), pelicula);
    }

    public void agregarActor(Actor actor) {
        actorRepository.save(actor);
        actores.put(actor.getId(), actor);
        relaciones.put(actor.getId(), new ArrayList<>());
    }

    public void conectarPeliculaActor(int peliculaId, int actorId) {
        if (peliculas.containsKey(peliculaId) && actores.containsKey(actorId)) {
            relaciones.get(peliculaId).add(actorId);
            relaciones.get(actorId).add(peliculaId);
        }
    }

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

    public List<Pelicula> buscarPeliculasPorActores(int actor1Id, int actor2Id, int actorExcluidoId) {
        List<Pelicula> resultado = new ArrayList<>();
        Set<Integer> visitados = new HashSet<>();
        for (Pelicula pelicula : peliculas.values()) {
            if (backtrackingConPoda(pelicula.getId(), actor1Id, actor2Id, actorExcluidoId, visitados)) {
                resultado.add(pelicula);
            }
        }
        return resultado;
    }

    private boolean backtrackingConPoda(int peliculaId, int actor1Id, int actor2Id, int actorExcluidoId, Set<Integer> visitados) {
        visitados.add(peliculaId);
        List<Integer> actoresPelicula = relaciones.get(peliculaId);
        boolean contieneActor1 = actoresPelicula.contains(actor1Id);
        boolean contieneActor2 = actoresPelicula.contains(actor2Id);
        boolean contieneActorExcluido = actoresPelicula.contains(actorExcluidoId);

        if (contieneActorExcluido) {
            visitados.remove(peliculaId);
            return false;
        }

        if (contieneActor1 && contieneActor2) {
            visitados.remove(peliculaId);
            return true;
        }

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

        visitados.remove(peliculaId);
        return false;
    }

    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaRepository.findAll();
    }
}
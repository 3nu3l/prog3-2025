package com.tpo.GrafoPeliculas.service;

import com.tpo.GrafoPeliculas.model.Actor;
import com.tpo.GrafoPeliculas.model.Pelicula;
import com.tpo.GrafoPeliculas.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GrafoPeliculasService {
    private final PeliculaRepository peliculaRepository;

    public GrafoPeliculasService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    // Método para crear una nueva película
    public Pelicula crearPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public void conectarPeliculaActor(Long peliculaId, Long actorId) {
        // Implementar la lógica para conectar una película con un actor
    }

    public List<Pelicula> buscarPeliculasPorActores(Long actor1Id, Long actor2Id) {
        return peliculaRepository.findPeliculasByActores(actor1Id, actor2Id);
    }

    // Método para obtener una película por ID
    public Pelicula obtenerPeliculaPorId(Long id) {
        return peliculaRepository.findById(id).orElse(null);
    }

    // Método para obtener todas las películas
    public List<Pelicula> obtenerTodasLasPeliculas() {
        return peliculaRepository.findAll();
    }

    // Implementación de DFS
    public void dfs(Long startId, Set<Long> visited) {
        if (visited.contains(startId)) return;
        visited.add(startId);
        
        Pelicula pelicula = peliculaRepository.findById(startId).orElse(null);
        if (pelicula != null) {
            System.out.println("Visitando película: " + pelicula.getTitulo());
            for (Actor actor : pelicula.getActores()) {
                dfs(actor.getId(), visited);
            }
        }
    }

    // Implementación de BFS
    public void bfs(Long startId) {
        Set<Long> visited = new HashSet<>();
        Queue<Long> queue = new LinkedList<>();
        
        queue.add(startId);
        visited.add(startId);
        
        while (!queue.isEmpty()) {
            Long currentId = queue.poll();
            Pelicula pelicula = peliculaRepository.findById(currentId).orElse(null);
            
            if (pelicula != null) {
                System.out.println("Visitando película: " + pelicula.getTitulo());
                for (Actor actor : pelicula.getActores()) {
                    if (!visited.contains(actor.getId())) {
                        visited.add(actor.getId());
                        queue.add(actor.getId());
                    }
                }
            }
        }
    }
} 
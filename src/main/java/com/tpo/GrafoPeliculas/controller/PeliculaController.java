package com.tpo.GrafoPeliculas.controller;

import com.tpo.GrafoPeliculas.model.Pelicula;
import com.tpo.GrafoPeliculas.service.GrafoPeliculasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final GrafoPeliculasService grafoPeliculasService;

    public PeliculaController(GrafoPeliculasService grafoPeliculasService) {
        this.grafoPeliculasService = grafoPeliculasService;
    }

    @PostMapping
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {
        return grafoPeliculasService.crearPelicula(pelicula);
    }

    @PutMapping("/conectar")
    public void conectarPeliculaActor(@RequestParam Long peliculaId, @RequestParam Long actorId) {
        grafoPeliculasService.conectarPeliculaActor(peliculaId, actorId);
    }

    @GetMapping("/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable Long id) {
        return grafoPeliculasService.obtenerPeliculaPorId(id);
    }

    @GetMapping
    public List<Pelicula> obtenerTodasLasPeliculas() {
        return grafoPeliculasService.obtenerTodasLasPeliculas();
    }

    @GetMapping("/buscar")
    public List<Pelicula> buscarPeliculasPorActores(@RequestParam Long actor1Id, @RequestParam Long actor2Id) {
        return grafoPeliculasService.buscarPeliculasPorActores(actor1Id, actor2Id);
    }

    // Otros métodos para manejar POST, PUT, GET, etc.
} 
package com.tpo.GrafoPeliculas.controller;

import com.tpo.GrafoPeliculas.service.GrafoPeliculas;
import com.tpo.GrafoPeliculas.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    
    @Autowired
    private GrafoPeliculas grafoPeliculas;

    @GetMapping("/buscar")
    public List<Pelicula> buscarPeliculas(
            @RequestParam int actor1Id,
            @RequestParam int actor2Id,
            @RequestParam int actorExcluidoId) {
        return grafoPeliculas.buscarPeliculasPorActores(actor1Id, actor2Id, actorExcluidoId);
    }

    @PutMapping("/conectar")
    public void conectarPeliculaActor(
            @RequestParam int peliculaId,
            @RequestParam int actorId) {
        grafoPeliculas.conectarPeliculaActor(peliculaId, actorId);
    }
}

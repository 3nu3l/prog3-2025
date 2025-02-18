package com.tpo.GrafoPeliculas.controller;

import com.tpo.GrafoPeliculas.service.GrafoPeliculas;
import com.tpo.GrafoPeliculas.model.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PeliculaController {
    
    @Autowired
    private GrafoPeliculas grafoPeliculas;

    @GetMapping("/peliculas")
    public ResponseEntity<List<Pelicula>> obtenerPeliculas() {
        try {
            List<Pelicula> peliculas = grafoPeliculas.obtenerTodasLasPeliculas();
            return ResponseEntity.ok(peliculas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/peliculas/buscar")
    public List<Pelicula> buscarPeliculas(
            @RequestParam int actor1Id,
            @RequestParam int actor2Id,
            @RequestParam int actorExcluidoId) {
        return grafoPeliculas.buscarPeliculasPorActores(actor1Id, actor2Id, actorExcluidoId);
    }

    @PutMapping("/peliculas/conectar")
    public void conectarPeliculaActor(
            @RequestParam int peliculaId,
            @RequestParam int actorId) {
        grafoPeliculas.conectarPeliculaActor(peliculaId, actorId);
    }

    @PutMapping("/cargar-datos")
    public ResponseEntity<String> cargarDatos() {
        try {
            grafoPeliculas.inicializarGrafoEjemplo();
            return ResponseEntity.ok("Datos cargados exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al cargar datos: " + e.getMessage());
        }
    }
}

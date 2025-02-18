package com.tpo.GrafoPeliculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.tpo.GrafoPeliculas.repository.ActorRepository;
import com.tpo.GrafoPeliculas.model.Actor;

@RestController
@RequestMapping("/api")
public class ActorController {
    
    @Autowired
    private ActorRepository actorRepository;

    @PostMapping("/actores")
    public ResponseEntity<Actor> crearActor(@RequestBody Actor actor) {
        try {
            Actor nuevoActor = actorRepository.save(actor);
            return ResponseEntity.ok(nuevoActor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/actores")
    public ResponseEntity<List<Actor>> obtenerActores() {
        try {
            List<Actor> actores = actorRepository.findAll();
            return ResponseEntity.ok(actores);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/actores/{id}")
    public ResponseEntity<Actor> obtenerActorPorId(@PathVariable int id) {
        return actorRepository.findById(id)
            .map(actor -> ResponseEntity.ok(actor))
            .orElse(ResponseEntity.notFound().build());
    }
} 
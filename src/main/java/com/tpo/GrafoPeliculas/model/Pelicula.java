package com.tpo.GrafoPeliculas.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
public class Pelicula {
    @Id
    private Long id;
    private String titulo;
    
    @Relationship(type = "ACTUA_EN", direction = Relationship.Direction.INCOMING)
    private Set<Actor> actores = new HashSet<Actor>();

    public Pelicula(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public Set<Actor> getActores() { return actores; }
    public void setActores(Set<Actor> actores) { this.actores = actores; }
} 
package com.tpo.GrafoPeliculas.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node
public class Actor {
    @Id
    private Long id;
    private String nombre;
    
    @Relationship(type = "ACTUA_EN")
    private Set<Pelicula> peliculas = new HashSet<Pelicula>();

    public Actor(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Set<Pelicula> getPeliculas() { return peliculas; }
    public void setPeliculas(Set<Pelicula> peliculas) { this.peliculas = peliculas; }
} 
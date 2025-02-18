package com.tpo.GrafoPeliculas.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import java.util.Set;
import java.util.HashSet;

@Node("Pelicula")
public class Pelicula {
    @Id
    private int id;
    private String titulo;
    
    @Relationship(type = "ACTUA_EN", direction = Relationship.Direction.INCOMING)
    private Set<Actor> actores = new HashSet<>();

    public Pelicula(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Actor> getActores() {
        return actores;
    }

    public void setActores(Set<Actor> actores) {
        this.actores = actores;
    }
}

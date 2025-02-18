package com.tpo.GrafoPeliculas.model;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("Pelicula")
public class Pelicula {
    @Id
    private int id;
    private String titulo;

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
}

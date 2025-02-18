package com.tpo.GrafoPeliculas.repository;

import com.tpo.GrafoPeliculas.model.Pelicula;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends Neo4jRepository<Pelicula, Integer> {
} 
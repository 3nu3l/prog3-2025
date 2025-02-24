package com.tpo.GrafoPeliculas.repository;

import com.tpo.GrafoPeliculas.model.Pelicula;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface PeliculaRepository extends Neo4jRepository<Pelicula, Long> {
    @Query("MATCH (p:Pelicula)<-[:ACTUA_EN]-(a:Actor) WHERE a.id = $actor1Id OR a.id = $actor2Id RETURN p")
    List<Pelicula> findPeliculasByActores(Long actor1Id, Long actor2Id);
} 
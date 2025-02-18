package com.tpo.GrafoPeliculas.repository;

import com.tpo.GrafoPeliculas.model.Actor;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends Neo4jRepository<Actor, Integer> {
} 
package com.tpo.GrafoPeliculas;
import java.util.*;

import com.tpo.GrafoPeliculas.model.Pelicula;
import com.tpo.GrafoPeliculas.service.GrafoPeliculas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GrafoPeliculasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrafoPeliculasApplication.class, args);
	}

	@Bean
	public GrafoPeliculas grafoPeliculas() {
		GrafoPeliculas red = new GrafoPeliculas();
		
		// Inicialización del grafo con datos de ejemplo
		inicializarGrafoEjemplo(red);
		
		return red;
	}

	private void inicializarGrafoEjemplo(GrafoPeliculas red) {
		// Crear películas
		Pelicula pelicula1 = new Pelicula(1, "Inception");
		// ... resto del código de inicialización ...
		
		// Agregar películas y actores al grafo
		red.agregarPelicula(pelicula1);
		// ... resto de las conexiones ...
	}

}



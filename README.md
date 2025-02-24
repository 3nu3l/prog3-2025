# Programación 3 - 2025

## Requisitos e Instalación

### Requisitos Previos
- Java 17 o superior
- Maven (opcional, se incluye wrapper)

### Ejecutar el Proyecto
```bash
# En Windows
./mvnw.cmd spring-boot:run

# En Unix/MacOS
./mvnw spring-boot:run
```

## API Endpoints y Ejemplos

### 1. Cargar Datos

#### Crear Actor
```bash
curl -X POST "http://localhost:8080/api/actores" \
     -H "Content-Type: application/json" \
     -d '{"nombre": "Marlon Brando", "fechaNacimiento": "1924-04-03"}'

curl -X POST "http://localhost:8080/api/actores" \
     -H "Content-Type: application/json" \
     -d '{"nombre": "John Travolta", "fechaNacimiento": "1954-02-18"}'

curl -X POST "http://localhost:8080/api/actores" \
     -H "Content-Type: application/json" \
     -d '{"nombre": "Keanu Reeves", "fechaNacimiento": "1964-09-02"}'
```

#### Crear Película
```bash
curl -X POST "http://localhost:8080/api/peliculas" \
     -H "Content-Type: application/json" \
     -d '{"titulo": "The Godfather", "anio": 1972, "genero": "Drama, Crimen"}'

curl -X POST "http://localhost:8080/api/peliculas" \
     -H "Content-Type: application/json" \
     -d '{"titulo": "Pulp Fiction", "anio": 1994, "genero": "Crimen, Drama"}'

curl -X POST "http://localhost:8080/api/peliculas" \
     -H "Content-Type: application/json" \
     -d '{"titulo": "The Matrix", "anio": 1999, "genero": "Ciencia Ficción, Acción"}'
```

#### Conectar Película y Actor
```bash
curl -X PUT "http://localhost:8080/api/peliculas/conectar?peliculaId=1&actorId=1"

curl -X PUT "http://localhost:8080/api/peliculas/conectar?peliculaId=2&actorId=2"

curl -X PUT "http://localhost:8080/api/peliculas/conectar?peliculaId=3&actorId=3"
```

### 2. Consultar Datos

#### Obtener todas las películas
```bash
curl http://localhost:8080/api/peliculas
```

#### Buscar películas por actores
```bash
curl "http://localhost:8080/api/peliculas/buscar?actor1Id=1&actor2Id=2&actorExcluidoId=3"
```

### 3. Ejemplos de Películas

1. The Godfather (1972)
   - ID: 1
   - Actor Principal: Marlon Brando (ID: 1)
   - Género: Drama, Crimen

2. Pulp Fiction (1994)
   - ID: 2
   - Actor Principal: John Travolta (ID: 2)
   - Género: Crimen, Drama

3. The Matrix (1999)
   - ID: 3
   - Actor Principal: Keanu Reeves (ID: 3)
   - Género: Ciencia Ficción, Acción

## Ramas del Proyecto

A continuación se encuentran los enlaces a las diferentes ramas del proyecto de cada miembro del grupo:

- [emmanuelmaidana](https://github.com/3nu3l/prog3-2025/tree/emmanuelmaidana) - Emmanuel Maidana
- [EjerciciosAgustinHaedo](https://github.com/3nu3l/prog3-2025/tree/EjerciciosAgustinHaedo) - Agustín Haedo
- [EjerciciosJoaquínHaedo](https://github.com/3nu3l/prog3-2025/tree/EjerciciosJoaquínHaedo) - Joaquín Haedo
- [arsilvestre](https://github.com/3nu3l/prog3-2025/tree/arsilvestre) - Ariel Silvestre
- [tpo](https://github.com/3nu3l/prog3-2025/tree/tpo) - Trabajo Práctico Obligatorio

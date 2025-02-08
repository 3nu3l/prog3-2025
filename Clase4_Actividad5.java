/*
 * Actividad 5

Ejercicio: Campeonato de Atletismo - Encontrar los Mejores Tiempos por
Categoría
Descripción:
Se organiza un campeonato de atletismo con varias categorías. Cada corredor
tiene un nombre, una categoría y un tiempo en segundos registrado en su carrera.
Se desea encontrar el mejor tiempo (mínimo) y el nombre del corredor
correspondiente para cada categoría, utilizando la técnica de Divide y Vencerás.



Pseudocodigo


function encontrarMejoresTiemposPorCategoria(listaCorredores):
    if tamaño(listaCorredores) == 1:
        return { listaCorredores[0].categoria: listaCorredores[0] }
    
    mitad = tamaño(listaCorredores) // 2
    subListaIzquierda = listaCorredores[0..mitad-1]
    subListaDerecha = listaCorredores[mitad..tamaño(listaCorredores)-1]
    
    mejoresTiemposIzquierda = encontrarMejoresTiemposPorCategoria(subListaIzquierda)
    mejoresTiemposDerecha = encontrarMejoresTiemposPorCategoria(subListaDerecha)
    
    return combinarMejoresTiempos(mejoresTiemposIzquierda, mejoresTiemposDerecha)

function combinarMejoresTiempos(mejoresIzq, mejoresDer):
    resultado = {}
    for cada categoria en mejoresIzq o mejoresDer:
        if categoria no está en mejoresIzq:
            resultado[categoria] = mejoresDer[categoria]
        else if categoria no está en mejoresDer:
            resultado[categoria] = mejoresIzq[categoria]
        else:
            if mejoresIzq[categoria].tiempo < mejoresDer[categoria].tiempo:
                resultado[categoria] = mejoresIzq[categoria]
            else:
                resultado[categoria] = mejoresDer[categoria]
    return resultado



Análisis de recurrencia:
El análisis de la complejidad algorítmica mediante el método inductivo implica considerar cómo el algoritmo se comporta a medida que el tamaño del problema se incrementa.

Caso base: Si la lista tiene solo un corredor, entonces retornamos el corredor como el mejor tiempo en su categoría. Esto tiene una complejidad de 𝑂(1).

Caso recursivo: Si la lista tiene más de un corredor, dividimos la lista en dos sublistas de aproximadamente la mitad del tamaño original. Aplicamos la técnica recursivamente a cada sublista y luego combinamos los resultados.

La relación de recurrencia se puede expresar como:

𝑇(𝑛)=2𝑇(𝑛/2)+𝑂(𝑛)

Donde 𝑂(𝑛) es el tiempo necesario para combinar los resultados de las dos sublistas. Usando el método inductivo, podemos inducir que la complejidad total del algoritmo es 𝑂(𝑛log 𝑛).
 * 
 * 
 */

import java.util.*;

class Corredor {
    String nombre;
    String categoria;
    double tiempo;

    Corredor(String nombre, String categoria, double tiempo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tiempo = tiempo;
    }
}

public class Clase4_Actividad5 {
    public static void main(String[] args) {
        List<Corredor> corredores = Arrays.asList(
            new Corredor("Juan", "Senior", 12.5),
            new Corredor("Ana", "Junior", 13.0),
            new Corredor("Luis", "Senior", 11.8),
            new Corredor("Marta", "Junior", 12.4),
            new Corredor("Carlos", "Juvenil", 14.0)
        );

        Map<String, Corredor> mejoresTiempos = encontrarMejoresTiemposPorCategoria(corredores);
        for (Map.Entry<String, Corredor> entry : mejoresTiempos.entrySet()) {
            Corredor corredor = entry.getValue();
            System.out.println("Categoría: " + entry.getKey() + ", Nombre: " + corredor.nombre + ", Tiempo: " + corredor.tiempo);
        }
    }

    public static Map<String, Corredor> encontrarMejoresTiemposPorCategoria(List<Corredor> listaCorredores) {
        if (listaCorredores.size() == 1) {
            Corredor corredor = listaCorredores.get(0);
            Map<String, Corredor> resultado = new HashMap<>();
            resultado.put(corredor.categoria, corredor);
            return resultado;
        }

        int mitad = listaCorredores.size() / 2;
        List<Corredor> subListaIzquierda = listaCorredores.subList(0, mitad);
        List<Corredor> subListaDerecha = listaCorredores.subList(mitad, listaCorredores.size());

        Map<String, Corredor> mejoresIzquierda = encontrarMejoresTiemposPorCategoria(subListaIzquierda);
        Map<String, Corredor> mejoresDerecha = encontrarMejoresTiemposPorCategoria(subListaDerecha);

        return combinarMejoresTiempos(mejoresIzquierda, mejoresDerecha);
    }

    public static Map<String, Corredor> combinarMejoresTiempos(Map<String, Corredor> mejoresIzq, Map<String, Corredor> mejoresDer) {
        Map<String, Corredor> resultado = new HashMap<>();

        Set<String> todasCategorias = new HashSet<>(mejoresIzq.keySet());
        todasCategorias.addAll(mejoresDer.keySet());

        for (String categoria : todasCategorias) {
            if (!mejoresIzq.containsKey(categoria)) {
                resultado.put(categoria, mejoresDer.get(categoria));
            } else if (!mejoresDer.containsKey(categoria)) {
                resultado.put(categoria, mejoresIzq.get(categoria));
            } else {
                if (mejoresIzq.get(categoria).tiempo < mejoresDer.get(categoria).tiempo) {
                    resultado.put(categoria, mejoresIzq.get(categoria));
                } else {
                    resultado.put(categoria, mejoresDer.get(categoria));
                }
            }
        }
        return resultado;
    }
}

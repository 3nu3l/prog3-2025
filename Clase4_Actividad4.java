/*
 * Actividad 4

Objetivo: Encontrar los "n" elementos más grandes en una lista utilizando la
técnica de Divide y Vencerás
Tareas:
Resolver mediante pseudocódigo
Realizar el análisis de recurrencia mediante método inductivo (sin utilizar fórmulas
matemáticas) para indicar la complejidad algorítmica.
Implementar en java
 * 
 * 
 * Pseudocódigo
 * 
 * function encontrarNMaximos(lista, n):
    if tamaño(lista) <= n:
        return ordenar(lista)[:n]
    
    mitad = tamaño(lista) // 2
    subListaIzquierda = lista[0..mitad-1]
    subListaDerecha = lista[mitad..tamaño(lista)-1]

    maximosIzquierda = encontrarNMaximos(subListaIzquierda, n)
    maximosDerecha = encontrarNMaximos(subListaDerecha, n)

    combinados = combinar(maximosIzquierda, maximosDerecha)
    return ordenar(combinados)[:n]

function combinar(lista1, lista2):
    return lista1 + lista2

function ordenar(lista):
    // Implementación de un algoritmo de ordenación (p.ej., QuickSort, MergeSort)
    return lista ordenada

 * Análisis de recurrencia:
El análisis de la complejidad algorítmica de este problema mediante el método inductivo implica considerar cómo el algoritmo se comporta al aumentar el tamaño del problema:

Caso base: Si la lista tiene un tamaño menor o igual a "n", entonces simplemente ordenamos la lista y tomamos los primeros "n" elementos. Este paso tiene una complejidad de 𝑂(𝑛log  𝑛) debido a la ordenación.

Caso recursivo: Si la lista tiene un tamaño mayor que "n", dividimos la lista en dos sublistas de aproximadamente la mitad del tamaño original. Luego aplicamos la técnica recursivamente a cada sublista y combinamos los resultados.

La relación de recurrencia para este problema se puede expresar como:

𝑇(𝑛)=2𝑇(𝑛/2)+𝑂(𝑛log⁡ 𝑛)

Este es un problema clásico que se puede resolver con el método de la recurrencia. Usando el método inductivo, podemos inducir que la complejidad total del algoritmo es 𝑂(𝑛log 𝑛).
 * 
 * 
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class Clase4_Actividad4 {
    public static void main(String[] args) {
        int[] numeros = {15, 42, 23, 4, 8, 16, 9};
        int n = 3; // Por ejemplo, queremos encontrar los 3 elementos más grandes

        int[] resultado = encontrarNMaximos(numeros, n);
        System.out.println("Los " + n + " elementos más grandes son: " + Arrays.toString(resultado));
    }

    public static int[] encontrarNMaximos(int[] lista, int n) {
        if (lista.length <= n) {
            Arrays.sort(lista);
            return Arrays.copyOfRange(lista, Math.max(0, lista.length - n), lista.length);
        }

        int mitad = lista.length / 2;
        int[] subListaIzquierda = Arrays.copyOfRange(lista, 0, mitad);
        int[] subListaDerecha = Arrays.copyOfRange(lista, mitad, lista.length);

        int[] maximosIzquierda = encontrarNMaximos(subListaIzquierda, n);
        int[] maximosDerecha = encontrarNMaximos(subListaDerecha, n);

        return combinarYOrdenar(maximosIzquierda, maximosDerecha, n);
    }

    public static int[] combinarYOrdenar(int[] lista1, int[] lista2, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : lista1) pq.offer(num);
        for (int num : lista2) pq.offer(num);

        while (pq.size() > n) {
            pq.poll();
        }

        int[] resultado = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            resultado[i] = pq.poll();
        }

        return resultado;
    }
}

 

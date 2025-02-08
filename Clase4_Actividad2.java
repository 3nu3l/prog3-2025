/*

Actividad 2

Objetivo: Dada una lista de números, encontrar los dos números mayores
utilizando la técnica de Divide y Conquista.
Tareas:
Pseudocódigo: Escribe el pseudocódigo que resuelva el problema.
Implementación en Java: Implementa el pseudocódigo en Java.




Pseudocódigo
 * function encontrarDosMayores(lista):
    if tamaño(lista) == 1:
        return (lista[0], -∞)
    if tamaño(lista) == 2:
        if lista[0] > lista[1]:
            return (lista[0], lista[1])
        else:
            return (lista[1], lista[0])

    mitad = tamaño(lista) // 2
    subListaIzquierda = lista[0..mitad-1]
    subListaDerecha = lista[mitad..tamaño(lista)-1]

    (mayorIzq, segundoMayorIzq) = encontrarDosMayores(subListaIzquierda)
    (mayorDer, segundoMayorDer) = encontrarDosMayores(subListaDerecha)

    if mayorIzq > mayorDer:
        mayor = mayorIzq
        segundoMayor = max(segundoMayorIzq, mayorDer)
    else:
        mayor = mayorDer
        segundoMayor = max(segundoMayorDer, mayorIzq)

    return (mayor, segundoMayor)

 */

import java.util.Arrays;

public class Clase4_Actividad2 {
     public static void main(String[] args) {
         int[] numeros = {15, 42, 23, 4, 8, 16, 9};
 
         int[] resultado = encontrarDosMayores(numeros);
         System.out.println("Los dos números mayores son: " + resultado[0] + " y " + resultado[1]);
     }
 
     public static int[] encontrarDosMayores(int[] lista) {
         if (lista.length == 1) {
             return new int[]{lista[0], Integer.MIN_VALUE};
         }
         if (lista.length == 2) {
             if (lista[0] > lista[1]) {
                 return new int[]{lista[0], lista[1]};
             } else {
                 return new int[]{lista[1], lista[0]};
             }
         }
 
         int mitad = lista.length / 2;
         int[] subListaIzquierda = Arrays.copyOfRange(lista, 0, mitad);
         int[] subListaDerecha = Arrays.copyOfRange(lista, mitad, lista.length);
 
         int[] mayoresIzq = encontrarDosMayores(subListaIzquierda);
         int[] mayoresDer = encontrarDosMayores(subListaDerecha);
 
         int mayor, segundoMayor;
         if (mayoresIzq[0] > mayoresDer[0]) {
             mayor = mayoresIzq[0];
             segundoMayor = Math.max(mayoresIzq[1], mayoresDer[0]);
         } else {
             mayor = mayoresDer[0];
             segundoMayor = Math.max(mayoresDer[1], mayoresIzq[0]);
         }
 
         return new int[]{mayor, segundoMayor};
     }
}
 
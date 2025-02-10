/*
 * Actividad 3

Una empresa distribuidora necesita cargar un camión con mercancía que se
puede fraccionar. Indicar con una lista los elementos a subir al camión para
maximizar el valor total, dado que el camión tiene una capacidad limitada.


Pseudocodigo

function maximizarValor(mercancias, capacidad):
    sort(mercancias) by value-to-weight ratio in descending order
    valorTotal = 0
    listaCargada = empty list
    for each mercancia in mercancias:
        if capacidad >= mercancia.peso:
            add mercancia to listaCargada
            capacidad = capacidad - mercancia.peso
            valorTotal = valorTotal + mercancia.valor
        else:
            fraccion = capacidad / mercancia.peso
            valorFraccionado = fraccion * mercancia.valor
            add mercancia (fraccion) to listaCargada
            valorTotal = valorTotal + valorFraccionado
            break
    return listaCargada, valorTotal




Complejidad Algorítmica
La complejidad del algoritmo greedy se basa en la ordenación de la lista de mercancías y la iteración sobre la lista.
La ordenación tiene una complejidad de 𝑂(𝑛log 𝑛) y la iteración tiene una complejidad de 𝑂(𝑛), donde 𝑛 es el número de mercancías en la lista. 
Por lo tanto, la complejidad total del algoritmo es 𝑂(𝑛log  𝑛).


 * 
 * 
 */

 import java.util.*;

 class Mercancia {
     double peso;
     double valor;
     
     Mercancia(double peso, double valor) {
         this.peso = peso;
         this.valor = valor;
     }
     
     double ratio() {
         return valor / peso;
     }
 }
 
 public class Clase5_Actividad3 {
     public static List<Mercancia> maximizarValor(List<Mercancia> mercancias, double capacidad) {
         // Ordenar las mercancías por la relación valor/peso en orden descendente
         mercancias.sort((a, b) -> Double.compare(b.ratio(), a.ratio()));
         
         List<Mercancia> listaCargada = new ArrayList<>();
         double valorTotal = 0;
         
         for (Mercancia mercancia : mercancias) {
             if (capacidad >= mercancia.peso) {
                 listaCargada.add(mercancia);
                 capacidad -= mercancia.peso;
                 valorTotal += mercancia.valor;
             } else {
                 double fraccion = capacidad / mercancia.peso;
                 double valorFraccionado = fraccion * mercancia.valor;
                 listaCargada.add(new Mercancia(capacidad, valorFraccionado));
                 valorTotal += valorFraccionado;
                 break;
             }
         }
         
         System.out.println("Valor total: " + valorTotal);
         return listaCargada;
     }
     
     public static void main(String[] args) {
         List<Mercancia> mercancias = Arrays.asList(
             new Mercancia(10, 60),
             new Mercancia(20, 100),
             new Mercancia(30, 120)
         );
         double capacidad = 50;
         List<Mercancia> resultado = maximizarValor(mercancias, capacidad);
         System.out.println("Lista de mercancías cargadas:");
         for (Mercancia m : resultado) {
             System.out.println("Peso: " + m.peso + ", Valor: " + m.valor);
         }
     }
 }
 
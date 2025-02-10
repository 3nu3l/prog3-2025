/*
 * Actividad 2: Cambio de Moneda Extranjera con
Múltiples Tipos de Comprobantes

Descripción del Problema:
Un sistema de tesorería tiene a disposición una variedad de comprobantes que
incluyen monedas, cheques, bonos y otros documentos financieros. Cada
comprobante tiene un valor específico. El objetivo es realizar una compra de
moneda extranjera minimizando el número de comprobantes utilizados.
Resolver mediante pseudocódigo e implementación java.
Indicar la complejidad algorítmica.
 * 
 * 
 * 
 * Pseudocodigo
 * 
 * function cambioMoneda(comprobantes, importe):
    sort(comprobantes) in descending order by value
    listaSeleccion = empty list
    for each comprobante in comprobantes:
        while importe >= comprobante.valor:
            add comprobante to listaSeleccion
            importe = importe - comprobante.valor
    if importe == 0:
        return listaSeleccion
    else:
        return null



Complejidad Algorítmica
La complejidad del algoritmo greedy se basa en la ordenación de la lista de comprobantes y la iteración sobre la lista. 
La ordenación tiene una complejidad de 𝑂(𝑛log 𝑛) y la iteración tiene una complejidad de 𝑂(𝑛), donde 𝑛 es el número de comprobantes en la lista.
Por lo tanto, la complejidad total del algoritmo es 𝑂(𝑛log 𝑛).

 */

 import java.util.*;

 class Comprobante {
     int valor;
     String tipo;
 
     Comprobante(int valor, String tipo) {
         this.valor = valor;
         this.tipo = tipo;
     }
 }
 
 public class Clase5_Actividad2 {
     public static List<Comprobante> cambioMoneda(List<Comprobante> comprobantes, int importe) {
         // Ordenar los comprobantes en orden descendente por valor
         comprobantes.sort((a, b) -> b.valor - a.valor);
         
         List<Comprobante> listaSeleccion = new ArrayList<>();
         for (Comprobante comprobante : comprobantes) {
             while (importe >= comprobante.valor) {
                 listaSeleccion.add(comprobante);
                 importe -= comprobante.valor;
             }
         }
         
         if (importe == 0) {
             return listaSeleccion;
         } else {
             // Devolver una lista nula si no se puede realizar la compra exacta
             return null;
         }
     }
 
     public static void main(String[] args) {
         List<Comprobante> comprobantes = Arrays.asList(
             new Comprobante(10, "moneda"),
             new Comprobante(20, "cheque"),
             new Comprobante(50, "bono"),
             new Comprobante(5, "moneda"),
             new Comprobante(1, "moneda")
         );
         int importe = 66;
         List<Comprobante> resultado = cambioMoneda(comprobantes, importe);
         if (resultado != null) {
             System.out.println("Lista de comprobantes utilizados:");
             for (Comprobante c : resultado) {
                 System.out.println("Tipo: " + c.tipo + ", Valor: " + c.valor);
             }
         } else {
             System.out.println("No se puede realizar la compra exacta.");
         }
     }
 }
 
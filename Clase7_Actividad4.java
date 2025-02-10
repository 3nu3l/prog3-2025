/*
 * Actividad 4

Problema: Selección de paquetes de inversión
Eres un gestor financiero y tienes la tarea de seleccionar entre varios paquetes de
inversión para maximizar las ganancias. Cada paquete tiene un costo inicial y una
ganancia estimada. Sin embargo, tu presupuesto es limitado, por lo que debes elegir
cuidadosamente qué paquetes comprar para maximizar las ganancias sin exceder el
presupuesto.
Requerimientos:
Te proporcionarán un arreglo de costos, donde cada elemento representa el costo de un
paquete de inversión.
También recibirás un arreglo de ganancias que representa la ganancia esperada de
cada paquete.
Debes implementar un algoritmo que determine la combinación de paquetes que
maximiza las ganancias totales sin superar el presupuesto disponible.

Datos de Ejemplo:
Costos de los paquetes de inversión: [12, 20, 15, 25]
Ganancias esperadas: [150, 200, 100, 300]
Presupuesto disponible: 35
El programa debe calcular cuál es la ganancia máxima que puedes obtener
respetando el presupuesto.

Calcular utilizando algoritmos de programación dinámica. Indicar complejidades.
 * 
 * Complejidad
Tiempo: La complejidad temporal del algoritmo es O(n×B), donde n es el número de paquetes y B es el presupuesto disponible.
Espacio: La complejidad espacial del algoritmo es O(n×B) debido a la tabla dp utilizada para almacenar los valores intermedios.
 * 
 * 
 */


 import java.util.*;

 public class Clase7_Actividad4 {
     public static void main(String[] args) {
         int[] costos = {12, 20, 15, 25};
         int[] ganancias = {150, 200, 100, 300};
         int presupuesto = 35;
         int n = costos.length;
 
         int[][] dp = new int[n + 1][presupuesto + 1];
 
         for (int i = 1; i <= n; i++) {
             for (int j = 1; j <= presupuesto; j++) {
                 if (costos[i - 1] <= j) {
                     dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + ganancias[i - 1]);
                 } else {
                     dp[i][j] = dp[i - 1][j];
                 }
             }
         }
 
         System.out.println("Ganancia máxima: " + dp[n][presupuesto]);
 
         // Recuperar los paquetes seleccionados
         List<Integer> paquetesSeleccionados = new ArrayList<>();
         int w = presupuesto;
         for (int i = n; i > 0 && w > 0; i--) {
             if (dp[i][w] != dp[i - 1][w]) {
                 paquetesSeleccionados.add(i);
                 w -= costos[i - 1];
             }
         }
 
         System.out.println("Paquetes seleccionados: " + paquetesSeleccionados);
     }
 }
/*
 * Actividad 3

Problema: Selección óptima de proyectos
Eres el gerente de una empresa que debe decidir en qué proyectos invertir. Cada
proyecto tiene un costo asociado y un beneficio esperado. Tienes un presupuesto
limitado y necesitas elegir qué combinación de proyectos maximiza el beneficio
total sin exceder el presupuesto.
Requerimientos:
Te proporcionarán un arreglo de costos que representa el costo de cada proyecto.
También te proporcionarán un arreglo de beneficios que indica el beneficio que se
espera de cada proyecto.
Implementa un algoritmo que determine qué proyectos deben seleccionarse para
maximizar el beneficio total sin exceder el presupuesto.

Supón que tienes los siguientes datos:
Costos de los proyectos: [10, 15, 20, 25]
Beneficios esperados de los proyectos: [100, 200, 150, 300]
Presupuesto disponible: 40
El programa debe calcular cuál es el beneficio máximo que puedes obtener
respetando el presupuesto disponible y los proyectos seleccionados.

Calcular utilizando algoritmos de programación dinámica. Indicar complejidades.
 * 
 * 
 * 
 * 
 * 
 * Complejidad
 * ***********
Tiempo: La complejidad temporal del algoritmo es O(n×B), donde n es el número de proyectos y B es el presupuesto disponible.
Espacio: La complejidad espacial del algoritmo es O(n×B) debido a la tabla dp utilizada para almacenar los valores intermedios.
 */

import java.util.ArrayList;
import java.util.List;

public class Clase7_Actividad3 {
    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;
        int n = costos.length;

        int[][] dp = new int[n + 1][presupuesto + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + beneficios[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Beneficio máximo: " + dp[n][presupuesto]);

        // Recuperar los proyectos seleccionados
        List<Integer> proyectosSeleccionados = new ArrayList<>();
        int w = presupuesto;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                proyectosSeleccionados.add(i);
                w -= costos[i - 1];
            }
        }

        System.out.println("Proyectos seleccionados: " + proyectosSeleccionados);
    }
}
package Actividad4;

import java.util.ArrayList;
import java.util.List;

public class SeleccionPaquetesInversion {

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;

        Resultado resultado = seleccionarPaquetes(costos, ganancias, presupuesto);

        System.out.println("Ganancia máxima: " + resultado.gananciaMaxima);
        System.out.println("Paquetes seleccionados: " + resultado.paquetesSeleccionados);
    }

    static class Resultado {
        int gananciaMaxima;
        List<Integer> paquetesSeleccionados;

        Resultado(int gananciaMaxima, List<Integer> paquetesSeleccionados) {
            this.gananciaMaxima = gananciaMaxima;
            this.paquetesSeleccionados = paquetesSeleccionados;
        }
    }

    public static Resultado seleccionarPaquetes(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenar la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], ganancias[i - 1] + dp[i - 1][j - costos[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Reconstruir la solución: encontrar qué paquetes se seleccionaron
        int j = presupuesto;
        List<Integer> paquetesSeleccionados = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            if (dp[i][j] != dp[i - 1][j]) {  // Si se tomó el paquete
                paquetesSeleccionados.add(i); 
                j -= costos[i - 1];
            }
        }

        return new Resultado(dp[n][presupuesto], paquetesSeleccionados);
    }
}


/*
Análisis de Complejidad
Tiempo: 
𝑂(𝑛 × 𝑃)
O(n×P) donde:
n es la cantidad de paquetes.
P es el presupuesto disponible.
Espacio: 
𝑂(𝑛 × 𝑃)
O(n×P) por la tabla dp.

*/
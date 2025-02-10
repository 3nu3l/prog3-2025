package Actividad3;

public class SeleccionProyectos {

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        Resultado resultado = seleccionarProyectos(costos, beneficios, presupuesto);

        System.out.println("Beneficio máximo: " + resultado.beneficioMaximo);
        System.out.println("Proyectos seleccionados: " + resultado.proyectosSeleccionados);
    }

    static class Resultado {
        int beneficioMaximo;
        java.util.List<Integer> proyectosSeleccionados;

        Resultado(int beneficioMaximo, java.util.List<Integer> proyectosSeleccionados) {
            this.beneficioMaximo = beneficioMaximo;
            this.proyectosSeleccionados = proyectosSeleccionados;
        }
    }

    public static Resultado seleccionarProyectos(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Llenar la tabla dp
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], beneficios[i - 1] + dp[i - 1][j - costos[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Reconstruir los proyectos seleccionados
        int j = presupuesto;
        java.util.List<Integer> proyectosSeleccionados = new java.util.ArrayList<>();
        for (int i = n; i > 0; i--) {
            if (dp[i][j] != dp[i - 1][j]) {  // Si se tomó el proyecto
                proyectosSeleccionados.add(i); 
                j -= costos[i - 1];
            }
        }

        return new Resultado(dp[n][presupuesto], proyectosSeleccionados);
    }
}


/*

Análisis de Complejidad
Tiempo: 
𝑂(𝑛 × 𝑃)
O(n×P) donde:
n es la cantidad de proyectos.
P es el presupuesto disponible.
Espacio: 
𝑂(𝑛 × 𝑃)
O(n×P) debido a la tabla dp.
*/
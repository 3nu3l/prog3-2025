public class SeleccionProyectos {
    public static int seleccionarProyectos(int[] costos, int[] beneficios, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Construcción de la tabla DP
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= presupuesto; w++) {
                if (costos[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], beneficios[i - 1] + dp[i - 1][w - costos[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][presupuesto];
    }

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25};
        int[] beneficios = {100, 200, 150, 300};
        int presupuesto = 40;

        int beneficioMaximo = seleccionarProyectos(costos, beneficios, presupuesto);
        System.out.println("Beneficio máximo obtenible: " + beneficioMaximo);
    }
}
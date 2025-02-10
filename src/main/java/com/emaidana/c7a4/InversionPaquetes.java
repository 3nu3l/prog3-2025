public class InversionPaquetes {
    
    public static int seleccionPaquetes(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + ganancias[i - 1]);
                }
            }
        }
        
        return dp[n][presupuesto];
    }
    
    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;
        
        int maxGanancia = seleccionPaquetes(costos, ganancias, presupuesto);
        System.out.println("La ganancia máxima que se puede obtener es: " + maxGanancia);
    }
}

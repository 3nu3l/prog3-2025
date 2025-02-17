import java.util.*;

public class StockTradingDP {
    public static int maxProfit(int K, int[] prices) {
        int n = prices.length;
        if (n == 0 || K == 0) return 0;

        // Si K es mayor que n/2, podemos operar libremente como si no hubiera restricciones
        if (K >= n / 2) {
            int maxProfit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    maxProfit += prices[i] - prices[i - 1];
                }
            }
            return maxProfit;
        }

        // DP: dp[k][d] = máximo beneficio con hasta k transacciones en el día d
        int[][] dp = new int[K + 1][n];

        // Iterar sobre el número de transacciones
        for (int t = 1; t <= K; t++) {
            int maxDiff = -prices[0]; // Máximo beneficio posible si compramos en un día previo
            for (int d = 1; d < n; d++) {
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }

        return dp[K][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de datos
        System.out.print("Ingrese el número máximo de transacciones (K): ");
        int K = scanner.nextInt();
        System.out.print("Ingrese el número de días (N): ");
        int N = scanner.nextInt();
        
        int[] prices = new int[N];
        System.out.println("Ingrese los precios de las acciones para cada día:");
        for (int i = 0; i < N; i++) {
            prices[i] = scanner.nextInt();
        }

        int resultado = maxProfit(K, prices);
        System.out.println("Máxima ganancia posible: " + resultado);
        scanner.close();
    }
}
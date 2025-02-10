package Actividad2;

public class Mochila {
    // Fuerza Bruta - Backtracking
    static int knapsackBruteForce(int[] pesos, int[] valores, int capacidad, int n) {
        if (n == 0 || capacidad == 0) return 0;
        
        if (pesos[n - 1] > capacidad) 
            return knapsackBruteForce(pesos, valores, capacidad, n - 1);

        int incluir = valores[n - 1] + knapsackBruteForce(pesos, valores, capacidad - pesos[n - 1], n - 1);
        int excluir = knapsackBruteForce(pesos, valores, capacidad, n - 1);
        
        return Math.max(incluir, excluir);
    }

    // Programación Dinámica - DP
    static int knapsackDP(int[] pesos, int[] valores, int capacidad, int n) {
        int[][] dp = new int[n + 1][capacidad + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacidad; j++) {
                if (pesos[i - 1] <= j) {
                    dp[i][j] = Math.max(valores[i - 1] + dp[i - 1][j - pesos[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacidad];
    }

    public static void main(String[] args) {
        int[] pesos = {2, 5, 6, 7};
        int[] valores = {4, 2, 1, 6};
        int capacidad = 10;
        int n = pesos.length;

        System.out.println("Fuerza Bruta: " + knapsackBruteForce(pesos, valores, capacidad, n));
        System.out.println("Programación Dinámica: " + knapsackDP(pesos, valores, capacidad, n));
    }
}

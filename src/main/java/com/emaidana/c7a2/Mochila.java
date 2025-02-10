public class Mochila {

    // Enfoque de Fuerza Bruta (Backtracking)
    public static int knapsackBruteForce(int[] pesos, int[] valores, int capacidad, int n) {
        if (n == 0 || capacidad == 0) {
            return 0; // Caso base
        }

        if (pesos[n - 1] > capacidad) {
            return knapsackBruteForce(pesos, valores, capacidad, n - 1);
        } else {
            int incluir = valores[n - 1] + knapsackBruteForce(pesos, valores, capacidad - pesos[n - 1], n - 1);
            int excluir = knapsackBruteForce(pesos, valores, capacidad, n - 1);
            return Math.max(incluir, excluir);
        }
    }

    // Enfoque de Programación Dinámica
    public static int knapsackDP(int[] pesos, int[] valores, int capacidad) {
        int n = pesos.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacidad; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (pesos[i - 1] <= j) {
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

        // Solución con Fuerza Bruta
        int resultadoBruteForce = knapsackBruteForce(pesos, valores, capacidad, n);
        System.out.println("Máximo valor (Fuerza Bruta): " + resultadoBruteForce);

        // Solución con Programación Dinámica
        int resultadoDP = knapsackDP(pesos, valores, capacidad);
        System.out.println("Máximo valor (Programación Dinámica): " + resultadoDP);
    }
}
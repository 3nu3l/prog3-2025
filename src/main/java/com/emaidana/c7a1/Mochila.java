public class Mochila {

    // Enfoque de Fuerza Bruta
    public static int knapsackBruteForce(int[] pesos, int[] valores, int capacidad, int n) {
        // Caso base: Si no hay objetos o la capacidad es 0
        if (n == 0 || capacidad == 0) {
            return 0;
        }

        // Si el peso del objeto actual es mayor que la capacidad, lo ignoramos
        if (pesos[n - 1] > capacidad) {
            return knapsackBruteForce(pesos, valores, capacidad, n - 1);
        } else {
            // Caso 1: Incluir el objeto
            int incluir = valores[n - 1] + knapsackBruteForce(pesos, valores, capacidad - pesos[n - 1], n - 1);
            // Caso 2: No incluir el objeto
            int excluir = knapsackBruteForce(pesos, valores, capacidad, n - 1);

            return Math.max(incluir, excluir);
        }
    }

    // Enfoque de Programación Dinámica
    public static int knapsackDP(int[] pesos, int[] valores, int capacidad) {
        int n = pesos.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        // Llenamos la tabla dp
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

        return dp[n][capacidad];  // Máximo valor obtenido con los objetos dados
    }

    public static void main(String[] args) {
        int[] pesos = {3, 4, 2}; // Pesos de los objetos
        int[] valores = {4, 5, 3}; // Valores de los objetos
        int capacidad = 6; // Capacidad de la mochila
        int n = pesos.length;

        // Solución con Fuerza Bruta
        int resultadoBruteForce = knapsackBruteForce(pesos, valores, capacidad, n);
        System.out.println("Máximo valor (Fuerza Bruta): " + resultadoBruteForce);

        // Solución con Programación Dinámica
        int resultadoDP = knapsackDP(pesos, valores, capacidad);
        System.out.println("Máximo valor (Programación Dinámica): " + resultadoDP);
    }
}
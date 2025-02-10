public class Main {
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] B = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };

        int n = A.length; // Tamaño de la matriz (n x n)
        int[][] C = new int[n][n]; // Matriz resultado

        // Multiplicación de matrices
        for (int i = 0; i < n; i++) { // Bucle externo: filas de A
            for (int j = 0; j < n; j++) { // Bucle medio: columnas de B
                for (int k = 0; k < n; k++) { // Bucle interno: cálculo del producto escalar
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("Resultado de la multiplicación:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}
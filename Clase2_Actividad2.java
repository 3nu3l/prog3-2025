public class Clase2_Actividad2 {
    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] mat2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        int n = mat1.length;

        int[][] result = new int[n][n];

        // Multiplicar las matrices
        for (int i = 0; i < n; i++) {          // O(n)
            for (int j = 0; j < n; j++) {      // O(n)
                result[i][j] = 0;              // O(1)
                for (int k = 0; k < n; k++) {  // O(n)
                    result[i][j] += mat1[i][k] * mat2[k][j]; // O(1)
                }
            }
        }

        // Imprimir la matriz resultado
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/*
Los bucles anidados para multiplicar las matrices tienen tres niveles.

Cada bucle tiene una complejidad de 𝑂(𝑛), y como están anidados, la complejidad total es 
𝑂(𝑛^3)
*/
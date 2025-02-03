//Se multiplica fila por columna


public class multiplicarMatrices {
    public static void main(String[] args) {
        // Definir matrices cuadradas de 2x2
        int[][] matriz1 = {
            {1, 2},
            {3, 4}
        };

        int[][] matriz2 = {
            {5, 6},
            {7, 8}
        };

        int n = matriz1.length; // Tamaño de la matriz (n x n)
        int[][] resultado = new int[n][n]; // Matriz resultado

        // Multiplicación de matrices
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        // Imprimir matriz resultante
        System.out.println("Matriz resultante:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//Complejidad asintótica- Tres bucles anidados.
// O(n)×O(n)×O(n)=O(n^3)- 


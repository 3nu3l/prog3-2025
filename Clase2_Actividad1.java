public class Clase2_Actividad1 {
    public static void main(String[] args) {
        int[][] mat = {{4, 5, 6}, {7, 8, 9}, {5, 6, 7}};
        int n = mat.length;
        int totalSum = 0;
        int elementCount = n * n; // O(1) - 1 instrucción

        // O(n^2) - n*n instrucciones
        for (int i = 0; i < n; i++) { // O(n) - n instrucciones
            for (int j = 0; j < n; j++) { // O(n) - n instrucciones
                totalSum += mat[i][j]; // O(1) - 1 instrucción
            }
        }

        double average = (double) totalSum / elementCount; // O(1) - 1 instrucción
        System.out.println("El promedio es: " + average); // O(1) - 1 instrucción
    }
}

/*
Complejidad asintótica:

El bucle anidado tiene una complejidad de O(n^2), donde n es el tamaño de la matriz.
Las demás operaciones tienen una complejidad de O(1).
Por lo tanto, la complejidad asintótica total del programa es O(n^2)

*/
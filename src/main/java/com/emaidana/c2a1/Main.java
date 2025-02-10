public class Main {
    public static void main(String[] args) {
        int[][] mat = {
            {4, 5, 6},
            {7, 8, 9},
            {5, 6, 7}
        };

        int suma = 0;
        int n = mat.length; // Número de filas o columnas (matriz cuadrada)

        // Conteo de elementos e iteración sobre la matriz
        for (int i = 0; i < n; i++) { // n iteraciones
            for (int j = 0; j < n; j++) { // n iteraciones por fila
                suma += mat[i][j]; // 1 instrucción por cada elemento
            }
        }

        // Cálculo del promedio
        double promedio = (double) suma / (n * n); // 1 instrucción
        System.out.println("El promedio de los elementos de la matriz es: " + promedio);
    }
}
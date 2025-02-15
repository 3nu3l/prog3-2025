/*Actividad 3

Diseño de Distribución de Equipos Electrónicos en Oficinas
En una oficina de 4x4, se necesita organizar la disposición de computadoras y
impresoras de manera que optimice el uso del espacio y facilite el acceso. Las
restricciones de diseño son las siguientes:
No puede haber dos computadoras en la misma fila o columna.
No puede haber dos impresoras en la misma fila o columna.
Debes encontrar todas las combinaciones posibles para colocar 4 computadoras y 4
impresoras en el tablero, respetando las restricciones anteriores.
Objetivo: Implementar un programa en Java que utilice la técnica de backtracking para
encontrar todas las configuraciones posibles de colocación de computadoras e
impresoras en el tablero de 4x4. Tu programa debe imprimir cada configuración válida. */

public class Clasee11_Actividad3 {

    private static final int N = 4; // Tamaño del tablero

    public static void main(String[] args) {
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.'; // Inicializar el tablero con puntos
            }
        }
        placeItems(board, 0, 0, 0, 0);
    }

    private static void placeItems(char[][] board, int row, int col, int computersPlaced, int printersPlaced) {
        if (computersPlaced == 4 && printersPlaced == 4) {
            printBoard(board);
            return;
        }

        for (int i = row; i < N; i++) {
            for (int j = (i == row ? col : 0); j < N; j++) {
                if (computersPlaced < 4 && isSafe(board, i, j, 'C')) {
                    board[i][j] = 'C'; // Colocar una computadora
                    placeItems(board, i, j + 1, computersPlaced + 1, printersPlaced);
                    board[i][j] = '.'; // Deshacer la colocación
                }
                if (printersPlaced < 4 && isSafe(board, i, j, 'P')) {
                    board[i][j] = 'P'; // Colocar una impresora
                    placeItems(board, i, j + 1, computersPlaced, printersPlaced + 1);
                    board[i][j] = '.'; // Deshacer la colocación
                }
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col, char item) {
        // Verificar fila y columna
        for (int i = 0; i < N; i++) {
            if (board[row][i] == item || board[i][col] == item) {
                return false;
            }
        }
        return true;
    }

    private static void printBoard(char[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

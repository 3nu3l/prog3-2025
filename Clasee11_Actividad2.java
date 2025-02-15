/*
 * Actividad 2

En el diseño de interiores de oficinas o hogares, necesitamos un programa que
imprima las combinaciones posibles de la ubicación de escritorios y sillas, en una
habitación de 4x4. Las restricciones son: garantizar que ningún elemento esté en
la misma "fila" (por ejemplo, en una misma fila de escritorios) o en la misma
"columna" (por ejemplo, alineación en una pared) para optimizar el uso del
espacio y facilitar la circulación.
 */


 public class Clasee11_Actividad2 {

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

    private static void placeItems(char[][] board, int row, int col, int desksPlaced, int chairsPlaced) {
        if (desksPlaced == 2 && chairsPlaced == 2) {
            printBoard(board);
            return;
        }

        for (int i = row; i < N; i++) {
            for (int j = (i == row ? col : 0); j < N; j++) {
                if (desksPlaced < 2 && isSafe(board, i, j)) {
                    board[i][j] = 'D'; // Colocar un escritorio
                    placeItems(board, i, j + 1, desksPlaced + 1, chairsPlaced);
                    board[i][j] = '.'; // Deshacer la colocación
                }
                if (chairsPlaced < 2 && isSafe(board, i, j)) {
                    board[i][j] = 'C'; // Colocar una silla
                    placeItems(board, i, j + 1, desksPlaced, chairsPlaced + 1);
                    board[i][j] = '.'; // Deshacer la colocación
                }
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {
        // Verificar fila y columna
        for (int i = 0; i < N; i++) {
            if (board[row][i] != '.' || board[i][col] != '.') {
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
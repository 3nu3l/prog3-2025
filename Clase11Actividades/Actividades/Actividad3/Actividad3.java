package Actividad3;

public class Actividad3 {

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

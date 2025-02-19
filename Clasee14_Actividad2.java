/*
 * Actividad 2

Modificar un programa de Sudoku para que trabaje con un tablero de 6x6, usando
los números del 1 al 6 y con tres subcuadrantes de 6 números cada uno.
Siguiendo estas instrucciones:
Cambiar el tamaño del tablero de 9x9 a 6x6.
Ajustar las reglas del juego para que en lugar de 9 subcuadrantes de 3x3, ahora
el tablero tenga tres subcuadrantes de 6 números. Es decir, cada subcuadrante
contendrá 6 celdas en total, de 2x3.
Asegurarse de que los números utilizados sean del 1 al 6.
 * 
 */

public class Clasee14_Actividad2 {
    private static final int SIZE = 6;
    private static final int SUBGRID_ROWS = 2;
    private static final int SUBGRID_COLS = 3;
    private static final int EMPTY = 0;

    public static void main(String[] args) {
        int[][] board = {
            {5, 3, EMPTY, EMPTY, 1, 6},
            {EMPTY, EMPTY, 6, 5, EMPTY, EMPTY},
            {EMPTY, 1, EMPTY, EMPTY, 3, EMPTY},
            {EMPTY, 6, EMPTY, EMPTY, 5, EMPTY},
            {EMPTY, EMPTY, 1, 3, EMPTY, EMPTY},
            {6, 5, EMPTY, EMPTY, 2, 4}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) {
                                return true;
                            }
                            board[row][col] = EMPTY;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Verificar fila y columna
        for (int x = 0; x < SIZE; x++) {
            if (board[row][x] == num || board[x][col] == num) {
                return false;
            }
        }

        // Verificar subcuadrante
        int startRow = row - row % SUBGRID_ROWS;
        int startCol = col - col % SUBGRID_COLS;
        for (int i = 0; i < SUBGRID_ROWS; i++) {
            for (int j = 0; j < SUBGRID_COLS; j++) {
                if (board[i + startRow][j + startCol] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        for (int r = 0; r < SIZE; r++) {
            for (int d = 0; d < SIZE; d++) {
                System.out.print(board[r][d] + " ");
            }
            System.out.println();
        }
    }
}
package Actividad2;

public class Actividad2 {
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

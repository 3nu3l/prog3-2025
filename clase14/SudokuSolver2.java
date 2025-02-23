package clase14;

public class SudokuSolver2 {

    private static final int N = 6; // Tamaño del tablero
    private static final int SUBGRID_ROWS = 2; // Filas en cada subcuadrante
    private static final int SUBGRID_COLS = 3; // Columnas en cada subcuadrante

    public static void main(String[] args) {
        int[][] board = {
            {0, 0, 0, 0, 5, 6},
            {0, 0, 0, 0, 0, 0},
            {3, 0, 6, 0, 0, 0},
            {0, 0, 0, 6, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {6, 5, 0, 0, 0, 0}
        };

        if (solve(board)) {
            printBoard(board);
        } else {
            System.out.println("No hay solución posible.");
        }
    }

    // Método de backtracking para resolver el Sudoku
    public static boolean solve(int[][] board) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (board[row][col] == 0) { // Buscar una celda vacía
                    for (int num = 1; num <= N; num++) {
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num; // Colocar número

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = 0; // Backtracking
                        }
                    }
                    return false; // No hay número válido para esta celda
                }
            }
        }
        return true; // Solución encontrada
    }

    // Verifica si un número puede colocarse en una celda sin violar reglas del Sudoku
    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Verificar la fila
        for (int i = 0; i < N; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Verificar la columna
        for (int i = 0; i < N; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Verificar el subcuadrante 2x3
        int startRow = (row / SUBGRID_ROWS) * SUBGRID_ROWS;
        int startCol = (col / SUBGRID_COLS) * SUBGRID_COLS;
        for (int i = 0; i < SUBGRID_ROWS; i++) {
            for (int j = 0; j < SUBGRID_COLS; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true; // Número válido
    }

    // Método para imprimir el tablero
    public static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

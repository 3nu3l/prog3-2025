import java.util.ArrayList;
import java.util.List;

public class TwoQueensBacktracking {
    private static final int N = 4; // Tamaño del tablero 4x4

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        List<int[][]> solutions = new ArrayList<>();
        placeQueens(board, 0, 0, 0, solutions);

        System.out.println("Total de soluciones encontradas: " + solutions.size());
        for (int[][] sol : solutions) {
            printBoard(sol);
            System.out.println();
        }
    }

    private static void placeQueens(int[][] board, int row, int col, int queensPlaced, List<int[][]> solutions) {
        if (queensPlaced == 2) {
            saveSolution(board, solutions);
            return;
        }

        for (int i = row; i < N; i++) {
            for (int j = (i == row ? col : 0); j < N; j++) {
                if (isSafe(board, i, j)) {
                    board[i][j] = 1;
                    placeQueens(board, i, j + 1, queensPlaced + 1, solutions);
                    board[i][j] = 0;
                }
            }
        }
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < N; i++) {
            if (board[row][i] == 1 || board[i][col] == 1)
                return false;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && (Math.abs(i - row) == Math.abs(j - col))) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void saveSolution(int[][] board, List<int[][]> solutions) {
        int[][] solution = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(board[i], 0, solution[i], 0, N);
        }
        solutions.add(solution);
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "Q " : ". ") + " ");
            }
            System.out.println();
        }
    }
}
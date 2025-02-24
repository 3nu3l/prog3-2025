import java.util.ArrayList;
import java.util.List;

public class OfficeArrangement {
    private static final int N = 4;

    public static void main(String[] args) {
        int[][] room = new int[N][N];
        List<int[][]> solutions = new ArrayList<>();
        placeFurniture(room, 0, solutions);

        System.out.println("Total de configuraciones válidas: " + solutions.size());
        for (int[][] sol : solutions) {
            printRoom(sol);
            System.out.println();
        }
    }

    private static void placeFurniture(int[][] room, int row, List<int[][]> solutions) {
        if (row == N) {
            saveSolution(room, solutions);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(room, row, col)) {
                room[row][col] = 1;
                placeFurniture(room, row + 1, solutions);
                room[row][col] = 0;
            }
        }
    }

    private static boolean isSafe(int[][] room, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (room[i][col] == 1) return false;
        }
        return true;
    }

    private static void saveSolution(int[][] room, List<int[][]> solutions) {
        int[][] solution = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(room[i], 0, solution[i], 0, N);
        }
        solutions.add(solution);
    }

    private static void printRoom(int[][] room) {
        for (int[] row : room) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "E " : ". ") + " ");
            }
            System.out.println();
        }
    }
}
import java.util.ArrayList;
import java.util.List;

public class OfficeEquipmentArrangement {
    private static final int N = 4;
    private static final char EMPTY = '.';
    private static final char COMPUTER = 'C';
    private static final char PRINTER = 'P';

    public static void main(String[] args) {
        char[][] office = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                office[i][j] = EMPTY;
            }
        }
        List<char[][]> solutions = new ArrayList<>();
        placeComputers(office, 0, solutions);
        System.out.println("Total de configuraciones válidas: " + solutions.size());
        for (char[][] sol : solutions) {
            printOffice(sol);
            System.out.println();
        }
    }

    private static void placeComputers(char[][] office, int row, List<char[][]> solutions) {
        if (row == N) {
            placePrinters(office, 0, solutions);
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(office, row, col)) {
                office[row][col] = COMPUTER;
                placeComputers(office, row + 1, solutions);
                office[row][col] = EMPTY;
            }
        }
    }

    private static void placePrinters(char[][] office, int row, List<char[][]> solutions) {
        if (row == N) {
            saveSolution(office, solutions);
            return;
        }
        for (int col = 0; col < N; col++) {
            if (isSafe(office, row, col)) {
                office[row][col] = PRINTER;
                placePrinters(office, row + 1, solutions);
                office[row][col] = EMPTY;
            }
        }
    }

    private static boolean isSafe(char[][] office, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (office[i][col] != EMPTY) return false;
        }
        return true;
    }

    private static void saveSolution(char[][] office, List<char[][]> solutions) {
        char[][] solution = new char[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(office[i], 0, solution[i], 0, N);
        }
        solutions.add(solution);
    }

    private static void printOffice(char[][] office) {
        for (char[] row : office) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
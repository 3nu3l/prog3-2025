package clase11.ejercicios;
import java.util.ArrayList;
import java.util.List;

public class Actividad1 {
    static final int N = 4; // Tamaño del tablero

    public static void main(String[] args) {
        char[][] tablero = new char[N][N];

        // Inicializamos el tablero vacío
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = '.';
            }
        }

        // Lista para almacenar soluciones válidas
        List<String[]> soluciones = new ArrayList<>();

        // Ejecutamos el backtracking
        colocarReinas(tablero, 0, 0, 0, soluciones);

        // Imprimimos las soluciones encontradas
        System.out.println("Número total de soluciones: " + soluciones.size());
        for (String[] solucion : soluciones) {
            imprimirTablero(solucion);
        }
    }

    public static void colocarReinas(char[][] tablero, int fila, int col, int reinasColocadas, List<String[]> soluciones) {
        if (reinasColocadas == 2) { // Si colocamos dos reinas, guardamos la solución
            soluciones.add(clonarTablero(tablero));
            return;
        }

        // Recorremos todas las posiciones del tablero
        for (int i = fila; i < N; i++) {
            for (int j = (i == fila) ? col : 0; j < N; j++) {
                if (esPosicionValida(tablero, i, j)) {
                    // Colocamos la reina
                    tablero[i][j] = 'Q';
                    colocarReinas(tablero, i, j + 1, reinasColocadas + 1, soluciones);
                    // Backtracking: retiramos la reina
                    tablero[i][j] = '.';
                }
            }
        }
    }

    public static boolean esPosicionValida(char[][] tablero, int fila, int col) {
        // Verificamos la columna
        for (int i = 0; i < fila; i++) {
            if (tablero[i][col] == 'Q') return false;
        }

        // Verificamos la diagonal principal (↘ y ↖)
        for (int i = fila - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 'Q') return false;
        }
        for (int i = fila - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (tablero[i][j] == 'Q') return false;
        }

        return true;
    }

    public static String[] clonarTablero(char[][] tablero) {
        String[] copia = new String[N];
        for (int i = 0; i < N; i++) {
            copia[i] = new String(tablero[i]);
        }
        return copia;
    }

    public static void imprimirTablero(String[] tablero) {
        for (String fila : tablero) {
            System.out.println(fila);
        }
        System.out.println();
    }
}

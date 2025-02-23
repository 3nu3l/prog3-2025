package clase11.ejercicios;
import java.util.ArrayList;
import java.util.List;

public class Actividad2 {
    static final int N = 4; // Tamaño del tablero
    static char[][] tablero = new char[N][N]; // Tablero de 4x4
    static List<String[]> soluciones = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializamos el tablero vacío
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tablero[i][j] = '.';
            }
        }

        // Ejecutamos el Backtracking para escritorios
        colocarEscritorios(0);

        // Imprimimos todas las soluciones
        System.out.println("Número total de soluciones: " + soluciones.size());
        for (String[] solucion : soluciones) {
            imprimirTablero(solucion);
        }
    }

    public static void colocarEscritorios(int fila) {
        if (fila == N) {
            // Cuando todos los escritorios están colocados, colocamos sillas
            colocarSillas(0);
            return;
        }

        // Intentamos colocar un escritorio en cada columna de la fila actual
        for (int col = 0; col < N; col++) {
            if (esPosicionValida(tablero, fila, col)) {
                tablero[fila][col] = 'E'; // Colocamos un escritorio
                colocarEscritorios(fila + 1);
                tablero[fila][col] = '.'; // Backtracking
            }
        }
    }

    public static void colocarSillas(int fila) {
        if (fila == N) {
            // Si colocamos todas las sillas, almacenamos la configuración
            soluciones.add(clonarTablero(tablero));
            return;
        }

        // Intentamos colocar una silla en cada columna de la fila actual
        for (int col = 0; col < N; col++) {
            if (tablero[fila][col] == '.' && esPosicionValida(tablero, fila, col)) {
                tablero[fila][col] = 'S'; // Colocamos una silla
                colocarSillas(fila + 1);
                tablero[fila][col] = '.'; // Backtracking
            }
        }
    }

    public static boolean esPosicionValida(char[][] tablero, int fila, int col) {
        // Verificamos la columna para evitar conflictos
        for (int i = 0; i < fila; i++) {
            if (tablero[i][col] == 'E' || tablero[i][col] == 'S') {
                return false;
            }
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

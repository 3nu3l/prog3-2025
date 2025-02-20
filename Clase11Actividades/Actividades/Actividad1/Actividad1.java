package Actividad1;
import java.util.ArrayList;
import java.util.List;

public class Actividad1 {
    private static boolean esValido(int[] tablero, int fila, int columna) {
        for (int i = 0; i < fila; i++) {
            if (tablero[i] == columna || Math.abs(tablero[i] - columna) == Math.abs(i - fila)) {
                return false;
            }
        }
        return true;
    }

    private static void colocarReinas(int[] tablero, int fila, int reinasColocadas, List<int[]> soluciones) {
        if (reinasColocadas == 2) {
            soluciones.add(tablero.clone());
            return;
        }

        if (fila >= 4) {
            return;
        }

        for (int columna = 0; columna < 4; columna++) {
            if (esValido(tablero, fila, columna)) {
                tablero[fila] = columna;
                colocarReinas(tablero, fila + 1, reinasColocadas + 1, soluciones);
                tablero[fila] = -1; // Backtracking
            }
        }
        
        colocarReinas(tablero, fila + 1, reinasColocadas, soluciones);
    }

    private static void imprimirSoluciones(List<int[]> soluciones) {
        for (int[] solucion : soluciones) {
            char[][] tableroVisual = new char[4][4];
            for (char[] fila : tableroVisual) {
                java.util.Arrays.fill(fila, '.');
            }
            for (int i = 0; i < 4; i++) {
                if (solucion[i] != -1) {
                    tableroVisual[i][solucion[i]] = 'Q';
                }
            }
            for (char[] fila : tableroVisual) {
                System.out.println(new String(fila));
            }
            System.out.println();
        }
    }

    public static void encontrarSoluciones() {
        List<int[]> soluciones = new ArrayList<>();
        int[] tablero = new int[4];
        java.util.Arrays.fill(tablero, -1);
        colocarReinas(tablero, 0, 0, soluciones);
        imprimirSoluciones(soluciones);
    }

    public static void main(String[] args) {
        encontrarSoluciones();
    }
}
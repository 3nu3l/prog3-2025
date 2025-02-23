package clase11.ejercicios;
import java.util.*;

public class Actividad3 {
    private static final int N = 4; // Tamaño del tablero (4x4)
    private static int[] computadoras = new int[N]; // Posiciones de computadoras
    private static int[] impresoras = new int[N]; // Posiciones de impresoras
    private static boolean[] columnasComputadoras = new boolean[N];
    private static boolean[] columnasImpresoras = new boolean[N];
    
    public static void main(String[] args) {
        colocarComputadoras(0);
    }
    
    private static void colocarComputadoras(int fila) {
        if (fila == N) {
            colocarImpresoras(0);
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (!columnasComputadoras[col]) {
                computadoras[fila] = col;
                columnasComputadoras[col] = true;
                colocarComputadoras(fila + 1);
                columnasComputadoras[col] = false;
            }
        }
    }
    
    private static void colocarImpresoras(int fila) {
        if (fila == N) {
            imprimirDistribucion();
            return;
        }
        
        for (int col = 0; col < N; col++) {
            if (!columnasImpresoras[col]) {
                impresoras[fila] = col;
                columnasImpresoras[col] = true;
                colocarImpresoras(fila + 1);
                columnasImpresoras[col] = false;
            }
        }
    }
    
    private static void imprimirDistribucion() {
        char[][] oficina = new char[N][N];
        for (char[] fila : oficina) Arrays.fill(fila, '.');
        
        for (int i = 0; i < N; i++) {
            oficina[i][computadoras[i]] = 'C';
            oficina[i][impresoras[i]] = 'I';
        }
        
        for (char[] fila : oficina) {
            System.out.println(Arrays.toString(fila));
        }
        System.out.println();
    }
}

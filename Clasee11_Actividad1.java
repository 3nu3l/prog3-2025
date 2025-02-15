/*Actividad 1

Posicionamiento de dos reinas en un tablero de 4x4 usando Backtracking
Descripción del Problema: Dado un tablero de ajedrez de tamaño 4x4, debes
encontrar todas las posibles posiciones donde se pueden colocar dos reinas de
tal manera que no se ataquen entre sí. El objetivo es imprimir todas las
configuraciones válidas del tablero. Las dos reinas no deben compartir la misma
fila, columna ni estar en la misma diagonal.
Para resolver este problema, deberás usar la técnica de Backtracking para
explorar las posibles posiciones de las reinas de manera eficiente. El backtracking
te permitirá descartar las configuraciones inválidas a medida que avances en la
construcción de las soluciones.

Análisis Matemático del Problema

Número total de formas de colocar dos reinas en el tablero (sin restricciones):
Un tablero de 4x4 tiene 16 casillas en total.
El número total de formas de seleccionar dos casillas para colocar dos reinas es
una combinación de 16 casillas tomadas de 2 en 2:
C(16,2)= (16×15)/2 =120
Esto significa que hay 120 formas de colocar dos reinas en un tablero de 4x4 si
no imponemos restricciones de ataque.
Eliminar configuraciones en las que las reinas se atacan: Las reinas pueden
atacarse si están en:
La misma fila. La misma columna. La misma diagonal (diagonal principal o
diagonal secundaria).

Análisis Matemático del Problema

Ahora contamos cuántas configuraciones de ataque existen para restarlas del total.
Misma fila: En cada fila hay 4 casillas, y se pueden elegir 2 de esas casillas para colocar dos reinas que
se ataquen en la fila: C(4,2)= (4×3)/2 =6 formas por fila.
Como hay 4 filas, esto da un total de: 6×4=24 configuraciones de ataque en la misma fila.
Misma columna: Similar al caso de las filas, hay 4 columnas, y en cada columna también hay 6 formas de
colocar dos reinas que se ataquen en la misma columna. Esto nos da:
6×4=24 configuraciones de ataque en la misma columna.
Diagonales: Para la diagonal principal (de izquierda a derecha), tenemos las siguientes posibilidades:
Diagonal de longitud 2: Hay 2 formas de colocar dos reinas en diagonales de longitud 2 (hay dos de estas
diagonales en cada dirección).
Diagonal de longitud 3: Hay 3 formas de colocar dos reinas en diagonales de longitud 3 (dos diagonales
de longitud 3).
Diagonal de longitud 4: Solo hay 1 forma de colocar dos reinas en una diagonal de longitud 4.
En total para la diagonal principal: 2+2+3+3+1=11 configuraciones de ataque.
Para la diagonal secundaria (de derecha a izquierda), tenemos las mismas configuraciones:
2+2+3+3+1=11 configuraciones de ataque.

Análisis Matemático del Problema

El número total de configuraciones en las que las reinas se atacan es:
24 (fila)+24 (columna)+11 (diagonal principal)+11 (diagonal secundaria)=70
Número de configuraciones válidas: Ahora, restamos las configuraciones inválidas (en las que
las reinas se atacan) del total de configuraciones posibles:
120−70=50
Esto significa que hay 50 configuraciones válidas donde dos reinas pueden colocarse en un
tablero de 4x4 sin atacarse entre sí.
Conclusión:
Hay 50 configuraciones posibles para colocar dos reinas en un tablero de 4x4 de manera que no
se ataquen. Este cálculo matemático te permite comprobar el resultado que obtienes con la
implementación en Java, asegurando que imprimes exactamente 50 configuraciones distintas. */


public class Clasee11_Actividad1 {

    private static final int N = 4; // Tamaño del tablero

    public static void main(String[] args) {
        boolean[][] board = new boolean[N][N];
        placeQueens(board, 0, 0, 0);
    }

    private static void placeQueens(boolean[][] board, int row, int col, int queensPlaced) {
        if (queensPlaced == 2) {
            printBoard(board);
            return;
        }

        for (int i = row; i < N; i++) {
            for (int j = (i == row ? col : 0); j < N; j++) {
                if (isSafe(board, i, j)) {
                    board[i][j] = true;
                    placeQueens(board, i, j + 1, queensPlaced + 1);
                    board[i][j] = false;
                }
            }
        }
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        // Verificar fila y columna
        for (int i = 0; i < N; i++) {
            if (board[row][i] || board[i][col]) {
                return false;
            }
        }

        // Verificar diagonales
        for (int i = -N; i < N; i++) {
            if (row + i >= 0 && row + i < N && col + i >= 0 && col + i < N && board[row + i][col + i]) {
                return false;
            }
            if (row + i >= 0 && row + i < N && col - i >= 0 && col - i < N && board[row + i][col - i]) {
                return false;
            }
        }

        return true;
    }

    private static void printBoard(boolean[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

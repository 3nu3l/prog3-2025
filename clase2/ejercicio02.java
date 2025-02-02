/* import java.util.*;
import java.lang.*;
import java.io.*; */

class Main {
    public static void main(String[] args) {
        int[][] matriz1 = { { 1, 2 }, { 3, 4 } };
        int[][] matriz2 = { { 5, 6 }, { 7, 8 } };
        int[][] resultado = new int[2][2];

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz2.length; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }

        System.out.println("Resultado:");
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j] + " ");
            }
            System.out.println();
        }
    }
}
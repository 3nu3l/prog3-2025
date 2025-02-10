/*
 * Actividad 2

Dada una mochila con una capacidad máxima de
peso P, y dispones de n objetos. Cada objeto
tiene un peso w y un valor v
El objetivo es seleccionar algunos objetos de
manera que maximicen el valor total, sin superar
la capacidad de la mochila, que es de 10
Se pide realizar una prueba de escritorio para
fuerza bruta y para programación dinámica (el
valor máximo se encuentra en la celda dp[n][B],
donde B es la capacidad máxima de la mochila)

Objeto Peso Valor
1 2 4
2 5 2
3 6 1
4 7 6


Progra dinamica
***************
 * 
 * 
 * 
 */

 public class Clase7_Actividad2_B {
    public static void main(String[] args) {
        int[] pesos = {2, 5, 6, 7};
        int[] valores = {4, 2, 1, 6};
        int capacidad = 10;
        int n = pesos.length;

        int[][] dp = new int[n + 1][capacidad + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacidad; j++) {
                if (pesos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - pesos[i - 1]] + valores[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println("Valor máximo: " + dp[n][capacidad]);
    }
}
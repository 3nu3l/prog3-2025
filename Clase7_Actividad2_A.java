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


Fuerza bruta
*************
 * 
 * 
 * 
 */



 public class Clase7_Actividad2_A {
    static int maxValor = 0;

    public static void main(String[] args) {
        int[] pesos = {2, 5, 6, 7};
        int[] valores = {4, 2, 1, 6};
        int capacidad = 10;

        fuerzaBruta(pesos, valores, capacidad, 0, 0, 0);
        System.out.println("Valor máximo: " + maxValor);
    }

    public static void fuerzaBruta(int[] pesos, int[] valores, int capacidad, int indice, int pesoActual, int valorActual) {
        if (pesoActual <= capacidad) {
            maxValor = Math.max(maxValor, valorActual);
        }
        if (indice == pesos.length) {
            return;
        }
        // No tomar el objeto actual
        fuerzaBruta(pesos, valores, capacidad, indice + 1, pesoActual, valorActual);
        // Tomar el objeto actual
        fuerzaBruta(pesos, valores, capacidad, indice + 1, pesoActual + pesos[indice], valorActual + valores[indice]);
    }
}

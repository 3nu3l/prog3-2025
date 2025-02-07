package Ejercicio4;

public class FactorialLong {

    public static long factorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        long resultado = 1;
        for (long i = 2; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int numero = 20; 
        System.out.println("Factorial de " + numero + " con long: " + factorial(numero));
    }
}

package Ejercicio4;

import java.math.BigInteger;

public class FactorialBigInteger {

    public static BigInteger factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El factorial no está definido para números negativos.");
        }
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }

    public static void main(String[] args) {
        int numero = 50; 
        System.out.println("Factorial de " + numero + " con BigInteger: " + factorial(numero));
    }
}
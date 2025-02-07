import java.math.BigInteger;

public class Ejercicio4Factorial {

    
    public static long factorialLong(int n) {
        if (n < 0) throw new IllegalArgumentException("El número debe ser positivo");
        long resultado = 1;
        for (int i = 2; i <= n; i++) {
            resultado *= i;
            if (resultado < 0) throw new ArithmeticException("Overflow! Usa BigInteger.");
        }
        return resultado;
    }

    
    public static BigInteger factorialBigInteger(int n) {
        if (n < 0) throw new IllegalArgumentException("El número debe ser positivo");
        BigInteger resultado = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }

    public static void main(String[] args) {
        int number = 10; 
        
        
        try {
            long resultLong = factorialLong(number);
            System.out.println("Factorial de " + number + " con long: " + resultLong);
        } catch (ArithmeticException e) {
            System.out.println("Error con long: " + e.getMessage());
        }

        
        BigInteger resultBigInteger = factorialBigInteger(number);
        System.out.println("Factorial de " + number + " con BigInteger: " + resultBigInteger);
    }
}

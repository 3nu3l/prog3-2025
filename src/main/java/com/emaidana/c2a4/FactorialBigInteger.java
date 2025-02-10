import java.math.BigInteger;

public class FactorialBigInteger {
    public static void main(String[] args) {
        int n = 100; // Cambia este valor según sea necesario
        System.out.println("Factorial de " + n + " usando BigInteger: " + calcularFactorialBigInteger(n));
    }

    public static BigInteger calcularFactorialBigInteger(int n) {
        BigInteger resultado = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            resultado = resultado.multiply(BigInteger.valueOf(i));
        }
        return resultado;
    }
}
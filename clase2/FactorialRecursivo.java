import java.math.BigInteger;

public class FactorialRecursivo {
    public static void main(String[] args) {
        int numero = 10000;
        System.out.println("El factorial de " + numero + " es: " + factorial(BigInteger.valueOf(numero)));
    }

    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }
        return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }
}
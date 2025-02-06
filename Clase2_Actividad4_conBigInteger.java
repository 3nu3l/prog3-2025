public class Clase2_Actividad4_conBigInteger {

    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 20;
        System.out.println("Factorial de " + number + " es: " + factorial(number));
    }
}

/*Ambas implementaciones tienen una complejidad temporal de 𝑂(𝑛) ya que iteran desde 1 hasta 𝑛 para calcular el factorial.
La implementación con long tiene una limitación en el tamaño máximo del número que puede manejar, debido a que long puede almacenar hasta 2^63−1. Esto limita su uso práctico a números pequeños.
La implementación con BigInteger no tiene esta limitación y puede manejar números muy grandes, pero requiere más memoria y tiempo de procesamiento debido a las operaciones con enteros arbitrariamente grandes. */
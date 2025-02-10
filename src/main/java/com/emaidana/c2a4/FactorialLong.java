public class FactorialLong {
    public static void main(String[] args) {
        int n = 20; 
        System.out.println("Factorial de " + n + " usando long: " + calcularFactorialLong(n));
    }

    public static long calcularFactorialLong(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}
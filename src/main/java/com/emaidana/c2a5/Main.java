public class Main {
    public static void main(String[] args) {
        int n = 50; 
        System.out.println("La suma de los primeros " + n + " números enteros es: " + suma(n));
    }

    // Método recursivo para calcular la suma
    public static int suma(int n) {
        if (n == 1) { // Caso base
            return 1;
        }
        return n + suma(n - 1); // Llamada recursiva
    }
}
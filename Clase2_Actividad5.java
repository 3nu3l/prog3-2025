public class Clase2_Actividad5 {

    public static int suma(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + suma(n - 1);
        }
    }

    public static void main(String[] args) {
        int n = 10; // Puedes cambiar este valor para probar con otros números
        int resultado = suma(n);
        System.out.println("La suma de los primeros " + n + " números enteros es: " + resultado);
    }
}

import java.util.Scanner;

public class SumaDeNumeros {

    // Lo resolvi como una Factorización del número ingresado. No entendi si el enunciado pedía eso o la suma de n numeros ingresados por teclado.
    public static int suma(int n) {
        if (n <= 1) {
            return n;
        }
        return n + suma(n - 1);
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int n = scanner.nextInt();
        int resultado = suma(n);
        System.out.println("La suma de los primeros " + n + " números es: " + resultado);
        scanner.close();
    }
}
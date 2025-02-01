import java.util.Scanner;

public class Actividad3Clase1_CalculadoraBasica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar dos números al usuario
        System.out.print("Introduce el primer número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double numero2 = scanner.nextDouble();

        // Solicitar una operación matemática
        System.out.print("Introduce la operación (suma, resta, multiplicación, división): ");
        String operacion = scanner.next();

        // Realizar la operación seleccionada y mostrar el resultado
        double resultado = 0;
        boolean operacionValida = true;

        switch (operacion.toLowerCase()) {
            case "suma":
                resultado = numero1 + numero2;
                break;
            case "resta":
                resultado = numero1 - numero2;
                break;
            case "multiplicación":
                resultado = numero1 * numero2;
                break;
            case "división":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    System.out.println("Error: No se puede dividir por cero.");
                    operacionValida = false;
                }
                break;
            default:
                System.out.println("Operación no válida.");
                operacionValida = false;
                break;
        }

        if (operacionValida) {
            System.out.println("El resultado de la " + operacion + " es: " + resultado);
        }

        scanner.close();
    }
}
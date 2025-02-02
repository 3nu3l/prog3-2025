import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una operación: sumar, restar, multiplicar, dividir o salir");
            String operacion = scanner.nextLine();

            if (operacion.equalsIgnoreCase("salir")) {
                System.out.println("Saliendo de la calculadora.");
                break;
            }

            System.out.println("Ingrese el primer número:");
            double num1 = scanner.nextDouble();
            System.out.println("Ingrese el segundo número:");
            double num2 = scanner.nextDouble();
            scanner.nextLine();

            switch (operacion.toLowerCase()) {
                case "sumar":
                    System.out.println("Resultado: " + (num1 + num2));
                    break;
                case "restar":
                    System.out.println("Resultado: " + (num1 - num2));
                    break;
                case "multiplicar":
                    System.out.println("Resultado: " + (num1 * num2));
                    break;
                case "dividir":
                    if (num2 != 0) {
                        System.out.println("Resultado: " + (num1 / num2));
                    } else {
                        System.out.println("Error: División por cero.");
                    }
                    break;
                default:
                    System.out.println("Operación no reconocida.");
                    break;
            }
        }
        scanner.close();
    }
}
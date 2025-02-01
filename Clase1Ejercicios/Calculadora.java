/* Actividad 3 : Calculadora Básica
Enunciado: Escribe un programa que:
Solicite dos números al usuario.
Solicite una operación matemática: suma, resta, multiplicación o división.
Realice la operación seleccionada y muestre el resultado
*/
import java.util.Scanner;

public class Calculadora {
    public static void main (String []args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        double numero1= scanner.nextDouble();

        System.out.print("Introduce el segundo número: ");
        double numero2= scanner.nextDouble();

        System.out.print("Escriba la operación matematica(Suma, resta, multiplicacion, división): ");
        String operacion = scanner.next().toLowerCase();


        switch(operacion){
            case "suma":
                System.out.println("El resultado de la suma es: " + (numero1 + numero2));
                break;
            case "resta":
                System.out.println("El resultado de la resta es: " + (numero1 - numero2));
                break;
            case "multiplicacion":
                System.out.println("El resultado de la multiplicación es: " + (numero1 * numero2));
                break;
            case "division":
                if (numero2 != 0) {
                    System.out.println("El resultado de la división es: " + (numero1 / numero2));
                } else {
                    System.out.println("Error: No se puede dividir por cero.");
                }
                break;
            default:
                System.out.println("Operación no válida. Por favor, introduce suma, resta, multiplicación o división.");
                break;
        }
        scanner.close();
    }
}
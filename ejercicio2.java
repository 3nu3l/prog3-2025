import java.util.Scanner;

public class ejercicio2{
    public static void main(String[] args) {
            int numero = 38;
            double numDec = 178.5;
            char inicial = 'A';
            String ciudad = "Berazategui";

            mostrarDatos(numero,numDec,inicial,ciudad);
            sumaEdad(numero);
            alturaPorDos(numDec);
            System.out.println("Tu inicial es: " + inicial);
    
        }
        public static void mostrarDatos(int numero, double numDec,char inicial,String ciudad) {    
            System.out.println("El número entero es: " + numero);
            System.out.println("El número decimal es: " + numDec);
            System.out.println("La inicial es: " + inicial);
            System.out.println("La ciudad es: " + ciudad);
        }

        public static void sumaEdad(int edad) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Ingrese la edad a sumar: ");
                int edad2 = scanner.nextInt();
                int suma = edad + edad2;
                System.out.println("La suma de las edades es: " + suma);
            }
        }

        public static void alturaPorDos(double altura) {
            double alturaDoble = altura * 2;
            System.out.println("La altura por dos es: " + alturaDoble);
        }
}
import java.util.Arrays;
import java.util.Scanner;

public class Actividad4 {
    public static void main(String[] args) {
        int[] arr = leerArrayDesdeTeclado(10);
        //int[] arr = {10, 3, 5, 7, 20, 50, 1, 30, 15, 40};
        int n = 3; // Número de elementos más grandes a encontrar
        int[] resultado = encontrarNMasGrandes(arr, n);
        System.out.println("Los " + n + " elementos más grandes son: " + Arrays.toString(resultado));
    }

    public static int[] encontrarNMasGrandes(int[] arr, int n) {
        if (arr.length <= n) {
            return ordenarDescendente(arr);
        }
        int mitad = arr.length / 2;
        int[] izquierda = Arrays.copyOfRange(arr, 0, mitad);
        int[] derecha = Arrays.copyOfRange(arr, mitad, arr.length);
        int[] maxIzquierda = encontrarNMasGrandes(izquierda, n);
        int[] maxDerecha = encontrarNMasGrandes(derecha, n);
        int[] combinado = fusionar(maxIzquierda, maxDerecha);
        return Arrays.copyOf(combinado, n);
    }

    private static int[] fusionar(int[] arr1, int[] arr2) {
        int[] resultado = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, resultado, 0, arr1.length);
        System.arraycopy(arr2, 0, resultado, arr1.length, arr2.length);
        return ordenarDescendente(resultado);
    }

    private static int[] ordenarDescendente(int[] arr) {
        Arrays.sort(arr);
        int[] ordenado = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ordenado[i] = arr[arr.length - 1 - i]; // Invertir el array
        }
        return ordenado;
    }

    public static int[] leerArrayDesdeTeclado(int tamano) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[tamano];
        System.out.println("Introduce " + tamano + " números:");
        for (int i = 0; i < tamano; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }
}

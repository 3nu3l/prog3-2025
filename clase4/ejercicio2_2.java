import java.util.Random;

public class ejercicio2_2 {
    public static int[] encontrarMaximos(int[] arr, int izquierda, int derecha) {
        if (izquierda == derecha) {
            return new int[]{arr[izquierda], Integer.MIN_VALUE};
        }
        if (derecha - izquierda == 1) {
            int max1 = Math.max(arr[izquierda], arr[derecha]);
            int max2 = Math.min(arr[izquierda], arr[derecha]);
            return new int[]{max1, max2};
        }
        int medio = izquierda + (derecha - izquierda) / 2;
        int[] maxIzquierda = encontrarMaximos(arr, izquierda, medio);
        int[] maxDerecha = encontrarMaximos(arr, medio + 1, derecha);
        return fusionarMaximos(maxIzquierda, maxDerecha);
    }

    private static int[] fusionarMaximos(int[] maxIzq, int[] maxDer) {
        int[] resultado = new int[2];
        resultado[0] = Math.max(maxIzq[0], maxDer[0]);
        if (resultado[0] == maxIzq[0]) {
            resultado[1] = Math.max(maxIzq[1], maxDer[0]);
        } else {
            resultado[1] = Math.max(maxIzq[0], maxDer[1]);
        }
        return resultado;
    }

    public static void imprimirArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //int[] numeros = {12, 5, 9, 21, 7, 14, 33, 19};

        int[] numeros = new int[10];
        //int max1,max2;
        Random rand = new Random();
        
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(100); // Lleno el arrya al azar de 0 a 99, lo hice así para que cambie cada vez que se ejecute
        }

        System.out.println("Array original:");
        imprimirArray(numeros);

        int[] maximos = encontrarMaximos(numeros, 0, numeros.length - 1);
        System.out.println("El número máximo es: " + maximos[0]);
        System.out.println("El segundo número máximo es: " + maximos[1]);
    }
}

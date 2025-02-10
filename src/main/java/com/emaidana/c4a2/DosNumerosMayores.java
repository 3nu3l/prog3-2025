import java.util.Arrays;

public class DosNumerosMayores {

    public static int[] encontrarDosMayores(int[] lista, int inicio, int fin) {
        // Caso base: Si solo hay un elemento
        if (inicio == fin) {
            return new int[]{lista[inicio], Integer.MIN_VALUE}; // No hay segundo mayor
        }

        // Divide: Encuentra el punto medio
        int medio = (inicio + fin) / 2;

        // Llama recursivamente para encontrar los dos mayores en cada mitad
        int[] mayoresIzq = encontrarDosMayores(lista, inicio, medio);
        int[] mayoresDer = encontrarDosMayores(lista, medio + 1, fin);

        // Combina: Determina los dos mayores
        int mayor, segundoMayor;
        if (mayoresIzq[0] > mayoresDer[0]) {
            mayor = mayoresIzq[0];
            segundoMayor = Math.max(mayoresIzq[1], mayoresDer[0]);
        } else {
            mayor = mayoresDer[0];
            segundoMayor = Math.max(mayoresDer[1], mayoresIzq[0]);
        }

        return new int[]{mayor, segundoMayor};
    }

    public static void main(String[] args) {
        int[] lista = {12, 34, 56, 78, 90, 11, 45, 67};

        // Encuentra los dos mayores
        int[] resultado = encontrarDosMayores(lista, 0, lista.length - 1);

        System.out.println("Dos números mayores: " + Arrays.toString(resultado));
    }
}
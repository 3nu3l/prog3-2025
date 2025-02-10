public class BusquedaBinaria {
    // Método principal para realizar la búsqueda binaria recursiva
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        return busquedaBinariaRecursiva(arreglo, objetivo, 0, arreglo.length - 1);
    }

    // Método recursivo
    private static int busquedaBinariaRecursiva(int[] arreglo, int objetivo, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return -1; // Caso base: el elemento no está en el arreglo
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        if (arreglo[medio] == objetivo) {
            return medio; // Elemento encontrado
        }

        if (arreglo[medio] > objetivo) {
            return busquedaBinariaRecursiva(arreglo, objetivo, izquierda, medio - 1); // Buscar en la mitad izquierda
        }

        return busquedaBinariaRecursiva(arreglo, objetivo, medio + 1, derecha); // Buscar en la mitad derecha
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 7, 9, 11, 13};
        int objetivo = 7;

        // Ejemplo con búsqueda recursiva
        int resultado = busquedaBinaria(arreglo, objetivo);
        System.out.println("Índice del objetivo (Recursiva): " + resultado);

        // Ejemplo con búsqueda iterativa
        int resultadoIterativo = busquedaBinariaIterativa(arreglo, objetivo);
        System.out.println("Índice del objetivo (Iterativa): " + resultadoIterativo);
    }

    // Método iterativo para búsqueda binaria
    public static int busquedaBinariaIterativa(int[] arreglo, int objetivo) {
        int izquierda = 0;
        int derecha = arreglo.length - 1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (arreglo[medio] == objetivo) {
                return medio; // Elemento encontrado
            }

            if (arreglo[medio] < objetivo) {
                izquierda = medio + 1; // Ignorar la mitad izquierda
            } else {
                derecha = medio - 1; // Ignorar la mitad derecha
            }
        }

        return -1; // Elemento no encontrado
    }
}
package Actividad2;

public class BusquedaBinariaActividad2 {
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        return busquedaBinariaRecursiva(arreglo, objetivo, 0, arreglo.length - 1);
    }

    private static int busquedaBinariaRecursiva(int[] arreglo, int objetivo, int izquierda, int derecha) {
        
        if (izquierda > derecha) {
            return -1;
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        
        if (arreglo[medio] == objetivo) {
            return medio;
        }

        
        if (arreglo[medio] > objetivo) {
            return busquedaBinariaRecursiva(arreglo, objetivo, izquierda, medio - 1);
        }

        
        return busquedaBinariaRecursiva(arreglo, objetivo, medio + 1, derecha);
    }

    public static void main(String[] args) {
        int[] arreglo = {1, 3, 5, 7, 9, 11, 13};
        int objetivo = 7;
        int resultado = busquedaBinaria(arreglo, objetivo);
        System.out.println("Índice del objetivo: " + resultado);
    }
}

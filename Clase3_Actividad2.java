public class Clase3_Actividad2 {

    // Método para buscar un valor en un array ordenado
    public static int search(int[] arr, int x) {
        return search(arr, 0, arr.length - 1, x);
    }

    // Método de búsqueda binaria recursiva
    private static int search(int[] arr, int left, int right, int x) {
        // Caso base: si el índice izquierdo es mayor que el derecho, el valor no se encuentra en el array
        if (left > right) {
            return -1;
        }

        // Encontrar el punto medio del array
        int mid = left + (right - left) / 2;

        // Si el valor medio es el que estamos buscando, devolver el índice
        if (arr[mid] == x) {
            return mid;
        }

        // Si el valor a buscar es menor que el valor medio, buscar en la mitad izquierda
        if (x < arr[mid]) {
            return search(arr, left, mid - 1, x);
        }

        // Si el valor a buscar es mayor que el valor medio, buscar en la mitad derecha
        return search(arr, mid + 1, right, x);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21};
        int x = 7;

        // Buscar el elemento en el array
        int result = search(arr, x);
        if (result != -1) {
            System.out.println("El elemento " + x + " se encuentra en el índice " + result);
        } else {
            System.out.println("El elemento " + x + " no se encuentra en el array");
        }
    }
}

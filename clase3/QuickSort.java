package clase3;

public class QuickSort {

    // Método para realizar el ordenamiento QuickSort
    public static void quickSort(int[] arreglo, int bajo, int alto) {
        if (bajo < alto) {
            // Encuentra el índice de partición
            int indiceParticion = particion(arreglo, bajo, alto);

            // Ordena los elementos antes y después de la partición
            quickSort(arreglo, bajo, indiceParticion - 1);
            quickSort(arreglo, indiceParticion + 1, alto);
        }
    }

    // Método para particionar el arreglo
    private static int particion(int[] arreglo, int bajo, int alto) {
        int pivote = arreglo[alto]; // Se elige el último elemento como pivote
        int i = (bajo - 1); // Índice del elemento más pequeño

        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arreglo[j] <= pivote) {
                i++;
                // Intercambia arreglo[i] y arreglo[j]
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        // Intercambia el pivote con el elemento en la posición i+1
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[alto];
        arreglo[alto] = temp;

        return i + 1; // Retorna el índice de la partición
    }

    /* ## Agrego un MAIN para probar el algoritmo QuickSort ## */
    public static void main(String[] args) {
        int[] arreglo = {10, 7, 8, 9, 1, 5};
        System.out.println("Antes de ordenar:");
        for (int a : arreglo) {
            System.out.print(a + " ");
        }
        quickSort(arreglo, 0, arreglo.length - 1);
        System.out.println("");
        System.out.println("Después de ordenar:");
        for (int a : arreglo) {
            System.out.print(a + " ");
        }
    }

}

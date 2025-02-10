import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NMaximos {

    public static List<Integer> encontrarNMaximos(List<Integer> lista, int inicio, int fin, int n) {
        // Caso base: Si solo hay un elemento
        if (inicio == fin) {
            List<Integer> resultado = new ArrayList<>();
            resultado.add(lista.get(inicio));
            return resultado;
        }

        // Divide: Encuentra el punto medio
        int medio = (inicio + fin) / 2;

        // Vence: Encuentra los n máximos en ambas mitades
        List<Integer> maximosIzquierda = encontrarNMaximos(lista, inicio, medio, n);
        List<Integer> maximosDerecha = encontrarNMaximos(lista, medio + 1, fin, n);

        // Combina: Une las dos listas y ordena
        List<Integer> combinados = new ArrayList<>();
        combinados.addAll(maximosIzquierda);
        combinados.addAll(maximosDerecha);

        // Ordena en orden descendente
        Collections.sort(combinados, Collections.reverseOrder());

        // Retorna los primeros n elementos
        return combinados.subList(0, Math.min(n, combinados.size()));
    }

    public static void main(String[] args) {
        List<Integer> lista = List.of(12, 34, 56, 78, 90, 11, 45, 67);
        int n = 3;

        List<Integer> resultado = encontrarNMaximos(lista, 0, lista.size() - 1, n);

        System.out.println("Los " + n + " números más grandes son: " + resultado);
    }
}
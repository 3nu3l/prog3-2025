import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CambioGreedy {

    public static List<Integer> obtenerCambio(List<Integer> monedas, int montoObjetivo) throws Exception {
        // Ordenar monedas en orden descendente
        Collections.sort(monedas, Collections.reverseOrder());

        List<Integer> cambio = new ArrayList<>();
        int montoRestante = montoObjetivo;

        for (int moneda : monedas) {
            // Seleccionar monedas mientras sea posible
            while (moneda <= montoRestante) {
                cambio.add(moneda);
                montoRestante -= moneda;
            }
        }

        // Verificar si se logró el cambio exacto
        if (montoRestante == 0) {
            return cambio;
        } else {
            throw new Exception("No es posible dar el cambio exacto");
        }
    }

    public static void main(String[] args) {
        List<Integer> monedas = List.of(10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 5, 10);
        int montoObjetivo = 33;

        try {
            List<Integer> cambio = obtenerCambio(new ArrayList<>(monedas), montoObjetivo);
            System.out.println("Cambio obtenido: " + cambio);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
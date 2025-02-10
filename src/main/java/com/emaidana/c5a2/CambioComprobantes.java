import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CambioComprobantes {

    public static List<Integer> obtenerComprobantesMinimos(List<Integer> comprobantes, int montoObjetivo) throws Exception {
        // Ordenar comprobantes en orden descendente
        Collections.sort(comprobantes, Collections.reverseOrder());

        List<Integer> resultado = new ArrayList<>();
        int montoRestante = montoObjetivo;

        for (int comprobante : comprobantes) {
            // Seleccionar comprobantes mientras sea posible
            while (comprobante <= montoRestante) {
                resultado.add(comprobante);
                montoRestante -= comprobante;
            }
        }

        // Verificar si se logró completar el monto
        if (montoRestante == 0) {
            return resultado;
        } else {
            throw new Exception("No es posible completar el cambio con los comprobantes disponibles.");
        }
    }

    public static void main(String[] args) {
        List<Integer> comprobantes = List.of(50, 20, 10, 5, 1, 100, 200);
        int montoObjetivo = 275;

        try {
            List<Integer> resultado = obtenerComprobantesMinimos(new ArrayList<>(comprobantes), montoObjetivo);
            System.out.println("Comprobantes utilizados: " + resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
package Actividad2;

import java.util.*;

public class CambioMonedaExtranjera {

    public static List<Integer> encontrarComprobantesParaCambio(int monto, List<Integer> comprobantes) {
        // Ordenamos los comprobantes de mayor a menor
        comprobantes.sort(Collections.reverseOrder());

        List<Integer> listaCambio = new ArrayList<>();
        int i = 0;

        while (monto > 0 && i < comprobantes.size()) {
            if (monto >= comprobantes.get(i)) {
                monto -= comprobantes.get(i);
                listaCambio.add(comprobantes.get(i));
            } else {
                i++; // Pasamos al siguiente comprobante menor
            }
        }

        if (monto == 0) {
            return listaCambio;
        } else {
            throw new IllegalArgumentException("No es posible completar el cambio con los comprobantes disponibles.");
        }
    }

    public static void main(String[] args) {
        List<Integer> comprobantesDisponibles = Arrays.asList(100, 50, 20, 10, 5, 1);
        int montoAConvertir = 83;

        try {
            List<Integer> resultado = encontrarComprobantesParaCambio(montoAConvertir, comprobantesDisponibles);
            System.out.println("Comprobantes utilizados: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

package clase5.ejercicios; 
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class CambioInsuficienteException extends Exception {
    public CambioInsuficienteException(String mensaje) {
        super(mensaje);
    }
}
public class Actividad1 {
    public static List<Integer> darCambioGreedy(List<Integer> monedasDisponibles, int monto) throws CambioInsuficienteException {
        monedasDisponibles.sort(Comparator.reverseOrder()); // Ordeno las monedas en orden descendente para que sea mas facil aplicar greedy
        List<Integer> cambio = new ArrayList<>();
        int suma = 0;

        for (int moneda : monedasDisponibles) {
            if (suma + moneda <= monto) {
                cambio.add(moneda);
                suma += moneda;
                if (suma == monto) {
                    return cambio;
                }
            }
        }
        throw new CambioInsuficienteException("No se puede dar el cambio exacto con las monedas disponibles.");
    }

    public static void main(String[] args) {
        List<Integer> monedas = Arrays.asList(10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 5, 10);
        int monto = 325;
        try {
            List<Integer> cambio = darCambioGreedy(monedas, monto);
            System.out.println("Cambio dado: " + cambio);
        } catch (CambioInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }
}

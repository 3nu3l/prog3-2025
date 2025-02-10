
import java.util.ArrayList;
import java.util.Arrays;

public class Actividad1 {

    static ArrayList<Integer> calcularCambio(int monto, int[] monedas) {
        ArrayList<Integer> cambio = new ArrayList<>();
        int[] monedasOrdenadas = Arrays.copyOf(monedas, monedas.length);
        Arrays.sort(monedasOrdenadas); // Ordenamos las monedas de menor a mayor

        int i = monedasOrdenadas.length - 1; // Empezamos desde la moneda de mayor valor
        while (monto > 0 && i >= 0) {
            if (monto >= monedasOrdenadas[i]) {
                monto -= monedasOrdenadas[i];
                cambio.add(monedasOrdenadas[i]);
            } else {
                i--; // Si la moneda actual es demasiado grande, pasamos a la siguiente menor
            }
        }

        return monto == 0 ? cambio : null; // Si no podemos dar cambio exacto, devolvemos null
    }

    public static void main(String[] args) {
        int[] monedasDisponibles = {10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 5, 10};
        int monto = 33;

        ArrayList<Integer> resultado = calcularCambio(monto, monedasDisponibles);

        if (resultado != null) {
            System.out.println("Cambio encontrado: " + resultado);
        } else {
            System.out.println("No es posible dar el cambio exacto.");
        }
    }
}

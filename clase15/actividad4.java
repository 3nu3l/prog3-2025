package clase15;
import java.util.*;

class Nodo {
    int id;
    double monto; // Positivo si cobra, negativo si paga
    double tasaCambio; // Representa el valor de la criptomoneda en el nodo

    public Nodo(int id, double monto, double tasaCambio) {
        this.id = id;
        this.monto = monto;
        this.tasaCambio = tasaCambio;
    }
}

class RedCripto {
    private final Map<Integer, List<Nodo>> red;

    public RedCripto() {
        this.red = new HashMap<>();
    }

    public void agregarNodo(int id) {
        red.putIfAbsent(id, new ArrayList<>());
    }

    public void agregarConexion(int origen, int destino, double monto, double tasaCambio) {
        red.get(origen).add(new Nodo(destino, monto, tasaCambio));
    }

    public List<Integer> encontrarMejorRecorrido(int inicio, double saldoInicial, double tasaCambioInicial) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1] * b[2], a[1] * a[2]));
        Map<Integer, Double> maxSaldo = new HashMap<>();
        List<Integer> recorrido = new ArrayList<>();
        
        pq.offer(new double[]{inicio, saldoInicial, tasaCambioInicial});
        maxSaldo.put(inicio, saldoInicial);

        while (!pq.isEmpty()) {
            double[] actual = pq.poll();
            int nodo = (int) actual[0];
            double saldo = actual[1];
            double tasaCambio = actual[2];
            
            recorrido.add(nodo);

            for (Nodo vecino : red.getOrDefault(nodo, new ArrayList<>())) {
                double nuevoSaldo = saldo + vecino.monto;
                double nuevoValorDolares = nuevoSaldo * vecino.tasaCambio;
                
                if (nuevoSaldo >= 0 && (!maxSaldo.containsKey(vecino.id) || nuevoValorDolares > maxSaldo.get(vecino.id) * vecino.tasaCambio)) {
                    maxSaldo.put(vecino.id, nuevoSaldo);
                    pq.offer(new double[]{vecino.id, nuevoSaldo, vecino.tasaCambio});
                }
            }
        }
        
        return recorrido;
    }
}

public class actividad4 {
    public static void main(String[] args) {
        RedCripto red = new RedCripto();
        
        // Agregamos nodos
        for (int i = 1; i <= 5; i++) {
            red.agregarNodo(i);
        }

        // Agregamos conexiones con montos y tasas de cambio
        red.agregarConexion(1, 2, 1.5, 45000);
        red.agregarConexion(1, 3, -2.0, 46000);
        red.agregarConexion(2, 4, -1.0, 45500);
        red.agregarConexion(2, 5, 2.5, 47000);
        red.agregarConexion(3, 4, 0.5, 44800);
        red.agregarConexion(4, 5, -0.8, 47200);
        
        // Iniciar recorrido con un saldo de 1 BTC y tasa inicial de 45000 USD/BTC
        List<Integer> rutaOptima = red.encontrarMejorRecorrido(1, 1.0, 45000);

        System.out.println("Ruta óptima: " + rutaOptima);
    }
}
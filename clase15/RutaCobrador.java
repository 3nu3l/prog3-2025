package clase15;
import java.util.*;

class Sucursal {
    int id;
    int monto; // positivo si cobra, negativo si paga

    public Sucursal(int id, int monto) {
        this.id = id;
        this.monto = monto;
    }
}

class Grafo {
    private final Map<Integer, List<Sucursal>> sucursales;
    
    public Grafo() {
        this.sucursales = new HashMap<>();
    }

    public void agregarSucursal(int id) {
        sucursales.putIfAbsent(id, new ArrayList<>());
    }

    public void agregarCamino(int origen, int destino, int monto) {
        sucursales.get(origen).add(new Sucursal(destino, monto));
    }

    public List<Integer> encontrarMejorRecorrido(int inicio, int saldoInicial) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        Map<Integer, Integer> maxSaldo = new HashMap<>();
        List<Integer> recorrido = new ArrayList<>();
        
        pq.offer(new int[]{inicio, saldoInicial});
        maxSaldo.put(inicio, saldoInicial);

        while (!pq.isEmpty()) {
            int[] actual = pq.poll();
            int nodo = actual[0], saldo = actual[1];

            recorrido.add(nodo);

            for (Sucursal vecino : sucursales.getOrDefault(nodo, new ArrayList<>())) {
                int nuevoSaldo = saldo + vecino.monto;

                if (nuevoSaldo >= 0 && (!maxSaldo.containsKey(vecino.id) || nuevoSaldo > maxSaldo.get(vecino.id))) {
                    maxSaldo.put(vecino.id, nuevoSaldo);
                    pq.offer(new int[]{vecino.id, nuevoSaldo});
                }
            }
        }
        
        return recorrido;
    }
}

public class RutaCobrador {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Agregamos sucursales
        for (int i = 1; i <= 5; i++) {
            grafo.agregarSucursal(i);
        }

        // Agregamos conexiones entre sucursales con los montos cobrados o pagados
        grafo.agregarCamino(1, 2, 500);
        grafo.agregarCamino(1, 3, -300);
        grafo.agregarCamino(2, 4, -200);
        grafo.agregarCamino(2, 5, 400);
        grafo.agregarCamino(3, 4, 100);
        grafo.agregarCamino(4, 5, -100);

        // Iniciamos el recorrido con un saldo inicial de 500
        List<Integer> rutaOptima = grafo.encontrarMejorRecorrido(1, 500);

        System.out.println("Ruta óptima: " + rutaOptima);
    }
}
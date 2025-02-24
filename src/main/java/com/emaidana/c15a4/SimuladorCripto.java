import java.util.*;

class Nodo {
    String nombre;
    double saldo; // Puede ser positivo (cobro) o negativo (pago)
    Map<Nodo, Double> conexiones; // Nodo destino y costo en criptomonedas

    public Nodo(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        this.conexiones = new HashMap<>();
    }

    public void agregarConexion(Nodo destino, double costo) {
        conexiones.put(destino, costo);
    }
}

class RedCripto {
    Map<String, Nodo> nodos;

    public RedCripto() {
        this.nodos = new HashMap<>();
    }

    public void agregarNodo(String nombre, double saldo) {
        nodos.put(nombre, new Nodo(nombre, saldo));
    }

    public void conectarNodos(String origen, String destino, double costo) {
        Nodo nodoOrigen = nodos.get(origen);
        Nodo nodoDestino = nodos.get(destino);
        if (nodoOrigen != null && nodoDestino != null) {
            nodoOrigen.agregarConexion(nodoDestino, costo);
        }
    }

    public void realizarRecorrido(String inicio, double saldoInicial) {
        PriorityQueue<Nodo> cola = new PriorityQueue<>(Comparator.comparingDouble(n -> -n.saldo));
        Set<Nodo> visitados = new HashSet<>();
        Nodo nodoActual = nodos.get(inicio);
        double saldoActual = saldoInicial;

        if (nodoActual == null) {
            System.out.println("Nodo inicial no encontrado.");
            return;
        }

        cola.add(nodoActual);
        while (!cola.isEmpty()) {
            nodoActual = cola.poll();
            if (visitados.contains(nodoActual)) continue;

            visitados.add(nodoActual);
            saldoActual += nodoActual.saldo;
            System.out.println("Visitando nodo: " + nodoActual.nombre + " | Saldo actual: " + saldoActual);

            for (Map.Entry<Nodo, Double> entrada : nodoActual.conexiones.entrySet()) {
                Nodo vecino = entrada.getKey();
                double costo = entrada.getValue();
                if (!visitados.contains(vecino) && saldoActual >= costo) {
                    saldoActual -= costo;
                    cola.add(vecino);
                }
            }
        }

        System.out.println("Recorrido finalizado. Saldo restante: " + saldoActual);
    }
}

public class SimuladorCripto {
    public static void main(String[] args) {
        RedCripto red = new RedCripto();
        red.agregarNodo("A", 10);
        red.agregarNodo("B", -5);
        red.agregarNodo("C", 15);
        red.agregarNodo("D", -10);
        red.agregarNodo("E", 20);

        red.conectarNodos("A", "B", 3);
        red.conectarNodos("A", "C", 5);
        red.conectarNodos("B", "D", 2);
        red.conectarNodos("C", "E", 7);
        red.conectarNodos("E", "D", 4);

        System.out.println("Iniciando recorrido con saldo inicial de 10...");
        red.realizarRecorrido("A", 10);
    }
}
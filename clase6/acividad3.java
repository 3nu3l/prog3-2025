package clase6;
import java.util.*;

class Grafo3 {
    private Map<Integer, List<int[]>> adyacencia;
    private int numVertices;

    public Grafo3(int numVertices) {
        this.numVertices = numVertices;
        adyacencia = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            adyacencia.put(i, new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int costo) {
        adyacencia.get(origen).add(new int[]{destino, costo});
        adyacencia.get(destino).add(new int[]{origen, costo}); // Grafo3 no dirigido
    }

    public void aplicarPrim() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        boolean[] visitado = new boolean[numVertices];
        int costoTotal = 0;
        List<int[]> resultado = new ArrayList<>();
        
        pq.add(new int[]{0, 0, -1});
        
        while (!pq.isEmpty()) {
            int[] actual = pq.poll();
            int nodo = actual[0], costo = actual[1], padre = actual[2];
            
            if (visitado[nodo]) continue;
            visitado[nodo] = true;
            costoTotal += costo;
            if (padre != -1) resultado.add(new int[]{padre, nodo, costo});
            
            for (int[] vecino : adyacencia.get(nodo)) {
                if (!visitado[vecino[0]]) {
                    pq.add(new int[]{vecino[0], vecino[1], nodo});
                }
            }
        }
        
        System.out.println("Árbol de Recubrimiento Mínimo:");
        for (int[] arista : resultado) {
            System.out.println(arista[0] + " - " + arista[1] + " (Costo: " + arista[2] + ")");
        }
        System.out.println("Costo total: " + costoTotal);
    }

    public static void main(String[] args) {
        Grafo3 Grafo3 = new Grafo3(6);
        Grafo3.agregarArista(0, 1, 4);
        Grafo3.agregarArista(0, 2, 3);
        Grafo3.agregarArista(1, 2, 1);
        Grafo3.agregarArista(1, 3, 2);
        Grafo3.agregarArista(2, 3, 4);
        Grafo3.agregarArista(3, 4, 2);
        Grafo3.agregarArista(4, 5, 6);
        
        Grafo3.aplicarPrim();
    }
}

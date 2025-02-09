package clase8;
//actividad 2

public class FloydWarshall {
    final static int INF = 99999;
    
    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int graph[][] = { 
                            {0, 8, 5},
                            {3, 0, INF},
                            {INF, 2, 0}
                        };
        int V = graph.length;
        fw.floydWarshall(graph, V);

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Ingrese el valor del origen: ");
        int origen = scanner.nextInt();
        System.out.print("Ingrese el valor del destino: ");
        int busqueda = scanner.nextInt();
        scanner.close();

        
        buscarCamino(origen, busqueda);
    }
    public static void  buscarCamino(int origen,int busqueda)
    {
        int[][] p = new int[3][3];
        System.out.println("El camino más corto desde " + origen + " hasta " + busqueda + " es: ");
        System.out.print(origen + " ");
        while (origen != busqueda) {
            System.out.print(busqueda + " ");
            busqueda = p[origen][busqueda];
        }
        System.out.println();
    }


    
    
    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        // Inicializar la matriz de distancias
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j];
            }
        }
     // Actualizar la matriz de distancias
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Imprimir la matriz de distancias
        printSolution(dist, V);
    }

    void printSolution(int dist[][], int V) {

        System.out.println("Matriz de distancias más cortas entre cada centro de distribución:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
public class GrafoMatrizAdyacencia {
    private int[][] matrizAdyacencia;
    private int numVertices;

    // Constructor para inicializar el grafo con un número dado de vértices
    public GrafoMatrizAdyacencia(int numVertices) {
        this.numVertices = numVertices;
        this.matrizAdyacencia = new int[numVertices][numVertices];
    }

    // Agregar una arista al grafo
    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 1;
        } else {
            System.out.println("Índices fuera de rango.");
        }
    }

    // Eliminar una arista del grafo
    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matrizAdyacencia[origen][destino] = 0;
        } else {
            System.out.println("Índices fuera de rango.");
        }
    }

    // Verificar si existe una arista entre dos vértices
    public boolean verificarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return matrizAdyacencia[origen][destino] == 1;
        } else {
            System.out.println("Índices fuera de rango.");
            return false;
        }
    }

    // Listar los vértices adyacentes a un vértice dado
    public void listarAdyacentes(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            System.out.print("Vértices adyacentes a " + vertice + ": ");
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // Contar el grado de salida de un vértice dado
    public int contarGradoSalida(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            int grado = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[vertice][i] == 1) {
                    grado++;
                }
            }
            return grado;
        } else {
            System.out.println("Índice fuera de rango.");
            return -1;
        }
    }

    // Contar el grado de entrada de un vértice dado
    public int contarGradoEntrada(int vertice) {
        if (vertice >= 0 && vertice < numVertices) {
            int grado = 0;
            for (int i = 0; i < numVertices; i++) {
                if (matrizAdyacencia[i][vertice] == 1) {
                    grado++;
                }
            }
            return grado;
        } else {
            System.out.println("Índice fuera de rango.");
            return -1;
        }
    }

    // Imprimir la matriz de adyacencia
    public void imprimirMatriz() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Crear un grafo con 5 vértices
        GrafoMatrizAdyacencia grafo = new GrafoMatrizAdyacencia(5);

        // Agregar algunas aristas
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(3, 4);

        // Imprimir la matriz de adyacencia
        grafo.imprimirMatriz();

        // Listar adyacentes del vértice 0
        grafo.listarAdyacentes(0);

        // Verificar si existe una arista entre 0 y 1
        System.out.println("¿Existe arista entre 0 y 1? " + grafo.verificarArista(0, 1));

        // Contar grados de entrada y salida
        System.out.println("Grado de salida del vértice 0: " + grafo.contarGradoSalida(0));
        System.out.println("Grado de entrada del vértice 4: " + grafo.contarGradoEntrada(4));

        // Eliminar una arista y volver a imprimir la matriz
        grafo.eliminarArista(0, 1);
        System.out.println("Después de eliminar la arista (0 -> 1):");
        grafo.imprimirMatriz();
    }
}
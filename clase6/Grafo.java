package clase6;

import java.util.*;

class Grafo {
    private int[][] matrizAdyacencia;
    private int vertices;

    public Grafo(int vertices) {
        this.vertices = vertices;
        matrizAdyacencia = new int[vertices][vertices];
    }

    public void agregarArista(int desde, int hacia) {
        matrizAdyacencia[desde][hacia] = 1;
    }

    public void eliminarArista(int desde, int hacia) {
        matrizAdyacencia[desde][hacia] = 0;
    }

    public boolean tieneArista(int desde, int hacia) {
        return matrizAdyacencia[desde][hacia] == 1;
    }

    public List<Integer> obtenerAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            if (matrizAdyacencia[vertice][i] == 1) {
                adyacentes.add(i);
            }
        }
        return adyacentes;
    }

    public int obtenerGradoEntrada(int vertice) {
        int gradoEntrada = 0;
        for (int i = 0; i < vertices; i++) {
            if (matrizAdyacencia[i][vertice] == 1) {
                gradoEntrada++;
            }
        }
        return gradoEntrada;
    }

    public int obtenerGradoSalida(int vertice) {
        int gradoSalida = 0;
        for (int i = 0; i < vertices; i++) {
            if (matrizAdyacencia[vertice][i] == 1) {
                gradoSalida++;
            }
        }
        return gradoSalida;
    }

    public void mostrarGrafo() {
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(2, 3);
        grafo.agregarArista(3, 4);

        grafo.mostrarGrafo();
        
        System.out.println("Adyacentes de 0: " + grafo.obtenerAdyacentes(0));
        System.out.println("Grado de entrada de 3: " + grafo.obtenerGradoEntrada(3));
        System.out.println("Grado de salida de 0: " + grafo.obtenerGradoSalida(0));
    }
}
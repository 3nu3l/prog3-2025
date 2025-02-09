package clase6;
import java.util.*;
/*// Matriz de adyacencia en Java
int[][] grafo = new int[numVertices][numVertices];
// Agregar aristas
grafo[0][1] = 1; // A - B
grafo[0][2] = 1; // A - C
grafo[1][3] = 1; // B - D
grafo[2][3] = 1; // C - D */

/*Implementación de un Grafo en una Matriz de Adyacencia 
Objetivo: Implementar un grafo utilizando una matriz de adyacencia en Java 
y realizar varias operaciones para manipular y consultar el grafo.
Descripción del Problema: Dado un grafo dirigido, tu tarea es implementar las siguientes operaciones
utilizando una matriz de adyacencia: Operaciones: Inicialización del Grafo, Agregar Arista, Eliminar Arista, Verificar
Arista, Listar Adyacentes, Contar Grado de Entrada y Salida: 
Implementa métodos para contar el grado de salida (número de aristas que salen) y el grado de entrada
(número de aristas que entran) de un vértice dado. */

class Grafo {
    private int[][] matriz;
    private int numVertices;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        matriz = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 1;
        }
    }

    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 0;
        }
    }

    public boolean verificarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return matriz[origen][destino] == 1;
        }
        return false;
    }

    public List<Integer> listarAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[vertice][i] == 1) {
                    adyacentes.add(i);
                }
            }
        }
        return adyacentes;
    }

    public int contarGradoEntrada(int vertice) {
        int grado = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[i][vertice] == 1) {
                    grado++;
                }
            }
        }
        return grado;
    }

    public int contarGradoSalida(int vertice) {
        int grado = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[vertice][i] == 1) {
                    grado++;
                }
            }
        }
        return grado;
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(3, 4);

        System.out.println("Adyacentes a 0: " + grafo.listarAdyacentes(0));
        System.out.println("Grado de entrada de 3: " + grafo.contarGradoEntrada(3));
        System.out.println("Grado de salida de 1: " + grafo.contarGradoSalida(1));
        System.out.println("¿Existe arista de 0 a 2?: " + grafo.verificarArista(0, 2));
        grafo.eliminarArista(0, 2);
        System.out.println("¿Existe arista de 0 a 2 después de eliminarla?: " + grafo.verificarArista(0, 2));
    }
}
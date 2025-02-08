package Actividad1;

public class ScoringMaximo {

    public static Cliente encontrarMaximo(Cliente[] lista, int inicio, int fin) {
        if (inicio == fin) {
            return lista[inicio];  // Caso base: un solo cliente
        }

        int mitad = (inicio + fin) / 2;
        Cliente maxIzquierda = encontrarMaximo(lista, inicio, mitad);
        Cliente maxDerecha = encontrarMaximo(lista, mitad + 1, fin);

        return (maxIzquierda.scoring > maxDerecha.scoring) ? maxIzquierda : maxDerecha;
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente(1, "Juan", 500),
            new Cliente(2, "Ana", 750),
            new Cliente(3, "Carlos", 300),
            new Cliente(4, "Sofía", 900),
            new Cliente(5, "Pedro", 600)
        };

        Cliente maxCliente = encontrarMaximo(clientes, 0, clientes.length - 1);
        System.out.println("Cliente con el scoring máximo: " + maxCliente);
    }
}
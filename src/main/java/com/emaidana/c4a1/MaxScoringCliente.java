class Cliente {
    int id;
    String nombre;
    double scoring;

    public Cliente(int id, String nombre, double scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', scoring=" + scoring + "}";
    }
}

public class MaxScoringCliente {

    public static Cliente buscarMaximoCliente(Cliente[] clientes, int inicio, int fin) {
        // Caso base: si solo hay un cliente
        if (inicio == fin) {
            return clientes[inicio];
        }

        // Divide: Encuentra el punto medio
        int medio = (inicio + fin) / 2;

        // Llama recursivamente para cada mitad
        Cliente clienteIzquierda = buscarMaximoCliente(clientes, inicio, medio);
        Cliente clienteDerecha = buscarMaximoCliente(clientes, medio + 1, fin);

        // Combina: Retorna el cliente con el mayor scoring
        if (clienteIzquierda.scoring >= clienteDerecha.scoring) {
            return clienteIzquierda;
        } else {
            return clienteDerecha;
        }
    }

    public static void main(String[] args) {
        // Lista de clientes
        Cliente[] clientes = {
            new Cliente(1, "Juan", 85.5),
            new Cliente(2, "María", 90.3),
            new Cliente(3, "Carlos", 78.2),
            new Cliente(4, "Ana", 95.4),
            new Cliente(5, "Luis", 88.1)
        };

        // Encuentra el cliente con el scoring máximo
        Cliente clienteMaximo = buscarMaximoCliente(clientes, 0, clientes.length - 1);

        // Imprime el cliente con el máximo scoring
        System.out.println("Cliente con el máximo scoring: " + clienteMaximo);
    }
}
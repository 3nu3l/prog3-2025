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

public class DosClientesMaximos {

    public static Cliente[] encontrarDosMaximos(Cliente[] clientes, int inicio, int fin) {
        // Caso base: Si solo hay un cliente
        if (inicio == fin) {
            return new Cliente[]{clientes[inicio], null}; // No hay segundo mayor
        }

        // Divide: Encuentra el punto medio
        int medio = (inicio + fin) / 2;

        // Llama recursivamente para encontrar los dos mayores en cada mitad
        Cliente[] mayoresIzq = encontrarDosMaximos(clientes, inicio, medio);
        Cliente[] mayoresDer = encontrarDosMaximos(clientes, medio + 1, fin);

        // Combina: Determina los dos mayores
        Cliente mayor, segundoMayor;
        if (mayoresIzq[0].scoring > mayoresDer[0].scoring) {
            mayor = mayoresIzq[0];
            segundoMayor = (mayoresIzq[1] != null && mayoresIzq[1].scoring > mayoresDer[0].scoring)
                    ? mayoresIzq[1] : mayoresDer[0];
        } else {
            mayor = mayoresDer[0];
            segundoMayor = (mayoresDer[1] != null && mayoresDer[1].scoring > mayoresIzq[0].scoring)
                    ? mayoresDer[1] : mayoresIzq[0];
        }

        return new Cliente[]{mayor, segundoMayor};
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente(1, "Juan", 85.5),
            new Cliente(2, "María", 90.3),
            new Cliente(3, "Carlos", 78.2),
            new Cliente(4, "Ana", 95.4),
            new Cliente(5, "Luis", 88.1)
        };

        Cliente[] resultado = encontrarDosMaximos(clientes, 0, clientes.length - 1);
        System.out.println("Cliente con mayor scoring: " + resultado[0]);
        System.out.println("Cliente con segundo mayor scoring: " + resultado[1]);
    }
}
import Main.java.Clientes;
// Ejercicio 3
public class Main2 {
    public static void main(String[] args) {
        Clientes[] clientes = {
            new Clientes(1, 5, "Juan"),
            new Clientes(2, 3, "Pedro"),
            new Clientes(3, 88, "Ana"),
            new Clientes(4, 1, "Luis"),
            new Clientes(5, 90, "Maria")
        };

        // Imprimir lista de clientes
        for (Clientes c : clientes) {
            System.out.println("ID: " + c.getId() + ", Nombre: " + c.getnombre() + ", Scoring: " + c.getScoring());
        }

        // Buscar los dos clientes con mayor scoring
        Clientes[] top2 = Clientes.buscarDosMaximosScoring(clientes);

        // Imprimir los dos clientes con mayor scoring
        System.out.println("\nClientes con mayor scoring:");
        System.out.println("1° " + top2[0].getnombre() + " - Scoring: " + top2[0].getScoring());
        System.out.println("2° " + top2[1].getnombre() + " - Scoring: " + top2[1].getScoring());
    }
}

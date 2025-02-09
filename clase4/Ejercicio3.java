public class Ejercicio3 {
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
            System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre() + ", Scoring: " + c.getScoring());
        }

        // Buscar los dos clientes con mayor scoring
        Clientes[] top2 = Clientes.buscarDosMaximosScoring(clientes);

        // Imprimir los dos clientes con mayor scoring
        System.out.println("\nClientes con mayor scoring:");
        System.out.println("1° " + top2[0].getNombre() + " - Scoring: " + top2[0].getScoring());
        System.out.println("2° " + top2[1].getNombre() + " - Scoring: " + top2[1].getScoring());
    }
}

class Clientes {
    private int id;
    private int scoring;
    private String nombre;

    public Clientes(int id, int scoring, String nombre) {
        this.id = id;
        this.scoring = scoring;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public int getScoring() {
        return scoring;
    }

    public String getNombre() {
        return nombre;
    }

    // Método para encontrar los dos clientes con mayor scoring
    public static Clientes[] buscarDosMaximosScoring(Clientes[] clientes) {
        if (clientes.length < 2) {
            throw new IllegalArgumentException("Debe haber al menos dos clientes");
        }

        Clientes max1 = clientes[0];
        Clientes max2 = clientes[1];

        if (max1.getScoring() < max2.getScoring()) {
            // Intercambiar si el segundo es mayor
            Clientes temp = max1;
            max1 = max2;
            max2 = temp;
        }

        for (int i = 2; i < clientes.length; i++) {
            if (clientes[i].getScoring() > max1.getScoring()) {
                max2 = max1;
                max1 = clientes[i];
            } else if (clientes[i].getScoring() > max2.getScoring()) {
                max2 = clientes[i];
            }
        }

        return new Clientes[]{max1, max2};
    }
}

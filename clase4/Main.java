public class Main {
    public static void main(String[] args) {
        Clientes[] Clientes = {
            new Clientes(1, 5, "Juan"),
            new Clientes(2, 3, "Pedro"),
            new Clientes(3, 88, "Ana"),
            new Clientes(4, 1, "Luis"),
            new Clientes(5, 2, "Maria")
        };

        for (Clientes Clientes2 : Clientes) {
            System.out.println("ID: " + Clientes2.getId() + ", Nombre: " + Clientes2.getnombre() + ", Scoring: " + Clientes2.getScoring());
        }

        Clientes max = Clientes[0].buscarMaximoScoring(Clientes);
        System.out.println("Cliente con mayor scoring: " + max.getnombre() + ", Scoring: " + max.getScoring());
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

    public void setId(int id) {
        this.id = id;
    }

    public int getScoring() {
        return scoring;
    }

    public void setScoring(int scoring) {
        this.scoring = scoring;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public Clientes buscarMaximoScoring(Clientes[] Clientes) {
        Clientes max = Clientes[0];
        for (int i = 1; i < Clientes.length; i++) {
            if (Clientes[i].getScoring() > max.getScoring()) {
                max = Clientes[i];
            }
        }
        return max;
    }

        // Método para encontrar los dos clientes con mayor scoring
        public static Clientes[] buscarDosMaximosScoring(Clientes[] clientes) {
            if (clientes.length < 2) {
                System.out.println("Debe haber al menos dos clientes");
            }
    
            Clientes max1 = clientes[0];
            Clientes max2 = clientes[1];
    
            if (max1.getScoring() < max2.getScoring()) {
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
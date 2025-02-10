import java.util.Arrays;

public class GreedyFlorist {

    public static int getMinimumCost(int k, int[] c) {
        // Ordenar los precios de las flores en orden descendente
        Arrays.sort(c);
        int totalCost = 0;
        int purchases = 0;

        // Comprar las flores de la más cara a la más barata
        for (int i = c.length - 1; i >= 0; i--) {
            totalCost += (purchases / k + 1) * c[i];
            purchases++;
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int k = 3; // Número de amigos
        int[] c = {1, 3, 5, 7, 9}; // Precios de las flores

        int result = getMinimumCost(k, c);
        System.out.println("Costo mínimo: " + result);
    }
}
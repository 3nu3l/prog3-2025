package clase5.ejercicios;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Actividad3 {

    // Clase para representar un objeto con su valor y peso
    static class Item {
        double value, weight, ratio;

        Item(double value, double weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = value / weight;
        }
    }

    public static double camion(int W, List<Item> items) {
            // Ordenar los objetos por la relación valor/peso en orden descendente
            items.sort((a, b) -> Double.compare(((Item) b).ratio, ((Item) a).ratio));
    
            double maxValue = 0.0;
    
            for (Item item : items) {
            if (W == 0) break; 

            if (item.weight <= W) {
                maxValue += item.value;
                W -= item.weight;
            } else {
                maxValue += item.value * ((double) W / item.weight);
                W = 0;
            }
        }

        return maxValue;
    }
    public static void main(String[] args) {
        List <Item> items = new ArrayList<>();

        
        items.add(new Item(10, 10));
        items.add(new Item(20, 5));
        items.add(new Item(30, 20));
        items.add(new Item(40, 15));
        items.add(new Item(50, 10));
        
        int W = 50; // Capacidad de la mochila
        System.out.println("Valor máximo obtenido = " + camion(W, items));
    };
}
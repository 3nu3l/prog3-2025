import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Item {
    double peso;
    double valor;

    public Item(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }

    public double valorPorPeso() {
        return valor / peso;
    }
}

public class FraccionableCamion {

    public static List<Item> cargarCamionFraccionable(List<Item> items, double capacidad) {
        // Ordenar los items por valor por peso en orden descendente
        items.sort(Comparator.comparingDouble(Item::valorPorPeso).reversed());

        List<Item> seleccionados = new ArrayList<>();
        double pesoActual = 0;
        double valorTotal = 0;

        for (Item item : items) {
            if (pesoActual + item.peso <= capacidad) {
                // Agregar el item completo
                seleccionados.add(item);
                pesoActual += item.peso;
                valorTotal += item.valor;
            } else {
                // Agregar parte fraccional del item
                double pesoFraccional = capacidad - pesoActual;
                valorTotal += pesoFraccional * item.valorPorPeso();
                seleccionados.add(new Item(pesoFraccional, pesoFraccional * item.valorPorPeso()));
                break;
            }
        }

        System.out.println("Valor total: " + valorTotal);
        return seleccionados;
    }

    public static void main(String[] args) {
        List<Item> items = List.of(
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        );
        double capacidad = 50;

        List<Item> resultado = cargarCamionFraccionable(new ArrayList<>(items), capacidad);

        System.out.println("Items seleccionados:");
        for (Item item : resultado) {
            System.out.println("Peso: " + item.peso + ", Valor: " + item.valor);
        }
    }
}
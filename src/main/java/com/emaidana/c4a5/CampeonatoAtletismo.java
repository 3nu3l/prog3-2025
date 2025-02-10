import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Corredor {
    String nombre;
    String categoria;
    double tiempo;

    public Corredor(String nombre, String categoria, double tiempo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Tiempo: " + tiempo;
    }
}

public class CampeonatoAtletismo {

    public static Map<String, Corredor> encontrarMejoresTiempos(List<Corredor> corredores, int inicio, int fin) {
        // Caso base: Un solo corredor
        if (inicio == fin) {
            Map<String, Corredor> resultado = new HashMap<>();
            Corredor corredor = corredores.get(inicio);
            resultado.put(corredor.categoria, corredor);
            return resultado;
        }

        // Divide: Encuentra el punto medio
        int medio = (inicio + fin) / 2;

        // Vence: Encuentra los mejores tiempos en ambas mitades
        Map<String, Corredor> tiemposIzquierda = encontrarMejoresTiempos(corredores, inicio, medio);
        Map<String, Corredor> tiemposDerecha = encontrarMejoresTiempos(corredores, medio + 1, fin);

        // Combina: Une los resultados
        for (Map.Entry<String, Corredor> entrada : tiemposDerecha.entrySet()) {
            String categoria = entrada.getKey();
            Corredor corredorDerecha = entrada.getValue();

            if (!tiemposIzquierda.containsKey(categoria)) {
                tiemposIzquierda.put(categoria, corredorDerecha);
            } else {
                Corredor corredorIzquierda = tiemposIzquierda.get(categoria);
                if (corredorDerecha.tiempo < corredorIzquierda.tiempo) {
                    tiemposIzquierda.put(categoria, corredorDerecha);
                }
            }
        }

        return tiemposIzquierda;
    }

    public static void main(String[] args) {
        List<Corredor> corredores = List.of(
            new Corredor("Juan", "Adultos", 12.5),
            new Corredor("María", "Juveniles", 10.2),
            new Corredor("Carlos", "Adultos", 11.8),
            new Corredor("Ana", "Juveniles", 9.8),
            new Corredor("Luis", "Senior", 14.3),
            new Corredor("Sofía", "Senior", 13.7)
        );

        Map<String, Corredor> mejoresTiempos = encontrarMejoresTiempos(corredores, 0, corredores.size() - 1);

        System.out.println("Mejores tiempos por categoría:");
        for (Map.Entry<String, Corredor> entrada : mejoresTiempos.entrySet()) {
            System.out.println("Categoría: " + entrada.getKey() + " -> " + entrada.getValue());
        }
    }
}
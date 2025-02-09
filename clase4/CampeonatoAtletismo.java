import java.util.*;

class Corredor {
    String nombre;
    String categoria;
    double tiempo;

    public Corredor(String nombre, String categoria, double tiempo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tiempo = tiempo;
    }
}

public class CampeonatoAtletismo {

    // Método recursivo que encuentra el mejor corredor en cada categoría
    public static Map<String, Corredor> encontrarMejores(Corredor[] corredores, int inicio, int fin) {
        if (inicio == fin) {
            Map<String, Corredor> resultado = new HashMap<>();
            resultado.put(corredores[inicio].categoria, corredores[inicio]);
            return resultado;
        }

        int medio = inicio + (fin - inicio) / 2;

        // Divide: Llamadas recursivas a la mitad izquierda y derecha
        Map<String, Corredor> izquierda = encontrarMejores(corredores, inicio, medio);
        Map<String, Corredor> derecha = encontrarMejores(corredores, medio + 1, fin);

        // Conquista: Combinar los resultados de ambas mitades
        return combinarResultados(izquierda, derecha);
    }

    // Método para combinar los resultados de las mitades
    private static Map<String, Corredor> combinarResultados(Map<String, Corredor> izquierda, Map<String, Corredor> derecha) {
        Map<String, Corredor> resultado = new HashMap<>(izquierda);

        for (Map.Entry<String, Corredor> entrada : derecha.entrySet()) {
            String categoria = entrada.getKey();
            Corredor corredor = entrada.getValue();

            if (!resultado.containsKey(categoria) || corredor.tiempo < resultado.get(categoria).tiempo) {
                resultado.put(categoria, corredor);
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        Corredor[] corredores = {
            new Corredor("Juan", "Juvenil", 12.5),
            new Corredor("María", "Adulto", 11.2),
            new Corredor("Pedro", "Juvenil", 10.8),
            new Corredor("Ana", "Adulto", 10.5),
            new Corredor("Carlos", "Senior", 13.1),
            new Corredor("Lucía", "Senior", 12.8),
            new Corredor("Luis", "Juvenil", 10.2),
            new Corredor("Sofía", "Adulto", 10.0)
        };

        Map<String, Corredor> mejores = encontrarMejores(corredores, 0, corredores.length - 1);

        System.out.println("Mejores tiempos por categoría:");
        for (Map.Entry<String, Corredor> entry : mejores.entrySet()) {
            System.out.println("Categoría: " + entry.getKey() + " - Corredor: " + entry.getValue().nombre + " - Tiempo: " + entry.getValue().tiempo + " segundos");
        }
    }
}

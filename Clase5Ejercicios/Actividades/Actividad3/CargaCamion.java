package Actividad3;


import java.util.*;

public class CargaCamion {
    public static List<String> cargarCamion(double capacidad, List<Mercancia> mercancias) {
        Collections.sort(mercancias);

        List<String> listaCargada = new ArrayList<>();
        double pesoActual = 0;

        for (Mercancia mercancia : mercancias) {
            if (pesoActual + mercancia.peso <= capacidad) {
                listaCargada.add("Cargar: " + mercancia.peso + "kg (100%)");
                pesoActual += mercancia.peso;
            } else {
                double fraccion = (capacidad - pesoActual) / mercancia.peso;
                listaCargada.add("Cargar: " + (fraccion * 100) + "% de " + mercancia.peso + "kg");
                break;
            }
        }

        return listaCargada;
    }

    public static void main(String[] args) {
        List<Mercancia> mercancias = Arrays.asList(
            new Mercancia(10, 60),
            new Mercancia(20, 100),
            new Mercancia(30, 120)
        );

        double capacidadCamion = 50;
        List<String> resultado = cargarCamion(capacidadCamion, mercancias);

        System.out.println("Lista de mercancías cargadas en el camión:");
        resultado.forEach(System.out::println);
    }
}
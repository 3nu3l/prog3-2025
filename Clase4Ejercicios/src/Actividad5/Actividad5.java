package Actividad5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Actividad5 {
    public static void main(String[] args) {
        
        ArrayList<Corredor> corredores = new ArrayList<>();
        corredores.add(new Corredor("Junior", "Juan", 12.2));
        corredores.add(new Corredor("Senior", "Pedro", 10.90));
        corredores.add(new Corredor("Junior", "Franco", 9.2));
        corredores.add(new Corredor("Senior", "Hamilton", 11.90));

        HashMap<String,ArrayList<Corredor>> corredorPorCategoria = new HashMap<>();
        for (Corredor corredor : corredores) {
            if(!corredorPorCategoria.containsKey(corredor.categoria)) {
                ArrayList<Corredor> ncorredores  = new ArrayList<>();
                corredorPorCategoria.put(corredor.categoria, ncorredores);
            }
            corredorPorCategoria.get(corredor.categoria).add(corredor);
        }

        for (ArrayList<Corredor> ncorredores : corredorPorCategoria.values()) {
            System.out.println(buscarScoringMaximo(ncorredores));
        }

    }

    private static Corredor buscarScoringMaximo(List<Corredor> corredores) {
        return buscarScoringMaximo(corredores, 0, corredores.size()-1);
    }    
    private static Corredor buscarScoringMaximo(List<Corredor> corredores, int inicio, int fin) {
        if (inicio == fin) {
            return corredores.get(inicio);
        }

        int medio = (inicio + fin) / 2;
        Corredor maxIzquierda = buscarScoringMaximo(corredores, inicio, medio);
        Corredor maxDerecha = buscarScoringMaximo(corredores, medio + 1, fin);
 
        return maxIzquierda.tiempo > maxDerecha.tiempo ? maxIzquierda : maxDerecha;
 
        /*
        if (maxIzquierda.scoring >= maxDerecha.scoring) {
            return maxIzquierda;
        } else {
            return maxDerecha;
        }
        */    
    }



}
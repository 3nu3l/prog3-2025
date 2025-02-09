package clase4;

import java.util.ArrayList;

public class Clase4Actividad4 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = cargarDatos();
        System.out.println(obtenerMayores(numeros, 4));
    }

    private static ArrayList<Integer> obtenerMayores(ArrayList<Integer> numeros, int cantidad) {
        return obtenerMayores(numeros, cantidad, 0, numeros.size());
    }    
    private static ArrayList<Integer> obtenerMayores(ArrayList<Integer> numeros, int cantidad, int i, int f) {
        // caso base
        if (f - i <= 1) {
            ArrayList<Integer> base = new ArrayList<>();
            if (f - i == 1) {
                base.add(numeros.get(i));
            }
            return base;
        }

        // mitad
        int mitad = (i + f) / 2;

        // izq
        ArrayList<Integer> izq = obtenerMayores(numeros, cantidad, i, mitad);

        // der
        ArrayList<Integer> der = obtenerMayores(numeros, cantidad, mitad+1, f);

        // combinar
        ArrayList<Integer> resultado = new ArrayList<>();
        int izqIndex = 0, derIndex = 0;
        while (resultado.size() < cantidad && (izqIndex < izq.size() || derIndex < der.size())) {
            if (izqIndex < izq.size() && (derIndex >= der.size() || izq.get(izqIndex) > der.get(derIndex))) {
                resultado.add(izq.get(izqIndex++));
            } else {
                resultado.add(der.get(derIndex++));   
            }
        }

        return resultado;
    }

    private static ArrayList<Integer> cargarDatos() {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(12);
        numeros.add(20);
        numeros.add(10);
        numeros.add(15);
        return numeros;
    }

}
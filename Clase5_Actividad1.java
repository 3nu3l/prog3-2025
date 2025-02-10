/*
 * 
 * Actividad 1

Dada una lista de monedas con denominaciones convencionales
(10,1,5,2,10,10,5,2,5,5,5,5,5,5,10), implementar una función greedy que devuelva
o genere una lista de monedas para dar cambio exacto utilizando una lista de
monedas disponible para un importe de $33. Devolver una lista nula o lanzar una
excepción, si no se puede dar el cambio.
Realizar pseudocódigo e implementación en Java. Indicar la complejidad
algorítmica.


Pseudocódigo

function darCambio(monedas, importe):
    sort(monedas) in descending order
    listaCambio = empty list
    for each moneda in monedas:
        while importe >= moneda:
            add moneda to listaCambio
            importe = importe - moneda
    if importe == 0:
        return listaCambio
    else:
        return null

 * 
 * 
 * Complejidad Algorítmica
La complejidad del algoritmo greedy depende principalmente de la ordenación de la lista de monedas y de la iteración sobre la lista. 
La ordenación tiene una complejidad de 𝑂(𝑛log 𝑛) y la iteración tiene una complejidad de 𝑂(𝑛), donde 𝑛 es el número de monedas en la lista. 
Por lo tanto, la complejidad total del algoritmo es 𝑂(𝑛log 𝑛).
 * 
 */
import java.util.*;

public class Clase5_Actividad1 {
    public static List<Integer> darCambio(List<Integer> monedas, int importe) {
        // Ordenar las monedas en orden descendente
        monedas.sort(Collections.reverseOrder());
        
        List<Integer> listaCambio = new ArrayList<>();
        for (int moneda : monedas) {
            while (importe >= moneda) {
                listaCambio.add(moneda);
                importe -= moneda;
            }
        }
        
        if (importe == 0) {
            return listaCambio;
        } else {
            // Devolver una lista nula si no se puede dar el cambio exacto
            return null;
        }
    }

    public static void main(String[] args) {
        List<Integer> monedas = Arrays.asList(10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 5, 10);
        int importe = 33;
        List<Integer> resultado = darCambio(monedas, importe);
        if (resultado != null) {
            System.out.println("Lista de monedas para dar el cambio: " + resultado);
        } else {
            System.out.println("No se puede dar el cambio exacto.");
        }
    }
}

/*

Actividad 1

Aplicar la técnica de Divide y Vencerás en una lista de clientes con id, nombre y
scoring, buscando el cliente con el scoring máximo.
Resolver mediante pseudocódigo
Implementar en java





Pseudocodigo
 function encontrarMaximoScoring(listaClientes):
    if tamaño(listaClientes) == 1:
        return listaClientes[0]
    
    mitad = tamaño(listaClientes) // 2
    subListaIzquierda = listaClientes[0..mitad-1]
    subListaDerecha = listaClientes[mitad..tamaño(listaClientes)-1]
    
    maxIzquierda = encontrarMaximoScoring(subListaIzquierda)
    maxDerecha = encontrarMaximoScoring(subListaDerecha)
    
    if maxIzquierda.scoring > maxDerecha.scoring:
        return maxIzquierda
    else:
        return maxDerecha

*/

class Cliente1 {
    int id;
    String nombre;
    int scoring;

    Cliente1(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }
}

public class Clase4_Actividad1 {
    public static void main(String[] args) {
        Cliente1[] clientes = {
            new Cliente1(1, "Juan", 85),
            new Cliente1(2, "Ana", 90),
            new Cliente1(3, "Luis", 95),
            new Cliente1(4, "Marta", 88)
        };

        Cliente1 maxScoringCliente = encontrarMaximoScoring(clientes);
        System.out.println("Cliente con el scoring máximo: " + maxScoringCliente.nombre + " con scoring " + maxScoringCliente.scoring);
    }

    public static Cliente1 encontrarMaximoScoring(Cliente1[] listaClientes) {
        if (listaClientes.length == 1) {
            return listaClientes[0];
        }

        int mitad = listaClientes.length / 2;
        Cliente1[] subListaIzquierda = java.util.Arrays.copyOfRange(listaClientes, 0, mitad);
        Cliente1[] subListaDerecha = java.util.Arrays.copyOfRange(listaClientes, mitad, listaClientes.length);

        Cliente1 maxIzquierda = encontrarMaximoScoring(subListaIzquierda);
        Cliente1 maxDerecha = encontrarMaximoScoring(subListaDerecha);

        if (maxIzquierda.scoring > maxDerecha.scoring) {
            return maxIzquierda;
        } else {
            return maxDerecha;
        }
    }
}

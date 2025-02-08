/*
 * Objetivo: Aplicar la técnica de Divide y Vencerás en una lista de clientes con id,
nombre y scoring, buscando los dos clientes con los scoring máximos.
Tareas:
Resolver mediante pseudocódigo
Realizar el análisis de recurrencia mediante método inductivo (sin utilizar fórmulas
matemáticas) para indicar la complejidad algorítmica.
Implementar en java


Pseudocodigo

function encontrarDosMaximosScorings(listaClientes):
    if tamaño(listaClientes) == 1:
        return (listaClientes[0], None)
    if tamaño(listaClientes) == 2:
        if listaClientes[0].scoring > listaClientes[1].scoring:
            return (listaClientes[0], listaClientes[1])
        else:
            return (listaClientes[1], listaClientes[0])

    mitad = tamaño(listaClientes) // 2
    subListaIzquierda = listaClientes[0..mitad-1]
    subListaDerecha = listaClientes[mitad..tamaño(listaClientes)-1]

    (maxIzquierda, segundoMaxIzquierda) = encontrarDosMaximosScorings(subListaIzquierda)
    (maxDerecha, segundoMaxDerecha) = encontrarDosMaximosScorings(subListaDerecha)

    if maxIzquierda.scoring > maxDerecha.scoring:
        maximo = maxIzquierda
        segundoMaximo = max(segundoMaxIzquierda, maxDerecha, porScoring)
    else:
        maximo = maxDerecha
        segundoMaximo = max(segundoMaxDerecha, maxIzquierda, porScoring)

    return (maximo, segundoMaximo)



Análisis de recurrencia:
Para analizar la complejidad algorítmica de este problema utilizando el método inductivo, consideramos cómo el algoritmo se comporta a medida que el tamaño del problema se incrementa. La función encontrarDosMaximosScorings divide la lista en dos sublistas de aproximadamente la mitad del tamaño original y hace llamadas recursivas en cada sublista.

Caso base: Si la lista tiene uno o dos elementos, la solución se encuentra en tiempo constante, es decir, 𝑂(1).

Caso recursivo: Si la lista tiene más de dos elementos, el algoritmo se divide en dos subproblemas de tamaño aproximadamente 𝑛/2. Luego combina los resultados de los subproblemas, lo que implica una comparación adicional que también es en tiempo constante.

Si analizamos el algoritmo de manera inductiva, podemos escribir la relación de recurrencia como:

𝑇(𝑛)=2𝑇(𝑛/2)+𝑂(1)

Usando el método inductivo, si asumimos que el tiempo de ejecución para un tamaño de lista 𝑛 es 𝑇(𝑛) y para el tamaño 𝑛/2 es 𝑇(𝑛/2), podemos inducir que la complejidad total del algoritmo es 𝑂(𝑛log⁡ 𝑛).
 * 
 */
class Cliente3 {
    int id;
    String nombre;
    int scoring;

    Cliente3(int id, String nombre, int scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }
}

public class Clase4_Actividad3 {
    public static void main(String[] args) {
        Cliente3[] clientes = {
            new Cliente3(1, "Juan", 85),
            new Cliente3(2, "Ana", 90),
            new Cliente3(3, "Luis", 95),
            new Cliente3(4, "Marta", 88),
            new Cliente3(5, "Carlos", 91)
        };

        Cliente3[] resultado = encontrarDosMaximosScorings(clientes);
        System.out.println("Clientes con los dos máximos scorings: " + resultado[0].nombre + " con scoring " + resultado[0].scoring +
                " y " + resultado[1].nombre + " con scoring " + resultado[1].scoring);
    }

    public static Cliente3[] encontrarDosMaximosScorings(Cliente3[] listaClientes) {
        if (listaClientes.length == 1) {
            return new Cliente3[]{listaClientes[0], null};
        }
        if (listaClientes.length == 2) {
            if (listaClientes[0].scoring > listaClientes[1].scoring) {
                return new Cliente3[]{listaClientes[0], listaClientes[1]};
            } else {
                return new Cliente3[]{listaClientes[1], listaClientes[0]};
            }
        }

        int mitad = listaClientes.length / 2;
        Cliente3[] subListaIzquierda = java.util.Arrays.copyOfRange(listaClientes, 0, mitad);
        Cliente3[] subListaDerecha = java.util.Arrays.copyOfRange(listaClientes, mitad, listaClientes.length);

        Cliente3[] mayoresIzq = encontrarDosMaximosScorings(subListaIzquierda);
        Cliente3[] mayoresDer = encontrarDosMaximosScorings(subListaDerecha);

        Cliente3 maximo, segundoMaximo;
        if (mayoresIzq[0].scoring > mayoresDer[0].scoring) {
            maximo = mayoresIzq[0];
            segundoMaximo = encontrarSegundoMaximo(mayoresIzq[1], mayoresDer[0], mayoresDer[1]);
        } else {
            maximo = mayoresDer[0];
            segundoMaximo = encontrarSegundoMaximo(mayoresDer[1], mayoresIzq[0], mayoresIzq[1]);
        }

        return new Cliente3[]{maximo, segundoMaximo};
    }



    private static Cliente3 encontrarSegundoMaximo(Cliente3 candidato1, Cliente3 candidato2, Cliente3 candidato3) {
        Cliente3 segundoMaximo = candidato1;
        if (candidato2 != null && (segundoMaximo == null || candidato2.scoring > segundoMaximo.scoring)) {
            segundoMaximo = candidato2;
        }
        if (candidato3 != null && (segundoMaximo == null || candidato3.scoring > segundoMaximo.scoring)) {
            segundoMaximo = candidato3;
        }
        return segundoMaximo;
    }
}
package Actividad3;

//Ejemplo de uso
public class RedAlmacenes {
 public static void main(String[] args) {
     Grafo grafo = new Grafo();

     Almacen a1 = new Almacen("A1", "Almacen Central");
     Almacen a2 = new Almacen("A2", "Almacen Norte");
     Almacen a3 = new Almacen("A3", "Almacen Sur");
     Almacen a4 = new Almacen("A4", "Almacen Este");
     Almacen a5 = new Almacen("A5", "Almacen Oeste");

     grafo.agregarAlmacen(a1);
     grafo.agregarAlmacen(a2);
     grafo.agregarAlmacen(a3);
     grafo.agregarAlmacen(a4);
     grafo.agregarAlmacen(a5);

     grafo.conectarAlmacenes(a1, a2);
     grafo.conectarAlmacenes(a1, a3);
     grafo.conectarAlmacenes(a2, a4);
     grafo.conectarAlmacenes(a3, a5);
     grafo.conectarAlmacenes(a4, a5);

     grafo.dfs(a1);
     grafo.bfs(a1);
 }
}

package Actividad4;

public class Main {
    public static void main(String[] args) {
        Logistica logistica = new Logistica(5);
        logistica.agregarRuta(0, 1, 10);
        logistica.agregarRuta(0, 2, 5);
        logistica.agregarRuta(1, 2, 2);
        logistica.agregarRuta(1, 3, 1);
        logistica.agregarRuta(2, 3, 9);
        logistica.agregarRuta(2, 4, 2);
        logistica.agregarRuta(3, 4, 4);
        
        logistica.dijkstra(0);
    }
}

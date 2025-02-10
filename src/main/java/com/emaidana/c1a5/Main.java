import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        // Crear objetos de cada tipo de vehículo
        Auto auto = new Auto("ABC123", "Toyota", "Corolla", 4);
        Camion camion = new Camion("DEF456", "Volvo", "FH16", 18.0);
        Moto moto = new Moto("GHI789", "Yamaha", "R1", "Deportiva");

        // Agregar vehículos a la lista
        vehiculos.add(auto);
        vehiculos.add(camion);
        vehiculos.add(moto);

        // Mostrar información de todos los vehículos
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInformacion();
        }
    }
}
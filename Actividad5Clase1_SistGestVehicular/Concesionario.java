package Actividad5Clase1_SistGestVehicular;

import java.util.ArrayList;

public class Concesionario {
    public static void main(String[] args) {
        // Crear objetos de cada tipo de vehículo
        Auto auto = new Auto("ABC123", "Toyota", "Corolla", 4);
        Camion camion = new Camion("DEF456", "Volvo", "FH16", 20);
        Moto moto = new Moto("GHI789", "Yamaha", "MT-07", "deportiva");

        // Almacenar los vehículos en una lista
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto);
        vehiculos.add(camion);
        vehiculos.add(moto);

        // Mostrar la información de todos los vehículos
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInformacion();
        }
    }
}

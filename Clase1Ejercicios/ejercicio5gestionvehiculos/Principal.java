package ejercicio5gestionvehiculos;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        
        Vehiculo auto = new Auto("TEG","Toyota", "Hiace", 4);
        Vehiculo camion = new Camion("ETG 233", "Volvo", "FH16", 25.0);
        Vehiculo moto = new Moto(" 123 FFT","Harley-Davidson", "Sportster", "Tipo1");

        
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto);
        vehiculos.add(camion);
        vehiculos.add(moto);

        
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInformacion();
        }
    }
}
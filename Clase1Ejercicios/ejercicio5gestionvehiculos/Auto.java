package ejercicio5gestionvehiculos;

public class Auto extends Vehiculo {

    private int cantidadDePuertas;

    public Auto(String matricula, String marca, String modelo, int cantidadDePuertas) {
        super(matricula, marca, modelo);
        this.cantidadDePuertas = cantidadDePuertas;
    }
    @Override
    public void mostrarInformacion() {
        System.out.println("Auto - Matrícula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", Puertas: " + cantidadDePuertas);
    }
}

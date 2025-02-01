package ejercicio5gestionvehiculos;

public abstract class Vehiculo {
    protected String matricula;
    protected String marca;
    protected String modelo;

    public Vehiculo(String marca, String modelo, String matricula) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula=matricula;
    }

    public abstract void mostrarInformacion();
   
}
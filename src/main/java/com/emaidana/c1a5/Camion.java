public class Camion extends Vehiculo {
    private double capacidadDeCarga;

    public Camion(String matricula, String marca, String modelo, double capacidadDeCarga) {
        super(matricula, marca, modelo);
        this.capacidadDeCarga = capacidadDeCarga;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Camion [Matrícula: " + getMatricula() + ", Marca: " + getMarca() + 
                           ", Modelo: " + getModelo() + ", Capacidad de Carga: " + capacidadDeCarga + " toneladas]");
    }
}
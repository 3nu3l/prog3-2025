public class Moto extends Vehiculo {
    private String tipoDeMoto;

    public Moto(String matricula, String marca, String modelo, String tipoDeMoto) {
        super(matricula, marca, modelo);
        this.tipoDeMoto = tipoDeMoto;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Moto [Matrícula: " + getMatricula() + ", Marca: " + getMarca() + 
                           ", Modelo: " + getModelo() + ", Tipo: " + tipoDeMoto + "]");
    }
}
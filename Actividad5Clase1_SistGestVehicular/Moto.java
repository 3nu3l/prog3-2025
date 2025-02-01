package Actividad5Clase1_SistGestVehicular;

class Moto extends Vehiculo {
    private String tipoDeMoto;

    public Moto(String matricula, String marca, String modelo, String tipoDeMoto) {
        super(matricula, marca, modelo);
        this.tipoDeMoto = tipoDeMoto;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Moto - Matrícula: " + matricula + ", Marca: " + marca + ", Modelo: " + modelo + ", Tipo de Moto: " + tipoDeMoto);
    }
}

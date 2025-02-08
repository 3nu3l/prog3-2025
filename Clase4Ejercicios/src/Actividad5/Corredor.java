package Actividad5;

class Corredor {
    String categoria;
    String nombre;
    double tiempo;
    public Corredor(String categoria, String nombre, double tiempo) {
        this.categoria = categoria;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }
    @Override
    public String toString() {
        return "Corredor [categoria=" + categoria + ", nombre=" + nombre + ", tiempo=" + tiempo + "]";
    }
       
}
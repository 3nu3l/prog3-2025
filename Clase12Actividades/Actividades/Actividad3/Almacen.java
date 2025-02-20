package Actividad3;

class Almacen {
    private String id;
    private String nombre;

    public Almacen(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre + " (" + id + ")";
    }
}
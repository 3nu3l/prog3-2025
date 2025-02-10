package Actividad3;

class Conexion implements Comparable<Conexion> {
    int destino, costo;

    public Conexion(int destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }

    @Override
    public int compareTo(Conexion otra) {
        return Integer.compare(this.costo, otra.costo);
    }
}
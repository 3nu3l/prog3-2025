package Actividad3;

class Mercancia implements Comparable<Mercancia> {
    double peso, valor;

    public Mercancia(double peso, double valor) {
        this.peso = peso;
        this.valor = valor;
    }

    @Override
    public int compareTo(Mercancia otra) {
        return Double.compare(otra.valor / otra.peso, this.valor / this.peso);
    }
}

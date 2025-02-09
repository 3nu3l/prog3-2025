package clase5.ejercicios;
import java.util.*;

class CambioInsuficienteException extends Exception {
    public CambioInsuficienteException(String mensaje) {
        super(mensaje);
    }
}

class Comprobante {
    protected String nombre;
    protected double valor;

    public Comprobante(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        if(this.getClass().getName()=="Cheque" || this.getClass().getName()=="OtrosDocumento"){ 
            return "Cheque [nombre=" + nombre + ", valor=" + valor + "]";
        }
        return "Comprobante ["+this.getClass().getSimpleName() + " valor=" + valor + "]";
    }
}

class Moneda extends Comprobante {
    public Moneda(double valor) {
        super(valor);
    }
}

class Cheque extends Comprobante {
    public Cheque(String nombre, double valor) {
        super(valor);
        this.nombre = nombre;
    }
}

class Bono extends Comprobante {
    public Bono(double valor) {
        super(valor);
    }
}

class OtrosDocumento extends Comprobante {
    public OtrosDocumento(String nombre, double valor) {
        super(valor);
        this.nombre = nombre;
    }
}

public class Actividad2 {
    public static List<Comprobante> darCambioGreedy(List<Comprobante> monedasDisponibles, int monto) throws CambioInsuficienteException {
        monedasDisponibles.sort(Comparator.comparingDouble(Comprobante::getValor).reversed()); // Corrección aquí
        List<Comprobante> cambio = new ArrayList<>();
        int suma = 0;

        for (Comprobante comprobante : monedasDisponibles) {
            if (suma + comprobante.getValor() <= monto) {
                cambio.add(comprobante);
                suma += comprobante.getValor();
            }
        }

        if (suma != monto) {
            throw new CambioInsuficienteException("No se puede dar el cambio exacto con las monedas disponibles.");
        }

        return cambio;
    }

    public static void main(String[] args) {
        int montoTotal = 300;
        List<Comprobante> comprobantes = new ArrayList<>();
        comprobantes.add(new Moneda(10));
        comprobantes.add(new Moneda(5));
        comprobantes.add(new Moneda(5));
        comprobantes.add(new Moneda(2));
        comprobantes.add(new Moneda(2));
        comprobantes.add(new Moneda(1));
        comprobantes.add(new Moneda(1));
        comprobantes.add(new Moneda(1));
        comprobantes.add(new Cheque("Juan Carlos Gomez", 100));
        comprobantes.add(new Cheque("Ezequiel Altamirano", 200));
        comprobantes.add(new Cheque("Vanesa Gonzalez", 300));
        comprobantes.add(new Cheque("Nicolas Nicassio", 400));
        comprobantes.add(new Cheque("Leandro Lopez", 500));
        comprobantes.add(new Bono(1000));
        comprobantes.add(new Bono(2000));
        comprobantes.add(new Bono(3000));
        comprobantes.add(new Bono(4000));
        comprobantes.add(new Bono(5000));
        comprobantes.add(new OtrosDocumento("Juan Domingo", 10000));
        comprobantes.add(new OtrosDocumento("Domingo Faustino", 20000));
        comprobantes.add(new OtrosDocumento("Juan Manuel", 30000));
        comprobantes.add(new OtrosDocumento("Julio Argentino", 40000));
        comprobantes.add(new OtrosDocumento("Daniel Osvaldo", 50000));

        comprobantes.sort(Comparator.comparingDouble(Comprobante::getValor).reversed());

        try {
            List<Comprobante> cambio = darCambioGreedy(comprobantes, montoTotal);
            System.out.println("Cambio entregado:");
            for (Comprobante c : cambio) {
                System.out.println(c);
            }
        } catch (CambioInsuficienteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

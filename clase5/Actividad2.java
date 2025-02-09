package clase5;

public class Actividad2 {
    public static void main(String[] args) {
        int monedas = 10;
        int cheques = 15;
        int bonos = 20;
        int otros= 1;
        int montoTotal = 51239;
        //int total = monedas + cheques + bonos + otros;

        calcularMonto(monedas, cheques, bonos, otros, montoTotal);
    }
    
    
    public static void calcularMonto(int monedas, int cheques, int bonos, int otros, int montoTotal) {
        
        int contadorMonedas=0, contadorCheques=0, contadorBonos=0, contadorOtros=0;
        for (int i = 0; montoTotal > 0; i++) {
            if(montoTotal >= bonos){
                contadorBonos++;
                montoTotal -= bonos;
            } else if(montoTotal >= cheques){
                contadorCheques++;
                montoTotal -= cheques;
            } else if(montoTotal >= monedas){
                contadorMonedas++;
                montoTotal -= monedas;
            } else if(montoTotal >= otros){
                contadorOtros++;
                montoTotal -= otros;
            }
        }
        System.out.println("Bonos: " + contadorBonos);
        System.out.println("Cheques: " + contadorCheques);
        System.out.println("Monedas: " + contadorMonedas);
        System.out.println("Otros: " + contadorOtros);
    }
}
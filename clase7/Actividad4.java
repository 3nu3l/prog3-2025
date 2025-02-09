package clase7.ejercicios;

public class Actividad4 {
    public static void Main(String[] args) {
        // Definición del presupuesto y datos de los paquetes
        int presupuestoMaximo = 35;
        int[] costosPaquetes = {12, 20, 15, 25};
        int[] gananciasPaquetes = {150, 200, 100, 300};
        int cantidadPaquetes = costosPaquetes.length;

        // Crear tabla dinámica
        int[][] tablaGanancias = new int[cantidadPaquetes + 1][presupuestoMaximo + 1];

        // Calcular máximas ganancias
        for (int paquete = 1; paquete <= cantidadPaquetes; paquete++) {
            for (int capacidad = 0; capacidad <= presupuestoMaximo; capacidad++) {
                if (costosPaquetes[paquete - 1] <= capacidad) {
                    tablaGanancias[paquete][capacidad] = Math.max(
                            tablaGanancias[paquete - 1][capacidad],
                            gananciasPaquetes[paquete - 1] + tablaGanancias[paquete - 1][capacidad - costosPaquetes[paquete - 1]]
                    );
                } else {
                    tablaGanancias[paquete][capacidad] = tablaGanancias[paquete - 1][capacidad];
                }
            }
        }

        // Mostrar la tabla dinámica
        System.out.println("Tabla de ganancias máximas:");
        for (int i = 0; i <= cantidadPaquetes; i++) {
            for (int j = 0; j <= presupuestoMaximo; j++) {
                System.out.printf("%4d", tablaGanancias[i][j]);
            }
            System.out.println();
        }

        // Imprimir la ganancia máxima alcanzable
        int gananciaMaxima = tablaGanancias[cantidadPaquetes][presupuestoMaximo];
        System.out.println("\nGanancia máxima alcanzable con el presupuesto: " + gananciaMaxima);

        // Recuperar y mostrar los paquetes seleccionados
        System.out.println("\nPaquetes seleccionados:");
        int paqueteActual = cantidadPaquetes;
        int presupuestoRestante = presupuestoMaximo;

        while (paqueteActual > 0 && presupuestoRestante > 0) {
            if (tablaGanancias[paqueteActual][presupuestoRestante] != tablaGanancias[paqueteActual - 1][presupuestoRestante]) {
                System.out.println("Paquete " + paqueteActual + ": Costo=" + costosPaquetes[paqueteActual - 1] +
                        ", Ganancia=" + gananciasPaquetes[paqueteActual - 1]);
                presupuestoRestante -= costosPaquetes[paqueteActual - 1];
            }
            paqueteActual--;
        }

        // Mostrar complejidad
        System.out.println("\nAnálisis de complejidad:");
        System.out.println("Tiempo: O(cantidadPaquetes * presupuestoMaximo)");
        System.out.println("Espacio: O(cantidadPaquetes * presupuestoMaximo) para la tabla dinámica");
    }
}
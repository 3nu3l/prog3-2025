import java.util.*;

class LaberintoSolver {
    static class Nodo {
        int x, y, distancia;

        Nodo(int x, int y, int distancia) {
            this.x = x;
            this.y = y;
            this.distancia = distancia;
        }
    }

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static List<int[]> resolverLaberinto(int[][] laberinto, int inicioX, int inicioY, int metaX, int metaY) {
        int filas = laberinto.length;
        int columnas = laberinto[0].length;
        boolean[][] visitado = new boolean[filas][columnas];
        Queue<Nodo> cola = new LinkedList<>();
        Map<Nodo, Nodo> padres = new HashMap<>(); 

        cola.add(new Nodo(inicioX, inicioY, 0));
        visitado[inicioX][inicioY] = true;

        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();

            if (actual.x == metaX && actual.y == metaY) {
                return construirCamino(padres, actual);
            }

            for (int i = 0; i < 4; i++) {
                int nuevoX = actual.x + dx[i];
                int nuevoY = actual.y + dy[i];

                if (esValido(nuevoX, nuevoY, filas, columnas, laberinto, visitado)) {
                    visitado[nuevoX][nuevoY] = true;
                    Nodo nuevoNodo = new Nodo(nuevoX, nuevoY, actual.distancia + 1);
                    cola.add(nuevoNodo);
                    padres.put(nuevoNodo, actual);
                }
            }
        }
        return Collections.emptyList();
    }

    private static boolean esValido(int x, int y, int filas, int columnas, int[][] laberinto, boolean[][] visitado) {
        return x >= 0 && x < filas && y >= 0 && y < columnas && laberinto[x][y] == 0 && !visitado[x][y];
    }

    private static List<int[]> construirCamino(Map<Nodo, Nodo> padres, Nodo meta) {
        List<int[]> camino = new ArrayList<>();
        Nodo actual = meta;

        while (actual != null) {
            camino.add(new int[]{actual.x, actual.y});
            actual = padres.get(actual);
        }
        Collections.reverse(camino);
        return camino;
    }

    public static void main(String[] args) {
        int[][] laberinto = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 0, 1, 0},
            {0, 0, 0, 0, 0}
        };

        int inicioX = 0, inicioY = 0, metaX = 4, metaY = 4;
        List<int[]> camino = resolverLaberinto(laberinto, inicioX, inicioY, metaX, metaY);

        if (!camino.isEmpty()) {
            System.out.println("Camino más corto: " + (camino.size() - 1) + " pasos.");
            for (int[] paso : camino) {
                System.out.println("Paso: (" + paso[0] + ", " + paso[1] + ")");
            }
        } else {
            System.out.println("No hay camino posible.");
        }
    }
}

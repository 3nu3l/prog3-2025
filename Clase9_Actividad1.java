/*Actividad 1

Desarrollar un programa que permita analizar y maximizar la ganancia de compra
y venta de acciones utilizando programación dinámica.
Contexto: Un inversionista quiere comprar y vender acciones de una empresa con
un número máximo de transacciones K. Dado un conjunto de precios históricos de
la acción, debe determinar la máxima ganancia posible siguiendo estas reglas:
Puede comprar y vender la acción hasta K veces.
No puede comprar sin haber vendido antes una acción anterior.
Debe encontrar la mejor estrategia para maximizar su ganancia.

Ejemplo

Supongamos que tenemos los siguientes precios de la acción de IBM durante 7
días:
Día: 0 1 2 3 4 5 6
Precios: 150 155 160 158 165 172 170
Si el inversionista tiene K = 2 transacciones, la mejor estrategia es:
Comprar en el día 0 (150) y vender en el día 2 (160) → Ganancia: 10
Comprar en el día 3 (158) y vender en el día 5 (172) → Ganancia: 14
Ganancia total máxima = 10 + 14 = 24
Objetivo: Implementar un programa en Java que descargue los precios históricos
de una acción usando una API y luego aplique programación dinámica para
calcular la máxima ganancia posible con K transacciones.

Paso 1: Conectar con la API de Alpha Vantage

Para obtener los datos de precios de las acciones, utilizaremos la API de Alpha
Vantage.
Crear una cuenta gratuita en Alpha Vantage y obtener una API Key.
Hacer una solicitud HTTP para obtener los precios diarios de una acción en
formato JSON.
Ejemplo:
https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=IBM
&apikey=tu_key

Paso 2: Convertir la Respuesta JSON a un Formato
Utilizable

Utilizaremos la biblioteca Gson (gson-2.8.2.jar) para convertir el JSON en un
objeto Java y extraer los valores de cierre de cada día.

// Convertir la respuesta en un objeto JSON usando Gson 2.8.2
JsonParser parser = new JsonParser();
JsonObject jsonResponse = parser.parse(response.toString()).getAsJsonObject();

// Extraer los datos de "Time Series (Daily)"
JsonObject timeSeries = jsonResponse.getAsJsonObject("Time Series (Daily)");
TreeMap<String, Double> sortedPrices = new TreeMap<>();

Paso 3: Implementar el Algoritmo de Programación
Dinámica

Definir la tabla dp[k][i] donde k es el número de transacciones y i el día.
Usar la ecuación de recurrencia:
dp[k][i]=max(dp[k][i−1],P[i]+max(dp[k−1][j]−P[j]))
Llenar la tabla dinámicamente y encontrar el valor máximo en dp[K][n-1]. */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

public class Clase9_Actividad1 {

    private static final String API_KEY = "DNR3BEPNEFE3QPG8";
    private static final String SYMBOL = "IBM";
    private static final String URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + SYMBOL + "&apikey=" + API_KEY;

    public static String getStockPrices() throws Exception {
        URL url = new URL(URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        conn.disconnect();
        return content.toString();
    }

    public static TreeMap<String, Double> parseJson(String jsonResponse) {
        TreeMap<String, Double> sortedPrices = new TreeMap<>();
        String[] lines = jsonResponse.split("\n");

        for (String line : lines) {
            if (line.trim().startsWith("\"")) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    String date = parts[0].trim().replace("\"", "").replace(",", "");
                    double closePrice = Double.parseDouble(parts[1].trim().replace("\"", "").replace(",", ""));
                    sortedPrices.put(date, closePrice);
                }
            }
        }
        return sortedPrices;
    }

    public static int maxProfit(int K, int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;

        int[][] dp = new int[K + 1][n];

        for (int k = 1; k <= K; k++) {
            int maxDiff = -prices[0];
            for (int i = 1; i < n; i++) {
                dp[k][i] = Math.max(dp[k][i - 1], prices[i] + maxDiff);
                maxDiff = Math.max(maxDiff, dp[k - 1][i] - prices[i]);
            }
        }
        return dp[K][n - 1];
    }

    public static void main(String[] args) throws Exception {
        String jsonResponse = getStockPrices();
        TreeMap<String, Double> sortedPrices = parseJson(jsonResponse);

        int[] prices = sortedPrices.values().stream().mapToInt(Double::intValue).toArray();
        int K = 2; // Número de transacciones permitidas

        int maxProfit = maxProfit(K, prices);
        System.out.println("La ganancia máxima posible con " + K + " transacciones es: " + maxProfit);
    }
}
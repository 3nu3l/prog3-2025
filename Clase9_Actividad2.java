/*Actividad 2

A la actividad 1, agregar opción para elegir la empresa (símbolo de acción) antes
de hacer la consulta. */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Clase9_Actividad2 {

    private static final String API_KEY = "DNR3BEPNEFE3QPG8.";

    public static String getStockPrices(String symbol) throws Exception {
        String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + API_KEY;
        URL url = new URL(urlString);
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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el símbolo de la acción: ");
        String symbol = scanner.nextLine().toUpperCase();

        String jsonResponse = getStockPrices(symbol);
        TreeMap<String, Double> sortedPrices = parseJson(jsonResponse);

        int[] prices = sortedPrices.values().stream().mapToInt(Double::intValue).toArray();
        int K = 2; // Número de transacciones permitidas

        int maxProfit = maxProfit(K, prices);
        System.out.println("La ganancia máxima posible con " + K + " transacciones es: " + maxProfit);
    }
}

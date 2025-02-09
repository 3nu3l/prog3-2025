package clase5.ejercicios;
/** Ejercicio  4*/
import java.io.*;
import java.util.*;


public class Solution {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        Arrays.sort(c);
        int total = 0;
        int cantidadFlores = 0; 
    
        for (int i = c.length - 1; i >= 0; i--) { 
            total += (cantidadFlores / k + 1) * c[i];
            cantidadFlores++;
        }
    
        return total;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // Lo saco por que no se para que sirve y el programa no corre =) //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] c = new int[n];
        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?"); //Esto es REGEX??!

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);
        System.out.println(minimumCost);

        /*IDEM CON ESTO
        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();
         */
        scanner.close();
    }
}

package Ejercicio5SumaRecursiva;

public class SumaRecursiva {

	 public static int suma(int n) {
	        if (n == 0) return 0; // Caso base
	        return n + suma(n - 1); // Llamado recursivo
	    }

	    public static void main(String[] args) {
	        int numero = 5; 
	        System.out.println("Suma de los primeros " + numero + " números: " + suma(numero));
	    }
}


//Análisis Recurrencia.Igual que el factorial pero con distinta operación.
/*
T(n)=T(n−1)+O(1)
T(n)=(T(n−2)+O(1))+O(1)=T(n−2)+2⋅O(1)
T(n)=(T(n−3)+O(1))+2⋅O(1)=T(n−3)+3⋅O(1)
                  .
                  .
                  .
T(n)=T(n−k)+k⋅O(1)
T(n)=T(0)+n⋅O(1)
T(n)=O(1)+n⋅O(1)=(n+1)⋅O(1)

   Resultado= T(n)=O(n)
*/
public class Ejercicio1CalcularPromedioMatriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matriz = {{4,5, 6},{7,8,9},{5,6,7}}; //O(1)  //1
		double suma = 0;  //O(1)  // 1
		
		
		//O(n^2)
		for (int i = 0;i< matriz.length;i++) {				//O(n)  // 1 + 2(n+1) + n = 3+ 3n 
			for(int j=0; j<matriz[i].length; j++) {			//O(n)  // 1 + 2(n+1) + n = 3+ 3n 
				suma = suma+ matriz[i][j];					//O(1)  // 2n
			}
		}
		
		double promedio = ((double) suma / (matriz.length*matriz[0].length)); //O(1) //2
		System.out.println("El promedio de los valores de la matriz es igual a = " + promedio); //O(1) //2
	}
	
}

// f(n)=  1 + 3 + 3n + n (3 + 3n + 2n) + 2 + 2 = 6 + 3n + n (3+5n)
// f(n)= 6 + 3n + 3n + 5n^2 = 6 +6n + 5n^2
// lo importante es que el ciclo es n veces.

//Demostración
// 6 +6n + 5n^2 <= c n^2 buscando c y n0, dividimos ambos términos por n^2
// 6/n^2 + 6n/n^2 + 5n^2/n^2 <= c n^2/n^2
// Simplificando 6/n^2 + 6n/n^2 + 5 <= c
// Para n = 1       6 + 6 + 5 <= 17
// Para n = 2       6/4 + 6 * 2/4 + 5 <= 17 
// Elegimos c= 17
// Por lo que f(n) = 6 + 6n + 5n^2 pertenece a O(n^2) para c = 17 y n0 = 1

//f(n)= O(n^2)
//ComplejidadCuadratica
//n = la cantidad de elemento de la matriz
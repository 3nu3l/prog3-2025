/*
 * ¿Cómo funciona el backtracking en este problema?
El backtracking es una técnica de búsqueda que prueba todas las posibles soluciones y retrocede cuando encuentra una solución incorrecta. En el problema de las N reinas, el algoritmo intenta colocar una reina en cada fila del tablero de manera que ninguna 
reina pueda atacar a otra.

¿Qué pasa cuando el algoritmo encuentra una solución?
Cuando el algoritmo encuentra una solución (es decir, ha colocado una reina en cada fila sin conflictos), retorna true y el tablero se imprime mostrando la posición de las reinas.

¿Qué ocurre cuando no puede colocar más reinas?
Si el algoritmo no puede colocar una reina en una fila sin conflictos, retorna false y retrocede a la fila anterior para intentar una nueva posición para la reina de esa fila.

¿Qué sucede en el código cuando el algoritmo "retrocede"?
Cuando el algoritmo retrocede, descoloca la reina de la posición actual (board[row][col] = 0) y prueba la siguiente columna en la misma fila. Este proceso continúa hasta que encuentra una posición válida o agota todas las opciones.

¿Qué modificaciones harías para aumentar N a 8? ¿Cómo crees que cambiaría el tiempo de ejecución?
Para cambiar el tamaño del tablero a 8x8, simplemente modifica la constante N a 8:
private static final int N = 8;
El tiempo de ejecución cambiará significativamente. El problema de las N reinas tiene una complejidad exponencial, por lo que aumentar el tamaño del tablero incrementa drásticamente el número de posibles configuraciones que el algoritmo debe explorar.
Para N=8, el algoritmo aún es manejable, pero para valores mucho mayores, el tiempo de ejecución puede volverse prohibitivo.

¿Por qué el método isSafe es crucial en este algoritmo?
El método isSafe es crucial porque verifica si es seguro colocar una reina en una posición dada. Sin esta verificación, el algoritmo podría colocar reinas en posiciones que se atacan entre sí, lo que llevaría a soluciones incorrectas. 
isSafe asegura que cada reina colocada no esté en la misma columna, ni en la misma diagonal que otra reina ya colocada.
 * 
 */
package Actividad1;




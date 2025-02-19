Explicación del problema del viajante
El problema del viajante (o problema del vendedor viajero) plantea la siguiente pregunta: dada una lista de ciudades y las distancias entre cada par de ellas, 
¿cuál es la ruta más corta posible que visita cada ciudad exactamente una vez y regresa a la ciudad de origen? Este problema es NP-Hard y es muy importante en la optimización combinatoria, la investigación operativa y las ciencias de la computación.

Cálculo de las combinaciones posibles para 15 ciudades
Para calcular el número de combinaciones posibles de rutas para 15 ciudades, se utiliza el factorial de 15 (15!). Esto se debe a que el viajante puede visitar las ciudades en cualquier orden.

15!=15×14×13×12×11×10×9×8×7×6×5×4×3×2×1=1,307,674,368,000

Por lo tanto, hay 1,307,674,368,000 combinaciones posibles para 15 ciudades.

Métodos heurísticos para resolver el problema del viajante
En la página de Wikipedia se mencionan varios métodos heurísticos para abordar el problema del viajante1:

Algoritmo del vecino más cercano: Este método selecciona la ciudad más cercana no visitada como el siguiente destino. Es simple pero no siempre produce la ruta más corta.

Algoritmo de inserción: Inserta ciudades en la ruta de manera que el aumento en la longitud total del recorrido sea mínimo.

Optimización por colonia de hormigas: Inspirado en el comportamiento de las hormigas, este método utiliza feromonas para guiar la búsqueda de rutas más cortas.

Algoritmos genéticos: Utilizan técnicas de evolución y selección natural para encontrar soluciones aproximadas al problema.

Recocido simulado: Emula el proceso de enfriamiento de metales para encontrar una solución aproximada, permitiendo movimientos que empeoran la solución temporalmente para evitar mínimos locales.

Estos métodos heurísticos son útiles para encontrar soluciones aproximadas en un tiempo razonable, especialmente cuando el número de ciudades es grande y los métodos exactos se vuelven impracticables.
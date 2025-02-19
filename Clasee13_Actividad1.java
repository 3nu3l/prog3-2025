/*
 * Actividad 1

Consigna:
Escenario conceptual: Imagina que estás diseñando un sistema de detección de
ciberataques para proteger una plataforma web. Este sistema debe identificar posibles
acciones maliciosas que un atacante pueda intentar realizar sobre la plataforma.
1. Indicar algunos ejemplos de Acciones posibles del atacante:
2. Indicar las Funciones del sistema de detección A su vez, el sistema de detección de
ataques debe reaccionar para intentar evitar o mitigar estas acciones. ¿Qué técnicas o
herramientas puede usar el sistema para detectar estos ataques?
3. Explicar cómo se aplicaría la poda alfa-beta
4. Construir un árbol de decisión simplificado


1. Ejemplos de Acciones posibles del atacante:
* Inyección SQL: Intentar insertar código SQL malicioso en formularios de entrada para acceder o manipular la base de datos.
* Cross-Site Scripting (XSS): Inyectar scripts maliciosos en páginas web vistas por otros usuarios.
* Ataques de fuerza bruta: Intentar adivinar contraseñas mediante la prueba de múltiples combinaciones.
* Phishing: Enviar correos electrónicos fraudulentos para engañar a los usuarios y obtener información confidencial.
* Denegación de servicio (DoS): Sobrecargar el servidor con tráfico para hacerlo inaccesible.

2. Funciones del sistema de detección y técnicas/herramientas:
Monitoreo de tráfico: Analizar el tráfico de red en busca de patrones sospechosos.
Análisis de logs: Revisar los registros del servidor para detectar actividades inusuales.
Sistemas de detección de intrusos (IDS): Utilizar herramientas como Snort o Suricata para identificar comportamientos anómalos.
Firewalls: Configurar reglas para bloquear tráfico malicioso.
Autenticación multifactor (MFA): Añadir capas adicionales de seguridad para verificar la identidad de los usuarios.

3. Concepto de Poda Alfa-Beta en Detección de Ciberataques
Evaluación de Patrones:

En el método isSqlInjection, se evalúan los patrones de inyección SQL uno por uno. 
Si se encuentra un patrón que coincide, se puede considerar que el nodo (patrón) ha sido evaluado y se puede "podar" el resto de los patrones, ya que ya se ha detectado una inyección SQL.

Optimización de la Búsqueda:

La idea es que una vez que se detecta un patrón malicioso, no es necesario seguir evaluando otros patrones. 
Esto es similar a la poda alfa-beta, donde se descartan ramas del árbol de decisión que no pueden mejorar el resultado actual.

En este ejemplo, la poda se realiza cuando se detecta un patrón de inyección SQL, evitando la evaluación de patrones adicionales. 
Aunque no es una implementación directa de la poda alfa-beta, el concepto de optimización y reducción de evaluaciones innecesarias es similar.


4.Árbol de decisión:
                          ¿Entrada de usuario?
                          /           \
                    Sí                  No
                   /                      \
        ¿Contiene caracteres          No acción
        especiales? (', ", --, etc.)
        /           \
      Sí             No
     /                 \
¿Coincide con         No acción
patrones de
inyección SQL?
/           \
Sí             No
/                 \
Bloquear         Permitir
solicitud        solicitud
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class Clasee13_Actividad1 {

    // Lista de patrones de inyección SQL
    private static final List<String> sqlInjectionPatterns = new ArrayList<>();

    static {
        sqlInjectionPatterns.add("'");
        sqlInjectionPatterns.add("\"");
        sqlInjectionPatterns.add("--");
        sqlInjectionPatterns.add(";");
        sqlInjectionPatterns.add("/*");
        sqlInjectionPatterns.add("*/");
    }

    public static void main(String[] args) {
        String userInput = "SELECT * FROM users WHERE username = 'admin' --";

        if (isSqlInjection(userInput)) {
            System.out.println("Posible ataque de inyección SQL detectado. Solicitud bloqueada.");
        } else {
            System.out.println("Solicitud permitida.");
        }
    }

    // Método para detectar inyección SQL
    private static boolean isSqlInjection(String input) {
        for (String pattern : sqlInjectionPatterns) {
            if (input.contains(pattern)) {
                return true;
            }
        }
        return false;
    }
}
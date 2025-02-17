package Actividad1;

import java.util.ArrayList;
import java.util.List;

public class CyberAttackDetection {

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

package com.ciencias.modelado.rsa;

import java.math.BigInteger;

/**
 * Clase principal del programa.
 */
public class Main {
    // Entero positivo A.
    private static BigInteger a;
    // Entero positivo B.
    private static BigInteger b;
    // Numero primo.
    private static BigInteger p;

    /**
     * Método que imprime la forma de uso de este programa.
     */
    private static void uso() {
        System.out.println("Uso del programa: ");
        System.out.println("  java -jar target/rsa.jar A B P");
        System.out.println("  A -- Numero entero positivo");
        System.out.println("  B -- Numero entero positivo");
        System.out.println("  P -- Numero Primo");
        System.exit(1);
    }

    /**
     * Método para revisar los argumentos de entrada del programa sean correctos
     * para su ejecución.
     * 
     * @param args Argumentos del programa.
     */
    private static void revisaArgumentos(String[] args) {
        // Verificamos la cantidad de argumentos del programa.
        if (args.length != 3)
            uso();

        // Intentamos incializar los enteros y el numero primo.
        try {
            a = new BigInteger(args[0]);
            b = new BigInteger(args[1]);
            p = new BigInteger(args[2]);

        } catch (NumberFormatException e) { // Si el argumento no es un numero.
            uso();
        }

        // Verificamos que A y B no sean negativos.
        BigInteger cero = new BigInteger("0");
        if (a.compareTo(cero) < 0 || b.compareTo(cero) < 0)
            uso();
    }

    /**
     * Método principal del programa donde ocurre la ejecución del mismo.
     * 
     * @param args Parámetros necesarios para la ejecución correcta del programa.
     */
    public static void main(String[] args) {
        // Revisamos que los argumentos sean los adecuados.
        revisaArgumentos(args);

        // Implementamos el Algoritmo de Euclides
        BigInteger[] valores = Euclides.euclidesExtendido(a, b, p);
        BigInteger mcd = valores[0];
        BigInteger s = valores[1];
        BigInteger t = valores[2];

        // Impresión de los resultados
        System.out.println("Valores:");
        System.out.println("  A = " + a);
        System.out.println("  B = " + b);
        System.out.println("  P = " + p);

        System.out.println("Máximo Común Divisor:");
        System.out.printf("  MCD(%d, %d) = %d \n", a, b, mcd);

        System.out.println("Coeficientes:");
        System.out.println("  C1 = " + s);
        System.out.println("  C2 = " + t);

        System.out.println("Combinación Lineal:");
        System.out.printf("  %d * %d + %d * %d = %d \n", a, s, b, t, mcd);

    }
}

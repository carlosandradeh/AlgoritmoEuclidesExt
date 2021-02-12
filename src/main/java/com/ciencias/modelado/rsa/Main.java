package com.ciencias.modelado.rsa;

import java.math.BigInteger;

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
        if (a.compareTo(cero) < 0  || b.compareTo(cero) < 0) 
            uso();
    }

    /**
     * Método principal del programa donde ocurre la ejecución del mismo.
     * 
     * @param args Parámetros necesarios para la ejecución correcta del programa.
     */
    public static void main(String[] args) {
        //Revisamos que los argumentos sean los adecuados.
        revisaArgumentos(args);

        //Imprimimos.
        System.out.println("Soy a: " + a);
        System.out.println("Soy b: " + b);
        System.out.println("Soy p: " + p);
    }
}

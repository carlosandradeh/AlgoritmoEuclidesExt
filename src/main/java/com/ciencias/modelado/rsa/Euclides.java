package com.ciencias.modelado.rsa;

import java.math.BigInteger;

/**
 * Clase que contiene los algoritmos de Euclides para el desarrollo del
 * programa.
 */
public class Euclides {

    /**
     * Algoritmo de Euclides extendido. Regresa el máximo compun divisor de dos números y su combinación lineal.
     * MCD(a, b) = a(s) + b(t).
     * @param a Numero entero positivo arbitrariamente grande.
     * @param b Numero entero positivo arbitrariamente grande.
     * @param p NUmero primo arbitrariamente grande.
     * @return BigInteger[] Arreglo con los valores [MCD(a,b), s, t].
     */
    public static BigInteger[] euclidesExtendido(BigInteger a, BigInteger b, BigInteger prime) {
        // Verificamos que no sean null los parámetros.
        if (a == null || b == null)
            throw new IllegalArgumentException("No puedes usar null en el algoritmo de Euclides");

        // TODO: Implementación del Algoritmo Extendido de Euclides.
        BigInteger ONE = BigInteger.ONE;
        BigInteger ZERO = BigInteger.ZERO;
        
        /*
         * Obtenemos el valor positivo del número primo, 
         * podemos hacer esto por que la operación mod p es equivalente a mod -p.
         */
        BigInteger p = prime.abs();

        // Residuos de las divisiones del algoritmo de Euclides:
        // Residuo con índice actual.
        BigInteger r = ZERO;
        // Si a es negativo, a % p será negativo, solucionamos esto más adelante.
        // Residuo con índice -1.
        BigInteger r1 = a.mod(p);
        // Si b es negativo, b % p será negativo, solucionamos esto más adelante.
        // Residuo con índice -2.
        BigInteger r2 = b.mod(p);

        // Cociente con índice -1.
        BigInteger q1 = ZERO;

        // Factores asociados a la variable más grande:
        // Índice actual.
        BigInteger s = ZERO;
        // Índice -1.
        BigInteger s1 = ZERO;
        // Índice -2.
        BigInteger s2 = ONE;

        // Factores asociados a la variable más pequeña:
        // Índice actual.
        BigInteger t = ZERO;
        // Índice -1.
        BigInteger t1 = ONE;
        // Índice -2.
        BigInteger t2 = ZERO;

        // Valor booleano para saber en que orden se regresaran los datos de salida.
        boolean orden = false;

        // MCD(0, 0) no está matemáticamente definido.
        if(r1.equals(ZERO) && r2.equals(ZERO))
            throw new IllegalArgumentException("MCD(0, 0) is not defined.");
        // Si uno de los enteros es 0, entonces el MCD(x, 0) = x, siempre que x no sea 0.
        if(r1.equals(ZERO))
            return new BigInteger[]{r2, ZERO, ONE};
        if(r2.equals(ZERO))
            return new BigInteger[]{r1, ONE, ZERO};

        /* Nos aseguramos de estar tomando valores positivos equivalentes a a y b (mod p).
         * Necesitamos trabajar con números positivos para el correcto funcionamiento del programa.
         */
        if(r1.compareTo(ZERO) < 0)
            r1 = r1.add(p);
        if(r2.compareTo(ZERO) < 0)
            r2 = r2.add(p);

        // Nos aseguramos que r2 > r1. En caso que no lo sean, intercambiamos los valores.
        if(r2.compareTo(r1) < 0){
            BigInteger aux = r1;
            r1 = r2;
            r2 = aux;
            // Si ocurre un intercambio, cambiamos el orden de los datos de salida.
            orden = true;
        }

        // Algoritmo de Euclides extendido.
        do{
            r = r2 .mod(r1);
            q1 = (r2.subtract(r)).divide(r1);
            s = s2.subtract(q1.multiply(s1));
            t = t2.subtract(q1.multiply(t1));
            // Actualizamos las variables.
            r2 = r1;
            r1 = r;
            s2 = s1;
            s1 = s;
            t2 = t1;
            t1 = t;
        }while(!r.equals(ZERO));

        // Verificamos el orden de entrada de los argumentos para regresar el arreglo en orden.
        if(orden)
            return new BigInteger[]{r2, s2, t2};
        return new BigInteger[]{r2, t2, s2};
    }
}

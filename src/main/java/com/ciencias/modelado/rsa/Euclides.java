package com.ciencias.modelado.rsa;

import java.math.BigInteger;

/**
 * Clase que contiene los algoritmos de Euclides para el desarrollo del
 * programa.
 */
public class Euclides {

    /**
     * Algoritmo de Euclides extendido.
     * 
     * @param a Numero entero positivo (Mayor) arbitrariamente grande.
     * @param b Numero entero positivo arbitrariamente grande.
     * @param p NUmero primo arbitrariamente grande.
     * @return BigInteger[] Arreglo con los valores [MCD(a,b), s, t].
     */
    public static BigInteger[] euclidesExtendido(BigInteger a, BigInteger b, BigInteger p) {
        // Verificamos que no sean null los parámetros.
        if (a == null || b == null)
            throw new IllegalArgumentException("No puedes usar null en el algoritmo de Euclides");

        // TODO: Implementación del Algoritmo Extendido de Euclides.
        return null;
    }
}

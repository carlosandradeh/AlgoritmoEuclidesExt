Algoritmo de Euclides Extendido.
====================
### Authors 
- Carlos Andrade Hernández
- Demian Alejandro Monterrubio Acosta

### Introducción
El algoritmo de Euclides es un método antiguo y eficiente para calcular el máximo común divisor (MCD). Fue originalmente descrito por Euclides en su obra Elementos. El algoritmo de Euclides extendido es una ligera modificación que permite además expresar al máximo común divisor como una combinación lineal. Este algoritmo tiene aplicaciones en diversas áreas como álgebra, teoría de números y ciencias de la computación, entre otras. Con unas ligeras modificaciones suele ser utilizado en computadoras electrónicas debido a su gran eficiencia.

### Entrada

$ java -jar target/euclidesExtendido.jar A B P

A -- Numero entero positivo

B -- Numero entero positivo

P -- Numero Primo

### Salida

Valores:

  A

  B

  P

Máximo Común Divisor:

  MCD(A, B) 

Coeficientes:
  
  C1
  
  C2

Combinación Lineal:
  
  A * C1 + B * C2 = MCD (mod P)


### Para correr este programa:
Maven Website : https://maven.apache.org/
Se debe tener instalado Maven : https://maven.apache.org/download.cgi

```
$ mvn clean
$ mvn compile
$ mvn install  

$ java -jar target/euclidesExtendido.jar A B P

```
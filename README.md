# Sistema solar - Examen de ingreso Mercado Libre
Desarrollé el sistema solicitado usando Java 8, Maven, testNG y Mockito.

Por cuestiones de tiempo, no llegué a desarrollar el Bonus.

### Decisiones de implementación:≈
  - Si dos dias seguidos comparten el *pronostico* forman parte del mismo periodo, y no son dos periodos distintos.
  - En el ejercicio pide calcular los proximos 10 años. Dado que un año esta definido por cuanto tarda un planeta en dar una vuelta al sol y en este sistema habia 3 planetas con distinto radio y velocidad, asumi que un año eran 365 dias (y que no hay bisiestos).
  - Los planetas, en el dia 0, comienzan alineados arriba del sol, tal como lo muestra el PDF.

## Tests
Se pueden correr los tests corriendo el archivo run-all.xml dentro de la carpeta test/resources.

## Aplicación
Para obtener los pronosticos de los proximos 10 años, basta con correr la aplicación dado que el ```main``` los imprime en formato *human-readable*.

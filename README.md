# congreso-politico
Proyecto de congreso político para la clase de POO

El congreso del estado desea contar con un sistema que le permita tener el control de registo de los políticos que lo conforman. 

En un congreso, sesionan gobernadores(as), diputados(as), senadores(as) conforme al tema que trate la sesión correspondiente. 
El sistema debe permitir almacenar: 

1) los datos demográficos de cada político (nombre completo, género, edad, grado académico, ciudad de residencia)
 
2) los datos del partido y la entidad que representa (año en el que inicio en la política, nombre del partido político, 
la entidad que representa (nombre de la ciudad o estado))
 
3) su salario mensual y salario anual. 

Cabe resaltar que, para determinar el salario mensual de un gobernador, se calcula al multiplicar el salario mínimo del año actual por 520 o 550 
el salario mensual de un diputado, se calcula al multiplicar el salario mínimo del año actual por 420 o 450; 
mientras que el salario de un senador, se calcula al multiplicar el salario mínimo del año actual por 588 o 598. 
Si el político pertenece a una entidad de la zona norte del país, entonces se multiplica por el valor más alto. 
Mientras que, el salario anual se calcula al multiplicar por 12 el salario mensual.

El presidente del congreso del estado, desea tener un sistema que le permita:
1. Determinar el salario mínimo actual. 
2. Dar de alta a un gobernador.
3. Dar de alta a un diputado.
4. Dar de alta a un senador.
5. Listar los datos demográficos del gobernador, diputado y senador que gana más. 
6. Calcular y imprimir el salario promedio mensual de los diputados.
7. Calcular e imprimir el nombre completo, entidad y partido político de quien gana menos. 
8. Determinar el gasto anual en México para el pago todos los gobernadores, los diputados y los senadores.
9. Listar (organizados por apellido paterno), a todos los gobernadores, diputados y senadores dados de alta en el sistema.
10. Salir

Restricciones:

a) la opción 1 se ejecuta 1 vez al día.

b) las opciones 2, 3 y 4 se pueden ejecutar sólo si ya se realizó la opción 1.

c) las opciones 5, 6, 7, 8 y 9, no se realizarán si no se ha dado de alta al menos a un gobernador, a un diputado y a un senador 
(se debe dar ese mensaje al usuario).

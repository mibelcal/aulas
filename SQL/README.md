# EJERCICIOS EMPLEADOS

## 1. Consultas sobre una tabla
Lista el primer apellido de todos los empleados.

Lista el primer apellido de los empleados eliminando los apellidos que estén repetidos.

Lista todas las columnas de la tabla empleado.

Lista el nombre y los apellidos de todos los empleados.

Lista el identificador de los departamentos de los empleados que aparecen en la tabla empleado.

Lista el identificador de los departamentos de los empleados que aparecen en la tabla empleado, eliminando los identificadores que aparecen repetidos.

Lista el nombre y apellidos de los empleados en una única columna.

Lista el nombre y apellidos de los empleados en una única columna, convirtiendo todos los caracteres en mayúscula.

Lista el nombre y apellidos de los empleados en una única columna, convirtiendo todos los caracteres en minúscula.

Lista el identificador de los empleados junto al nif, pero el nif deberá aparecer en dos columnas, una mostrará únicamente los dígitos del nif y la otra la letra.

Lista el nombre de cada departamento y el valor del presupuesto actual del que dispone. Para calcular este dato tendrá que restar al valor del presupuesto inicial (columna presupuesto) los gastos que se han generado (columna gastos). Tenga en cuenta que en algunos casos pueden existir valores negativos. Utilice un alias apropiado para la nueva columna columna que está calculando.

Lista el nombre de los departamentos y el valor del presupuesto actual ordenado de forma ascendente.

Lista el nombre de todos los departamentos ordenados de forma ascendente.

Lista el nombre de todos los departamentos ordenados de forma descendente.

Lista los apellidos y el nombre de todos los empleados, ordenados de forma alfabética tendiendo en cuenta en primer lugar sus apellidos y luego su nombre.

Devuelve una lista con el nombre y el presupuesto, de los 3 departamentos que tienen mayor presupuesto.

Devuelve una lista con el nombre y el presupuesto, de los 3 departamentos que tienen menor presupuesto.

Devuelve una lista con el nombre y el gasto, de los 2 departamentos que tienen mayor gasto.

Devuelve una lista con el nombre y el gasto, de los 2 departamentos que tienen menor gasto.

Devuelve una lista con 5 filas a partir de la tercera fila de la tabla empleado. La tercera fila se debe incluir en la respuesta. La respuesta debe incluir todas las columnas de la tabla empleado.

Devuelve una lista con el nombre de los departamentos y el presupuesto, de aquellos que tienen un presupuesto mayor o igual a 150000 euros.

Devuelve una lista con el nombre de los departamentos y el gasto, de aquellos que tienen menos de 5000 euros de gastos.

Devuelve una lista con el nombre de los departamentos y el presupuesto, de aquellos que tienen un presupuesto entre 100000 y 200000 euros. Sin utilizar el operador BETWEEN.

Devuelve una lista con el nombre de los departamentos que no tienen un presupuesto entre 100000 y 200000 euros. Sin utilizar el operador BETWEEN.

Devuelve una lista con el nombre de los departamentos que tienen un presupuesto entre 100000 y 200000 euros. Utilizando el operador BETWEEN.

Devuelve una lista con el nombre de los departamentos que no tienen un presupuesto entre 100000 y 200000 euros. Utilizando el operador BETWEEN.

Devuelve una lista con el nombre de los departamentos, gastos y presupuesto, de aquellos departamentos donde los gastos sean mayores que el presupuesto del que disponen.

Devuelve una lista con el nombre de los departamentos, gastos y presupuesto, de aquellos departamentos donde los gastos sean menores que el presupuesto del que disponen.

Devuelve una lista con el nombre de los departamentos, gastos y presupuesto, de aquellos departamentos donde los gastos sean iguales al presupuesto del que disponen.

Lista todos los datos de los empleados cuyo segundo apellido sea NULL.

Lista todos los datos de los empleados cuyo segundo apellido no sea NULL.

Lista todos los datos de los empleados cuyo segundo apellido sea López.

Lista todos los datos de los empleados cuyo segundo apellido sea Díaz o Moreno. Sin utilizar el operador IN.

Lista todos los datos de los empleados cuyo segundo apellido sea Díaz o Moreno. Utilizando el operador IN.

Lista los nombres, apellidos y nif de los empleados que trabajan en el departamento 3.

Lista los nombres, apellidos y nif de los empleados que trabajan en los departamentos 2, 4 o 5.

## 2. Consultas multitabla (Composición interna)
* Resuelve todas las consultas utilizando la sintaxis de SQL1 y SQL2.

Devuelve un listado con los empleados y los datos de los departamentos donde trabaja cada uno.

Devuelve un listado con los empleados y los datos de los departamentos donde trabaja cada uno. Ordena el resultado, en primer lugar por el nombre del departamento (en orden alfabético) y en segundo lugar por los apellidos y el nombre de los empleados.

Devuelve un listado con el identificador y el nombre del departamento, solamente de aquellos departamentos que tienen empleados.

Devuelve un listado con el identificador, el nombre del departamento y el valor del presupuesto actual del que dispone, solamente de aquellos departamentos que tienen empleados. El valor del presupuesto actual lo puede calcular restando al valor del presupuesto inicial (columna presupuesto) el valor de los gastos que ha generado (columna gastos).

Devuelve el nombre del departamento donde trabaja el empleado que tiene el nif 38382980M.

Devuelve el nombre del departamento donde trabaja el empleado Pepe Ruiz Santana.

Devuelve un listado con los datos de los empleados que trabajan en el departamento de I+D. Ordena el resultado alfabéticamente.

Devuelve un listado con los datos de los empleados que trabajan en el departamento de Sistemas, Contabilidad o I+D. Ordena el resultado alfabéticamente.

Devuelve una lista con el nombre de los empleados que tienen los departamentos que no tienen un presupuesto entre 100000 y 200000 euros.

Devuelve un listado con el nombre de los departamentos donde existe algún empleado cuyo segundo apellido sea NULL. Tenga en cuenta que no debe mostrar nombres de departamentos que estén repetidos.

## 3. Consultas multitabla (Composición externa)
* Resuelve todas las consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.

Devuelve un listado con todos los empleados junto con los datos de los departamentos donde trabajan. Este listado también debe incluir los empleados que no tienen ningún departamento asociado.

Devuelve un listado donde sólo aparezcan aquellos empleados que no tienen ningún departamento asociado.

Devuelve un listado donde sólo aparezcan aquellos departamentos que no tienen ningún empleado asociado.

Devuelve un listado con todos los empleados junto con los datos de los departamentos donde trabajan. El listado debe incluir los empleados que no tienen ningún departamento asociado y los departamentos que no tienen ningún empleado asociado. Ordene el listado alfabéticamente por el nombre del departamento.

Devuelve un listado con los empleados que no tienen ningún departamento asociado y los departamentos que no tienen ningún empleado asociado. Ordene el listado alfabéticamente por el nombre del departamento.

## 4. Consultas resumen
Calcula la suma del presupuesto de todos los departamentos.

Calcula la media del presupuesto de todos los departamentos.

Calcula el valor mínimo del presupuesto de todos los departamentos.

Calcula el nombre del departamento y el presupuesto que tiene asignado, del departamento con menor presupuesto.

Calcula el valor máximo del presupuesto de todos los departamentos.

Calcula el nombre del departamento y el presupuesto que tiene asignado, del departamento con mayor presupuesto.

Calcula el número total de empleados que hay en la tabla empleado.

Calcula el número de empleados que no tienen NULL en su segundo apellido.

Calcula el número de empleados que hay en cada departamento. Tienes que devolver dos columnas, una con el nombre del departamento y otra con el número de empleados que tiene asignados.

Calcula el nombre de los departamentos que tienen más de 2 empleados. El resultado debe tener dos columnas, una con el nombre del departamento y otra con el número de empleados que tiene asignados.

Calcula el número de empleados que trabajan en cada uno de los departamentos. El resultado de esta consulta también tiene que incluir aquellos departamentos que no tienen ningún empleado asociado.

Calcula el número de empleados que trabajan en cada unos de los departamentos que tienen un presupuesto mayor a 200000 euros.

## 5. Subconsultas
### 5.1. Con operadores básicos de comparación
Devuelve un listado con todos los empleados que tiene el departamento de Sistemas. (Sin utilizar INNER JOIN).

Devuelve el nombre del departamento con mayor presupuesto y la cantidad que tiene asignada.

Devuelve el nombre del departamento con menor presupuesto y la cantidad que tiene asignada.

### 5.2. Subconsultas con ALL y ANY
Devuelve el nombre del departamento con mayor presupuesto y la cantidad que tiene asignada. Sin hacer uso de MAX, ORDER BY ni LIMIT.

Devuelve el nombre del departamento con menor presupuesto y la cantidad que tiene asignada. Sin hacer uso de MIN, ORDER BY ni LIMIT.

Devuelve los nombres de los departamentos que tienen empleados asociados. (Utilizando ALL o ANY).

Devuelve los nombres de los departamentos que no tienen empleados asociados. (Utilizando ALL o ANY).

### 5.3. Subconsultas con IN y NOT IN
Devuelve los nombres de los departamentos que tienen empleados asociados. (Utilizando IN o NOT IN).

Devuelve los nombres de los departamentos que no tienen empleados asociados. (Utilizando IN o NOT IN).

### 5.4. Subconsultas con EXISTS y NOT EXISTS
Devuelve los nombres de los departamentos que tienen empleados asociados. (Utilizando EXISTS o NOT EXISTS).

Devuelve los nombres de los departamentos que tienen empleados asociados. (Utilizando EXISTS o NOT EXISTS).
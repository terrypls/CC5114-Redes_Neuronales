# CC5114-Redes_Neuronales
Tarea 2 del curso CC5114 Redes Neuronales de la Universidad de Chile

Estarán programadas en Kotlin con el objetivo de aprender el lenguaje :3

### Instalaciones
La tarea se realizó por completo usando el IDE de Jetbrains IntelliJ, usando las librerías nativas de Kotlin provistas 
por el IDE para compilar el proyecto.

Para generar los gráficos usados se utilizó la librería [XChart](https://knowm.org/open-source/XChart/). Para su instalación
se debe descargar haciendo click en __Download version__ con la versión actual de la librería, al momento de escribir 
esto estan en la versión 3.5.4, luego descomprimir el zip y poner el archivo .jar en la carpeta .idea->libraries y haciendo click 
derecho sobre el jar apretar __Add as Library__.

### Correr el Proyecto
Se tienen 2 archivos que contienen la resolucion de las tareas pedidas. El pirmero llamado
`AGEncontrarPalabra.kt` es donde se encuentran resueltos el ejercicio para encontrar un binario
y par encontrar una palabra, se dejan un par de ejemplos con las variables correspondientes
para llegar y probar. Hay que probarlos por separado o se tendran datos con informacion cruzada.

El segundo archivo se llama `UnboundKnapsack.kt` y tiene una configuracion de variables parecida al archivo
anterior para resolver el primer problema de los propuestos en el enunciado de la tarea. Se considero como gen 
a los pares peso-valor, un individuo es un conjunto de estos genes que representa la combinacion de pares
peso-valor que se propusieron como solucion al problema de la mochila.

## Implementación y dificultades
La implementacion se realizo de manera extensible con el fin de que agregar
nuevos tipos de algoritmos geneticos fuera barato. En particular la clase `Individuo.kt` 
es igual para los 3 problemas realizados, solo hay que pasarle el tipo de cromosoma que se quiera evaluar. 

Para la clase `Poblacion.kt` se tienen 2 funciones genericas que permiten calcular el fitness y realizar la
mutacion a lo largo de los individuos de la poblacion. Para poder generar una poblacion en particular, se crean
funciones constructoras para cada uno de los tipos posibles.

La mayor dificultad de la implementacion estuvo relacionada con como establecer una forma de relalizar
el codigo extensible y ademas poder determinar la buena forma de definir la funcion de fitness de cada uno de los
problemas.

#Resultado

Se opto por analizar los resultados del problema de encontrar la palabra. Se tiene el siguiente grafico a modo de ejemplo 
para la encontrar la palabra *anitalavalatina* con una poblacion de 10 individuos.

 ![imagen](/src/Tarea2/Assets/char.png "Minimo, maximo y promedio de evolucion del algoritmo")
 
 Se observa que la distancia entre las 3 curvas se mantiene bastante pareja a lo largo de las 
 generacions. Al no tener otra implementacion de este algoritmo en particular para comparar la eficiencia
 no tengo forma de estimar que tan eficiente y efectiva quedo la implementacion realizada
 pero al menos la cantidad de iteraciones es ligeramente superior a la cantidad que esperaba.
  

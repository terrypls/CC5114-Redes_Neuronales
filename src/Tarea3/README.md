# CC5114-Redes_Neuronales
Tarea 3 del curso CC5114 Redes Neuronales de la Universidad de Chile

Estarán programadas en Kotlin con el objetivo de aprender el lenguaje :3

### Instalaciones
La tarea se realizó por completo usando el IDE de Jetbrains IntelliJ, usando las librerías nativas de Kotlin provistas 
por el IDE para compilar el proyecto.

Para generar los gráficos usados se utilizó la librería [XChart](https://knowm.org/open-source/XChart/). Para su instalación
se debe descargar haciendo click en __Download version__ con la versión actual de la librería, al momento de escribir 
esto estan en la versión 3.5.4, luego descomprimir el zip y poner el archivo .jar en la carpeta .idea->libraries y haciendo click 
derecho sobre el jar apretar __Add as Library__.

### Correr el proyecto
Los ejercicios que fueron desarrollados se encuentran en la carpeta Ejercicios. Cada uno
de ellos tiene un main en donde se encuentrar las condiciones estandar esperadas para
ejecutar la tarea en base a lo pedido en el enunciado

## Implementacion y Dificultades
La implementacion la libreria de arboles se encuentra repartida en dos partes, la
carpeta Nodos y la carpeta Arboles, ambos fueron implementados siguiendo la estructura
 de la implementacion en python propuesta en material docente del curso. 
 
 Se considera a todo nodo como un arbol en potencia, por lo que cada uno de los nodos
 se generan usando la clase AST. Esta clase se pasa como argumento a la clase Arbol(equivalente
 con la clase Individuo,de la tarea 2) que es contiene las operacion para generar las mutaciones
 y crossovers del algoritmo.
 
 La clase Bosque funciona de manera similar a la Clase Poblacion de la tarea 2, ya 
 que contendra el conjunto de arboles que se estan utilizando para resolver el problema.
 Encargada de realizar la evaluacion de la poblacion y generar las mutaciones y crossover, ademas
 recibir las funciones y terminales a usar para la resolucion del problema, que luego seran
 entregadas a un AST propio de cada arbol
 
 Cabe destacar que se implemento una variante de la funcion __toString()__ para poder tener
 un registro visual de como se estaban evaluando cada uno de los arboles, en inorden para mejor
 claridad de la estructura del arbol.
  
  Tambien se opto desde un comienzo limitar el tamaño maximo de
 los arboles de dos maneras. La primera corresponde a una condicion de tamaño maximo al momento de crea
 un bosque, y la otra es la probabilidad de que el nodo sea un nodo terminal. 
 
 
## Ejercicios
 Para el caso de los ejercicios, solo se alcanzo a implementar el primero de los propuestos,
 debido a complicaciones con el codigo y el lenguaje, ya que no se tenia conocimientos muy
 profundo de la forma que tiene Kotlin para trabajar funciones como parametros de otras funciones
 al momento de implementar la tarea.
 
 
  ![imagen](/Assets/maravillosa.jpg "Ejercicio 1")
 
 El grafico corresponde a una prueba realizada con un bosque con 50 arboles y cada uno
 con una profundidad maxima de 15
 
 

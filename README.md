# CC5114-Redes_Neuronales
Tareas del curso CC5114 Redes Neuronales de la Universidad de Chile

Estarán programadas en Kotlin con el objetivo de aprender el lenguaje :3

### Instalaciones
La tarea se realizó por completo usando el IDE de Jetbrains IntelliJ, usando las librerías nativas de Kotlin provistas 
por el IDE para compilar el proyecto.

Para generar los gráficos usados se utilizó la librería [XChart](https://knowm.org/open-source/XChart/). Para su instalación
se debe descargar haciendo click en __Download version__ con la versión actual de la librería, al momento de escribir 
esto estan en la versión 3.5.4, luego descomprimir el zip y poner el archivo .jar en la carpeta .idea->libraries y haciendo click 
derecho sobre el jar apretar __Add as Library__.

### Correr el Proyecto
Para probar la red neuronal se utilizó el dataset [Iris](https://archive.ics.uci.edu/ml/datasets/Iris). Los detalles
de la implementación y un método main para correr el programa se encuentran en la carpeta Tarea1->Red_Neuronal con el nombre
de [ClasificadorIris.kt]().



## Tarea 1: Entrenar una red Neuronal
La tarea 1 consistió en la implementación y testeo de una red neuronal, basadas en las enseñanzas aprendidas en clases.
Parte de los ejercicios realizados en clases se encuentran en la carpeta [Ejercicios]() entre los que se encuentrar implementaciones
básicas de neuronas con función de activación Step(perceptron) y Sigmoid, y los test correspondientes a la implementación de esta
en la carpeta Test->Ejercicios.
 
La red como tal fue implementada usando clases y objetos de Kotlin para el manejo de las operaciones internas de esta. El código
se dividió en 3 clases principales, [Neurona](https://github.com/terrypls/CC5114-Redes_Neuronales/blob/master/src/Tarea1/Red_Neuronal/Neurona.kt),
 [CapaNeurona](https://github.com/terrypls/CC5114-Redes_Neuronales/blob/master/src/Tarea1/Red_Neuronal/CapaNeurona.kt)
   y [RedNeuronal]( https://github.com/terrypls/CC5114-Redes_Neuronales/blob/master/src/Tarea1/Red_Neuronal/RedNeuronal.kt). La descripción de cada clase y los métodos asociados estan documentados en los archivos correspondientes.

### Análisis

#### Implementacion y dificultads
 Se prefirió la 
aproximación a clases para la implementación,debido a que era un lenguaje nuevo y la semejanza estructural que tiene Kotlin
con Java hizo
que fuera mas natural la elección de clases por sobre matrices.
Una de las principales dificultades presentadas tuvo relación con la inexperiencia con el lenguaje elegido para
implementar la tarea y en el hecho de que se prefiriera hacer una implementación en base a clases  en vez de matricial,
 debido a que la mayoría del material disponible, tanto en clases como en internet esta pensado para el segundo tipo de implementación.
=======
#### Implementacion y dificultades
Una de las principales dificultades de la implementación tuvo relacion con la inexperiencia con el lenguaje elegido
y el hecho de que se prefiriera hacer una implementación en base a clases  en vez de matricial, debido a que la mayoría del
material disponible, tanto en clases como en internet esta pensado para el segundo tipo de implementación. Se prefirió la 
aproximación a clases debido a que era un lenguaje nuevo y la semejanza estructural que tiene Kotlin  con Java hizo
que fuera mas natural la elección de clases por sobre matrices


Se prefirió crear una neurona desde 0 en vez de reutilizar las que habían sido implementadas previamente por conveniencia,
ya que había que modificar mucho código para formar una neurona util pensada para la red y modificar los test asociados 
previamente a las neuronas. El resto de la implementación se fue construyendo a base de prueba y error, y en constante comunicacion
con compañeros del curso que tambien estaban implementando la red neural en el lenguaje.

#### Eficiencia y Resultados

Basado en los resultados obtenidos luego de probar la red con el dataset de Iris, se puede observar que la red en general
 presenta problemas de implementación no identificados al momento de escribir este documento, posiblemente
relacionados con la actualización o la propagación de errores a lo largo de las capas de esta. Tampoco se descarta 
que el problema puede ser producido por una mala configuración de la red, referente a la cantidad de capas y neuronas
presentes en esta, ya que al modificar esto se observaron cambios en la distribucion de las curvas de precisión y error, 
pero con peores resultados que con la configuración que quedo en el repositorio. La configuracion mencionada
 consiste en 4 capas con [4,3,4,3] neuronas por capa respectiva. Las imagenes
a continuación corresponde a uno de las ejecuciones del programa, en particular con 100 entrenamientos, usando 80% del set
de Iris (120 datos aproximadamente) para el entrenamiento de la red y el restante para realizar las pruebas de efectividad 
de la red, en donde se iteró 10 veces sobre los datos 


Con respecto a los resultados obtenidos del entrenamiento de la red, se puede apreciar en la imagen:
 
 ![imagen](/src/Assets/Aprendizaje.png "Curva de aprendizaje") 
 
 La red no alcanza a superar el 70% de precisión en sus predicciones, con una variacion aproximada de 5% tanto hacia arriba como hacia abajo para otras 
 ejecuciones del programa. La evolución de la curva lleva a pensar que la neurona paso de predecir bien el resultado del input
 dado desde 1 cada 3 veces a 2 cada 3 veces
 
 El error se calculo usando la fórmula del error cuadrático medio, dando por resultado la siguiente imagen:
 
 ![imagen](/src/Assets/Error.png "Curva de error")
  
 Es aquí donde se nota un error grande dentro de las primeras iteracion,
 para luego ir dando paso a un error consistente con la precisión expuesta en la imagen de la curva de precisión
 
 Para las pruebas con los datos restantes, se obtuvo el siguiente gráfico:
   
  ![gráfico](/src/Assets/Test.png "Porcentaje de aciertos")
  
  De donde se obtiene que el porcentaje de aciertos es un poco menor que a la precisión final observada en el gráfico de 
  aprendizaje
  
 
  


package Tarea2

class UnboundKnapsack {
    fun encontrarOptimo(
        cantPoblacion: Int,
        largoCromosoma: Int,
        opciones: Array<Pair<Int, Int>>,
        objetivo: Int,
        pesoMaximo: Int
    ) {
        var iteracion = 0
        val poblacion = Poblacion(cantPoblacion, largoCromosoma, .6)
        poblacion.crearPoblacionMochila(objetivo, pesoMaximo, opciones)
        var valores = poblacion.fitness()
        println("empezamos")
        while (valores.second < objetivo) {
            println("Iteracion: $iteracion Menor: ${valores.first} Mayor: ${valores.second} Palabra: ${poblacion.best}")
            poblacion.evolucionar()
            valores = poblacion.fitness()
            iteracion++
        }
        println("Iteracion $iteracion Menor: ${valores.first} Mayor: ${valores.second} Palabra: ${poblacion.best}")
    }

}

fun main() {
    val opciones = arrayOf(
        Pair(0, 0),
        Pair(12, 4),
        Pair(2, 2),
        Pair(1, 2),
        Pair(1, 1),
        Pair(4, 10)
    )
    val objetivo = 36
    val pesoMaximo = 15
    val cantPoblacion = 10
    val largoCromosoma = 6
    var yo = UnboundKnapsack().encontrarOptimo(cantPoblacion, largoCromosoma, opciones, objetivo, pesoMaximo)
}
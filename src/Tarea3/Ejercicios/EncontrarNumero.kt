package Tarea3.Ejercicios

import Tarea3.*
import Tarea3.Bosque
import Tarea3.Nodos.Nodo
import kotlin.math.abs

class EncontrarNumero {
    val terminales: MutableList<Int> = mutableListOf(25, 7, 8, 100, 4, 2)
    val funciones: MutableList<(Nodo, Nodo) -> Int> = mutableListOf(Suma(), Resta(), Multi(), Max())
    val bosque: Bosque =
        Bosque(
            funcionSinLimites(),
            15,
            funciones,
            terminales,
            50,
            0.1
        )


    fun encontrarCoso(): MutableList<Double> {
        var vueltas = 0
        val listaFitness: MutableList<Double> = mutableListOf(-1.0)
        while (listaFitness.last().toInt() != 65346) {
            listaFitness.add(bosque.mejorFitness().toDouble())
            bosque.evolucionar()
            vueltas++
            when {
                vueltas % 10 == 0 -> println("vuelta $vueltas, que tan lejos estoy ${65346 - bosque.mejorFitness()}, mejor${listaFitness.last().toInt()}")
            }

        }
        println("termino ${listaFitness.last()}")
        return listaFitness
    }


}
fun main() {
    val algo = EncontrarNumero()
    val lista = algo.encontrarCoso()
    val plot = LinePlot("Sin limite de repeticiones", "Generacion", "Fitness", "fitness")
    plot.yData = lista.toDoubleArray()
    plot.draw()

}

class funcionSinLimites : (Nodo) -> Int {
    override fun invoke(p1: Nodo): Int {
        return (65346 - abs(65346 - p1.eval()))
    }
}
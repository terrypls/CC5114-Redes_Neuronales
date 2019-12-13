package Tarea3.Ejercicios

import Tarea3.*
import Tarea3.Nodos.Nodo

class EncontrarNumero {
    val terminales: MutableList<Int> = mutableListOf(25, 7, 8, 100, 4, 2)
    val funciones: MutableList<(Nodo, Nodo) -> Int> = mutableListOf(Suma(), Resta(), Multi(), Max())
    val bosque: Bosque = Bosque(funcionSinLimites(), 5, funciones, terminales, 10, 0.1)
    var objetivo: Double = Double.MAX_VALUE


    fun encontrarCoso() {
        var vuelta = 0
        objetivo = bosque.estadisticas().first
        var aux = bosque.estadisticas()

        println("Vuelta ${vuelta} Peor ${aux.second} Mejor ${aux.first} ")
        while (objetivo != 0.0) {
            aux = bosque.estadisticas()
            bosque.evolucionar()
            objetivo = aux.first
            println("Vuelta ${vuelta} Peor ${aux.second} Mejor ${aux.first} ")
            vuelta++
        }
        println("Vuelta ${vuelta} Peor ${aux.second} Mejor ${aux.first} ")


    }


}

fun main() {
    val algo = EncontrarNumero()
    algo.encontrarCoso()
}

class funcionSinLimites() : (Nodo) -> Double {
    override fun invoke(p1: Nodo): Double {
        return (65346 - p1.eval()).toDouble()
    }
}
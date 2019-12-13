package Tarea3.Ejercicios

import Tarea3.Max
import Tarea3.Multi
import Tarea3.Nodos.Nodo
import Tarea3.Resta
import Tarea3.Suma

class EncontrarNumero {
    val terminales: MutableList<Int> = mutableListOf(25, 7, 8, 100, 4, 2)
    val funciones: MutableList<(Nodo, Nodo) -> Int> = mutableListOf(Suma(), Resta(), Multi(), Max())

    fun funcionFitnessSinLimites(aNodo: Nodo): Double {
        return (65346 - aNodo.eval()).toDouble()
    }



}
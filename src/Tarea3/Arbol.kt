package Tarea3

import Tarea3.Nodos.Nodo

class Arbol(var generador: AST, var fitness: Any, profundidad: Int? = 10) {
    var raiz = generador.invoke(profundidad)
    var nodos: MutableList<Nodo> = mutableListOf()

    init {
        nodos = raiz.serializar()
    }

    fun crossover(otroArbol: Arbol) {

    }

    fun mutar(prob: Double) {
        val nodoAux: Nodo = nodos.random()
        val arbolaux: Arbol = Arbol(generador, fitness, nodoAux.profundidad)
        nodoAux.reemplazar(arbolaux.raiz)
    }

    fun fitness() {

    }
}
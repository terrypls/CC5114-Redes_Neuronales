package Tarea3.Nodos

open class NodoBinario(
    operacion: (Nodo, Nodo) -> Int,
    var nodoIzq: Nodo,
    var nodoDer: Nodo
) : Nodo(operacion = operacion) {
    override var numArgumentos = 2

    init {
        super.argumentos.add(nodoIzq)
        super.argumentos.add(nodoDer)
    }

    override fun toString(): String {
        return operacion.toString()
    }

}
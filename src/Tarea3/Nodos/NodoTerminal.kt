package Tarea3.Nodos


class NodoTerminal(

    val valor: Int,
    private val profundo: Int? = 0
) : Nodo(null, profundidad = profundo) {

    override fun eval(): Int {
        return valor
    }

    override fun copiar(): Nodo {
        return NodoTerminal(valor)
    }

    override fun toString(): String {
        return this.valor.toString()
    }
}

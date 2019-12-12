package Tarea3.Nodos


class NodoTerminal(

    val valor: Int
) : Nodo(null) {

    override fun eval(): Int {
        return valor
    }

    override fun toString(): String {
        return this.valor.toString()
    }
}

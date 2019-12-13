package Tarea3

import Tarea3.Nodos.Nodo
import kotlin.math.max

class Suma : (Nodo, Nodo) -> Int {
    lateinit var a: Nodo
    lateinit var b: Nodo
    override fun invoke(a: Nodo, b: Nodo): Int {
        this.a = a
        this.b = b
        return a.eval() + b.eval()
    }

    override fun toString(): String = "${this.a.eval().toString()} + ${this.b.eval().toString()}"
}

class Resta : (Nodo, Nodo) -> Int {
    lateinit var a: Nodo
    lateinit var b: Nodo
    override fun invoke(a: Nodo, b: Nodo): Int = a.eval() - b.eval()
    override fun toString(): String = "${this.a.eval().toString()} - ${this.b.eval().toString()}"
}

class Multi : (Nodo, Nodo) -> Int {
    lateinit var a: Nodo
    lateinit var b: Nodo
    override fun invoke(a: Nodo, b: Nodo): Int = a.eval() * b.eval()
    override fun toString(): String = "${this.a.eval().toString()} * ${this.b.eval().toString()}"
}

class Div : (Nodo, Nodo) -> Int {
    lateinit var a: Nodo
    lateinit var b: Nodo
    override fun invoke(a: Nodo, b: Nodo): Int {
        return when (b.eval()) {
            0 -> throw ArithmeticException("no se puede dividir por 0 o el mundo explota")
            else -> a.eval() / b.eval()
        }
    }

    override fun toString(): String = "${this.a.eval().toString()} / ${this.b.eval().toString()}"
}

class Max : (Nodo, Nodo) -> Int {
    lateinit var a: Nodo
    lateinit var b: Nodo
    override fun invoke(a: Nodo, b: Nodo): Int = max(a.eval(), b.eval())
    override fun toString(): String = " max (${this.a.eval().toString()}, ${this.b.eval().toString()})"
}

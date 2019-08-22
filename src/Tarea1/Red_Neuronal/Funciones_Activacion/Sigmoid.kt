package Tarea1.Red_Neuronal.Funciones_Activacion

import kotlin.math.exp

class Sigmoid : FuncionesActivacion {
    override fun derivada(valor: Double): Double {
        return (this.calcula(valor) * (1 - this.calcula(valor)))
    }

    override fun calcula(valor: Double): Double {
        return (1/(1+ exp(-valor)))
    }
}
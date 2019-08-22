package Tarea1.Red_Neuronal.Funciones_Activacion

class Step : FuncionesActivacion {
    override fun calcula(valor: Double): Double {
        return when {
            valor > 0.0 -> 1.0
            else -> 0.0
        }
    }

    override fun derivada(valor: Double): Double {
        return 0.0
    }
}
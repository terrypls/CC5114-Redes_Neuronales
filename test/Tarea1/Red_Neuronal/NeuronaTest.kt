package Tarea1.Red_Neuronal

import Tarea1.Red_Neuronal.Funciones_Activacion.FuncionesActivacion
import Tarea1.Red_Neuronal.Funciones_Activacion.Sigmoid
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class NeuronaTest {

    @BeforeEach
    fun setUp() {
        val learnignRate:Double = 0.1
        val activacion:FuncionesActivacion = Sigmoid()
        val neurona:Neurona = Neurona(2,activacion,learnignRate)

    }

    @Test
    fun procesador() {


    }
}
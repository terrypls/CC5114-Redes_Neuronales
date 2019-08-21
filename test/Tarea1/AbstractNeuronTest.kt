package Tarea1

import Extras.Utils
import Tarea1.Neurona_Sigmoid.SigmoidNeuron
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.random.Random

abstract class AbstractNeuronTest {

    protected lateinit var pesos: Array<Double>
    protected var tolerance: Double = 0.0
    protected lateinit var inputs11: List<Int>
    protected lateinit var inputs10: List<Int>
    protected lateinit var inputs01: List<Int>
    protected lateinit var inputs00: List<Int>
    protected var initPesos:Array<Double> = arrayOf(Random.nextDouble(-2.0,2.0), Random.nextDouble(-2.0,2.0))
    protected var initBias:Double = Random.nextDouble(-2.0,2.0)
    protected var utils:Utils = Utils()
    protected var sigmoidAnd:SigmoidNeuron = SigmoidNeuron(2)
    protected var sigmoidOr:SigmoidNeuron = SigmoidNeuron(2)
    protected var sigmoidNand:SigmoidNeuron = SigmoidNeuron(2)


    @BeforeEach
    fun setUp() {


        tolerance = 0.001
        inputs11 = listOf(1, 1)
        inputs10 = listOf(1, 0)
        inputs01 = listOf(0, 1)
        inputs00 = listOf(0, 0)


    }
}
package Tarea2.Cromosoma

import Tarea2.Genes.MochilaGen
import java.lang.StringBuilder
import kotlin.random.Random

@Suppress("UNCHECKED_CAST")
class MochilaCromosoma : ICromosoma<MochilaGen> {


    private var opciones: Array<Pair<Int, Int>>
    override var objetivo: Array<MochilaGen> = emptyArray() //no se usa
    private var fitnessObjetivo: Int
    private var cantGenes: Int
    private var pesoMaximo: Int
    override var genes: Array<MochilaGen> = emptyArray()
    private var pesos = 0
    private var valor = 0

    constructor(
        cantGenes: Int,
        opciones: Array<Pair<Int, Int>>,
        objetivo: Int,
        pesoMaximo: Int
    ) : this(cantGenes, opciones, objetivo, pesoMaximo, null)

    constructor(
        cantGenes: Int,
        opciones: Array<Pair<Int, Int>>,
        objetivo: Int,
        pesoMaximo: Int,
        genesNuevos: Array<MochilaGen>?
    ) {
        this.cantGenes = cantGenes
        this.fitnessObjetivo = objetivo
        this.opciones = opciones
        this.pesoMaximo = pesoMaximo
        this.genes = genesNuevos ?: Array(cantGenes) { MochilaGen(opciones) }
    }


    override fun mutar(probMutacion: Double) {
        for (i in genes.indices) {
            if (Random.nextDouble() < probMutacion) {
                genes[i] = MochilaGen(opciones)
            }
        }
    }

    override fun cambiarGenEn(posicion: Int, valor: Any) {
        genes[posicion].cambiarGen(valor as Pair<Int, Int>)
    }

    override fun copiar(): ICromosoma<MochilaGen> {
        val arreglo = Array(cantGenes) { i -> genes[i].copiarGen() as MochilaGen }
        return MochilaCromosoma(cantGenes, opciones, fitnessObjetivo, pesoMaximo, arreglo)
    }

    override fun imprimir(): String {
        val builder = StringBuilder()
        genes.forEach {
            builder.append("Peso: ${it.alelo.first} Valor:${it.alelo.second}\n")
        }

        return builder.toString()
    }

    override fun fitness(): Int {
        pesos = 0
        valor = 0
        genes.forEach {
            pesos += it.alelo.first
            valor *= it.alelo.second
        }
        return when {
            pesos > pesoMaximo -> 0
            else -> valor
        }
    }
}
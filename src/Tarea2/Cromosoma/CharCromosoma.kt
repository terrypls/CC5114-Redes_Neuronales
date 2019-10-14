package Tarea2.Cromosoma

import Tarea2.Genes.CharGen
import Tarea2.Genes.IGen
import kotlin.random.Random

class CharCromosoma : ICromosoma<CharGen> {
    override var genes: Array<CharGen> = emptyArray()
    private lateinit var alfabeto: String

    constructor(
        cantGenes: Int,
        alfabeto: String,
        stringBuscado: String = ""
    ) : this(cantGenes, alfabeto, stringBuscado, null)

    constructor(
        cantGenes: Int,
        alfabeto: String,
        stringBuscado: String = "",
        genesNuevos: Array<CharGen>?
    ) {
        this.alfabeto = alfabeto
        this.genes =
            if (genesNuevos != null) Array(cantGenes) { i -> genes[i] }
            else Array(cantGenes) { CharGen(alfabeto) }
    }

    override fun mutar(probMutacion: Double) {
        for (i in genes.indices) {
            if (Random.nextDouble() < probMutacion) {
                genes[i] = CharGen(alfabeto)
            }
        }
    }

    override fun cambiarGenEn(posicion: Int, valor: Any) {
        genes[posicion].cambiarGen(valor as Char)
    }

    fun compararCromosoma(otroCromosoma: CharCromosoma): Boolean {
        for (i in genes.indices) {
            if (!genes[i].comparar(otroCromosoma.genes[i])) {
                return false
            }
        }
        return true
    }

}
package Tarea2.Cromosoma

import Tarea2.Genes.CharGen
import Tarea2.Genes.IGen
import java.lang.StringBuilder
import kotlin.random.Random

class CharCromosoma : ICromosoma<CharGen> {


    override var objetivo: Array<CharGen> = emptyArray()
    override var genes: Array<CharGen> = emptyArray()
    private var alfabeto: String
    private var stringObjetivo: String


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
        this.stringObjetivo = stringBuscado
        this.alfabeto = alfabeto
        this.genes =
            if (genesNuevos != null) Array(cantGenes) { i -> genes[i] }
            else Array(cantGenes) { CharGen(alfabeto) }
        this.objetivo = Array(stringBuscado.length) { i -> CharGen(alfabeto, stringBuscado[i]) }
    }

    override fun copiar(): CharCromosoma {
        val arreglo = Array(genes.size) { i -> genes[i].copiarGen() }
        return CharCromosoma(genes.size, alfabeto, stringObjetivo, arreglo as Array<CharGen>)
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

    fun imprimir(): String {
        val builder = StringBuilder()
        genes.forEach {
            builder.append(it.alelo)
        }
        return builder.toString()
    }

}
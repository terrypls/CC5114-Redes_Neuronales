package Extras

import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.XYChartBuilder
import org.knowm.xchart.style.markers.SeriesMarkers
import kotlin.math.max

/**
 * Clase para manejar la creación de gráficos
 * autor Ignacion Slater Muñoz
 */
class Graficador(title: String, xLabel: String, yLabel: String, private val seriesName: String = "Success rate") {
    private val plot =
        XYChartBuilder().width(800).height(600).title(title).xAxisTitle(xLabel).yAxisTitle(yLabel).build()
    var yData: DoubleArray? = null
    var xData: DoubleArray? = null
    var minData: DoubleArray? = null
    var maxData: DoubleArray? = null
    var meanData: DoubleArray? = null


    fun draw() {
        if (xData == null) xData = DoubleArray(yData!!.size) { i -> i.toDouble() }
        assert(xData!!.size == yData!!.size)
        SwingWrapper(plot).displayChart()
        val line = plot.addSeries(seriesName, xData, yData)
        line.marker = SeriesMarkers.NONE
    }

    fun drawMultiple() {
        if (xData == null) xData = DoubleArray(minData!!.size) { i -> i.toDouble() }
        assert(xData!!.size == yData!!.size)
        SwingWrapper(plot).displayChart()
        val min = plot.addSeries("minimo", xData, minData)
        val max = plot.addSeries("maximo", xData, maxData)
        val mean = plot.addSeries("promedio", xData, meanData)
        min.marker = SeriesMarkers.NONE
        max.marker = SeriesMarkers.NONE
        mean.marker = SeriesMarkers.NONE

    }
}
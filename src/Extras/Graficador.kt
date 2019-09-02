package Extras

import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.XYChartBuilder
import org.knowm.xchart.style.markers.SeriesMarkers

/**
 * Clase para manejar la creación de gráficos
 * autor Ignacion Slater Muñoz
 */
class Graficador(title: String, xLabel: String, yLabel: String, private val seriesName: String = "Success rate") {
    private val plot =
        XYChartBuilder().width(800).height(600).title(title).xAxisTitle(xLabel).yAxisTitle(yLabel).build()
    var yData: DoubleArray? = null
    private var xData: DoubleArray? = null
     var errorData:DoubleArray?=null

    fun draw() {
        if (xData == null) xData = DoubleArray(yData!!.size) { i -> i.toDouble() }
        assert(xData!!.size == yData!!.size)
        SwingWrapper(plot).displayChart()
        val line = plot.addSeries(seriesName, xData, yData)
        plot.addSeries("error",xData,errorData)

        line.marker = SeriesMarkers.NONE
    }
}
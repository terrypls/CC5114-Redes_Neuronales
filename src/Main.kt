import Tarea1.Red_Neuronal.Neurona
import org.knowm.xchart.*
import java.awt.BorderLayout
import javax.swing.SwingConstants
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JFrame
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle
import org.knowm.xchart.style.Styler.LegendPosition
import javax.swing.Spring.width
import javax.swing.Spring.height

/**
 * usado principalmente para pruebas de funcionalidades de librerias y de kotlin en general
 */

fun main() {
    val a = Neurona(2)
    val b = Neurona(2)
    val c = Neurona(2)
    val d  = listOf<Double>(1.0,2.0)
    val e = listOf(a,b,c)
    println("pesos de cada neurona iniciales ${a.pesos},${b.pesos},${c.pesos}")
    e.forEach {
        it.entrenar(d)
    }
    println("pesos de cada neurona iniciales ${a.pesos},${b.pesos},${c.pesos}")

/*
// Create Chart
    val chart = XYChartBuilder().width(600).height(400).title("Area Chart").xAxisTitle("X").yAxisTitle("Y").build()

// Customize Chart
    chart.getStyler().setLegendPosition(LegendPosition.InsideNE)
    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area)

// Series
    chart.addSeries("a", doubleArrayOf(0.0, 3.0, 5.0, 7.0, 9.0), doubleArrayOf(-3.0, 5.0, 9.0, 6.0, 5.0))
    chart.addSeries("b", doubleArrayOf(0.0, 2.0, 4.0, 6.0, 9.0), doubleArrayOf(-1.0, 6.0, 4.0, 0.0, 4.0))
    chart.addSeries("c", doubleArrayOf(0.0, 1.0, 3.0, 8.0, 9.0), doubleArrayOf(-2.0, -1.0, 1.0, 0.0, 1.0))
    SwingWrapper(chart).displayChart()
// Schedule a job for the event-dispatching thread:
// creating and showing this application's GUI.
    */
    /*javax.swing.SwingUtilities.invokeLater {

        // Create and set up the window.
        val frame = JFrame("Advanced Example")
        frame.layout = BorderLayout()
        frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE

        // chart
        val chartPanel = XChartPanel<XYChart>(chart)
        frame.add(chartPanel, BorderLayout.CENTER)

        // label
        val label = JLabel("Blah blah blah.", SwingConstants.CENTER)
        frame.add(label, BorderLayout.SOUTH)

        // Display the window.
        frame.pack()
        frame.isVisible = true
    }*/


}

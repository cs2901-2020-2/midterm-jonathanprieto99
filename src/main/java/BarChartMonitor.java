import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;

public class BarChartMonitor extends JFrame {

    public void BarChartEx() {

        initUI();
    }

    private void initUI() {

        CategoryDataset dataset = generateDataset();

        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Bar chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private CategoryDataset generateDataset() {

        var dataset = new DefaultCategoryDataset();

        Cliente clienteNotas=new Cliente(1);

        String[][] grades = clienteNotas.getGrades();

        for (String[] grade : grades) {
            dataset.setValue(Double.parseDouble(grade[1]), "", grade[0]);
        }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
                "Grades",
                "",
                "Calificacion",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        return barChart;
    }

}

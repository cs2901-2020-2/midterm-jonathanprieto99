import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;

public class barChartMonitor extends JFrame {

    Cliente clienteNotas=new Cliente(1);

    public barChartMonitor() {
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

        String[][] grades = clienteNotas.getGrades();

        for (String[] grade : grades) {
            dataset.setValue(Double.parseDouble(grade[1]), "", grade[0]);
        }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {

        return  ChartFactory.createBarChart(
                "Grades",
                "",
                "Calificacion",
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);
    }

    public static void encender(){
        EventQueue.invokeLater(() -> {
            var ex = new barChartMonitor();
            ex.setVisible(true);
        });
    }

}

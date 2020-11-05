import org.testng.Assert;
import org.testng.annotations.Test;


public class SubjectsTest {
    @Test
    public void test_get_data_single() {
        Subject colegio = new Subject();

        barChartMonitor barcharMonitor = new barChartMonitor();

        colegio.addObserver(barcharMonitor.clienteNotas);

        String[][] notas = new String[][]{{"A","15"},{"B","16"},{"C","17"},{"D","18"}};
        colegio.addGrades(notas);

        Assert.assertEquals(barcharMonitor.clienteNotas.getGrades(), colegio.getGrades());
    }

    @Test
    public void test_get_data_multiple() {
        Subject colegio = new Subject();

        barChartMonitor barcharMonitor1 = new barChartMonitor();
        barChartMonitor barcharMonitor2 = new barChartMonitor();
        barChartMonitor barcharMonitor3 = new barChartMonitor();
        barChartMonitor barcharMonitor4 = new barChartMonitor();
        barChartMonitor barcharMonitor5 = new barChartMonitor();

        colegio.addObserver(barcharMonitor1.clienteNotas);
        colegio.addObserver(barcharMonitor2.clienteNotas);
        colegio.addObserver(barcharMonitor3.clienteNotas);
        colegio.addObserver(barcharMonitor4.clienteNotas);
        colegio.addObserver(barcharMonitor5.clienteNotas);

        String[][] notas = new String[][]{{"A","14"},{"B","12"},{"C","10"},{"D","19"}};
        colegio.addGrades(notas);

        Assert.assertEquals(barcharMonitor1.clienteNotas.getGrades(), colegio.getGrades());
        Assert.assertEquals(barcharMonitor2.clienteNotas.getGrades(), colegio.getGrades());
        Assert.assertEquals(barcharMonitor3.clienteNotas.getGrades(), colegio.getGrades());
        Assert.assertEquals(barcharMonitor4.clienteNotas.getGrades(), colegio.getGrades());
        Assert.assertEquals(barcharMonitor5.clienteNotas.getGrades(), colegio.getGrades());
    }
}
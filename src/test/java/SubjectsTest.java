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
}
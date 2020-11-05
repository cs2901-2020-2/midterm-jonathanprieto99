import org.testng.Assert;
import org.testng.annotations.Test;


public class SubjectsTest {
    @Test
    public void test_get_data_single() {
        Subject colegio = new Subject();
        Cliente barcharMonitor = new Cliente(0);
        colegio.addObserver(barcharMonitor);
        String[][] notas = new String[][]{{"A","15"},{"B","16"},{"C","17"},{"D","18"}};
        colegio.addGrades(notas);

        Assert.assertEquals(barcharMonitor.getGrades(), colegio.getGrades());
    }
}
import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {

    int clientID;

    int size;

    public void getSize(Observable gradesSistem, Object values){
        this.size=(int) values;
    }

    private String [][]grades = new String[3][3];

    public Cliente(int id){
        clientID=id;
    }

    public void update(Observable gradesSistem, Object values) {
        this.grades = (String[][]) values;
    }

    public String[][] getGrades() {
        return grades;
    }

}

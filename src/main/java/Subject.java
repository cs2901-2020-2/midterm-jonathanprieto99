import java.util.Observable;

public class Subject extends Observable {

    String[][] grades;

    public void addGrades(String[][] notas) {
        setChanged();

        grades=notas;

        notifyObservers(grades);
    }

    public String[][] getGrades() {
        return grades;
    }

}

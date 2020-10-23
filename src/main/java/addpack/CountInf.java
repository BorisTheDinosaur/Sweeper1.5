package addpack;

import javafx.scene.control.Label;

public class CountInf {

    private int countTrueFlags = 0;
    private int countBombs = 0;
    private int countFlags = 0;
    private final Label num = new Label("0");
    private static Timer time;


    public Label getNum() {
        return num;
    }



    public Timer getTime() {
        return time;
    }

    public Timer getDefTime() {
        return time = new Timer();
    }



    public int getCountTrueFlags() {
        return countTrueFlags;
    }



    public int getCountFlags() {
        return countFlags;
    }



    public void setCountBombs(int countBombs) {
        this.countBombs = countBombs;
    }

    public int getCountBombs() {
        return countBombs;
    }



    public void plusCountFlags() {
        countFlags++;
    }

    public void plusCountTrueFlags() {
        countTrueFlags++;
    }



    public void consCountFlags() {
        countFlags--;
    }

    public void consCountTrueFlags() {
        countTrueFlags--;
    }

}

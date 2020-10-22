package sample;

public class CountInf {

    private static int countTrueFlags = 0;
    private static int countBombs = 0;
    private static int countFlags = 0;



    public void setCountTrueFlags(int countTrueFlags) {
        CountInf.countTrueFlags = countTrueFlags;
    }

    public int getCountTrueFlags() {
        return countTrueFlags;
    }



    public void setCountFlags(int countFlags) {
        CountInf.countFlags = countFlags;
    }

    public int getCountFlags() {
        return countFlags;
    }



    public void setCountBombs(int countBombs) {
        CountInf.countBombs = countBombs;
    }

    public int getCountBombs() {
        return countBombs;
    }

    public void PlusCBombs(int countBombs) {
        countBombs++;
    }
}

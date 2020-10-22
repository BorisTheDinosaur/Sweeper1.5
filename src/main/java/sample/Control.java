package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Control {    //???
    private boolean bomb;
    private int bombAround = 0;
    private boolean visible = false;
    private boolean flag = false;
    private Timer time;
    private Rectangle cube = new Rectangle(20, 20);
    private Text value = new Text();

/*
    public void see() {
        if (flag || visible) return;
        if (bomb) {
            cube.setFill(Color.RED);
            time.stop();
            new WinWindow();
            //             lost.getChildren().add();
            //             a = sliderLevel.getValue();
            //            scene.setRoot(create());
            return;
        }
        visible = true;
        value.setVisible(true);
        cube.setFill(Color.BLACK);
        if (value.getText().equals("0"))
            for (Main.Title neighbor: listNeighbors(this)) {
                value.setText("");
                if (neighbor.flag) neighbor.flagged();
                neighbor.see();
            }
    }

    public void flagged() {
        if (visible) return;

        if (flag) {
            cube.setFill(Color.GRAY);
            if (this.bomb) countTrueFlags--;
            countFlags--;
        }

        if (countFlags >= countBombs) return;
        flag = !flag;

        if (flag) {
            cube.setFill(Color.ORANGE);
            if (this.bomb) countTrueFlags++;
            countFlags++;
        }

        num.setText(String.valueOf(countBombs - countFlags));

        if (countTrueFlags == countBombs) {
            time.setValue(time.getValue());
            time.stop();
            newWindow("You Won!!!");
        }
    }

 */
}

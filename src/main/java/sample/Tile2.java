package sample;

import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class Tile2 extends StackPane{

    private final int x;
    private final int y;
    private final boolean bomb;
    private int bombAround = 0;
    private boolean visible = false;
    private boolean flag = false;

    private final Rectangle cube;
    private Text value = new Text();

    private Timer time;
    private Label num;
    int countTrueFlags;
    int countBombs;
    int countFlags;
    int width;
    int height;
    Tile2[][] matrix;

    public Tile2(int x, int y, boolean bomb, Timer time, Label num, int countTrueFlags, int countBombs, int countFlags, int width, int height, Tile2[][] matrix) {
        this.x = x;
        this.y = y;
        this.bomb = bomb;

        this.time = time;
        this.num = num;
        this.countBombs = countBombs;
        this.countFlags = countFlags;
        this.countTrueFlags = countTrueFlags;
        this.width = width;
        this.height = height;
        this.matrix = matrix;

        value.setStroke(Color.LIGHTGRAY);
        //       value.setVisible(false);
        cube = new Rectangle(20, 20);
        cube.setFill(Color.GRAY);
        cube.setStroke(Color.AQUAMARINE);
        getChildren().addAll(cube, value);
        setTranslateX(10 + x * 20);
        setTranslateY(74 + y * 20);

        setOnMouseClicked(event -> {
       //      if (event.getButton().equals(MouseButton.PRIMARY)) see();
             if (event.getButton().equals(MouseButton.SECONDARY)) flagged();
        });
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getBomb() {
            return bomb;
    }

    public int getBombAround() {
        return bombAround;
    }

    public Text getValue() {
            return value;
    }

    public void setBombAround(int a) {
            bombAround = a;
    }

    public void setValue(Text value) {
        this.value = value;
    }

    public Rectangle getCube() {
        return cube;
    }

    public boolean getFlag() {
        return flag;
    }

    public boolean getVisible() {
        return visible;
    }
/*
    public void see() {
        if (flag || visible) return;
        if (bomb) {
            cube.setFill(Color.RED);
            time.stop();
            new LoseWindow();
            return;
        }
        visible = true;
        value.setVisible(true);
        cube.setFill(Color.BLACK);
        if (value.getText().equals("0")){
            ListNeighbors list = new ListNeighbors(this, matrix, width, height);
            for (Tile2 neighbor: list.getNeighbors()) {
                value.setText("");
                if (neighbor.flag) neighbor.flagged();
                neighbor.see();
            }
        }
    }

 */

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
            time.stop();
            new WinWindow(time);
        }
    }
}

package sample;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Create extends Parent {

    private Label num = new Label("0");
    private Timer time;
    private CreateField field;
    private int width;
    private int height;
    private static Tile[][] matrix;


    public Create(Stage stage, BorderPane root, int width, int height, double rand) {
        this.width = width;
        this.height = height;

        stage.setWidth(width + 17);
        stage.setHeight(height + 104);

        root.setPrefSize(width - 9, height + 55);
        root.setBackground(new Background(new BackgroundFill(Color.DIMGREY, CornerRadii.EMPTY, Insets.EMPTY)));


        num.setFont(Font.font(30));
        num.setTextFill(Color.AQUAMARINE);

        time = new Timer();

        root.setRight(time);
        root.setLeft(num);

        field = new CreateField(width/20, height/20, rand, root);


        num.setText(String.valueOf(field.getCountBombs() - field.getCountFlags()));
    }

    public Timer getTimer() {
        return time;
    }

    public Label getNum() {
        return num;
    }

   /* public int getCountBombs() {
        return field.getCountBombs();
    }

    public int getCountTrueFlags() {
        return field.getCountTrueFlags();
    }

    public int getCountFlags() {
        return field.getCountFlags();
    }



    public Tile[][] getMatrix() { return field.getMatrix(); }

    */
/*
    public void see(Tile tile) {
        if (tile.getFlag() || tile.getVisible()) return;
        if (tile.getBomb()) {
            tile.getCube().setFill(Color.RED);
            time.stop();
            new LoseWindow();
            return;
        }
        tile.setVisible(true);
        tile.getValue().setVisible(true);
        tile.getCube().setFill(Color.BLACK);
        if (tile.getValue().getText().equals("0")){
            ListNeighbors list = new ListNeighbors(tile, field.getMatrix(), width, height);
            for (Tile neighbor: list.getNeighbors()) {
                tile.getValue().setText("");
                if (neighbor.getFlag()) flagged(neighbor);
                see(neighbor);
            }
        }
    }

    public void flagged(Tile tile) {
        boolean visible = tile.getVisible();
        boolean flag = tile.getFlag();
        Rectangle cube = tile.getCube();
        int countTrueFlags = field.getCountTrueFlags();
        int countFlags = field.getCountFlags();
        int countBombs = field.getCountBombs();

        if (visible) return;

        if (flag) {
            cube.setFill(Color.GRAY);
            if (tile.getBomb()) countTrueFlags--;
            countFlags--;
        }

        if (countFlags >= countBombs) return;
        flag = !flag;

        if (flag) {
            cube.setFill(Color.ORANGE);
            if (tile.getBomb()) countTrueFlags++;
            countFlags++;
        }

        num.setText(String.valueOf(countBombs - countFlags));

        if (countTrueFlags == countBombs) {


            new WinWindow(time);
        }
    }

 */

}

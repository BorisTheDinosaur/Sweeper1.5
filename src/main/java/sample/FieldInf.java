package sample;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FieldInf {

    private Stage stage;
    private BorderPane root;
    private int width;
    private int height;
    private int sizeTile;
    private double rand;


    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Stage getStage() {
        return stage;
    }



    public void setSizeTile(int sizeTile) {
        this.sizeTile = sizeTile;
    }



    public void setRoot(BorderPane root) {
        this.root = root;
    }

    public BorderPane getRoot() {
        return root;
    }



    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getTileWidth() {
        return width / sizeTile;
    }



    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getTileHeight() {
        return height / sizeTile;
    }



    public void setWH(int width, int height) {
        this.width = width;
        this.height = height;
    }



    public void setRand(double rand) {
        this.rand = rand;
    }

    public double getRand() {
        return rand;
    }
}

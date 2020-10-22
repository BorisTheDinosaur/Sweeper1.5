package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class CreateField {
    private static int countTrueFlags = 0;
    private int countBombs = 0;
    private int countFlags = 0;
    private static Tile[][] matrix;
    private Label num = new Label("0");
    private Timer time;

    public CreateField(int tileWidth, int tileHeight, double rand, BorderPane root) {
        matrix = new Tile[tileWidth][tileHeight];

        for (int j = 0; j < tileHeight; j++) {
            for (int i = 0; i < tileWidth; i++) {
                Tile tile = new Tile(i, j, Math.random() < rand);
                matrix[i][j] = tile;
                root.getChildren().add(tile);
            }
        }
        for (int j = 0; j < tileHeight; j++) {
            for (int i = 0; i < tileWidth; i++) {
                Tile tile = matrix[i][j];
                if (tile.getBomb()) {
                    countBombs++;
                    continue;
                }
                ListNeighbors list = new ListNeighbors(tile, matrix, tileWidth, tileHeight);
                int a = (int) list.getNeighbors().stream().filter(Tile::getBomb).count();
                tile.setBombAround(a);

                tile.getValue().setText(String.valueOf(tile.getBombAround()));
            }
        }
    }

    public int getCountBombs() {
        return countBombs;
    }

    public int getCountTrueFlags() { return countTrueFlags; }

    public int getCountFlags() {
        return countFlags;
    }

    public Tile[][] getMatrix() { return matrix; }



}

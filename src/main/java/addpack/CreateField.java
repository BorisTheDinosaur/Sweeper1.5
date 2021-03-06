package sample;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class CreateField {
    private static Tile[][] matrix;
    private Label num = new Label("0");
    private Timer time;

    public CreateField(FieldInf pack,  CountInf count) {
        int tileWidth = pack.getTileWidth();
        int tileHeight = pack.getTileHeight();
        double rand = pack.getRand();
        BorderPane root = pack.getRoot();
        int countBombs = 0;

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
        count.setCountBombs(countBombs);
    }

    public Tile[][] getMatrix() { return matrix; }



}

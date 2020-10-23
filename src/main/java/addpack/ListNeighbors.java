package sample;


import java.util.ArrayList;

public class ListNeighbors {

    private static ArrayList<Tile> neighbors;

    public ListNeighbors(Tile tile, Tile[][] matrix, int tileWidth, int tileHeight) {
        neighbors = new ArrayList<>();

        int[] xDif = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        int[] yDif = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};

        for (int i = 0; i < xDif.length; i++) {
            int xNei = tile.getX() + xDif[i];
            int yNei = tile.getY() + yDif[i];

            if (xNei >=0 && yNei >=0 && xNei < tileWidth && yNei < tileHeight) neighbors.add(matrix[xNei][yNei]);
        }
    }

    public ArrayList<Tile> getNeighbors() {
                return neighbors;
    }
}

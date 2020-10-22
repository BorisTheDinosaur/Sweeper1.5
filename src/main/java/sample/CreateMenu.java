package sample;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CreateMenu extends BorderPane {
    private static int width = 500;
    private static int height = 400;
    private static double rand = 0.2;
    private double a;
    private double b;
    private Create game;
    private MenuBar menuBar;


    public CreateMenu(Stage stage, BorderPane root) {


        //  titleWidth = width / titleSize;
        //  titleHeight = height / titleSize;
        //  Title[][] matrix = new Title[titleWidth][titleHeight];



        menuBar = new MenuBar();
        root.setTop(menuBar);

        Menu mainMenu = new Menu("_Menu");
        mainMenu.setMnemonicParsing(true);

        Menu optionsMenu = new Menu("_Options");

        Menu levelMenu = new Menu("Level");
        Slider sliderLevel = new Slider(0.0, 12.5, 6.25);
        sliderLevel.setSnapToTicks(true);
        sliderLevel.setBlockIncrement(6.25);
        sliderLevel.setShowTickMarks(true);
        CustomMenuItem level = new CustomMenuItem(sliderLevel);
        levelMenu.getItems().add(level);

        Menu resolutionMenu = new Menu("Resolution");
        Slider sliderResolution = new Slider(0.0, 12.5, 6.25);
        sliderResolution.setSnapToTicks(true);
        sliderResolution.setBlockIncrement(6.25);
        sliderResolution.setShowTickMarks(true);
        CustomMenuItem resolution = new CustomMenuItem(sliderResolution);
        resolutionMenu.getItems().add(resolution);

        optionsMenu.getItems().addAll(levelMenu, resolutionMenu);


        MenuItem newGameItem = new MenuItem("_New Game");
        newGameItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        newGameItem.setOnAction(event -> {
            a = sliderLevel.getValue();
            if (a == 0.0) rand = 0.1;
            if (a == 12.5) rand = 0.3;

            b = sliderResolution.getValue();
            if (b == 0.0) {
                width = 300;
                height = 200;
            }
            if (b == 12.5) {
                width = 700;
                height = 600;
            }
                game = new Create(stage, root, width, height, rand);
 //           field = new CreateField(width/20, height/20, rand, root);
        });

        MenuItem recordsItem = new MenuItem("_Records");
        recordsItem.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
        recordsItem.setOnAction(event -> {});

        MenuItem exitItem = new MenuItem("_Exit");
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        exitItem.setOnAction(event -> Platform.exit());

        mainMenu.getItems().addAll(newGameItem, recordsItem, optionsMenu, new SeparatorMenuItem(), exitItem);

        menuBar.getMenus().addAll(mainMenu);
    }

    public int getWidth1() {
        return width;
    }

    public int getHeight1() {
        return height;
    }

    public double getRand() {
        return rand;
    }

    public Create getGame() { return game; }

    public MenuBar getMenuBar() { return menuBar; }


  //  public Tile[][] getMatrix() {
  //      return matrix;
  //  }
}

package addpack;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;

public class CreateMenu extends BorderPane {
    private double a;
    private double b;
    private Create game;

    public CreateMenu(FieldInf pack) {

        BorderPane root = pack.getRoot();
        pack.setRand(0.2);
        pack.setWH(500, 400);

        MenuBar menuBar = new MenuBar();
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
            if (a == 0.0) pack.setRand(0.1);
            else if (a == 12.5) pack.setRand(0.3);
            else if (a == 6.25) pack.setRand(0.2);

            b = sliderResolution.getValue();
            if (b == 0.0) pack.setWH(300, 200);
            else if (b == 12.5) pack.setWH(700, 600);
            else if (b == 6.25) pack.setWH(500, 400);

                game = new Create(pack);
        });

        MenuItem exitItem = new MenuItem("_Exit");
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        exitItem.setOnAction(event -> Platform.exit());

        mainMenu.getItems().addAll(newGameItem, optionsMenu, new SeparatorMenuItem(), exitItem);

        menuBar.getMenus().addAll(mainMenu);
    }

    public Create getGame() { return game; }

}

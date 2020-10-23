package sample;

import javafx.application.Platform;

public class LoseWindow {

    CreateField field;
   // Timer time;
   // int tileWidth;
 //   int tileHeight;
   // double rand;
  //  BorderPane root;

    public LoseWindow() {
        AlertWindow window = new AlertWindow("You Lost!"/*, "//explosionImage.png"*/, "Exit");
        window.getButton1().setOnAction(event -> {
     //       new Create(tileWidth, tileHeight, rand, root);
            window.getStage().close();
        });
        window.getButton2().setOnAction(event -> {
            window.close();
            Platform.exit();
        });
        window.showAndWait();
    }
}

package sample;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class WinWindow {

  //  int tileWidth;
  //  int tileHeight;
  //  double rand;
  //  BorderPane root;
  //  CreateField field;

  //  Create create;


    public WinWindow(Timer time) {
        AlertWindow window = new AlertWindow("You Won!!!"/*, "sample/Images/cupImage.png"*/, "Records");
        window.getButton1().setOnAction(event -> {
      //  new Create(tileWidth, tileHeight, rand, root);
            window.getStage().close();
        });
        window.getButton2().setOnAction(event -> {});

        TextField textField = new TextField();
        textField.setPromptText("Name");

        Label timeValue = new Label("Your Time: " + time.getValue());

        window.getPane().getChildren().addAll(textField, timeValue);
        timeValue.setFont(new Font("Arial", 30));
        textField.setTranslateX(200);
        textField.setTranslateY(80);

        window.showAndWait();
    }
}

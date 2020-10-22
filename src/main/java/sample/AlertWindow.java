package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertWindow {
    private final Stage stage;
    private final Button button1;
    private final Button button2;
    private final Pane pane;



    public AlertWindow(String labelName,/* String imageAddress,*/ String buttonName) {
        stage = new Stage();
        stage.setTitle("Canep");
      //  Image icon = new Image(getClass().getResourceAsStream("sample/Images/iconImage.png"));
      //  stage.getIcons().add(icon);

        pane = new Pane();


        Label label = new Label(labelName);
        button1 = new Button("New Game");
        button2 = new Button(buttonName);


    //    ImageView image = new ImageView(imageAddress);
    //    image.setFitHeight(170);
    //    image.setFitWidth(230);


        pane.getChildren().addAll(label, button1, button2); //, image);
        label.setTranslateX(210);
        label.setTranslateY(25);
        label.setFont(new Font("Arial", 30));
        button1.setTranslateX(200);
        button1.setTranslateY(110);
        button2.setTranslateX(290);
        button2.setTranslateY(110);
    //    image.setTranslateX(-30);

        Scene sceneNew = new Scene(pane, 400, 170, Color.BLACK);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(sceneNew);
        stage.setResizable(false);
    }

    public Stage getStage() {
        return stage;
    }

    public Pane getPane() {
        return pane;
    }

    public Button getButton1() {
        return button1;
    }

    public Button getButton2() {
        return button2;
    }

    public void showAndWait() {
        stage.showAndWait();
    }

    public void close() {
        stage.close();
    }



}

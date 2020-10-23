package addpack;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class WinWindow {

    public WinWindow(Timer time, FieldInf pack) {
        AlertWindow window = new AlertWindow("You Won!!!"/*, "sample/Images/cupImage.png"*/);
        window.getButton1().setOnAction(event -> {
        new Create(pack);
            window.getStage().close();
        });
        window.getButton2().setOnAction(event -> {
            window.close();
            Platform.exit();
        });

        Label timeValue = new Label("Your Time: " + time.getValue());

        window.getPane().getChildren().add(timeValue);
        timeValue.setFont(new Font("Arial", 30));
        timeValue.setTranslateX(100);
        timeValue.setTranslateY(60);

        window.showAndWait();
    }
}

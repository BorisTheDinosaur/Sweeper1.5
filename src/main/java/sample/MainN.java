package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.ArrayList;


public class MainN extends Application {


    @Override
    public void start(Stage stage) throws  Exception{
        stage.setTitle("Canep");

        //  InputStream ggg = getClass().getClassLoader().getResourceAsStream("sample/Images/iconImage.png");
        //  Image icon = new Image(ggg);
        //  stage.getIcons().add(icon);

        BorderPane root = new BorderPane();
        CreateMenu menu = new CreateMenu(stage, root);
        Create game = menu.getGame();
        game = new Create(stage, root, menu.getWidth1(), menu.getHeight1(), menu.getRand());
        Scene scene = new Scene(root);

        stage.setScene(scene);
       // stage.setResizable(false);     change stage
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


/*
*
*
        Parent root = FXMLLoader.load(getClass().getResource("launcher.fxml"));
        primaryStage.setTitle("Canep");
        Image icon = new Image(getClass().getResourceAsStream("/sample/resources/iconImage.png"));
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
*
*
*/
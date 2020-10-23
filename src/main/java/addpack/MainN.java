package addpack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainN extends Application {

    BorderPane root;
    FieldInf pack;
    CreateMenu menu;
    Create game;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Canep");

      //    InputStream ggg = getClass().getResourceAsStream("src/main/resources/iconImage.png");
      //    Image icon = new Image(ggg);
       //   stage.getIcons().add(icon);

        //ImageIcon icon = new ImageIcon("src/main/resources/iconImage.png");
       // stage.getIcons().add(Image.impl_fromPlatformImage(icon.getImage()));

        root = new BorderPane();
        pack = new FieldInf();
        pack.setSizeTile(20);
        pack.setRoot(root);
        pack.setStage(stage);
        menu = new CreateMenu(pack);
        game = menu.getGame();

        game = new Create(pack);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

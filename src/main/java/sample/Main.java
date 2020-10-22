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


public class Main extends Application {

    private static int width = 300;
    private static int height = 200;
    private static final int titleSize = 20;
    private static int titleWidth = width / titleSize;
    private static int titleHeight = height / titleSize;
    private Title[][] matrix = new Title[titleWidth][titleHeight];
    private Scene scene;
    private int countTrueFlags;
    private int countBombs;
    private int countFlags;
    private double a = 6.25;
    private double rand;
    private Label num = new Label("0");
    private Timer time;

    private Parent create() {

        if (a == 0.0) {
      //      width = 300;
      //      height = 200;
            rand = 0.1;
        }
        if (a == 12.5) {
      //      width = 700;
      //      height = 600;
            rand = 0.3;
        }
        else {
      //      width = 700;
      //      height = 600;
            rand = 0.2;
        }
      //  titleWidth = width / titleSize;
      //  titleHeight = height / titleSize;
      //  Title[][] matrix = new Title[titleWidth][titleHeight];

         MenuBar menuBar = new MenuBar();

        Menu mainMenu = new Menu("_Menu");
        mainMenu.setMnemonicParsing(true);

        Menu optionsMenu = new Menu("_Options");

        Menu levelMenu = new Menu("Level");
        Slider sliderLevel = new Slider(0.0, 12.5, a);
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
            scene.setRoot(create());
        });

        MenuItem recordsItem = new MenuItem("_Records");
        recordsItem.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
     //   recordsItem.setOnAction(event -> );

        MenuItem exitItem = new MenuItem("_Exit");
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        exitItem.setOnAction(event -> Platform.exit());

        mainMenu.getItems().addAll(newGameItem, recordsItem, optionsMenu, new SeparatorMenuItem(), exitItem);

        menuBar.getMenus().addAll(mainMenu);


        BorderPane root = new BorderPane();
        root.setPrefSize(width - 9, height + 55);
        root.setTop(menuBar);
        root.setBackground(new Background(new BackgroundFill(Color.DIMGREY, CornerRadii.EMPTY, Insets.EMPTY)));




        num.setFont(Font.font(30));
        num.setTextFill(Color.AQUAMARINE);

        time = new Timer();

        root.setRight(time);
        root.setLeft(num);


//        a++;

        countBombs = 0;
        countTrueFlags = 0;
        countFlags = 0;
        for (int j = 0; j < titleHeight; j++) {
            for (int i = 0; i < titleWidth; i++) {
                Title title = new Title(i, j, Math.random() < rand);
                matrix[i][j] = title;
                root.getChildren().add(title);
            }
        }
        for (int j = 0; j < titleHeight; j++) {
            for (int i = 0; i < titleWidth; i++) {
                Title title = matrix[i][j];
                if (title.bomb) {
                    countBombs++;
                    continue;
                }
                title.bombAround = (int) listNeighbors(title).stream().filter(titlee -> titlee.bomb).count();
                title.value.setText(String.valueOf(title.bombAround));
            }
        }



        num.setText(String.valueOf(countBombs - countFlags));


        return root;
    }


    private ArrayList<Title> listNeighbors(Title title) {
        ArrayList<Title> neighbors = new ArrayList<>();

        int[] xDif = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        int[] yDif = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};

        for (int i = 0; i < xDif.length; i++) {
            int xNei = title.x + xDif[i];
            int yNei = title.y + yDif[i];

            if (xNei >=0 && yNei >=0 && xNei < titleWidth && yNei < titleHeight) neighbors.add(matrix[xNei][yNei]);
        }

        return neighbors;
    }


    private class Title extends StackPane {
        private final int x;
        private final int y;
        private final boolean bomb;
        private int bombAround = 0;
        private boolean visible = false;
        private boolean flag = false;

        private Rectangle cube = new Rectangle(titleSize, titleSize);
        private Text value = new Text();

        public Title(int x, int y, boolean bomb) {
            this.x = x;
            this.y = y;
            this.bomb = bomb;

            value.setStroke(Color.LIGHTGRAY);
     //       value.setVisible(false);
            cube.setFill(Color.GRAY);
            cube.setStroke(Color.AQUAMARINE);
            getChildren().addAll(cube, value);
            setTranslateX(10 + x * titleSize);
            setTranslateY(74 + y * titleSize);

            setOnMouseClicked(
                    event -> {
                        if (event.getButton().equals(MouseButton.PRIMARY)) see();
                        if (event.getButton().equals(MouseButton.SECONDARY)) flagged();
                    });
        }

        public void see() {
            if (flag || visible) return;
            if (bomb) {
                cube.setFill(Color.RED);
                time.stop();
                Pane lost = newWindow("You Lost!");
   //             lost.getChildren().add();
   //             a = sliderLevel.getValue();
    //            scene.setRoot(create());
                return;
            }
            visible = true;
            value.setVisible(true);
            cube.setFill(Color.BLACK);
            if (value.getText().equals("0"))
                for (Title neighbor: listNeighbors(this)) {
                    value.setText("");
                    if (neighbor.flag) neighbor.flagged();
                    neighbor.see();
                }
        }

        public void flagged() {
            if (visible) return;

            if (flag) {
                cube.setFill(Color.GRAY);
                if (this.bomb) countTrueFlags--;
                countFlags--;
            }

            if (countFlags >= countBombs) return;
            flag = !flag;

            if (flag) {
                cube.setFill(Color.ORANGE);
                if (this.bomb) countTrueFlags++;
                countFlags++;
            }

            num.setText(String.valueOf(countBombs - countFlags));

            if (countTrueFlags == countBombs) {
                time.setValue(time.getValue());
                time.stop();
                newWindow("You Won!!!");
            }
        }
    }


    private Pane newWindow(String str) {
        Stage stage = new Stage();
        stage.setTitle("Canep");
      //  Image icon = new Image(getClass().getResourceAsStream("/sample/resources/iconImage.png"));
      //  stage.getIcons().add(icon);

        Pane pane = new Pane();


        Label label = new Label(str);
        TextField textField = new TextField();
        textField.setPromptText("Name");
        Button button1 = new Button("New Game");
        button1.setOnAction(event -> {
            scene.setRoot(create());
            stage.close();
        });
        Button button2 = new Button("Records");

//        ImageView cup = new ImageView("/sample/resources/cupImage.png");
  //      cup.setFitHeight(170);
    //    cup.setFitWidth(230);

        Label timeValue = new Label("Your Time: " + time.getValue());


        pane.getChildren().addAll(label, textField, button1, button2, /*cup,*/ timeValue);
        label.setTranslateX(210);
        label.setTranslateY(25);
        label.setFont(new Font("Arial", 30));
        textField.setTranslateX(200);
        textField.setTranslateY(80);
        button1.setTranslateX(200);
        button1.setTranslateY(110);
        button2.setTranslateX(290);
        button2.setTranslateY(110);
       // cup.setTranslateX(-30);

        button2.setOnAction(event -> {

        });


        Scene sceneNew = new Scene(pane, 400, 170, Color.BLACK);

        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(sceneNew);
        stage.showAndWait();
        stage.setResizable(false);


        return pane;
    }


    @Override
    public void start(Stage stage) throws  Exception{
        stage.setTitle("Canep");

     //  InputStream ggg = getClass().getClassLoader().getResourceAsStream("sample/Images/iconImage.png");
     //  Image icon = new Image(ggg);
     //  stage.getIcons().add(icon);


        scene = new Scene(create());
        stage.setScene(scene);
        stage.setResizable(false);
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
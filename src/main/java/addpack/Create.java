package addpack;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Create extends Parent {

    public Create(FieldInf pack) {
        Stage stage = pack.getStage();
        BorderPane root = pack.getRoot();
        int width = pack.getWidth();
        int height = pack.getHeight();

        stage.setWidth(width + 7);
        stage.setHeight(height + 94);

        root.setBackground(new Background(new BackgroundFill(Color.DIMGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        CountInf count = new CountInf();

        count.getNum().setFont(Font.font(30));
        count.getNum().setTextFill(Color.AQUAMARINE);

        root.setLeft(count.getNum());
        root.setRight(count.getDefTime());
        new CreateField(pack, count);

        count.getNum().setText(String.valueOf(count.getCountBombs() - count.getCountFlags()));
    }

}

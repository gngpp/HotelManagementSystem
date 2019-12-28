package mvcpro.model.utils;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.Transition;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.util.TimerTask;

public class ProgressFrom extends TimerTask {
    private Stage dialogStage;
    private ProgressIndicator progressIndicator;
    private Stage newStage;

    public ProgressFrom(Stage primaryStage, String title) {
        this.newStage=primaryStage;
        dialogStage = new Stage();
        progressIndicator = new ProgressIndicator();
        // 窗口父子关系
        dialogStage.initOwner(primaryStage);
        dialogStage.initStyle(StageStyle.UNDECORATED);
        dialogStage.initStyle(StageStyle.TRANSPARENT);
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        // progress bar
        Label label = new Label(title);
        label.setTextFill(Color.BLUE);
        progressIndicator.setProgress(-1F);
        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setBackground(Background.EMPTY);
        vBox.getChildren().addAll(progressIndicator,label);
        Scene scene = new Scene(vBox);
        scene.setFill(null);
        dialogStage.setScene(scene);
        dialogStage.show();

    }

    @Override
    public void run() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                dialogStage.hide();
                newStage.show();
            }
        });
    }
}

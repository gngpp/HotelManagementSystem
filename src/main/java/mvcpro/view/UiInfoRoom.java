package mvcpro.view;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mvcpro.controlled.UiInfoRoomController;
import mvcpro.view.server.InfoRoomData;

public class UiInfoRoom extends Application {
    private double lastx_distance;
    private double lasty_distance;
    private Stage newStage;
    private UiInfoRoomController uiInfoRoomController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        newStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui_room_info_layout.fxml"));
        Pane root = loader.load();
        uiInfoRoomController = loader.getController();
        uiInfoRoomController.setMainStage(newStage);


        //
        //设置背景颜色
        //
        //Background bg=new Background(new BackgroundFill(Color.valueOf("#282828BF"),new CornerRadii(7),new Insets(0)));
        //root.setBackground(bg);
        Scene scene = new Scene(root);

        //
        //加载CSS文件
        //
        scene.getStylesheets().add(getClass().getResource("/ui_default_style.css").toExternalForm());

        scene.setFill(Paint.valueOf("#00000000"));
        newStage.getIcons().add(new Image(getClass().getResource("/png/icons8-fahrenheit_symbol.png").toExternalForm()));
        newStage.setScene(scene);
        //  newStage.initStyle(StageStyle.TRANSPARENT);
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.show();
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lastx_distance = event.getScreenX() - newStage.getX();
                lasty_distance = event.getScreenY() - newStage.getY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                newStage.setX(event.getScreenX() - lastx_distance);
                newStage.setY(event.getScreenY() - lasty_distance);
            }
        });
    }

    public void setInfoRoomData(ObservableList<InfoRoomData> infoRoomData) {
        uiInfoRoomController.setInfoRoomData(infoRoomData);
    }
}

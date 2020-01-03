package mvcpro.view;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import mvcpro.controlled.UiInfoRoomController;
import mvcpro.model.entity.InfoRoom;
import mvcpro.view.server.InfoRoomData;

public class UiInfoRoom extends Application {
    private double lastx_distance;
    private double lasty_distance;
    private Stage newStage;
    private Pane root;
    private UiInfoRoomController uiInfoRoomController;
    @Override
    public void start(Stage primaryStage) throws Exception {
        newStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ui_room_info_layout.fxml"));
        Pane root = loader.load();
        this.root=root;
        uiInfoRoomController = loader.getController();
        uiInfoRoomController.setMainStage(newStage);

        //
        //设置背景颜色
        //
        Scene scene = new Scene(root);

        //
        //加载CSS文件
        //
        scene.getStylesheets().add(getClass().getResource("/css/ui_default_style.css").toExternalForm());

        scene.setFill(Paint.valueOf("#373738"));
        newStage.getIcons().add(new Image(getClass().getResource("/png/icons8-fahrenheit_symbol.png").toExternalForm()));
        newStage.setScene(scene);


        newStage.initModality(Modality.APPLICATION_MODAL);

        scene.setOnMousePressed(event -> {
            lastx_distance = event.getScreenX() - newStage.getX();
            lasty_distance = event.getScreenY() - newStage.getY();
        });
        scene.setOnMouseDragged(event -> {
            newStage.setX(event.getScreenX() - lastx_distance);
            newStage.setY(event.getScreenY() - lasty_distance);
        });
    }

    public void setInfoRoomData(ObservableList<InfoRoomData> infoRoomData) {
        uiInfoRoomController.setInfoRoomData(infoRoomData);
    }

    public void show(){
        ScaleTransition st=new ScaleTransition(Duration.millis(700),root);
        st.setFromX(0.1);
        st.setToX(1);
        st.setFromY(0.1);
        st.setToY(1);
        st.play();
        newStage.show();
    }

    public void setInfoRoom(InfoRoom infoRoom){
        uiInfoRoomController.setInfoRoom(infoRoom);
    }
}

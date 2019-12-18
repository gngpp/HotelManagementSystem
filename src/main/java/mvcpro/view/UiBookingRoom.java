package mvcpro.view;

import javafx.application.Application;
import javafx.beans.value.ObservableBooleanValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mvcpro.controlled.UiBookingRoomController;
import mvcpro.view.server.BookRoomData;
import mvcpro.view.server.ClientData;

public class UiBookingRoom extends Application {
    private Stage newStage;
    private Scene scene;
    private UiBookingRoomController  bookingRoomController;
    private double lastx_distance,lasty_distance;

    @Override
    public void start(Stage primaryStage) throws Exception {
        try{
            newStage=primaryStage;
            //
            //获取控制类对象
            //
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/ui_bookingroom_layout.fxml"));
            Pane root =loader.load();

            //
            //获取控制类对象引用
            //
            bookingRoomController =loader.getController();
            bookingRoomController.setUiStage(newStage);

            //
            //设置背景颜色
            //
            Background bg=new Background(new BackgroundFill(Color.valueOf("FFFFFF6C"),new CornerRadii(0),new Insets(0)));
            root.setBackground(bg);

            scene=new Scene(root);

            newStage.getIcons().add(new Image(getClass().getResource("/png/icons8-fahrenheit_symbol.png").toExternalForm()));
            scene.setFill(Paint.valueOf("#FFFFFF00"));
            newStage.setScene(scene);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {

                //
                // 鼠标按下事件
                //

                @Override
                public void handle(MouseEvent event) {
                    lastx_distance = event.getScreenX()-newStage.getX();
                    lasty_distance = event.getScreenY()-newStage.getY();
                }});
            newStage.addEventFilter(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>() {

                //
                // 鼠标拖拽事件
                //

                @Override
                public void handle(MouseEvent event) {
                    newStage.setX(event.getScreenX()-lastx_distance);
                    newStage.setY(event.getScreenY()-lasty_distance);
                }
            });
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void setBookRoomData(ObservableList<BookRoomData> bookRoomData_list){
        this.bookingRoomController.setBookRoomData(bookRoomData_list);
    }

    public void setClientData(ObservableList<ClientData> clientData_list){
        this.bookingRoomController.setClientData(clientData_list);
    }
    public void show(){
        newStage.show();
    }
}

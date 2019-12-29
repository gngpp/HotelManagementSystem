package mvcpro.view;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
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
import javafx.util.Duration;
import mvcpro.controlled.UiBookingRoomController;
import mvcpro.model.entity.BookRoom;
import mvcpro.model.entity.User;
import mvcpro.view.server.BookRoomData;
import mvcpro.view.server.ClientData;

public class UiBookingRoom extends Application {
    private Stage newStage;
    private Pane root;
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
            this.root=root;
            //
            //获取控制类对象引用
            //
            bookingRoomController =loader.getController();
            bookingRoomController.setUiStage(newStage);

            //
            //设置背景颜色
            //
            Background bg=new Background(new BackgroundFill(Color.valueOf("282828BF"),new CornerRadii(7),new Insets(0)));
            root.setBackground(bg);

            scene=new Scene(root);

            newStage.getIcons().add(new Image(getClass().getResource("/png/icons8-fahrenheit_symbol.png").toExternalForm()));
            scene.setFill(Paint.valueOf("#00000000"));
            newStage.setScene(scene);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.initStyle(StageStyle.TRANSPARENT);

            scene.setOnMousePressed(event -> {
                lastx_distance=event.getScreenX()-newStage.getX();
                lasty_distance=event.getScreenY()-newStage.getY();
            });

            scene.setOnMouseDragged(event -> {

                newStage.setX(event.getScreenX()-lastx_distance);
                newStage.setY(event.getScreenY()-lasty_distance);
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

    public void setBookRoom(BookRoom bookRoom){
        this.bookingRoomController.setBookRoom(bookRoom);
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
    public void setUser(User user){
        this.bookingRoomController.setUser(user);
    }
}

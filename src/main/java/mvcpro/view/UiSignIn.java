package mvcpro.view;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import mvcpro.controlled.UiSignInController;

public class UiSignIn extends Application {


    private Stage newStage;
    private Scene scene;
    private UiSignInController uiSignInController;
    private double lastx_distance,lasty_distance;

    @Override
    public void start(Stage primaryStage) throws Exception {
            try{
                newStage=primaryStage;
                //
                //获取控制类对象
                //
                FXMLLoader loader=new FXMLLoader(getClass().getResource("/ui_sign_in_layout.fxml"));
                Pane root =loader.load();

                //
                //获取控制类对象引用
                //
                uiSignInController =loader.getController();
                uiSignInController.setUiMessageBox(newStage);

                //
                //设置背景颜色
                //
                Background bg=new Background(new BackgroundFill(Color.valueOf("FFFFFF6C"),new CornerRadii(0),new Insets(0)));
                root.setBackground(bg);

                scene=new Scene(root);

                newStage.getIcons().add(new Image(getClass().getResource("/png/icons8-fahrenheit_symbol.png").toExternalForm()));
                scene.setFill(Paint.valueOf("#FFFFFF00"));
                newStage.initStyle(StageStyle.TRANSPARENT);
                newStage.setScene(scene);
                newStage.initModality(Modality.APPLICATION_MODAL);

                ScaleTransition st=new ScaleTransition(Duration.millis(500),root);
                st.setFromX(0.1);
                st.setToX(1);
                st.setFromY(0.1);
                st.setToY(1);
                st.play();

                newStage.show();
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

}

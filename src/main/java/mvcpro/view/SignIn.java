package mvcpro.view;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mvcpro.controlled.UiSignInController;

public class SignIn extends Application {


    private  Stage newStage=new Stage();
    private Scene scene;
    private UiSignInController uiSignInController;
    private double lastx_distance,lasty_distance;
    public  SignIn(){
        newStage=new Stage();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
            try{

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

                //
                //加载CSS文件
                //
                //  scene.getStylesheets().add(getClass().getResource("/ui_sign_in_style.css").toExternalForm());

                //
                //设置场景透明
                //
                scene.setFill(Paint.valueOf("#FFFFFF00"));
                newStage.initStyle(StageStyle.TRANSPARENT);
                newStage.setScene(scene);

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
                newStage.show();
            }catch(Exception e){
                e.printStackTrace();
            }
    }



}

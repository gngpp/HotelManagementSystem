package mvcpro.view.login;

import com.sun.org.apache.regexp.internal.RE;
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

import java.io.IOException;

//登录使用单列模式
public class UiLogin extends Application {

    private double lastx_distance;
    private double lasty_distance;

    @Override
    public void start(Stage primaryStage) throws IOException {

        createStage(primaryStage);
    }

    private void createStage(Stage loginStage) throws IOException {

        FXMLLoader loader= new FXMLLoader(getClass().getResource("/ui_login_layout.fxml"));
        Pane root = loader.load();
        UiLoginController uiLoginController=loader.getController();
        uiLoginController.setLoginStage(loginStage);

        //
        //设置背景颜色
        //
        Background bg=new Background(new BackgroundFill(Color.valueOf("282828BF"),new CornerRadii(7),new Insets(0)));
        root.setBackground(bg);

        Scene scene=new Scene(root, 232, 368);

        //
        //加载CSS文件
        //
        scene.getStylesheets().add(getClass().getResource("/ui_login_style.css").toExternalForm());

        //
        //设置场景透明
        //
        scene.setFill(Paint.valueOf("#FFFFFF00"));
        loginStage.initStyle(StageStyle.TRANSPARENT);
        loginStage.setScene(scene);
        loginStage.show();

        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lastx_distance=event.getScreenX()-loginStage.getX();
                lasty_distance=event.getScreenY()-loginStage.getY();
            }
        });

        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loginStage.setX(event.getScreenX()-lastx_distance);
                loginStage.setY(event.getScreenY()-lasty_distance);
            }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}

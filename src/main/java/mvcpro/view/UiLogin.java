package mvcpro.view;
import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import mvcpro.controlled.UiLoginController;
import mvcpro.model.entity.User;
import mvcpro.model.utils.ProgressFrom;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class UiLogin extends Application {

    private double lastx_distance;
    private double lasty_distance;
    private UiLoginController uiLoginController;
    private AudioClip audio =new AudioClip(getClass().getResource("/audio/Windows.wav").toString());
    @Override
    public void start(Stage primaryStage) throws IOException, InterruptedException {
        createStage(primaryStage);
    }

    private void createStage(Stage loginStage) throws IOException{

        FXMLLoader loader= new FXMLLoader(getClass().getResource("/ui_login_layout.fxml"));
        Pane root = loader.load();
        this.uiLoginController=loader.getController();
        this.uiLoginController.setLoginStage(loginStage);
        if (audio.isPlaying()) {
            audio.stop();
        }
        else {
            audio.play(1.0);
        }
        //
        //设置背景颜色
        //
        Background bg=new Background(new BackgroundFill(Color.valueOf("282828BF"),new CornerRadii(7),new Insets(0)));
        root.setBackground(bg);

        Scene scene=new Scene(root);

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
        loginStage.getIcons().add(new Image(UiLogin.class.getResource("/png/icons8-fahrenheit_symbol.png").toExternalForm()));


        scene.setOnMousePressed(event -> {
            lastx_distance=event.getScreenX()-loginStage.getX();
            lasty_distance=event.getScreenY()-loginStage.getY();
        });

        scene.setOnMouseDragged(event -> {
            loginStage.setX(event.getScreenX()-lastx_distance);
            loginStage.setY(event.getScreenY()-lasty_distance);
        });


        // 创建定时任务
        ProgressFrom progressFrom = new ProgressFrom(loginStage,"数据加载中, 请稍后...");
        progressFrom.setRoot(root);
        //创建定时器对象
        Timer timer = new Timer();
        timer.schedule(progressFrom, 1000);
    }

    public void setUserId(User user){
        this.uiLoginController.setUserId(user);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

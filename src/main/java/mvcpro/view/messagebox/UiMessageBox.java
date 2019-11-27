package mvcpro.view.messagebox;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UiMessageBox{

    private static String title;
    private static String text;
    private static Stage newStage=new Stage();
    private static Scene scene;
    private double lastx_distance,lasty_distance;

    public UiMessageBox(){
        try{

            Pane root =FXMLLoader.load((getClass().getResource("/ui_messagebox_layout.fxml")));
            //
            //设置背景颜色
            //
            Background bg=new Background(new BackgroundFill(Color.valueOf("282828BF"),new CornerRadii(7),new Insets(0)));
            root.setBackground(bg);

            scene=new Scene(root, 252, 160);

            //
            //加载CSS文件
            //
            scene.getStylesheets().add(getClass().getResource("/ui_messagebox_style.css").toExternalForm());

            //
            //设置场景透明
            //
            scene.setFill(Paint.valueOf("#FFFFFF00"));
            newStage.initStyle(StageStyle.TRANSPARENT);
            newStage.setScene(scene);

            scene.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    lastx_distance=event.getScreenX()-newStage.getX();
                    lasty_distance=event.getScreenY()-newStage.getY();
                }
            });

            scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
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

    public  String getTitle() {
        return title;
    }

    public  void setTitle(String title) {
        UiMessageBox.title = title;
    }

    public  String getText() {
        return text;
    }

    public  void setText(String text) {
        UiMessageBox.text = text;
    }

    public void showMessageBox(String newTitle, String newText){
        UiMessageBox.text=newText;
        UiMessageBox.title=newTitle;
        newStage.show();
    }

}

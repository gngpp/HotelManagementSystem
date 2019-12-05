package mvcpro.controlled;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class UiMessageBoxController implements Initializable {

    @FXML
    private Label text;

    @FXML
    private Label title;

    @FXML
    private Button exit;

    @FXML
    private Button check;

    private static Stage uiMessageBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exit.setFont(new Font("System",13));
        check.setFont(new Font("System",13));
    }

    @FXML
    public void messageBoxCheck(ActionEvent event){
        uiMessageBox.close();
    }

    @FXML
    public void messageBoxExit(ActionEvent event){
        uiMessageBox.close();
    }

    public Label getText() {
        return text;
    }

    public void setText(Label text) {
        this.text = text;
    }

    public Label getTitle() {
        return title;
    }

    public void setTitle(Label title) {
        this.title = title;
    }

    public void setUiMessageBox(Stage uiMessageBox){
        this.uiMessageBox=uiMessageBox;
    }
}

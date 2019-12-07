package mvcpro.controlled;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    private  Stage signInStage;

    @FXML
    private ImageView signInImage;

    @FXML
    private PasswordField signInpPassword;

    @FXML
    private TextField siginId;

    @FXML
    private ComboBox<String> selectTwo;

    @FXML
    private Button signInAndLogin;

    @FXML
    private TextField questionThree;

    @FXML
    private ComboBox<String> selectOne;

    @FXML
    private PasswordField checkPassword;

    @FXML
    private ComboBox<String> selectThree;

    @FXML
    private Button signIn;

    @FXML
    private TextField questionOne;

    @FXML
    private Button reset;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initProperty();
    }





    private void initProperty(){
        selectOne.getItems().addAll("你父母亲的姓名?","你的生日?","你毕业于那个初中?","你喜欢看的电影?");
        selectTwo.getItems().addAll("您父亲的姓名是？","您配偶的姓名是？","您高中班主任的名字是？","您配偶的姓名是？");
        selectThree.getItems().addAll("您的出生地是？","您的小学校名是？","您的小学校名是？","您的学号（或工号）是？");
    }


    @FXML
    private TextField questionTwo;
    public void setUiMessageBox(Stage newStage) {
        this.signInStage=newStage;
    }


    @FXML
    void btn_signInAndLogin(ActionEvent event) {

    }

    @FXML
    void btn_reset(ActionEvent event) {

    }

    @FXML
    void btn_signIn(ActionEvent event) {

    }

}




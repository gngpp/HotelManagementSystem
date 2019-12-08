package mvcpro.controlled;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.apache.commons.lang.ObjectUtils;

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
    private PasswordField signInCheckPassword;

    @FXML
    private ComboBox<String> selectThree;

    @FXML
    private Button signIn;

    @FXML
    private TextField questionOne;

    @FXML
    private Button reset;

    @FXML
    private TextField questionTwo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initProperty();
    }





    private void initProperty(){
        selectOne.getItems().addAll("你父母亲的姓名?","你的生日?","你毕业于那个初中?","你喜欢看的电影?");
        selectTwo.getItems().addAll("您父亲的姓名是？","您配偶的姓名是？","您高中班主任的名字是？","您配偶的姓名是？");
        selectThree.getItems().addAll("您的出生地是？","您的小学校名是？","您的小学校名是？","您的学号（或工号）是？");
    }



    public void setUiMessageBox(Stage newStage) {
        this.signInStage=newStage;
    }


    @FXML
    void btn_signInAndLogin(ActionEvent event) {

    }

    @FXML
    void btn_reset(ActionEvent event) {
        siginId.clear();
        signInpPassword.clear();
        signInCheckPassword.clear();
        questionOne.clear();
        questionTwo.clear();
        questionThree.clear();
        selectOne.setValue(null);
        selectTwo.setValue(null);
        selectThree.setValue(null);
    }

    @FXML
    void btn_signIn(ActionEvent event) {
        if(selectThree==null||selectTwo==null||
        selectOne==null||signInpPassword.getText()==null||
        signInCheckPassword.getText()==null||siginId.getText()==null||
        questionOne.getText()==null||questionTwo.getText()==null||
        questionThree.getText()==null){
            Alert confirmation=new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setTitle("提示");
            confirmation.setHeaderText("请完善注册信息");
            confirmation.show();
            return;
        }
    }

    @FXML
    void signInExitEvent(ActionEvent event) {
        signInStage.hide();
    }

    @FXML
    void signInCheckMinimize(ActionEvent event) {
        signInStage.setIconified(true);
    }
}




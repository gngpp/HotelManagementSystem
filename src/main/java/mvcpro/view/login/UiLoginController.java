package mvcpro.view.login;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.text.Font;
import mvcpro.model.entity.User;
import mvcpro.model.dao.UserDao;
import mvcpro.view.main.UiMainFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Optional;

public class UiLoginController {

    private UserDao userDao;

    private Stage loginStage;

    private Stage mainStage;

    private Alert alert;

    private UiMainFrame uiMainFrame;

    @FXML
    private Button registerUser;

    @FXML
    private TextField loginID;

    @FXML
    private ImageView image;

    @FXML
    private PasswordField loginPassword;

    @FXML
    private Button loginCheck;

    @FXML
    private ChoiceBox selectUserType;


    public void setLoginStage(Stage loginStage){
        this.loginStage=loginStage;
    }

    @FXML
    void LoginCheckEvent(ActionEvent event) throws Exception {

        userDao=new UserDao();
        for (User user :userDao.list()) {
            if (loginID.getText().equals(user.getId())&&
                    loginPassword.getText().equals(user.getPassword())) {
                loginStage.hide();
                uiMainFrame.start(mainStage);
                return;
            }
        }
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Your account number or password is incorrect！");
        alert.show();
    }

    @FXML
    void LoginExitEvent(ActionEvent event){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                alert.setGraphic(new ImageView(getClass().getResource("/png/confirmation.png").toString()));
                alert.setTitle("Confirmation Dialog");
                alert.setHeaderText("Lock,a Confirmation Dialog");
                alert.setContentText("Sure you want to exit?");
                Optional<ButtonType> result=alert.showAndWait();
                if(result.isPresent()&&result.get()==ButtonType.OK){
                    Platform.exit();
                }else {
                    return;
                }
            }
        });

    }

    @FXML
    void loginCheckMinimize(ActionEvent event){
        loginStage.setIconified(true);
    }

    @FXML
    void initialize() {
        mainStage=new Stage();
        uiMainFrame=new UiMainFrame();
        alert=new Alert(Alert.AlertType.CONFIRMATION);
        selectUserType.getItems().addAll("学生","管理员");
        image.screenToLocal(20,20);
        loginCheck.setFont(new Font("System", 13));
        registerUser.setFont(new Font("System",13));


    }


}

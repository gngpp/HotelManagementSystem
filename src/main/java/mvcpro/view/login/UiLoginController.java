package mvcpro.view.login;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import mvcpro.model.entity.User;
import mvcpro.model.dao.UserDao;
import mvcpro.view.main.UiMainFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mvcpro.view.messagebox.UiMessageBox;

import java.util.Optional;

public class UiLoginController {

    private UserDao userDao;

    private Stage loginStage;

    private Stage mainStage;

    private UiMainFrame uiMainFrame;

    private UiMessageBox uiMessageBox;

    @FXML
    private Button signIn;

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

        for (User user :userDao.list()) {
            if (loginID.getText().equals(user.getId())&&
                    loginPassword.getText().equals(user.getPassword())) {
                loginStage.hide();
                uiMainFrame.start(mainStage);
                return;
            }
        }

        uiMessageBox.showMessageBox("Confirmation Dialog","Your account number or password is incorrect！");


    }

    @FXML
    void LoginExitEvent(ActionEvent event){

        uiMessageBox.showMessageBox("Confirmation Dialog","Sure you want to exit?");
    }

    @FXML
    void loginCheckMinimize(ActionEvent event){
        loginStage.setIconified(true);
    }

    @FXML
    void initialize() {
        mainStage=new Stage();
        uiMainFrame=new UiMainFrame();
        uiMessageBox=new UiMessageBox();
        userDao=new UserDao();

        uiMessageBox.setModality(Modality.APPLICATION_MODAL);
        selectUserType.getItems().addAll("学生","管理员");
        image.screenToLocal(20,20);
        loginCheck.setFont(new Font("System", 13));
        signIn.setFont(new Font("System",13));


    }


}

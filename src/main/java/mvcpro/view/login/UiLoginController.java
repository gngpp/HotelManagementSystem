package mvcpro.view.login;

import com.sun.deploy.security.SelectableSecurityManager;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
    private Button loginExit;

    @FXML
    private ChoiceBox selectUserType;

    private Integer userType=0;

    public void setLoginStage(Stage loginStage){
        this.loginStage=loginStage;
    }

    @FXML
    void LoginCheckEvent(ActionEvent event) throws Exception {
        userDao.list().forEach(System.out::println);
         for (User user :userDao.list()) {
             if (loginID.getText().equals(user.getId())&&
                     loginPassword.getText().equals(user.getPassword())&&
                     userType==user.getUserType()) {
                 System.out.println(user.info());
                 loginStage.hide();
                 uiMainFrame.start(mainStage);
                 return;
             }
         }
         uiMessageBox.showMessageBox("Confirmation Dialog","Your account number or password is incorrect！");

    }

    @FXML
    void LoginExitEvent(ActionEvent event){
        Platform.exit();
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
        selectUserType.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        switch(selectUserType.getValue().toString()){
                            case "管理员":
                                userType=1;
                                break;
                            case "学生":
                                userType=0;
                                break;
                            default:
                                userType=0;
                                break;
                        }
                        System.out.println(userType);
                    }
                }).start();

            }
        });

    }


}

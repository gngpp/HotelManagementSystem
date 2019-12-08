package mvcpro.controlled;

import com.sun.deploy.security.SelectableSecurityManager;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import mvcpro.model.Verify;
import mvcpro.model.entity.User;
import mvcpro.model.dao.UserDao;
import mvcpro.view.main.UiMainFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mvcpro.view.messagebox.UiMessageBox;
import mvcpro.view.ru.SignIn;

import java.util.Optional;

public class UiLoginController implements Verify {

    private UserDao userDao;

    private Stage loginStage;

    private Stage mainStage;

    private Stage signInStage;

    private UiMainFrame uiMainFrame;

    private UiMessageBox uiMessageBox;

    @FXML
    private Button btnSignIn;

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

    private StringBuilder verify;


    @FXML
    void initialize() {
        mainStage=new Stage();
        signInStage=new Stage();
        uiMainFrame=new UiMainFrame();
        uiMessageBox=new UiMessageBox();
        userDao=new UserDao();
        verify=new StringBuilder("");
        uiMessageBox.setModality(Modality.APPLICATION_MODAL);
        selectUserType.getItems().addAll("用户","管理员");
        image.screenToLocal(20,20);
        loginCheck.setFont(new Font("System", 13));
        btnSignIn.setFont(new Font("System",13));
        selectUserType.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        verify=new StringBuilder(selectUserType.getValue().toString());
                        System.out.println(verify);
                    }
                }).start();

            }
        });

    }

    public void setLoginStage(Stage loginStage){
        this.loginStage=loginStage;
    }

    @FXML
    void LoginCheckEvent(ActionEvent event) throws Exception {

        userDao.list().forEach(System.out::println);

         for (User user :userDao.list()) {
             System.out.println(loginVerify(user));
             if (loginVerify(user)) {
                 loginStage.hide();
                 uiMainFrame.start(mainStage);
                 return;
             }
         }

//         if(verify.toString().equals())
//             uiMessageBox.showMessageBox("Confirmation Dialog","Please select permission！");
//            else
//             uiMessageBox.showMessageBox("Confirmation Dialog","Your account or password is incorrect！");

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
    void loginSignIn(ActionEvent event) throws Exception {
        new SignIn().start(signInStage);
    }



    private  Boolean loginVerify(User user){

        return (loginID.getText().equals(user.getId())&&
                loginPassword.getText().equals(user.getPassword())&&verify.toString().equals(user.getUserType()))? true:false;
    }

}

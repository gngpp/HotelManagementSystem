package mvcpro.controlled;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import mvcpro.model.entity.User;
import mvcpro.model.dao.UserDao;
import mvcpro.model.utils.MD5;
import mvcpro.view.UiLogin;
import mvcpro.view.UiMainFrame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mvcpro.view.UiMessageBox;
import mvcpro.view.SignIn;

public class UiLoginController {

    private  static boolean isTure=false;

    private UserDao userDao;

    private Stage loginStage;

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
    void initialize() throws Exception {
        uiMainFrame=new UiMainFrame();
        uiMainFrame.start(new Stage());
        signInStage=new Stage();
        uiMessageBox=new UiMessageBox();
        userDao=new UserDao();
        verify=new StringBuilder("");
        uiMessageBox.setModality(Modality.APPLICATION_MODAL);
        selectUserType.getItems().addAll("用户","管理员");
        image.screenToLocal(20,20);

        loginCheck.setFont(new Font("System", 13));
        btnSignIn.setFont(new Font("System",13));
        final Tooltip tooltip = new Tooltip();
        tooltip.setText(
                "\nYour password must be\n" +
                        "at least 8 characters in length\n"
        );
        ImageView tipImage=new ImageView(new Image(String.valueOf(((UiLogin.class.getResource("/png/icons8-close_window.png"))))));
        tooltip.setGraphic(tipImage);
        loginPassword.setTooltip(tooltip);
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

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    for (User user :userDao.list())
                        if (loginVerify(user)) {
                            System.out.println("已登陆");
                            loginStage.hide();
                            uiMainFrame.show();
                        }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

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
                MD5.encrypt(loginPassword.getText()).equals(user.getPassword())&&verify.toString().equals(user.getUserType()))? true:false;
    }

}

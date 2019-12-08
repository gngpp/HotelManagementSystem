package mvcpro.controlled;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import mvcpro.model.dao.UserDao;
import mvcpro.model.dao.UserVerifyDao;
import mvcpro.model.entity.User;
import mvcpro.model.entity.UserVerify;
import mvcpro.view.AlertDefined;

import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    private  Stage signInStage;

    @FXML
    private ImageView iv_Image;

    @FXML
    private PasswordField psf_password;

    @FXML
    private TextField txf_id;

    @FXML
    private ComboBox<String> cbx_selectTwo;

    @FXML
    private Button btn_signInAndLogin;

    @FXML
    private TextField txf_question_three;

    @FXML
    private ComboBox<String> cbx_selectOne;

    @FXML
    private PasswordField psf_checkPassword;

    @FXML
    private ComboBox<String> cbx_selectThree;

    @FXML
    private Button btn_signIn;

    @FXML
    private TextField txf_question_one;

    @FXML
    private Button btn_reset;

    @FXML
    private TextField txf_qustion_two;

    private UserDao userDao;

    private UserVerifyDao userVerifyDao;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userDao=new UserDao();
        userVerifyDao= new UserVerifyDao();
        initProperty();
    }


    private void initProperty(){

        cbx_selectOne.getItems().addAll("你父母亲的姓名?","你的生日?","你毕业于那个初中?","你喜欢看的电影?");
        cbx_selectTwo.getItems().addAll("您父亲的姓名是？","您配偶的姓名是？","您高中班主任的名字是？","您配偶的姓名是？");
        cbx_selectThree.getItems().addAll("您的出生地是？","您的小学校名是？","您的小学校名是？","您的学号（或工号）是？");
    }



    public void setUiMessageBox(Stage newStage) {
        this.signInStage=newStage;
    }


    @FXML
    void ac_signInAndLogin(ActionEvent event) {

    }

    @FXML
    void ac_reset(ActionEvent event) {
        txf_id.clear();
        psf_password.clear();
        psf_checkPassword.clear();
        txf_question_one.clear();
        txf_qustion_two.clear();
        txf_question_three.clear();
        cbx_selectOne.setValue(null);
        cbx_selectTwo.setValue(null);
        cbx_selectThree.setValue(null);
    }

    @FXML
    void ac_signIn(ActionEvent event) throws Exception {

        if(!isCheckInfo()){
            new AlertDefined(Alert.AlertType.INFORMATION,"提示","请完善注册信息").show();
            return;
        }else if (psf_password.getText().equals(psf_checkPassword.getText())){
            new AlertDefined(Alert.AlertType.ERROR,"警告⚠️","您的确认密码错误！").show();
            return;
        }


        System.out.println("正在测试注册验证。。。。。。");
        //没写入则跳出
        if(!isWriteInfo()){
            new AlertDefined(Alert.AlertType.INFORMATION,"警告⚠️","该账号已存在。。。。").show();
        }else {
            new AlertDefined(Alert.AlertType.INFORMATION,"提示️","注册成功！").show();
        }

    }



    @FXML
    void ac_signInExitEvent(ActionEvent event) {
        signInStage.hide();
    }

    @FXML
    void ac_signInCheckMinimize(ActionEvent event) {
        signInStage.setIconified(true);
    }

    private Boolean isCheckInfo(){

        if (cbx_selectThree.getValue()==null||cbx_selectTwo.getValue()==null||
                cbx_selectOne.getValue()==null|| psf_password.getText().equals(null)||
                psf_checkPassword.getText().equals(null)||txf_id.getText().equals(null)||
                txf_qustion_two.getText().equals(null)||txf_question_one.getText().equals(null)||
                txf_question_three.getText().equals(null)){
            return false;
        }
        return true;
    }

    private Boolean isWriteInfo() throws Exception {

        System.out.println("正在判断账号是否已存在。。。。。");
        //判断是否有相同的账号
        for(User user:userDao.list()){
            if(user.getId().equals(txf_id.getText()))
                return false;
        }

        //先写入主键表
        User user=new User();
        user.setId(txf_id.getText());
        user.setPassword(psf_password.getText());
        user.setQuestion_one(txf_question_one.getText());
        user.setQuestion_two(txf_qustion_two.getText());
        user.setQuestion_three(txf_question_three.getText());
        user.setUserType("用户");
        userDao.save(user);
        userDao.list().forEach(System.out::println);
        //写入外健表

        UserVerify userVerify=new UserVerify();
        userVerify.setSelect_one(cbx_selectOne.getValue());
        userVerify.setSelect_two(cbx_selectTwo.getValue());
        userVerify.setSelect_three(cbx_selectThree.getValue());
        userVerifyDao.save(userVerify);

        return true;
    }
}




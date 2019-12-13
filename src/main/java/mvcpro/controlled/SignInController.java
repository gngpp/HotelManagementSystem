package mvcpro.controlled;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mvcpro.model.dao.UserDao;
import mvcpro.model.dao.UserVerifyDao;
import mvcpro.model.entity.User;
import mvcpro.model.entity.UserVerify;
import mvcpro.model.md5.MD5;
import mvcpro.view.AlertDefined;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class SignInController implements Initializable {
    private  Stage signInStage;

    @FXML
    private TextField txf_question_two_find;

    @FXML
    private Button btn_signIn;


    @FXML
    private PasswordField psf_password_old_alter;

    @FXML
    private Button btn_browse;

    @FXML
    private ComboBox<String> cbx_selectThree_alter;

    @FXML
    private ComboBox<String> cbx_selectTwo_find;

    @FXML
    private PasswordField psf_checkPassword;

    @FXML
    private Button signInMinimize;

    @FXML
    private TextField txf_id_find_check;

    @FXML
    private Button btn_reset;

    @FXML
    private Button signInExit;

    @FXML
    private Button btn_checkFind;

    @FXML
    private ImageView iv_image;

    @FXML
    private ComboBox<String> cbx_selectOne_find;

    @FXML
    private Button btn_checkAlter;

    @FXML
    private ComboBox<String> cbx_selectOne;

    @FXML
    private PasswordField psf_checkPassword_new_alter;

    @FXML
    private TextField txf_id_find;

    @FXML
    private TextField txf_id;

    @FXML
    private TextField txf_id_alter;

    @FXML
    private ComboBox<String> cbx_selectOne_alter;

    @FXML
    private TextField txf_question_three_find;

    @FXML
    private PasswordField psf_password;

    @FXML
    private TextField txf_question_three_alter;

    @FXML
    private ComboBox<String> cbx_selectThree_find;

    @FXML
    private TextField txf_question_one_later;

    @FXML
    private TextField txf_qustion_two;

    @FXML
    private ComboBox<String> cbx_selectTwo;

    @FXML
    private ComboBox<String> cbx_selectThree;

    @FXML
    private TextField txf_question_two_alter;

    @FXML
    private Button btn_signInAndLogin;

    @FXML
    private PasswordField psf_password_new_alter;

    @FXML
    private TextField txf_question_one;

    @FXML
    private TextField txf_question_one_find;

    @FXML
    private TextField txf_question_three;

    @FXML
    private ComboBox<String> cbx_selectTwo_alter;

    private UserDao userDao;

    private UserVerifyDao userVerifyDao;

    private String pictureUrl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initProperty();
    }



    private void initProperty(){
        userDao=new UserDao();
        userVerifyDao= new UserVerifyDao();
        cbx_selectOne.getItems().addAll("你父母亲的姓名?","你的生日?","你毕业于那个初中?","你喜欢看的电影?");
        cbx_selectTwo.getItems().addAll("您父亲的姓名是？","您配偶的姓名是？","您高中班主任的名字是？","您配偶的姓名是？");
        cbx_selectThree.getItems().addAll("您的出生地是？","您的小学校名是？","您的小学校名是？","您的学号（或工号）是？");
        cbx_selectOne_alter.getItems().addAll("你父母亲的姓名?","你的生日?","你毕业于那个初中?","你喜欢看的电影?");
        cbx_selectTwo_alter.getItems().addAll("您父亲的姓名是？","您配偶的姓名是？","您高中班主任的名字是？","您配偶的姓名是？");
        cbx_selectThree_alter.getItems().addAll("您的出生地是？","您的小学校名是？","您的小学校名是？","您的学号（或工号）是？");
        cbx_selectOne_find.getItems().addAll("你父母亲的姓名?","你的生日?","你毕业于那个初中?","你喜欢看的电影?");
        cbx_selectTwo_find.getItems().addAll("您父亲的姓名是？","您配偶的姓名是？","您高中班主任的名字是？","您配偶的姓名是？");
        cbx_selectThree_find.getItems().addAll("您的出生地是？","您的小学校名是？","您的学号（或工号）是？");

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
        iv_image.setImage(new Image("/png/timg.jpeg"));
    }

    @FXML
    void ac_signIn(ActionEvent event) throws Exception {

        if(isCheckInfo()){
            System.out.println("正在测试注册验证。。。。。。");
            //没写入则跳出
            if(!isWriteInfo()){
                new AlertDefined(Alert.AlertType.INFORMATION,"警告⚠️","该账号已存在。。。。").show();
            }else {
                new AlertDefined(Alert.AlertType.INFORMATION,"提示️","注册成功！").show();
            }
        }
    }

    @FXML
    void ac_browse(ActionEvent event){
        FileChooser fileChooser=new FileChooser();
        File file=fileChooser.showOpenDialog(new Stage());
        if(file!=null){
            pictureUrl =new String("/png/"+file.getName());
            iv_image.setImage(new Image(pictureUrl));
        }

    }


    @FXML
    void ac_exit(ActionEvent event) {
        signInStage.hide();
    }

    @FXML
    void ac_minimize(ActionEvent event) {
        signInStage.setIconified(true);
    }


    @FXML
    void ac_checkFind(ActionEvent event) throws Exception {
        if(isCheckInfo_find()){
            if (!isFindInfo())
                new AlertDefined(Alert.AlertType.INFORMATION,"提示️","查找失败！，请确认你的信息是否正确。").show();
        }
        ac_resetFind(event);

    }


    @FXML
    void ac_checkAlter(ActionEvent event) throws Exception {
        if(isCheckInfo_alter()){
            if(!isAlterInfo())
            new AlertDefined(Alert.AlertType.INFORMATION,"提示️","修改失败！").show();
        }
        ac_resetAlter(event);
    }

    private Boolean isCheckInfo_alter(){
        if (cbx_selectThree_alter.getValue().equals(null)||cbx_selectTwo_alter.getValue().equals(null)||
                cbx_selectOne_alter.getValue().equals(null)|| txf_id_alter.getText().equals(null)||
                txf_question_one_later.getText().equals(null)|| txf_question_three_alter.getText().equals(null)||
                txf_question_two_alter.getText().equals(null)||txf_id_alter.getText().equals(null)||
                psf_password_old_alter.getText().equals(null)||psf_password_new_alter.equals(null)||
                psf_checkPassword_new_alter.equals(null)){
            new AlertDefined(Alert.AlertType.INFORMATION,"提示","请输入完整信息。。。").show();
            return false;
        }else if(!psf_password_new_alter.getText().equals(psf_checkPassword_new_alter.getText())){
            new AlertDefined(Alert.AlertType.INFORMATION,"提示","您的确认密码错误").show();
            return false;
        }
        return  true;
    }

    private Boolean isAlterInfo() throws Exception {

        for(User user:userDao.list()){

            if(txf_id_alter.getText().equals(user.getId())&&
                    MD5.encrypt(psf_password_old_alter.getText()).equals(user.getPassword())&&
                    txf_question_one_later.getText().equals(user.getQuestion_one())&&
                    txf_question_two_alter.getText().equals(user.getQuestion_two())&&
                    txf_question_three_alter.getText().equals(user.getQuestion_three())&&
                    cbx_selectOne_alter.getValue().equals(userVerifyDao.load(user.getUUID()).getSelect_one())&&
                    cbx_selectTwo_alter.getValue().equals(userVerifyDao.load(user.getUUID()).getSelect_two())&&
                    cbx_selectThree_alter.getValue().equals(userVerifyDao.load(user.getUUID()).getSelect_three())){
                //当前用户对象
                user.setPassword(MD5.encrypt(psf_checkPassword_new_alter.getText()));
                userDao.update(user);
                new AlertDefined(Alert.AlertType.INFORMATION,"提示️","修改成功！").show();
                return true;
            }

        }
        return false;
    }



    private Boolean isCheckInfo(){

        if (cbx_selectThree.getValue()==null||cbx_selectTwo.getValue()==null||
                cbx_selectOne.getValue()==null|| psf_password.getText().equals(null)||
                psf_checkPassword.getText().equals(null)||txf_id.getText().equals(null)||
                txf_qustion_two.getText().equals(null)||txf_question_one.getText().equals(null)||
                txf_question_three.getText().equals(null)){
            new AlertDefined(Alert.AlertType.INFORMATION,"提示","请完善注册信息").show();
            return false;
        } else if (!psf_password.getText().equals(psf_checkPassword.getText())){
            new AlertDefined(Alert.AlertType.ERROR,"警告⚠️","您的确认密码错误！").show();
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
        user.setPassword(MD5.encrypt(psf_password.getText()));
        user.setQuestion_one(txf_question_one.getText());
        user.setQuestion_two(txf_qustion_two.getText());
        user.setQuestion_three(txf_question_three.getText());
        user.setPicture(pictureUrl);
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

    private Boolean isFindInfo() throws Exception {

        for(User user:userDao.list()){
            if(txf_id_find.getText().equals(user.getId())&&
                    txf_question_one_find.getText().equals(user.getQuestion_one())&&
                    txf_question_two_find.getText().equals(user.getQuestion_two())&&
                    txf_question_three_find.getText().equals(user.getQuestion_three())&&
                    cbx_selectOne_find.getValue().equals(userVerifyDao.load(user.getUUID()).getSelect_one())&&
                    cbx_selectTwo_find.getValue().equals(userVerifyDao.load(user.getUUID()).getSelect_two())&&
                    cbx_selectThree_find.getValue().equals(userVerifyDao.load(user.getUUID()).getSelect_three())){
                user.setPassword(MD5.encrypt("123456"));
                userDao.update(user);
                new AlertDefined(Alert.AlertType.INFORMATION,"提示️","重置密码成功！您的密码是：123456，请尽快修改密码！").show();
                return true;
            }

        }

        return false;
    }

    private Boolean isCheckInfo_find(){

        if (cbx_selectThree_find.getValue()==null||cbx_selectTwo_find.getValue()==null||
                cbx_selectOne_find.getValue()==null|| txf_id_find.getText().equals(null)||
                txf_question_two_find.getText().equals(null)|| txf_question_one_find.getText().equals(null)||
                txf_question_three_find.getText().equals(null)||txf_id_find_check.getText().equals(null)){
            new AlertDefined(Alert.AlertType.INFORMATION,"提示","请输入完整信息。。。").show();
            return false;
        }else if(!txf_id_find.getText().equals(txf_id_find_check.getText())){
            new AlertDefined(Alert.AlertType.INFORMATION,"提示","您的确认账号错误").show();
            return false;
        }

        return true;
    }

    @FXML
    void ac_resetFind(ActionEvent event){
        txf_id_find.clear();
        txf_id_find_check.clear();
        txf_question_one_find.clear();
        txf_question_two_find.clear();
        txf_question_three_find.clear();
        cbx_selectOne_find.setValue(null);
        cbx_selectTwo_find.setValue(null);
        cbx_selectThree_find.setValue(null);
    }

    @FXML
    void ac_resetAlter(ActionEvent event){
        txf_id_alter.clear();
        psf_password_old_alter.clear();
        psf_password_new_alter.clear();
        psf_checkPassword_new_alter.clear();
        txf_question_one_later.clear();
        txf_question_two_alter.clear();
        txf_question_three_alter.clear();
        cbx_selectOne_alter.setValue(null);
        cbx_selectTwo_alter.setValue(null);
        cbx_selectThree_alter.setValue(null);
    }

}




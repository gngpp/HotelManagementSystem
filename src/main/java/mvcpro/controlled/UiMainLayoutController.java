package mvcpro.controlled;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mvcpro.model.dao.UserDao;
import mvcpro.model.entity.User;

public class UiMainLayoutController {

    private Stage mainStage;

    @FXML
    private ImageView imageView_one;

    @FXML
    private ImageView imageView_two;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button delete;

    @FXML
    private Button mainMinimize;

    @FXML
    private Button browse;

    @FXML
    private Button mainExit;

    @FXML
    private TableView<User> mTable;

    @FXML
    private TableView<User> mTableUser;

    @FXML
    private TableColumn<User, String> tableColumnPassword;

    @FXML
    private TableColumn<User, Integer> tableColumnType;

    @FXML
    private TableColumn<User, String> tableColumnId;

    //
    // 客户信息表数据列表，此列表绑定这控件
    //
    private final ObservableList<User> userData=FXCollections.observableArrayList();


    @FXML
    void CheckAdd(ActionEvent event) throws Exception {
        System.out.println("add");
    }

    @FXML
    void CheckUadate(ActionEvent event) {
        System.out.println("update!");
    }

    @FXML
    void CheckDelete(ActionEvent event) {
        System.out.println("delete!");
    }

    @FXML
    void CheckBrower(ActionEvent event) {
        System.out.println("brower!");
    }

    @FXML
    void CheckMainExit(ActionEvent event){
        Platform.exit();
    }

    @FXML
    void CheckMainMinimize(ActionEvent event){
        mainStage.setIconified(true);
    }

    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    @FXML
    void systemClose(ActionEvent event){
        Platform.exit();
    }

    @FXML
    void initialize() throws Exception {
        initProprety();
        initUserTable();

    }

    private void initProprety(){

        Rectangle clip_one = new Rectangle(imageView_one.getImage().getWidth(),imageView_one.getImage().getHeight());
        clip_one.setArcWidth(15);
        clip_one.setArcHeight(15);
        imageView_one.setClip(clip_one);

        Rectangle clip_two = new Rectangle(imageView_two.getFitWidth(),imageView_two.getImage().getHeight());
        clip_two.setArcWidth(15);
        clip_two.setArcHeight(15);
        imageView_two.setClip(clip_two);


        update.setFont(new Font("System", 13));
        delete.setFont(new Font("System", 13));
        add.setFont(new Font("System", 13));
        browse.setFont(new Font("System", 13));
        mainExit.setFont(new Font("System", 13));
        mainMinimize.setFont(new Font("System", 13));
    }

    private void initUserTable() throws Exception {

        tableColumnId.setCellValueFactory(new PropertyValueFactory<User,String>("id"));
        tableColumnPassword.setCellValueFactory(new PropertyValueFactory<User,String>("password"));
        tableColumnType.setCellValueFactory(new PropertyValueFactory<User,Integer>("userType"));
        mTableUser.setEditable(true);
        mTableUser.setItems(userData);
        UserDao dao=new UserDao();
        userData.add(dao.list().get(0));
    }

}





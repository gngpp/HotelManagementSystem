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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import mvcpro.model.dao.*;
import mvcpro.model.entity.Client;
import mvcpro.model.entity.User;
import mvcpro.view.server.ClientData;
import mvcpro.view.server.UserData;

public class UiMainController {

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
    private TableView<User> mTableUser;

    @FXML
    private TableView<Client> mTableClient;

    //用户表
    @FXML
    private TableColumn<UserData, String> tableColumnPassword;

    @FXML
    private TableColumn<UserData, Integer> tableColumnType;

    @FXML
    private TableColumn<UserData, String> tableColumnId;

    @FXML
    private TableColumn<UserData,Integer> tableColumnUUID;

    @FXML
    private TableColumn<UserData, String> tableColumnQs_three;

    @FXML
    private TableColumn<UserData, String> tableColumnQs_one;

    @FXML
    private TableColumn<UserData, String> tableColumnQs_two;

    @FXML  TableColumn<UserData,String> tableColumnPicture;


    @FXML
    private TableColumn<ClientData, String> tableColumnNative_client;

    @FXML
    private TableColumn<ClientData, String> tableColumnIdNumber_client;

    @FXML
    private TableColumn<ClientData, String> tableColumnName_client;

    @FXML
    private TableColumn<ClientData, String> tableColumnSex_client;

    @FXML
    private TableColumn<ClientData, String> tableColumnCard_client;

    @FXML
    private TableColumn<ClientData, String> tableColumnPhone_client;




    //
    // 用户表数据列表，此列表绑定这控件
    //
    private final ObservableList<User> userData=FXCollections.observableArrayList();

    //客户数据列表
    private final ObservableList<Client> clientData=FXCollections.observableArrayList();

    private UserDao userDao;
    private ClientDao clientDao;
    private InfoRoomDao infoRoomDao;
    private BookRoomDao bookRoomDao;
    private StandardRoomDao standardRoomDao;

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
        initDataDao();
        initProprety();
        initUserTable();
        initClientTable();

    }

    private void initDataDao(){
        bookRoomDao=new BookRoomDao();
        clientDao=new ClientDao();
        infoRoomDao=new InfoRoomDao();
        standardRoomDao=new StandardRoomDao();
        userDao=new UserDao();

    }
    private void initProprety(){

        Rectangle clip_one = new Rectangle(imageView_one.getImage().getWidth(),imageView_one.getImage().getHeight());
        clip_one.setArcWidth(15);
        clip_one.setArcHeight(15);
        imageView_one.setClip(clip_one);

        Rectangle clip_two = new Rectangle(361,30);
        clip_two.setArcWidth(15);
        clip_two.setArcHeight(15);
        imageView_two.setClip(clip_two);


        update.setFont(new Font("宋体", 13));
        delete.setFont(new Font("宋体", 13));
        add.setFont(new Font("宋体", 13));
        browse.setFont(new Font("宋体", 13));
        mainExit.setFont(new Font("宋体", 13));
        mainMinimize.setFont(new Font("宋体", 13));
    }

    private void initUserTable() throws Exception {

        //字段名
        tableColumnId.setCellValueFactory(new PropertyValueFactory<UserData,String>("id"));
        tableColumnPassword.setCellValueFactory(new PropertyValueFactory<UserData,String>("password"));
        tableColumnType.setCellValueFactory(new PropertyValueFactory<UserData,Integer>("userType"));
        tableColumnUUID.setCellValueFactory(new PropertyValueFactory<UserData,Integer>("UUID"));
        tableColumnQs_one.setCellValueFactory(new PropertyValueFactory<UserData,String>("question_one"));
        tableColumnQs_two.setCellValueFactory(new PropertyValueFactory<UserData,String>("question_two"));
        tableColumnQs_three.setCellValueFactory(new PropertyValueFactory<UserData,String>("question_three"));
        tableColumnPicture.setCellValueFactory(new PropertyValueFactory<UserData,String>("picture"));

        //添加列双击事件
        tableColumnId.setCellFactory(TextFieldTableCell.<UserData>forTableColumn());
        tableColumnId.setOnEditCommit(
                (TableColumn.CellEditEvent<UserData, String> t) -> {
                    ((UserData) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setUserId(t.getNewValue());
                });

        for (User user:userDao.list())
            userData.add(user);
        mTableUser.setItems(userData);
    }

    private void initClientTable() throws Exception {
        tableColumnName_client.setCellValueFactory(new PropertyValueFactory<ClientData,String>("client_name"));
        tableColumnSex_client.setCellValueFactory(new PropertyValueFactory<ClientData,String>("client_sex"));
        tableColumnCard_client.setCellValueFactory(new PropertyValueFactory<ClientData,String>("client_id_card"));
        tableColumnPhone_client.setCellValueFactory(new PropertyValueFactory<ClientData,String>("client_phone"));
        tableColumnNative_client.setCellValueFactory(new PropertyValueFactory<ClientData,String>("client_native"));
        tableColumnIdNumber_client.setCellValueFactory(new PropertyValueFactory<ClientData,String>("client_id_number"));
        for (Client client:clientDao.list())
            clientData.add(client);
        mTableClient.setItems(clientData);

    }
}





